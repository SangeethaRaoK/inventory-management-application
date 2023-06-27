package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterial;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterialStockRequest;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.service.StockManagementService;


	public class RawMaterialController {
		@Autowired
		 private StockManagementService stockManagementService;
		@GetMapping
		 public ResponseEntity<List<RawMaterial>> findAllRawMaterials() {
		  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllRawMaterials());
		 }
		@GetMapping("/{id}")
		 public ResponseEntity<RawMaterial> findRawMaterialById(@PathVariable Long id) {
		  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getRawMaterialById(id));
		 }
		@PostMapping
		 public ResponseEntity<RawMaterial> addRawMaterial(@RequestBody RawMaterial rawMaterial) {
		  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.saveRawMaterial(rawMaterial));
		 }
		@PutMapping
		 public ResponseEntity<RawMaterial> updateRawMaterialStock(@RequestBody RawMaterialStockRequest stockRequest) {
		  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.updateRawMaterialStock(stockRequest));
		 }

}
