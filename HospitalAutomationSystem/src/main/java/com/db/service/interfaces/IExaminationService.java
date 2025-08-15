package com.db.service.interfaces;

import com.db.models.Appointment;
import com.db.models.Examination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IExaminationService {

    Optional<Examination> findById(Long id);

    Page<Examination> findByAppointment(Long appointmentId, Pageable pageable);

    Page<Examination> findByDate(LocalDate date, Pageable pageable);

    Examination save(Examination examination);

    void delete(Long examination);

    Examination update(Long id,Examination examination);

}
