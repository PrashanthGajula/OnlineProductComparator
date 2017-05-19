package com.prashanth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
public class shoppercnet implements ProductSearch{
List<ProductInfo> shoppercnetproducts=new ArrayList<ProductInfo>();
	
	public void processMyNodes(String queryStringFormat){
		
		try{
             System.out.println("At process my node method 17");
			
			Parser prod_info=new Parser(queryStringFormat);
			NodeFilter prod_info_filter=new HasAttributeFilter("h3");
			NodeList prod_info_list=prod_info.parse(prod_info_filter);
			prod_info_list=prod_info_list.extractAllNodesThatMatch(prod_info_filter);
//			System.out.println("Lrg bold class:"+prod_info_list.elementAt(0).getFirstChild().toPlainTextString());
			
			
			Parser prod_price=new Parser(queryStringFormat);
			NodeFilter prod_price_list=new HasAttributeFilter("class","priceRange");
			NodeList prod_priceList=prod_price.parse(prod_price_list);			
			prod_priceList=prod_priceList.extractAllNodesThatMatch(prod_price_list);
		//	System.out.println(prod_priceList.elementAt(0).getFirstChild().toPlainTextString());
			
			
			Parser prod_rating=new Parser(queryStringFormat);
			NodeFilter prod_rating_list=new HasAttributeFilter("class", "rating");
			NodeList prod_ratingList=prod_rating.parse(prod_rating_list);
			prod_ratingList=prod_ratingList.extractAllNodesThatMatch(prod_rating_list);

			
			for(int i=0;i<prod_priceList.size();i++)
			{
				ProductInfo hinfo=new ProductInfo("http://shopper.cnet.com/1770-5_9-0.html");
//				minfo.setBrandName(prod_imageList.elementAt(i).getFirstChild().toPlainTextString());
				
				hinfo.setDescription(prod_info_list.elementAt(i).getFirstChild().toPlainTextString());
				hinfo.setMaxprice(prod_priceList.elementAt(i).getFirstChild().toPlainTextString());
				hinfo.setRating(prod_ratingList.elementAt(i).getFirstChild().toPlainTextString());
				
				System.out.println("I:"+i+" Des:"+hinfo.getDescription()+"Price:"+hinfo.getMaxprice());
				
				shoppercnetproducts.add(hinfo);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	


	@Override
	public List<ProductInfo> getProducts() {
		// TODO Auto-generated method stub
		return shoppercnetproducts;
	}




	@Override
	public void searchProduct(HashMap<String, String> searchKeys) {
		// TODO Auto-generated method stub
		QueryStringFormatter formatter=new QueryStringFormatter("http://shopper.cnet.com/1770-5_9-0.html");
		
		try
		{
//			formatter.addQuery("url", "search-alias");
			if(searchKeys.get(ProductSearch.BRAND_NAME)!=null && searchKeys.get(ProductSearch.PRODUCT_NAME)!=null)
			{
				formatter.addQuery("query",(String)searchKeys.get(ProductSearch.BRAND_NAME) +" "+ (String)searchKeys.get(ProductSearch.PRODUCT_NAME)+" " );				
				
			}
			String color=(String)searchKeys.get(ProductSearch.COLOR);
			String min=(String)searchKeys.get(ProductSearch.MIN_PRICE);
			String max=(String)searchKeys.get(ProductSearch.MAX_PRICE);
			if(color!=null){
				formatter.addQuery("color",color);
			}
			if(min.length()>0&&max.length()>0)
			{
			//formatter.addQuery("color",(String)searchKeys.get(HeadPhonesSearch.COLOR_S)+" Price between $"+(String)searchKeys.get(HeadPhonesSearch.MIN_PRICE)+" to $"+(String)searchKeys.get(HeadPhonesSearch.MAX_PRICE));
				
				formatter.addQuery(" Price between $",min +" to $"+max);
			}
			formatter.addQuery("tag","srch");
			
			String finalQueryString="http://shopper.cnet.com/1770-5_9-0.html"+formatter.getQueryString();
			System.out.println("query string :"+formatter.getQueryString());
			System.out.println("Query:"+finalQueryString);
			processMyNodes(finalQueryString);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
		
	}

}
