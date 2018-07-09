package com.mlchallenge.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mlchallenge.api.resource.ProductsResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MlChallengeApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private ProductsResource productResource;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(productResource).build();
	}
	
	@Test
	public void testGroupAndSortWithQueryParameters() throws Exception {
		JSONObject json = new JSONObject();
		json.put("id", "123");
		json.put("ean", "7898100848355");
		json.put("title", "Cruzador	espacial	Nikana	- 3000m	- sem	garantia");
		json.put("brand", "nikana");
		json.put("price", "820900.90");
		json.put("stock", "1");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(json);
			
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/products/groupAndSort")
				.param("filter", "id:123")
				.param("order_by", "price:asc")
				.param("group_by", "title")
				.contentType(MediaType.APPLICATION_JSON).content(jsonArray.toString())
				)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGroupAndSortWithOutQueryParameters() throws Exception {
		JSONObject json = new JSONObject();
		json.put("id", "");
		json.put("ean", "");
		json.put("title", "");
		json.put("brand", "");
		json.put("price", "");
		json.put("stock", "");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(json);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/products/groupAndSort")
				.param("filter", "")
				.param("order_by", "")
				.param("group_by", "")
				.contentType(MediaType.APPLICATION_JSON).content(jsonArray.toString())
		)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
