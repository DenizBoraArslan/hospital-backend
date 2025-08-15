package com.db.controller;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Doctor;

import com.db.service.interfaces.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final IDoctorService doctorService;

    @GetMapping("/getAllDoctors")
    public Page<Doctor> getAllDoctors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return doctorService.getAllDoctors(pageable);
    }

    @GetMapping("/getAllDoctorsByGender/{gender}")
    public ResponseEntity<Page<Doctor>> findAllDoctorsByGender(@PathVariable Gender gender, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findAllDoctorsByGender(gender, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getAllDoctorsByDepartment/{department}")
    public ResponseEntity<Page<Doctor>> getALlDoctorsByDepartment(@PathVariable Department department, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.getAllDoctorsByDepartment(department, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getById/{doctorId}")
    public ResponseEntity<Doctor> findById(@PathVariable long doctorId) {

        Optional<Doctor> doctor = doctorService.findById(doctorId);

        if (doctor.isPresent()) {
            return ResponseEntity.ok().body(doctor.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getByFirstname/{doctorFirstName}")
    public ResponseEntity<Page<Doctor>> findByDoctorFirstName(@PathVariable String doctorFirstName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDoctorFirstName(doctorFirstName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByLastname/{doctorLastName}")
    public ResponseEntity<Page<Doctor>> findByDoctorLastName(@PathVariable String doctorLastName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDoctorLastName(doctorLastName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Optional<Doctor>> findByDoctorEmail(@PathVariable String email) {

        return ResponseEntity.ok(doctorService.findByDoctorEmail(email));

    }

    @GetMapping("/getByGender/{gender}")
    public ResponseEntity<Page<Doctor>> findByGender(@PathVariable Gender gender, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByGender(gender, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<Page<Doctor>> findByDepartment(@PathVariable Department department, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDepartment(department, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {

        if (doctor.getId() != null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_ID_MUST_BE_NULL));
        }
        if (doctor.getDoctorFirstName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_FIRST_NAME_CANNOT_BE_NULL));
        }
        if (doctor.getDoctorLastName() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_LAST_NAME_CANNOT_BE_NULL));
        }
        if (doctor.getDoctorEmail() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_EMAIL_CANNOT_BE_NULL));
        }
        if (doctor.getGender() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_GENDER_CANNOT_BE_NULL));
        }
        if (doctor.getDepartment() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DEPARTMENT_CANNOT_BE_NULL));
        }

        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDoctor(@RequestBody Doctor doctor) {

        doctorService.deleteDoctor(doctor);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Long doctorId) {

        if (doctor == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_CANNOT_BE_NULL));
        }
        if (doctor.getId() == null) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_ID_CANNOT_BE_NULL));
        }
        if (!doctor.getId().equals(doctorId)) {
            throw new BaseException(new ErrorMessage(MessageType.DOCTOR_NOT_FOUND));
        }

        return ResponseEntity.ok(doctorService.updateDoctor(doctor));
    }


}
