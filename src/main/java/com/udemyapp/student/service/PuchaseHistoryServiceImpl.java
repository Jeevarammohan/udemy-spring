package com.udemyapp.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemyapp.exception.PurchaseHistoryNotFoundException;
import com.udemyapp.student.model.PurchaseHistory;
import com.udemyapp.student.repository.PurchaseHistoryRepository;

/**
 * @author JeevaR
 *
 */
@Service
public class PuchaseHistoryServiceImpl implements PurchaseHistoryService {

	@Autowired
	PurchaseHistoryRepository purchaseHistoryRepository;

	@Override
	public PurchaseHistory addPurchaseHistory(PurchaseHistory purchaseHistory) {
		return purchaseHistoryRepository.save(purchaseHistory);
	}

	@Override
	public PurchaseHistory getById(Integer puchaseId) throws PurchaseHistoryNotFoundException {
		PurchaseHistory purchaseHistory = null;
		purchaseHistory = purchaseHistoryRepository.findById(puchaseId).get();
		if (purchaseHistory == null) {
			throw new PurchaseHistoryNotFoundException("Invalid id");
		}
		return purchaseHistory;
	}

	@Override
	public List<PurchaseHistory> getAllPurchaseHistory() {
		return purchaseHistoryRepository.findAll();
	}

}
