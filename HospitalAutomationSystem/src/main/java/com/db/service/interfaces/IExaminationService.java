package com.db.service.interfaces;

import com.db.models.Appointment;
import com.db.models.Examination;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IExaminationService {

    Optional<Examination> findById(long id);

    Optional<Examination> findByAppointment(Appointment appointment);

    List<Examination> findByDate(LocalDate date);

    List<Examination> findByComplaint(String complaint);

    List<Examination> findByDiagnosis(String diagnosis);

    List<Examination> findByTreatmentPlan(String treatmentPlan);

}
