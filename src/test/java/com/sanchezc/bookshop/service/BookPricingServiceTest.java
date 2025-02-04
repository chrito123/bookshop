package com.sanchezc.bookshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BookPricingServiceTest {
	@InjectMocks
	private BookPricingService bookingPricingService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testEmptyBasketReturnsZero() {
		Map<String, Integer> basket = new HashMap<>();

		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(0.0, price, "An empty basket should cost 0 EUR");
	}
	@Test
	public void testBasketReturnsPriceForOneBook() {
		Map<String, Integer> basket = new HashMap<>();
		
		basket.put("Clean Code", 1);

		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(50.0, price, "An basket with 1 book should cost 50 EUR");
	}
}
