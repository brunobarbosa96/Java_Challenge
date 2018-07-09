package com.mlchallenge.api.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mlchallenge.api.model.Product;

public class ProductsService {

	public static Map<String, List<Product>> GroupBy(List<Product> products, String field) {
		
		switch(field.toLowerCase())
		{
			case "id": return products.stream().collect(Collectors.groupingBy(Product::getId));
			case "ean": return products.stream().collect(Collectors.groupingBy(Product::getEan));
			case "title": return products.stream().collect(Collectors.groupingBy(Product::getTitle));
			case "brand": return products.stream().collect(Collectors.groupingBy(Product::getBrand));
			case "price": return products.stream().collect(Collectors.groupingBy(Product::getPrice));
			case "stock": return products.stream().collect(Collectors.groupingBy(Product::getStock));
			default: return products.stream().collect(Collectors.groupingBy(Product::getTitle));
		}
		
	}
	
	public static List<Product> OrderBy(List<Product> products, String order_by){
		String ascDesc = "asc";
		String field = "";
		
		if (order_by != null && !order_by.trim().equals(""))
		{
			field = order_by.substring(0, order_by.indexOf(':'));
			ascDesc = order_by.substring(order_by.indexOf(':') +1);
		}
		
		if (ascDesc.toLowerCase().equals("asc"))
			switch(field) {
		        case "id": products.sort(Comparator.comparing(Product::getId)); break;
		        case "ean": products.sort(Comparator.comparing(Product::getEan)); break;
		        case "title": products.sort(Comparator.comparing(Product::getTitle)); break;
		        case "brand": products.sort(Comparator.comparing(Product::getBrand)); break;
		        case "price": products.sort(Comparator.comparing(Product::getPrice)); break;
		        case "stock": products.sort(Comparator.comparing(Product::getStock)); break;
		        default: products.sort(Comparator.comparing(Product::getStock)); break;
		    }
		else 
		    switch(field) {
		        case "id": products.sort(Comparator.comparing(Product::getId).reversed()); break;
		        case "ean": products.sort(Comparator.comparing(Product::getEan).reversed()); break;
		        case "title": products.sort(Comparator.comparing(Product::getTitle).reversed()); break;
		        case "brand": products.sort(Comparator.comparing(Product::getBrand).reversed()); break;
		        case "price": products.sort(Comparator.comparing(Product::getPrice).reversed()); break;
		        case "stock": products.sort(Comparator.comparing(Product::getStock).reversed()); break;
		        default: products.sort(Comparator.comparing(Product::getPrice).reversed()); break;
		    }
		
		return products;
	}
	
	public static List<Product> Filter(List<Product> products, String filter) {
		String field = "";
		Stream stream = null;
 
		if (filter != null && !filter.trim().equals("")) {
			field = filter.substring(0, filter.indexOf(':'));
			String value = filter.substring(filter.indexOf(':') +1);
	
			 switch(field) {
				 case "id": stream = products.stream().filter(x -> value.equals(x.getId())); break;
				 case "ean": stream = products.stream().filter(x -> value.equals(x.getEan())); break;
				 case "title": stream = products.stream().filter(x -> value.equals(x.getTitle())); break;
				 case "brand": stream = products.stream().filter(x -> value.equals(x.getBrand())); break;
				 case "price": stream = products.stream().filter(x -> value.equals(x.getPrice())); break;
				 case "stock": stream = products.stream().filter(x -> value.equals(x.getStock())); break; 
			 }
		}
		
		if (stream != null)
			products = (List<Product>) stream.collect(Collectors.toList());
		
		return products;
	}
	
}
