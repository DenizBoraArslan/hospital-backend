package com.db.service;

import com.db.models.PrescriptionItem;
import com.db.repository.IPrescriptionItemRepository;
import com.db.service.interfaces.IPrescriptionItemService;

import java.util.List;
import java.util.Optional;

public class PrescriptionItemsService implements IPrescriptionItemService {

    private IPrescriptionItemRepository prescriptionItemRepository;

    @Override
    public Optional<PrescriptionItem> findPrescriptionItemById(Long id) {
        return prescriptionItemRepository.findById(id);
    }

    @Override
    public List<PrescriptionItem> findPrescriptionItemByMedicineName(String medicineName) {
        return prescriptionItemRepository.findPrescriptionItemByMedicineName(medicineName);
    }

    @Override
    public List<PrescriptionItem> findPrescriptionItemByDosage(String dosage) {
        return prescriptionItemRepository.findPrescriptionItemByDosage(dosage);
    }

    @Override
    public List<PrescriptionItem> findPrescriptionItemByDurationInDays(String durationInDays) {
        return prescriptionItemRepository.findPrescriptionItemByDurationInDays(durationInDays);
    }

    @Override
    public List<PrescriptionItem> findPrescriptionItemByPrescriptionId(Long prescriptionId) {
        return prescriptionItemRepository.findPrescriptionItemByPrescriptionId(prescriptionId);
    }

}
