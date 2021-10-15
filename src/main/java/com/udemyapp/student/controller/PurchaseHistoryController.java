package com.udemyapp.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemyapp.student.model.PurchaseHistory;
import com.udemyapp.student.service.PurchaseHistoryService;

/**
 * @author JeevaR
 *
 */
@RestController
@RequestMapping("/udemy-api")
public class PurchaseHistoryController {

	@Autowired
	PurchaseHistoryService purchaseHistoryService;

	@PostMapping("/purchaseHistory")
	ResponseEntity<PurchaseHistory> addPurchaseHistory(PurchaseHistory purchaseHistory) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "PurchaseHistory is created");
		PurchaseHistory nPurchaseHistory = purchaseHistoryService.addPurchaseHistory(purchaseHistory);
		return ResponseEntity.ok().headers(headers).body(nPurchaseHistory);
	}

	@GetMapping("/purchaseHistory/purchasehistoryid/{purchaseId}")
	ResponseEntity<PurchaseHistory> getById(Integer purchaseId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "PurchaseHistory is retrieved");
		PurchaseHistory nPurchaseHistory = purchaseHistoryService.getById(purchaseId);
		return ResponseEntity.ok().headers(headers).body(nPurchaseHistory);

	}

	@GetMapping("/purchaseHistory")
	ResponseEntity<List<PurchaseHistory>> getAllPurchaseHistory() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All PurchaseHistory is retrieved");
		List<PurchaseHistory> purchaseHistoryList = purchaseHistoryService.getAllPurchaseHistory();
		return ResponseEntity.ok().headers(headers).body(purchaseHistoryList);
	}
}
