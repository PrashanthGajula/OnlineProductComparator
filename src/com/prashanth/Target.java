package com.prashanth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

public class Target implements ProductSearch{
List<ProductInfo> TargetProducts=new ArrayList<ProductInfo>();
	
	public void processMyNodes(String queryStringFormat){
			
			try{
				Parser prod_price=new Parser(queryStringFormat);
				NodeFilter prod_price_list=new HasAttributeFilter("class","price price-label");
				NodeList prod_priceList=prod_price.parse(prod_price_list);
				prod_priceList=prod_priceList.extractAllNodesThatMatch(prod_price_list);
				System.out.println("walmart price: "+prod_priceList.elementAt(0).getFirstChild().toPlainTextString());
				
				Parser prod_info=new Parser(queryStringFormat);
				NodeFilter prod_info_filter=new HasAttributeFilter("class","screen-reader-only");
				NodeList prod_info_list=prod_info.parse(prod_info_filter);
				prod_info_list=prod_info_list.extractAllNodesThatMatch(prod_info_filter);
				System.out.println("walmart description:"+prod_info_list.elementAt(0).getFirstChild().toPlainTextString());
				
				Parser prod_rating=new Parser(queryStringFormat);
				NodeFilter prod_rating_list=new HasAttributeFilter("class", "stars stars-small tile-row");
				NodeList prod_ratingList=prod_rating.parse(prod_rating_list);
				prod_ratingList=prod_ratingList.extractAllNodesThatMatch(prod_rating_list);
				System.out.println("walmart rating:"+prod_ratingList.elementAt(0).getFirstChild().toPlainTextString());
				
				
				for(int i=0;i<prod_priceList.size();i++)
				{
					ProductInfo pinfo=new ProductInfo("http://www.target.com/s");
//					minfo.setBrandName(prod_imageList.elementAt(i).getFirstChild().toPlainTextString());
					
					pinfo.setDescription(prod_info_list.elementAt(i).getFirstChild().toPlainTextString());
					pinfo.setMaxprice(prod_priceList.elementAt(i).getFirstChild().toPlainTextString());
					pinfo.setRating(prod_ratingList.elementAt(i).getFirstChild().toPlainTextString());
					
					System.out.println("I:"+i+"\n Des:"+pinfo.getDescription()+"\nPrice:"+pinfo.getMaxprice()+"\nRating :"+pinfo.getRating());
					
					TargetProducts.add(pinfo);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

		@Override
		public void searchProduct(HashMap<String, String> searchKeys) {
			// TODO Auto-generated method stub
			 
			QueryStringFormatter formatter=new QueryStringFormatter("http://www.target.com/s");
			try{
				//formatter.addQuery1("query", "ca77b9b4beca91fe414314b86bb581f8en20");
				
				String color=(String)searchKeys.get(ProductSearch.COLOR);
				String min=(String)searchKeys.get(ProductSearch.MIN_PRICE);
				String max=(String)searchKeys.get(ProductSearch.MAX_PRICE);
				
				if((searchKeys.get(ProductSearch.BRAND_NAME)!=null) && (searchKeys.get(ProductSearch.PRODUCT_NAME)!=null)){
					
				formatter.addQuery1("searchTerm",(String)searchKeys.get(ProductSearch.BRAND_NAME)+" "+(String)searchKeys.get(ProductSearch.PRODUCT_NAME));
					
				}
				
				
				if(color!=null){
				formatter.addQuery1("",color);
				}
				if(min.length()>0&&max.length()>0)
				{
				//formatter.addQuery("color",(String)searchKeys.get(HeadPhonesSearch.COLOR_S)+" Price between $"+(String)searchKeys.get(HeadPhonesSearch.MIN_PRICE)+" to $"+(String)searchKeys.get(HeadPhonesSearch.MAX_PRICE));
					
					formatter.addQuery1(" Price between $",min +" to $"+max);
				}
				String finalQueryString="http://www.target.com/s"+formatter.getQueryString();
				
				System.out.println("Query:"+finalQueryString);
				processMyNodes(finalQueryString);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}

		@Override
		public List<ProductInfo> getProducts() {
			// TODO Auto-generated method stub
			return TargetProducts;
		}


}
