package com.db.controller;


import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.Examination;
import com.db.repository.IAppointmentRepository;
import com.db.repository.IExaminationRepository;
import com.db.service.interfaces.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController("/api/examinations")
public class ExaminationController {

    @Autowired
    IExaminationService examinationService;

    @Autowired
    IExaminationRepository examinationRepository;

    @Autowired
    IAppointmentRepository appointmentRepository;

    @GetMapping("/getByExaminationsId/{id}")
    public ResponseEntity<Optional<Examination>> findById(@PathVariable Long id) {

        if (!examinationRepository.existsById(id)) {
            throw new BaseException(new ErrorMessage(MessageType.EXAMINATION_ID_NOT_FOUND));
        }

        return ResponseEntity.ok(examinationService.findById(id));
    }

    @GetMapping("/getByAppointment")
    public ResponseEntity<Page<Examination>> findByAppointment(@RequestParam Long appointmentId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        if (!appointmentRepository.existsById(appointmentId)) {
            throw new BaseException(new ErrorMessage(MessageType.APPOINTMENT_ID_NOT_FOUND));
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Examination> pageResult = examinationService.findByAppointment(appointmentId, pageable);
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping("/getByDate/{date}")
    public ResponseEntity<Page<Examination>> findByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Examination> pageResult = examinationService.findByDate(date, pageable);
        return ResponseEntity.ok(pageResult);
    }

    @PostMapping("/saveExamination")
    public Examination save(@RequestBody Examination examination) {

        return examinationRepository.save(examination);
    }

    @DeleteMapping("/deleteExamination/{id}")
    public ResponseEntity<Void> deleteExaminationById(@PathVariable Long id){

        examinationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateExamination")
    public Examination updateExamination(@RequestBody Examination examination) {
        return examinationRepository.save(examination);
    }


}
