package org.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseItem{
	private String date;
	@JsonProperty("id")
	private int id;
	private int userId;
	private List<ProductsItem> products;
}