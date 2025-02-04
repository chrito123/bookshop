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

		assertEquals(50.0, price, "A basket with 1 book should cost 50 EUR");
	}

	@Test
	public void testBasketReturnsPriceForSimilarBooks() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 2);

		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(100.0, price, "A basket with 2 similar books should cost 100 EUR");
		
	}
	
	@Test
	public void testBasketReturnsPriceFor2DifferentBooks() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 1);
		basket.put("The Clean Coder", 1);

		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(95.0, price, "A basket with 2 different books should cost 95 EUR");
		
	}
	@Test
	public void testBasketReturnsPriceFor3DifferentBooks() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 1);
		basket.put("The Clean Coder", 1);
		basket.put("The Clean Architecture", 1);

		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(135.0, price, "A basket with 3 different books should cost 135 EUR");
		
	}
	@Test
	public void testBasketReturnsPriceFor4DifferentBooks() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 1);
		basket.put("The Clean Coder", 1);
		basket.put("The Clean Architecture", 1);
		basket.put("Test Driven Development", 1);
		
		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(160.0, price, "A basket with 4 different books should cost 160 EUR");
		
	}
	@Test
	public void testBasketReturnsPriceFor5DifferentBooks() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 1);
		basket.put("The Clean Coder", 1);
		basket.put("The Clean Architecture", 1);
		basket.put("Test Driven Development", 1);
		basket.put("Working with legacy code", 1);
		
		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(187.5, price, "A basket with 5 different books should cost 187,50 EUR");
		
	}
	@Test
	public void testFullSetAndOneBasketReturnsPrice() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 2);
		basket.put("The Clean Coder", 1);
		basket.put("The Clean Architecture", 1);
		basket.put("Test Driven Development", 1);
		basket.put("Working with legacy code", 1);
		
		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(237.5, price, "A basket with 5 different books and one similar book should cost 237,50 EUR");
		
	}
	@Test
	public void testComplexUseCaseBasketReturnsPrice() {
		Map<String, Integer> basket = new HashMap<>();

		basket.put("Clean Code", 2);
		basket.put("The Clean Coder", 2);
		basket.put("The Clean Architecture", 2);
		basket.put("Test Driven Development", 1);
		basket.put("Working with legacy code", 1);
		
		double price = bookingPricingService.calculatePrice(basket);

		assertEquals(320, price, "A basket with 2 groups of 4 different books should cost 320 EUR");
		
	}

}
