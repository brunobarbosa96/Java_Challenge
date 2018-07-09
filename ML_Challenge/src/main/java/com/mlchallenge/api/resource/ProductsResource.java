package com.mlchallenge.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlchallenge.api.model.*;

@RestController
@RequestMapping("/products")
public class ProductsResource {

	
	public ResponseEntity<?> GroupingAndSorting(@Valid @RequestBody List<Product> products)
	{
		
		
		
		/*
		if (id == null || id == 0)	
			return ResponseEntity.notFound().build();
		else 
			return ResponseEntity.ok("Id informado: " + id.toString());
		 */	
	}
	
}
