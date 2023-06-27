package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
