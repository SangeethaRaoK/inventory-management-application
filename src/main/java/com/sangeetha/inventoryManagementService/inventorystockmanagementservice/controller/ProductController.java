package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.Product;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.ProductStockRequest;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.service.StockManagementService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/productstock")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@NoArgsConstructor
public class ProductController {
	
	 private StockManagementService stockManagementService;
	@GetMapping
	 public ResponseEntity<List<Product>> findAllProducts() {
	  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllProducts());
	 }
	@GetMapping("/{id}")
	 public ResponseEntity<Product> findProductById(@PathVariable Long id) {
	  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getProductById(id));
	 }
	@PostMapping
	 public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	  return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.saveProduct(product));
	  }
	  
	  @PutMapping
	 public ResponseEntity<Product> updateProductStock(@RequestBody ProductStockRequest stockRequest) {
	    return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.updateProductStock(stockRequest));

}
}
