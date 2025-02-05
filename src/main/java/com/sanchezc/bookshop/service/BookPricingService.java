package com.sanchezc.bookshop.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookPricingService {

	private final double unitPriceBook;

	@Autowired
	public BookPricingService(@Value("${book.unit.price}") double unitPrice) {
		this.unitPriceBook = unitPrice;
	}

	public double calculatePrice(Map<String, Integer> basket) {
		if (basket == null || basket.isEmpty())
			return 0;
		double totalPrice = 0d;
		double discount = 0d;

		List<Integer> notOptimizedGroup = getGroups(basket);
		List<Integer> optimizedList = getOptimizedGroups(notOptimizedGroup);

		for (Integer group : optimizedList) {
			discount = getDiscount(group);
			totalPrice += unitPriceBook * group * (1 - discount);
		}

		return totalPrice;
	}

	private List<Integer> getOptimizedGroups(List<Integer> groupsToBeOptimized) {
		List<Integer> optimizedGroups = new LinkedList<Integer>(groupsToBeOptimized);

		while (optimizedGroups.contains(5) && optimizedGroups.contains(3)) {

			optimizedGroups.add(4);
			optimizedGroups.add(4);
			optimizedGroups.remove(Integer.valueOf(5));
			optimizedGroups.remove(Integer.valueOf(3));
		}

		return optimizedGroups;
	}

	private List<Integer> getGroups(Map<String, Integer> basket) {
		Map<String, Integer> copyBasket = new HashMap<String, Integer>(basket);
		List<Integer> listOfGroups = new LinkedList<Integer>();
		boolean hasGroups = true;

		while (hasGroups) {
			int uniqueBooksCounter = 0;
			for (String book : copyBasket.keySet()) {
				int numberOfSameBook = copyBasket.get(book);
				if (numberOfSameBook >= 1) {
					uniqueBooksCounter++;
					copyBasket.replace(book, numberOfSameBook - 1);
				}

			}
			if (uniqueBooksCounter == 0) {
				hasGroups = false;
			} else {
				listOfGroups.add(uniqueBooksCounter);
			}
		}
		return listOfGroups;
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
