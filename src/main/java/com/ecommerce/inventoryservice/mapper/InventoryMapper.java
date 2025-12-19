package com.ecommerce.inventoryservice.mapper;

import com.ecommerce.inventoryservice.dto.CreateInventoryRequestDto;
import com.ecommerce.inventoryservice.dto.InventoryResponseDTO;
import com.ecommerce.inventoryservice.entity.Inventory;

public class InventoryMapper {

	
	public static Inventory mapToInventoryEntity(CreateInventoryRequestDto dto, Inventory inventory) {
		
		inventory.setProductId(dto.productId());
		inventory.setAvailableQty(dto.initialQty());
		inventory.setReserveQty(0);
		
		return inventory;
	}
	
	public static InventoryResponseDTO mapToResponseDTO(Inventory inventory) {
		
		return new InventoryResponseDTO(
								inventory.getProductId(), 
								inventory.getAvailableQty(), 
								inventory.getReserveQty());
		
	}
}
