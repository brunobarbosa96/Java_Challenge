package com.mlchallenge.api.resource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mlchallenge.api.model.*;
import com.mlchallenge.api.service.ProductsService;


@RestController
@RequestMapping("/products")
public class ProductsResource {

	@PostMapping("/groupAndSort")
	public ResponseEntity<?> GroupingAndSorting(@RequestBody String json, 
												@RequestParam String filter, 
												@RequestParam String order_by, 
												@RequestParam String group_by)
	{
		Result result = new Result();
		List<ProductsResult> productsResult = new ArrayList<>();
		
		Gson gson = new Gson();
		List<Product> products = gson.fromJson(json, new TypeToken<List<Product>>(){}.getType());
		
		products = ProductsService.Filter(products, filter);
		
		Map<String, List<Product>> productsGrouping = ProductsService.GroupBy(products, group_by); 
		productsGrouping.forEach((key, value) -> {
			ProductsResult pr = new ProductsResult();
			pr.setDescription(key);
			pr.setItems(ProductsService.OrderBy(value, order_by));
			productsResult.add(pr);
		});
		
		result.setData(productsResult);
		return ResponseEntity.ok(result);
	}
	
}
