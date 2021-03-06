package com.udemyapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemyapp.student.model.PurchaseHistory;
/**
 * @author JeevaR
 *
 */
@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer> {

}
