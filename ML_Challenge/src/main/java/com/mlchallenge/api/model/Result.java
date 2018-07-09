package com.mlchallenge.api.model;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {
	private List<ProductsResult> data;

	public List<ProductsResult> getData() {
		return data;
	}

	public void setData(List<ProductsResult> data) {
		this.data = data;
	}
		
}
