package com.db.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prescription_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionItem extends BaseEntity {

    private String medicineName;
    private String dosage;
    private String durationInDays;

    @ManyToOne
    private Prescription prescription;


}
