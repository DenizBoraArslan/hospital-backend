package com.db.controller;

import com.db.exceptions.BaseException;
import com.db.exceptions.ErrorMessage;
import com.db.exceptions.exepciton_enums.MessageType;
import com.db.models.PrescriptionItem;
import com.db.repository.IPrescriptionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/prescriptionItems")
public class PrescriptionItemController {

    @Autowired
    private IPrescriptionItemRepository prescriptionItemRepository;

    @GetMapping("/getPrescriptionById/{id}")
    public ResponseEntity<Optional<PrescriptionItem>> findPrescriptionItemById(@PathVariable Long id) {

        if (!prescriptionItemRepository.existsById(id)) {
            throw new BaseException(new ErrorMessage(MessageType.PRESCRIPTION_ITEM_ID_NOT_FOUND));
        }

        return ResponseEntity.ok(prescriptionItemRepository.findPrescriptionItemById(id));
    }

    @PostMapping("/savePrescriptionItem")
    public ResponseEntity<PrescriptionItem> save(@RequestBody PrescriptionItem prescriptionItem){

        return ResponseEntity.ok(prescriptionItemRepository.save(prescriptionItem));
    }

    @DeleteMapping("/deletePrescriptionItem/{patientId}")
    public ResponseEntity<Void> delete(@PathVariable Long patientId){

        prescriptionItemRepository.deleteById(patientId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatePrescriptionItem/{prescriptionItemId}")
    PrescriptionItem update(@PathVariable Long prescriptionItemId,@RequestBody PrescriptionItem prescriptionItem){

        return prescriptionItemRepository.save(prescriptionItem);
    }
}
