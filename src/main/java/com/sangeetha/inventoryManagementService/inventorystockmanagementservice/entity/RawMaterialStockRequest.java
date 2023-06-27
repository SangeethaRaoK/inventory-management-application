package com.sangeetha.inventoryManagementService.inventorystockmanagementservice.entity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RawMaterialStockRequest {
	@NotNull
	  private Long rawMaterialId;
	  @NotNull
	  @DecimalMax(value = "999.99")
	  private Double quantity;

}
