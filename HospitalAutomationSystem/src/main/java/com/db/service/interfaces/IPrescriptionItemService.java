package com.db.service.interfaces;

import com.db.models.PrescriptionItem;

import java.util.List;
import java.util.Optional;

public interface IPrescriptionItemService {

    Optional<PrescriptionItem> findPrescriptionItemById(Long id);
    List<PrescriptionItem> findPrescriptionItemByMedicineName(String medicineName);
    List<PrescriptionItem> findPrescriptionItemByDosage(String dosage);
    List<PrescriptionItem> findPrescriptionItemByDurationInDays(String durationInDays);
    List<PrescriptionItem> findPrescriptionItemByPrescriptionId(Long prescriptionId);

}
