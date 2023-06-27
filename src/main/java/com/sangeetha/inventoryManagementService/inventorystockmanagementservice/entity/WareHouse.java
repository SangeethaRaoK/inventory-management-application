package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class WareHouse {
	@Id
	  @SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
	  @GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
	  private Long warehouseId;
	  @Column(length = 20)
	  private String name;
	  @Column(length = 50)
	  private String description;

}
