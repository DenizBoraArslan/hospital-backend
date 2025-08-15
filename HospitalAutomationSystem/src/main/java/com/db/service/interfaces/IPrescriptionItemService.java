package com.db.service.interfaces;

import com.db.models.PrescriptionItem;

import java.util.List;
import java.util.Optional;

public interface IPrescriptionItemService {

    Optional<PrescriptionItem> findPrescriptionItemById(Long id);

    PrescriptionItem save(PrescriptionItem prescriptionItem);

    void delete(Long patientId);

    PrescriptionItem update(Long prescriptionItemId, PrescriptionItem prescriptionItem);


}
