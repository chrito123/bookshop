package com.sanchezc.bookshop.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BookPricingService {
	double unitPriceBook = 50;

	public double calculatePrice(Map<String, Integer> basket) {
		if (basket == null || basket.isEmpty())
			return 0;
		double totalPrice = 0d;
		double discount = 0d;

		boolean hasGroups = true;
		List<Integer> listOfGroups = new LinkedList<Integer>();
		while (hasGroups) {
			int uniqueBooksCounter = 0;
			for (String book : basket.keySet()) {
				int numberOfSameBook = basket.get(book);
				if (numberOfSameBook >= 1) {
					uniqueBooksCounter++;
					basket.replace(book, numberOfSameBook - 1);
				}

			}
			if (uniqueBooksCounter == 0) {
				hasGroups = false;
			} else {
				listOfGroups.add(uniqueBooksCounter);
			}
		}

		while (listOfGroups.contains(5) && listOfGroups.contains(3)) {

			listOfGroups.add(4);
			listOfGroups.add(4);
			listOfGroups.remove(Integer.valueOf(5));
            listOfGroups.remove(Integer.valueOf(3));
		}

		for (Integer group : listOfGroups) {
			discount = getDiscount(group);
			totalPrice += unitPriceBook * group * (1 - discount);
		}

		return totalPrice;
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
