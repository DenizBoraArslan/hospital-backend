package com.db.dto;

import com.db.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long id;
    private long patientId;
    private long doctorId;
    private LocalDate appointmentDate;
    private AppointmentStatus status;
    private String notes;


}
