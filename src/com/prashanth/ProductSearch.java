package com.prashanth;

import java.util.HashMap;
import java.util.List;
public interface ProductSearch {
	
	public final String PRODUCT_NAME="PRODUCT_NAME";
	public final String BRAND_NAME="BRAND_NAME";
	public final String MIN_PRICE="MIN_PRICE";
	public final String MAX_PRICE="MAX_PRICE";
	public final String COLOR="COLOR";
	
	
	public void searchProduct(HashMap<String, String> searchKeys);
	public List<ProductInfo> getProducts();

}
