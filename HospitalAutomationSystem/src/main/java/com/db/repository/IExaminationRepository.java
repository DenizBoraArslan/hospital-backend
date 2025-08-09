package com.db.repository;


import com.db.models.Appointment;
import com.db.models.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IExaminationRepository extends JpaRepository<Examination, Long> {

    Optional<Examination> findById(long id);

    Optional<Examination> findByAppointment(Appointment appointment);

    List<Examination> findByDate(LocalDate date);

    List<Examination> findByComplaint(String complaint);

    List<Examination> findByDiagnosis(String diagnosis);

    List<Examination> findByTreatmentPlan(String treatmentPlan);


}
