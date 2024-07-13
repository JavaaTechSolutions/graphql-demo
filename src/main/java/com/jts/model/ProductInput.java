package com.jts.model;

import lombok.Data;

@Data
public class ProductInput {
	private Integer id;
	private String name;
	private String category;
	private float price;
	private Integer stock;

}
