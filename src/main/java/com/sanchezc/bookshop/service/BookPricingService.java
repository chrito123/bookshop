package com.sanchezc.bookshop.service;

import java.util.Map;

public class BookPricingService {
	double unitPriceBook = 50 ;
	
	public double calculatePrice(Map<String, Integer> basket) {
		if(basket == null || basket.isEmpty())
			return 0;
		double price = 0d;
		for (String  book : basket.keySet()) {
			price += unitPriceBook ; 
		}
		return price;
	}
	
}
