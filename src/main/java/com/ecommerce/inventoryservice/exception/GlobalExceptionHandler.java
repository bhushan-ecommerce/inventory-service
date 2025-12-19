package com.ecommerce.inventoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.inventoryservice.dto.ErrorResponseDTO;

@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<ErrorResponseDTO> handleInsufficientStockException(InsufficientStockException exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponseDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value()));
	}

	@ExceptionHandler(InventoryNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleInventoryNotFoundException(InventoryNotFoundException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponseDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponseDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponseDTO> handleRunrimeException(RuntimeException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponseDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
	}
}
