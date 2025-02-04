package com.sanchezc.bookshop.service;

import java.util.Map;

public class BookPricingService {

	public double calculatePrice(Map<String, Integer> basket) {
		if(basket == null || basket.isEmpty())
			return 0;
		return -1;
	}
	
}
