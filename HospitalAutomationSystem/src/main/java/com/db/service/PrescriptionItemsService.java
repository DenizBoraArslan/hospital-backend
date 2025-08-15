package com.db.service;

import com.db.models.PrescriptionItem;
import com.db.repository.IPrescriptionItemRepository;
import com.db.service.interfaces.IPrescriptionItemService;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionItemsService implements IPrescriptionItemService {

    private IPrescriptionItemRepository prescriptionItemRepository;

    @Override
    public Optional<PrescriptionItem> findPrescriptionItemById(Long id) {
        return prescriptionItemRepository.findById(id);
    }

    @Override
    public PrescriptionItem save(PrescriptionItem prescriptionItem) {
        return prescriptionItemRepository.save(prescriptionItem);
    }

    @Override
    public void delete(Long patientId) {

        prescriptionItemRepository.deleteById(patientId);
    }

    @Override
    public PrescriptionItem update(Long prescriptionItemId, PrescriptionItem prescriptionItem) {

       return prescriptionItemRepository.findById(prescriptionItemId).map(existingPrescriptionItem ->{

            existingPrescriptionItem.setMedicineName(prescriptionItem.getMedicineName());
            existingPrescriptionItem.setDosage(prescriptionItem.getDosage());
            existingPrescriptionItem.setDurationInDays(prescriptionItem.getDurationInDays());

           return prescriptionItemRepository.save(existingPrescriptionItem);
       }).orElseThrow(()->new RuntimeException("Prescription Item Not Found With Id: " + prescriptionItemId));



    }


}
