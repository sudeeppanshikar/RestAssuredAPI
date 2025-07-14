package com.qa.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductAPI {

	private Integer id;
	private String title;
	private Double price;
	private String description;
	private String category;
	private String image;
	private Rating rating;

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public static class Rating {

		private Double rate;
		private Integer count;

	}

}
