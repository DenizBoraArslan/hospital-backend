package com.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExaminationDTO {

    private Long id;
    private Long appointmentId;
    private LocalDate date;
    private String complaint;
    private String diagnosis;
    private String treatmentPlan;

}
