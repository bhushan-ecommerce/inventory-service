package com.ecommerce.inventoryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventoryservice.dto.CreateInventoryRequestDto;
import com.ecommerce.inventoryservice.dto.InventoryResponseDTO;
import com.ecommerce.inventoryservice.dto.InventoryStockDTO;
import com.ecommerce.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	
	@PostMapping("/createInventory")
	public ResponseEntity<InventoryResponseDTO> createInventory(@RequestBody CreateInventoryRequestDto dto) {
		InventoryResponseDTO inventory = inventoryService.createInventory(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
	}
	
	@PostMapping("/restock")
	public ResponseEntity<InventoryResponseDTO> restockQty(@RequestBody InventoryStockDTO dto){	
		InventoryResponseDTO restockQty = inventoryService.restockQty(dto);	
		return ResponseEntity.status(HttpStatus.CREATED).body(restockQty);
	}

	@PostMapping("/reserve")
	public ResponseEntity<InventoryResponseDTO> reservedStock(@RequestBody InventoryStockDTO dto){
		InventoryResponseDTO reserveStock = inventoryService.reserveStock(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(reserveStock);
	}
	
	@PostMapping("/release")
	public ResponseEntity<InventoryResponseDTO> releasedStock(@RequestBody InventoryStockDTO dto){
		InventoryResponseDTO releaseStock = inventoryService.releaseStock(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(releaseStock);
	}
	
	@PostMapping("/confirm")
	public ResponseEntity<InventoryResponseDTO> confirmeStock(@RequestBody InventoryStockDTO dto){
		InventoryResponseDTO confirmStock = inventoryService.confirmStock(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(confirmStock);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<InventoryResponseDTO> getInventoryByProductId(@PathVariable Long productId){
		InventoryResponseDTO inventoryByProductId = inventoryService.getInventoryByProductId(productId);
		return ResponseEntity.status(HttpStatus.OK).body(inventoryByProductId);
	}
}
