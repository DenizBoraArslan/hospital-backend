package com.db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "examination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examination extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private LocalDate date;

    private String complaint;
    private String diagnosis;
    private String treatmentPlan;

}
