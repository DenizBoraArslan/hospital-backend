package com.db.service;

import com.db.models.Appointment;
import com.db.models.Examination;
import com.db.repository.IExaminationRepository;
import com.db.service.interfaces.IExaminationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ExaminationService implements IExaminationService {

    private IExaminationRepository examinationRepository;

    @Override
    public Optional<Examination> findById(long id) {
        return examinationRepository.findById(id);
    }

    @Override
    public Optional<Examination> findByAppointment(Appointment appointment) {
        return examinationRepository.findByAppointment(appointment);
    }

    @Override
    public List<Examination> findByDate(LocalDate date) {
        return examinationRepository.findByDate(date);
    }

    @Override
    public List<Examination> findByComplaint(String complaint) {
        return examinationRepository.findByComplaint(complaint);
    }

    @Override
    public List<Examination> findByDiagnosis(String diagnosis) {
        return examinationRepository.findByDiagnosis(diagnosis);
    }

    @Override
    public List<Examination> findByTreatmentPlan(String treatmentPlan) {
        return examinationRepository.findByTreatmentPlan(treatmentPlan);
    }
}
