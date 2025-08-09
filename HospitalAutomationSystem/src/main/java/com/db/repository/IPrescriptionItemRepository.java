package com.db.repository;

import com.db.models.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {

    Optional<PrescriptionItem> findPrescriptionItemById(Long id);

    List<PrescriptionItem> findPrescriptionItemByMedicineName(String medicineName);

    List<PrescriptionItem> findPrescriptionItemByDosage(String dosage);

    List<PrescriptionItem> findPrescriptionItemByDurationInDays(String durationInDays);

    List<PrescriptionItem> findPrescriptionItemByPrescriptionId(Long prescriptionId);

}
