package com.ecommerce.inventoryservice.service.impl;

import org.springframework.stereotype.Service;

import com.ecommerce.inventoryservice.dto.CreateInventoryRequestDto;
import com.ecommerce.inventoryservice.dto.InventoryResponseDTO;
import com.ecommerce.inventoryservice.dto.InventoryStockDTO;
import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.exception.InsufficientStockException;
import com.ecommerce.inventoryservice.exception.InventoryNotFoundException;
import com.ecommerce.inventoryservice.mapper.InventoryMapper;
import com.ecommerce.inventoryservice.repository.InventoryRepository;
import com.ecommerce.inventoryservice.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;

	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public InventoryResponseDTO createInventory(CreateInventoryRequestDto dto) {

		if (inventoryRepository.existsByProductId(dto.productId())) {
			throw new RuntimeException("ProductId already Present");
		}

		Inventory save = inventoryRepository.save(InventoryMapper.mapToInventoryEntity(dto, new Inventory()));

		return InventoryMapper.mapToResponseDTO(save);
	}

	@Override
	public InventoryResponseDTO restockQty(InventoryStockDTO dto) {
		// TODO Auto-generated method stub

		Inventory inventory = inventoryRepository.findByProductId(dto.productId())
				.orElseThrow(() -> new InventoryNotFoundException(dto.productId()));

		Integer newStock = inventory.getAvailableQty() + dto.quantity();
		inventory.setAvailableQty(newStock);

		inventoryRepository.save(inventory);

		return InventoryMapper.mapToResponseDTO(inventory);
	}

	@Override
	public InventoryResponseDTO getInventoryByProductId(Long productId) {
		// TODO Auto-generated method stub
		Inventory inventory = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new InventoryNotFoundException(productId));

		return InventoryMapper.mapToResponseDTO(inventory);
	}

	@Override
	public InventoryResponseDTO reserveStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub

		Inventory inventory = inventoryRepository.findByProductId(dto.productId())
				.orElseThrow(() -> new InventoryNotFoundException(dto.productId()));

		int newAvailable = 0;

		if (inventory.getAvailableQty() >= dto.quantity()) {

			inventory.setAvailableQty(inventory.getAvailableQty() - dto.quantity());
			inventory.setReserveQty(inventory.getReserveQty() + dto.quantity());

			inventoryRepository.save(inventory);
		} else {
			throw new InsufficientStockException("Not enough stock for productId: "+dto.productId());
		}

		return InventoryMapper.mapToResponseDTO(inventory);
	}

	@Override
	public InventoryResponseDTO releaseStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		Inventory inventory = inventoryRepository.findByProductId(dto.productId())
				.orElseThrow(() -> new InventoryNotFoundException(dto.productId()));

		if (inventory.getReserveQty() < dto.quantity()) {
			throw new InsufficientStockException(
					"Cannot release more stock than reserved for productId: " + dto.productId());
		}

		inventory.setAvailableQty(inventory.getAvailableQty() + dto.quantity());
		inventory.setReserveQty(inventory.getReserveQty() - dto.quantity());

		inventoryRepository.save(inventory);

		return InventoryMapper.mapToResponseDTO(inventory);
	}

	@Override
	public InventoryResponseDTO confirmStock(InventoryStockDTO dto) {
		// TODO Auto-generated method stub
		Inventory inventory = inventoryRepository.findByProductId(dto.productId())
				.orElseThrow(() ->new InventoryNotFoundException(dto.productId()));

		if (inventory.getReserveQty() < dto.quantity()) {
			throw new InsufficientStockException(
					"Cannot confirm more stock than reserved for productId: " + dto.productId());
		}

		inventory.setReserveQty(inventory.getReserveQty() - dto.quantity());

		inventoryRepository.save(inventory);

		return InventoryMapper.mapToResponseDTO(inventory);

	}

}
