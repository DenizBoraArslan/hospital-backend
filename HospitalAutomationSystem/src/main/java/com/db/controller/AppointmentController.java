package com.db.controller;


import com.db.enums.AppointmentStatus;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Appointment;
import com.db.service.interfaces.IAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private final IAppointmentService appointmentService;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<Optional<Appointment>> findByPatientId(@PathVariable Long patientId) {

        return ResponseEntity.ok(appointmentService.findAppointmentByPatientId(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<Page<Appointment>> findAppointmentByDoctorId(@PathVariable Long doctorId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Appointment> pageResult = appointmentService.findAppointmentByDoctorId(doctorId, pageable);

        if (pageResult.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/date/{appointmentDate}")
    public ResponseEntity<Page<Appointment>> findAppointmentByAppointmentDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Appointment> pageResult = appointmentService.findAppointmentByAppointmentDate(appointmentDate, pageable);

        if (pageResult.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<Appointment>> findAppointmentByStatus(@PathVariable AppointmentStatus status, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Appointment> pageResult = appointmentService.findAppointmentByStatus(status, pageable);

        if (pageResult.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(pageResult);
        }

    }

    @GetMapping("/allAppointments")
    public ResponseEntity<Page<Appointment>> getAllAppointments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Appointment> pageResult = appointmentService.findAllAppointments(pageable);

        if (pageResult.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(pageResult);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {

        if (appointment.getPatient() == null) {
            throw new BaseException(new ErrorMessage(MessageType.PATIENT_CANNOT_BE_NULL));
        }
        if (appointment.getPatient().getId() == null) {
            throw new BaseException(new ErrorMessage(MessageType.PATIENT_ID_CANNOT_BE_NULL));
        }
        if (appointment.getDoctor() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_CANNOT_BE_NULL));
        }
        if (appointment.getDoctor().getId() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_ID_CANNOT_BE_NULL));
        }
        if (appointment.getAppointmentDate() == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_DATE_CANNOT_BE_NULL));
        }
        if (appointment.getStatus() == null) {
            throw new BaseException(new ErrorMessage(MessageType.STATUS_CANNOT_BE_NULL));
        }

        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));

    }

    @DeleteMapping("/delete/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {

        if (appointmentId == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_ID_CANNOT_BE_NULL));
        }

        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment, @PathVariable Long appointmentId) {

        if (appointment == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_CANNOT_BE_NULL));
        }
        if (appointment.getId() == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_CANNOT_BE_NULL));
        }
        if (!appointment.getId().equals(appointmentId)) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_NOT_FOUND));
        }
        return ResponseEntity.ok(appointmentService.updateAppointment(appointment));
    }

}
