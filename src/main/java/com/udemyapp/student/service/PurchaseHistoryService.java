package com.udemyapp.student.service;

import java.util.List;

import com.udemyapp.exception.PurchaseHistoryNotFoundException;
import com.udemyapp.student.model.PurchaseHistory;

/**
 * @author JeevaR
 *
 */
public interface PurchaseHistoryService {

	PurchaseHistory addPurchaseHistory(PurchaseHistory purchaseHistory);

	PurchaseHistory getById(Integer puchaseId) throws PurchaseHistoryNotFoundException;

	List<PurchaseHistory> getAllPurchaseHistory();

}
