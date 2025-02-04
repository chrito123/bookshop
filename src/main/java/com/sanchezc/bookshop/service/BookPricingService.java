package com.sanchezc.bookshop.service;

import java.util.Map;

public class BookPricingService {
	double unitPriceBook = 50;

	public double calculatePrice(Map<String, Integer> basket) {
		if (basket == null || basket.isEmpty())
			return 0;
		double price = 0d;
		double discount = getDiscount(basket.keySet().size());
		
		for (String book : basket.keySet()) {
			price += unitPriceBook * basket.get(book) * (1 - discount);
		}
		return price;
	}

	private double getDiscount(int uniqueBooks) {
		return switch (uniqueBooks) {
		case 2 -> 0.05;
		case 3 -> 0.10;
		case 4 -> 0.20;
		case 5 -> 0.25;
		default -> 0d;
		};
	}

}
