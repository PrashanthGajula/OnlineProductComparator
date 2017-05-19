package com.prashanth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;


public class Amazon implements ProductSearch{
	List<ProductInfo> AmazonSearchMobiles=new ArrayList<ProductInfo>();
	
	
	public void processMyNodes(String queryStringFormat)
	{
		try
		{
			System.out.println("At process my node method 17");
			
			Parser prod_info=new Parser(queryStringFormat);
			NodeFilter prod_info_filter=new HasAttributeFilter("class","a-size-medium a-color-null s-inline s-access-title a-text-normal");
			NodeList prod_info_list=prod_info.parse(prod_info_filter);
			prod_info_list=prod_info_list.extractAllNodesThatMatch(prod_info_filter);
//			System.out.println("Lrg bold class:"+prod_info_list.elementAt(0).getFirstChild().toPlainTextString());
			
			
			Parser prod_price=new Parser(queryStringFormat);
			NodeFilter prod_price_list=new HasAttributeFilter("class","a-size-base a-color-price s-price a-text-bold");
			NodeList prod_priceList=prod_price.parse(prod_price_list);
			prod_priceList=prod_priceList.extractAllNodesThatMatch(prod_price_list);
//			System.out.println("price bld:"+prod_priceList.elementAt(0).getFirstChild().toPlainTextString());
			

			Parser prod_rating=new Parser(queryStringFormat);
			NodeFilter prod_rating_list=new HasAttributeFilter("class", "a-icon-alt");
			NodeList prod_ratingList=prod_rating.parse(prod_rating_list);
			prod_ratingList=prod_ratingList.extractAllNodesThatMatch(prod_rating_list);
			System.out.println("Amazon rating:"+prod_ratingList.elementAt(0).getFirstChild().toPlainTextString());
			
			for(int i=0;i<prod_priceList.size();i++)
			{
				ProductInfo pinfo=new ProductInfo("http://www.amazon.com");
//				minfo.setBrandName(prod_imageList.elementAt(i).getFirstChild().toPlainTextString());
				
				pinfo.setDescription(prod_info_list.elementAt(i).getLastChild().toPlainTextString());
				pinfo.setMaxprice(prod_priceList.elementAt(i).getLastChild().toPlainTextString());
				pinfo.setRating(prod_ratingList.elementAt(i).getFirstChild().toPlainTextString());
				
				System.out.println("I:"+i+" Des:"+pinfo.getDescription()+" Price:"+pinfo.getMaxprice()+"Rating :"+pinfo.getRating());
				
				AmazonSearchMobiles.add(pinfo);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}	
	
	@Override
	public void searchProduct(HashMap<String, String> searchKeys) {
		// TODO Auto-generated method stub
		QueryStringFormatter formatter=new QueryStringFormatter("http://www.amazon.com/s/ref=nb_sb_noss_1");
		try
		{
			formatter.addQuery("url", "search-alias");
			
			if(searchKeys.get(ProductSearch.BRAND_NAME)!=null)
			{
				formatter.addQuery("field-keywords",(String)searchKeys.get(ProductSearch.BRAND_NAME)+" "+(String)searchKeys.get(ProductSearch.PRODUCT_NAME)+" ");
				
			}
			String color=(String)searchKeys.get(ProductSearch.COLOR);
			String min=(String)searchKeys.get(ProductSearch.MIN_PRICE);
			String max=(String)searchKeys.get(ProductSearch.MAX_PRICE);
			if(color.length()>0){
				formatter.addQuery("color", (String)searchKeys.get(ProductSearch.COLOR));
			}
			if(min.length()>0&&max.length()>0)
			{
			
			formatter.addQuery("sprefix",(String)searchKeys.get(ProductSearch.BRAND_NAME)+" Mobile phones"+" "+(String)searchKeys.get(ProductSearch.COLOR)+" Price between $"+(String)searchKeys.get(ProductSearch.MIN_PRICE)+" to $"+(String)searchKeys.get(ProductSearch.MAX_PRICE));
			}
			String finalQueryString="http://www.amazon.com/s/ref=nb_sb_noss_1"+formatter.getQueryString();
			System.out.println("Query:"+finalQueryString);
			processMyNodes(finalQueryString);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<ProductInfo> getProducts() {
		// TODO Auto-generated method stub
		return AmazonSearchMobiles;
	}

}
