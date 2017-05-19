package com.prashanth;

import java.net.URLEncoder;

public class QueryStringFormatter {
	private String queryEngine;
	private StringBuilder query=new StringBuilder();
	
	public QueryStringFormatter(String queryEngine)
	{
		this.queryEngine=queryEngine;
	}
	public String getEngine() {
		return this.queryEngine;
		}
	public void addQuery(String queryString, String queryValue)throws Exception
	{
		query.append(queryString+"="+URLEncoder.encode(queryValue,"UTF-8")+"&");
		
		//query.append(queryString+"="+URLEncoder.encode(queryValue,"UTF-8"));
		
		
	}
	
	public void addQuery1(String queryString, String queryValue) throws Exception{
		
		query.append(queryString+"="+URLEncoder.encode(queryValue,"UTF-8")+"%20");
	}
public void addQuery2(String queryString, String queryValue) throws Exception{
		
		query.append(queryString+"="+URLEncoder.encode(queryValue,"UTF-8")+"+");
	}
	public String getQueryString()
	{
		//System.out.println("QSF query: "+query.toString());
		return "?"+query.toString();
		//return query.toString();
	}


}
