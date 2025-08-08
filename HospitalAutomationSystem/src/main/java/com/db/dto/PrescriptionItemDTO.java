package com.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionItemDTO {

    private Long id;
    private String medicineName;
    private String dosage;
    private String durationInDays;
    private Long prescriptionId;



}
