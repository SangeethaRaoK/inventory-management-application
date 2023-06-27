package com.sangeetha.inventoryManagementService.inventor.ystockmanagementservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.Product;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.ProductStockRequest;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterial;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.RawMaterialStockRequest;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.repository.ProductRepository;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.repository.RawMaterialRepository;
import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.service.StockManagementService;


@Service
public class stockManagementServiceImpl implements StockManagementService{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RawMaterialRepository rawMaterialRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new RuntimeException());
	
	}

	@Override
	public List<RawMaterial> getAllRawMaterials() {
		return rawMaterialRepository.findAll();
	}

	@Override
	public RawMaterial getRawMaterialById(Long id) {
		return rawMaterialRepository.findById(id).orElseThrow(()->new RuntimeException());
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public RawMaterial saveRawMaterial(RawMaterial rawMaterial) {
		
		return rawMaterialRepository.save(rawMaterial);
	}

	@Override
	public Product updateProductStock(ProductStockRequest stockRequest) {
		// TODO Auto-generated method stub
	Product product = productRepository.findById(stockRequest.getProductId()).orElseThrow(()->new RuntimeException());
	product.setQuantityAvailable(product.getQuantityAvailable()+stockRequest.getQuantity());
	
	return productRepository.save(product);
	}

	@Override
	public RawMaterial updateRawMaterialStock(RawMaterialStockRequest stockRequest) {
		RawMaterial rawMaterial=rawMaterialRepository.findById(stockRequest.getRawMaterialId()).orElseThrow(
				()->new RuntimeException());
		rawMaterial.setQuantityAvailable(rawMaterial.getQuantityAvailable()+stockRequest.getQuantity());
		
		return rawMaterialRepository.save(rawMaterial);
	}


}
