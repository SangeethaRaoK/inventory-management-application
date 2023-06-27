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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RawMaterial {
  @Id
  @SequenceGenerator(name = "rawmaterial_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "rawmaterial_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long rawMaterialId;
  @Column(length = 20)
  private String materialName;
  @Column(length = 100)
  private String description;
  private Double quantityAvailable;
  @Enumerated(EnumType.STRING)
  private Measurementunit quantityunit;
  @ManyToOne
  @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_raw_matr_warehouse_ID"))
  private WareHouse warehouse;
}