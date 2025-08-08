package com.db.controller;


import com.db.enums.AppointmentStatus;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Appointment;
import com.db.service.interfaces.IAppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> findByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.findAppointmentByPatientId(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> findAppointmentByDoctorId(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.findAppointmentByDoctorId(doctorId));
    }

    @GetMapping("/date/{appointmentDate}")
    public ResponseEntity<List<Appointment>> findAppointmentByAppointmentDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate) {
        return ResponseEntity.ok(appointmentService.findAppointmentByAppointmentDate(appointmentDate));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Appointment>> findAppointmentByStatus(@PathVariable AppointmentStatus status) {

        List<Appointment> appointments = appointmentService.findAppointmentByStatus(status);

        if(appointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(appointments);
        }

    }

    @GetMapping("/allAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        List<Appointment> appointments = appointmentService.findAllAppointments();

        if(appointments.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_CONTENT));
        }
        else {
            return ResponseEntity.ok(appointments);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {

        if (appointment.getPatient()== null) {
            throw new BaseException(new ErrorMessage(MessageType.PATIENT_CANNOT_BE_NULL));
        }
        if(appointment.getPatient().getId()== null) {
            throw new BaseException(new ErrorMessage(MessageType.PATIENT_ID_CANNOT_BE_NULL));
        }
        if(appointment.getDoctor()== null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_CANNOT_BE_NULL));
        }
        if(appointment.getDoctor().getId()== null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_ID_CANNOT_BE_NULL));
        }
        if (appointment.getAppointmentDate() == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_DATE_CANNOT_BE_NULL));
        }
        if (appointment.getStatus() == null) {
            throw new BaseException(new ErrorMessage(MessageType.STATUS_CANNOT_BE_NULL));
        }
        else {
            return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
        }
    }

    @DeleteMapping("/delete/{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId) {

        if (appointmentId == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_CANNOT_BE_NULL));
        }

        appointmentService.deleteAppointment(appointmentId);
    }

    @PutMapping("/update/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment, @PathVariable Long appointmentId) {

        if (appointment.getId() == null) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_CANNOT_BE_NULL));
        }
        if (!appointment.getId().equals(appointmentId)) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_NOT_FOUND));
        }
        return ResponseEntity.ok(appointmentService.updateAppointment(appointment));
    }

}
