package com.ecommerce.inventoryservice.service;

import com.ecommerce.inventoryservice.dto.CreateInventoryRequestDto;
import com.ecommerce.inventoryservice.dto.InventoryResponseDTO;
import com.ecommerce.inventoryservice.dto.InventoryStockDTO;

public interface InventoryService {
	
	InventoryResponseDTO createInventory(CreateInventoryRequestDto dto);
	
	InventoryResponseDTO restockQty(InventoryStockDTO dto);
	
	InventoryResponseDTO getInventoryByProductId(String productId );
	
	InventoryResponseDTO reserveStock(InventoryStockDTO dto);
	
	InventoryResponseDTO releaseStock(InventoryStockDTO dto);
	
	InventoryResponseDTO confirmStock(InventoryStockDTO dto);
	
	

}
