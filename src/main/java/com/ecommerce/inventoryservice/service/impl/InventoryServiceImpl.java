package com.ecommerce.inventoryservice.service.impl;

import org.springframework.stereotype.Service;

import com.ecommerce.inventoryservice.dto.CreateInventoryRequestDto;
import com.ecommerce.inventoryservice.dto.InventoryResponseDTO;
import com.ecommerce.inventoryservice.dto.InventoryStockDTO;
import com.ecommerce.inventoryservice.service.InventoryService;


@Service
public class InventoryServiceImpl implements InventoryService{

	@Override
	public InventoryResponseDTO createInventory(CreateInventoryRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResponseDTO restockQty(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResponseDTO getInventoryByProductId(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResponseDTO reserveStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResponseDTO releaseStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResponseDTO confirmStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
