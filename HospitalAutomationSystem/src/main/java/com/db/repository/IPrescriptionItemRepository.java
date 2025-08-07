package com.db.repository;

import com.db.models.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {




}
