package com.sanchezc.bookshop.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenApiController {
	@GetMapping(value = "/openapi.yaml", produces = MediaType.APPLICATION_YAML_VALUE)
	public ResponseEntity<Resource> getOpenApiYaml() {
		Resource resource = new ClassPathResource("openapi.yaml");
		return ResponseEntity.ok(resource);
	}
}
