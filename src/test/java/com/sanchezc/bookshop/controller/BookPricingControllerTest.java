package com.sanchezc.bookshop.controller;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanchezc.bookshop.service.BookPricingService;

@WebMvcTest(BookPricingController.class)
public class BookPricingControllerTest {

	@Autowired
	private MockMvc mockClient;
	@MockitoBean
	private BookPricingService bookPricingService;
	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testApiEndpointBasket() throws Exception {
		Map<String, Integer> request = new HashMap<String, Integer>();
		request.put("clean", 2);
		request.put("cleaner", 2);
		request.put("arch", 2);
		request.put("test", 1);
		request.put("working", 1);
		when(bookPricingService.calculatePrice(request)).thenReturn(320.0);
		mockClient
				.perform(MockMvcRequestBuilders.post("/api/books/calculate-price")
						.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("320.0"));
	}
}
