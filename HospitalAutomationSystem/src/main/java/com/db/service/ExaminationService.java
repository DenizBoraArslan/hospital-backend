package com.db.service;


import com.db.models.Examination;
import com.db.repository.IExaminationRepository;
import com.db.service.interfaces.IExaminationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExaminationService implements IExaminationService {

    private IExaminationRepository examinationRepository;

    @Override
    public Optional<Examination> findById(Long id) {
        return examinationRepository.findById(id);
    }

    @Override
    public Page<Examination> findByAppointment(Long appointmentId, Pageable pageable) {
        return examinationRepository.findByAppointment(appointmentId, pageable);
    }

    @Override
    public Page<Examination> findByDate(LocalDate date, Pageable pageable) {
        return examinationRepository.findByDate(date, pageable);
    }

    @Override
    public Examination save(Examination examination) {
        return examinationRepository.save(examination);
    }

    @Override
    public void delete(Long id) {
        examinationRepository.deleteById(id);
    }

    @Override
    public Examination update(Long examinationId,Examination examination) {

        return examinationRepository.findById(examinationId).map(existingExamination -> {

            existingExamination.setAppointment(examination.getAppointment());
            existingExamination.setDate(examination.getDate());
            existingExamination.setDiagnosis(examination.getDiagnosis());
            existingExamination.setComplaint(examination.getComplaint());
            existingExamination.setDiagnosis(examination.getTreatmentPlan());

            return examinationRepository.save(existingExamination);
        }).orElseThrow(()-> new RuntimeException("Examination not found with id: " + examinationId));


    }


}
