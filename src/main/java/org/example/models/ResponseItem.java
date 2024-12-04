package org.example.models;

import java.util.List;
import lombok.Data;

@Data
public class ResponseItem{
	private String date;
	private int id;
	private int userId;
	private List<ProductsItem> products;
}