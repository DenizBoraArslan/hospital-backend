package com.db.controller;

import com.db.models.Patient;
import com.db.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/getAllPatients")
    public ResponseEntity<Page<Patient>> getAllPatients(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> pageResult = patientService.getAllPatients(pageable);

        return ResponseEntity.ok(pageResult);

    }

    @GetMapping("/getPatientsById/{id}")
    public ResponseEntity<Optional<Patient>> findById(@PathVariable long id) {

        return ResponseEntity.ok(patientService.findById(id));
    }

    @GetMapping("/getPatientsByFirstName/{patientFirstName}")
    public ResponseEntity<Page<Patient>> findByPatientFirstName(@PathVariable String patientFirstName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> pageResult = patientService.findByPatientFirstName(patientFirstName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getPatientsByLastName/{patientLastName}")
    public ResponseEntity<Page<Patient>> findByPatientLastname(@PathVariable String patientLastName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> pageResult = patientService.findByPatientLastname(patientLastName, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getPatientByNationalId/{patientNationalIdNumber}")
    public ResponseEntity<Optional<Patient>> findByPatientNationalIdNumber(@PathVariable String patientNationalIdNumber) {

        return ResponseEntity.ok(patientService.findByPatientNationalIdNumber(patientNationalIdNumber));
    }

    @GetMapping("/getPatientByEmail/{patientEmail}")
    public ResponseEntity<Optional<Patient>> findByPatientEmail(@PathVariable String patientEmail) {

        return ResponseEntity.ok(patientService.findByPatientEmail(patientEmail));
    }

    @GetMapping("/getPatientByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Optional<Patient>> findByPatientPhoneNumber(@PathVariable String phoneNumber) {

        return ResponseEntity.ok(patientService.findByPatientPhoneNumber(phoneNumber));
    }

    @PostMapping("/savePatient")
    public ResponseEntity<Patient> save(@RequestBody Patient patient){

        return ResponseEntity.ok(patientService.save(patient));
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public ResponseEntity<Void> delete(@PathVariable Long patientId) {

        patientService.delete(patientId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatePatient/{patientId}")
    public ResponseEntity<Patient> update(@PathVariable Long patientId, @RequestBody Patient patient){
        return ResponseEntity.ok(patientService.update(patientId, patient));
    }


}
