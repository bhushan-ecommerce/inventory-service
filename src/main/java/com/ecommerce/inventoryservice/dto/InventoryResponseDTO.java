package com.ecommerce.inventoryservice.dto;

public record InventoryResponseDTO(
		Long productId,
		Integer availableQty,
		Integer reserveQty
		) 
{}
