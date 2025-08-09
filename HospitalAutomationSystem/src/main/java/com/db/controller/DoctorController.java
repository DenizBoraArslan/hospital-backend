package com.db.controller;

import com.db.enums.Department;
import com.db.enums.Gender;
import com.db.models.Doctor;
import com.db.service.UserService;
import com.db.service.interfaces.IDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final IDoctorService doctorService;
    @Autowired
    private UserService userService;

    @GetMapping("/getById/{doctorId}")
    public Optional<Doctor> findById(@PathVariable long doctorId){

        return doctorService.findById(doctorId);
    }

    @GetMapping("/getByFirstname/{doctorFirstName}")
    public ResponseEntity<Page<Doctor>> findByDoctorFirstName(@PathVariable String doctorFirstName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDoctorFirstName(doctorFirstName, pageable);

        return ResponseEntity.ok(pageResult) ;
    }

    @GetMapping("/getByLastname/{doctorLastName}")
    public ResponseEntity<Page<Doctor>> findByDoctorLastName(@PathVariable String doctorLastName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDoctorLastName(doctorLastName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByEmail/{email}")
    public Optional<Doctor> findByDoctorEmail(@PathVariable String email){

        return doctorService.findByDoctorEmail(email);

    }

    @GetMapping("/getByGender/{gender}")
    public ResponseEntity<Page<Doctor>> findByGender(@PathVariable Gender gender, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByGender(gender, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByDepartment/{department}")
    public ResponseEntity<Page<Doctor>> findByDepartment(@PathVariable Department department, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> pageResult = doctorService.findByDepartment(department, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){

        return doctorService.saveDoctor(doctor);
    }







}
