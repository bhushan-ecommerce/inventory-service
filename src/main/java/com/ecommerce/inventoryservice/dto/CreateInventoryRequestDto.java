package com.ecommerce.inventoryservice.dto;

public record CreateInventoryRequestDto(
		
		Long productId,
		Integer initialQty
		) {

}
