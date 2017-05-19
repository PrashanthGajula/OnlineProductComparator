package com.prashanth;

public class ProductInfo {
	
	private String product;
	private String brandname;
	private String color;
	private String description;
	private String minprice;
	private String maxprice;
	private String webname;
	private String rating;
	
	

	public ProductInfo(String webname){
		
		this.webname=webname;
		this.description="N/A";
		this.brandname="N/A";
		this.minprice="N/A";
		this.maxprice="N/A";
	}
	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}



	public String getBrandname() {
		return brandname;
	}



	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}



	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getMinprice() {
		return minprice;
	}



	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}



	public String getMaxprice() {
		return maxprice;
	}



	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}



	public String getWebname() {
		return webname;
	}



	public void setWebname(String webname) {
		this.webname = webname;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}





}
