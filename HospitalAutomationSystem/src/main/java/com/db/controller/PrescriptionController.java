package com.db.controller;

import com.db.models.Doctor;
import com.db.models.Patient;
import com.db.models.Prescription;

import com.db.service.interfaces.IPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    IPrescriptionService prescriptionService;

    @GetMapping("/getPrescriptionByPatient")
    public ResponseEntity<Page<Prescription>> findPrescriptionByPatient(@RequestBody Patient patient, @RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "10") int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Prescription> pageResult = prescriptionService.findPrescriptionByPatient(patient, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getPrescriptionByDoctor")
    public ResponseEntity<Page<Prescription>> findPrescriptionByDoctor(@RequestBody Doctor doctor, @RequestParam(defaultValue = "0") int size, @RequestParam(defaultValue = "10") int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Prescription> pageResult = prescriptionService.findPrescriptionByDoctor(doctor, pageable);

        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/savePrescription")
    public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription){

        return ResponseEntity.ok(prescriptionService.savePrescription(prescription));
    }

    @DeleteMapping("/deletePrescription/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id){
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatePrescription/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription){

        return ResponseEntity.ok(prescriptionService.updatePrescription(id,prescription));
    }

}
