package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.Product;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.ProductStockRequest;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterial;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterialStockRequest;


public interface StockManagementService {
	List<Product> getAllProducts() ;
	Product getProductById(Long id) ;
	List<RawMaterial> getAllRawMaterials() ;
	RawMaterial getRawMaterialById(Long id) ;
	Product saveProduct(Product product) ;
	RawMaterial saveRawMaterial(RawMaterial rawMaterial);
	  
	  Product updateProductStock(ProductStockRequest stockRequest);
	RawMaterial updateRawMaterialStock(RawMaterialStockRequest stockRequest);

}
