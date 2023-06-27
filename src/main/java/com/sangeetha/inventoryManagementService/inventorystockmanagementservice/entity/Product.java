package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity;

import com.sangeetha.inventoryManagementService.inventorystockmanagementservice.enums.Measurementunit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	@Id
	@SequenceGenerator(name = "product_id_sequence",initialValue = 10000,allocationSize = 1)
	@GeneratedValue(generator = "product_id_sequence",strategy = GenerationType.SEQUENCE)
	private Long productId;
	
	@Column(length = 20)
	private String materialName;
	@Column(length = 100)
	private String description;
	private Double quantityAvailable;
	@Enumerated(EnumType.STRING)
	private Measurementunit quantityUnit;
	
	@ManyToOne
	@JoinColumn(name = "warehouseId",referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_prod_warehouse_ID"))
	private WareHouse warehouse;
	
	
	

}
