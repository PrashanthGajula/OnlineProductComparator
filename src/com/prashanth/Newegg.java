package com.prashanth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

public class Newegg implements ProductSearch {
List<ProductInfo> neweggProducts=new ArrayList<ProductInfo>();
	
	public void processMyNodes(String queryStringFormat){
		
		try{
             System.out.println("At process my node method 17");
			
			Parser prod_info=new Parser(queryStringFormat);
			NodeFilter prod_info_filter=new HasAttributeFilter("class","itemDescription");
			NodeList prod_info_list=prod_info.parse(prod_info_filter);
			prod_info_list=prod_info_list.extractAllNodesThatMatch(prod_info_filter);
//			System.out.println("Lrg bold class:"+prod_info_list.elementAt(0).getFirstChild().toPlainTextString());
			
			
			Parser prod_price=new Parser(queryStringFormat);
			//NodeFilter prod_price_list=new HasAttributeFilter("class","price-current-label");
			NodeFilter prod_price_list=new HasAttributeFilter("strong");
			
			NodeList prod_priceList=prod_price.parse(prod_price_list);
			
			prod_priceList=prod_priceList.extractAllNodesThatMatch(prod_price_list);
		
			
//			System.out.println("price bld:"+prod_priceList.elementAt(0).getFirstChild().toPlainTextString());
			
			for(int i=0;i<5;i++)
			{
				ProductInfo hinfo=new ProductInfo("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&DEPA=0&Order=BESTMATCH");
//				minfo.setBrandName(prod_imageList.elementAt(i).getFirstChild().toPlainTextString());
				
				hinfo.setDescription(prod_info_list.elementAt(i).getFirstChild().toPlainTextString());
				hinfo.setMaxprice(prod_priceList.elementAt(i).getNextSibling().toPlainTextString());
				
				System.out.println("I:"+i+"\n Des:"+hinfo.getDescription()+"\nPrice:$"+hinfo.getMaxprice());
				
				neweggProducts.add(hinfo);
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
		return neweggProducts;
	}




	@Override
	public void searchProduct(HashMap<String, String> searchKeys) {
		// TODO Auto-generated method stub
	//	QueryStringFormatter formatter=new QueryStringFormatter("http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&DEPA=0&Order=BESTMATCH&");
		QueryStringFormatter formatter=new QueryStringFormatter("http://www.newegg.com/Product/ProductList.aspx");
		try
		{
			formatter.addQuery("Submit", "ENE&DEPA=0&Order=BESTMATCH");
//			formatter.addQuery("url", "search-alias");
			
			String color=(String)searchKeys.get(ProductSearch.COLOR);
			String min=(String)searchKeys.get(ProductSearch.MIN_PRICE);
			String max=(String)searchKeys.get(ProductSearch.MAX_PRICE);
			if(searchKeys.get(ProductSearch.BRAND_NAME)!=null)
			{
				formatter.addQuery("Description",(String)searchKeys.get(ProductSearch.BRAND_NAME) +" "+ (String)searchKeys.get(ProductSearch.PRODUCT_NAME)+" ");				
				
			}
			
			if(color!=null){
				//formatter.addQuery("color ",color);
				formatter.addQuery("color", color);
			}
			if(min.length()>0&&max.length()>0)
			{
			//formatter.addQuery("color",(String)searchKeys.get(HeadPhonesSearch.COLOR_S)+" Price between $"+(String)searchKeys.get(HeadPhonesSearch.MIN_PRICE)+" to $"+(String)searchKeys.get(HeadPhonesSearch.MAX_PRICE));
				
				//formatter.addQuery(" Price between $",min +" to $"+max);
				formatter.addQuery("name", "%24"+min+"%20"+"-%20%24"+max);
			}
			formatter.addQuery("tag","srch");
			
			String finalQueryString="http://www.newegg.com/Product/ProductList.aspx?Submit=ENE&DEPA=0&Order=BESTMATCH&"+formatter.getQueryString();
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
