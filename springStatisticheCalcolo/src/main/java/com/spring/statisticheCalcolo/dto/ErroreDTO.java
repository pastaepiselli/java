package com.spring.statisticheCalcolo.dto;

public class ErroreDTO extends RuntimeException {
	public ErroreDTO(String message) {
		super(message);
	}
}
