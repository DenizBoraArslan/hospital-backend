package com.db.repository;

import com.db.models.Examination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IExaminationRepository extends JpaRepository<Examination, Long> {

    Optional<Examination> findById(Long id);

    Page<Examination> findByAppointment(Long appointmentId, Pageable pageable);

    Page<Examination> findByDate(LocalDate date, Pageable pageable);


}
