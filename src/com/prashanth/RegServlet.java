package com.prashanth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String hdnParam=request.getParameter("pagename");
		if(hdnParam.equals("register")){

			String name=request.getParameter("txtname");
			String email=request.getParameter("txtemail");
			String password=request.getParameter("txtpassword");
			String gender=request.getParameter("gender");
			String age=request.getParameter("age");
			String contact=request.getParameter("txtcontact");
			
		
			GettersSetters sets = new GettersSetters();
			sets.setEmail(email);
			sets.setPassword(password);
			sets.setName(name);
		    sets.setGender(gender);
		    sets.setAge(age);
		    sets.setContact(contact);
		    
		    try{
		    	  dbManager.Insert(sets);
		    	  int checkUser=dbManager.checkUser(sets);
					if(checkUser==1){
						response.sendRedirect("register_success.jsp");
					}
		    }catch(ClassNotFoundException | SQLException e){
		    	e.printStackTrace();
		    }
			
		}
		if(hdnParam.equals("login") || hdnParam.equals("register_success")){
			String userName=request.getParameter("txtUsername");
			String password=request.getParameter("txtPassword");
			
				GettersSetters set=new GettersSetters();
				set.setEmail(userName);
				set.setPassword(password);
				
				try{
					int checkUser=dbManager.checkUser(set);
					if(checkUser==1){
						response.sendRedirect("search.jsp");
					}else{
						response.sendRedirect("login.jsp");
					}
				}catch(ClassNotFoundException | SQLException e){
					e.printStackTrace();
				}
				
			
//			try{
//				String reg=request.getParameter("buttonregister");
//				
//				if(reg!=null){
//					response.sendRedirect("register.jsp");
//				}
//				
//			}catch(Exception e){
//				e.printStackTrace();
//			}
			
			
			
			
		}
		
		
		if(hdnParam.equals("search")){
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
	try{
				String product=request.getParameter("product");
				String brandname=request.getParameter("brandname");
				String color=request.getParameter("color");
				String minprice=request.getParameter("minprice");
				String maxprice=request.getParameter("maxprice");
				//out.print("\n"+brandname+"\n"+color+"\n"+minprice+"\n"+maxprice);
				
				if(product.length()>0 && brandname.length()>0){
					
					HashMap<String, String> keys=new HashMap<String, String>();
					keys.put(ProductSearch.PRODUCT_NAME, product);
					keys.put(ProductSearch.BRAND_NAME, brandname);
					keys.put(ProductSearch.COLOR, color);
					keys.put(ProductSearch.MAX_PRICE, maxprice);
					keys.put(ProductSearch.MIN_PRICE, minprice);
					
				
					
					BestBuy obj2=new BestBuy();
					obj2.searchProduct(keys);
					
					String s1=obj2.finalQueryString;
										
					shoppercnet obj3=new shoppercnet();
					obj3.searchProduct(keys);
//					
//					Newegg obj4=new Newegg();
//					obj4.searchProduct(keys);
					
					Amazon a=new Amazon();
					a.searchProduct(keys);
//					
//					Walmart w=new Walmart();
//					w.searchProduct(keys);
					
					List<ProductInfo> bestbuyproducts=new ArrayList<ProductInfo>();
					List<ProductInfo> shopperscnetproducts=new ArrayList<ProductInfo>();
					List<ProductInfo> amazonproducts=new ArrayList<ProductInfo>();
					
					List<ProductInfo> recomendedproducts=new ArrayList<ProductInfo>();
				
					
					
					
					for(int index=0;index<obj2.getProducts().size();index++)
					{
						bestbuyproducts.add(obj2.getProducts().get(index));
					}
					
					for(int index=0;index<obj3.getProducts().size();index++)
					{
						shopperscnetproducts.add(obj3.getProducts().get(index));
					}
					for(int index=0;index<a.getProducts().size();index++)
					{
						amazonproducts.add(a.getProducts().get(index));
					}
//					for(int index=0;index<obj4.getProducts().size();index++)
//					{
//						totalHeadPhones.add(obj4.getProducts().get(index));
//					}
					
//					for(int index=0;index<w.getProducts().size();index++)
//						{
//							totalHeadPhones.add(w.getProducts().get(index));
//						}
					
//					for(int index=0;index<obj6.getHeadPhones().size();index++)
//					{
//						totalHeadPhones.add(obj6.getHeadPhones().get(index));
//					}
					
					for(int index=0;index<obj2.getProducts().size();index++)
					{
						recomendedproducts.add(obj2.getProducts().get(index));
					}
					
					for(int index=0;index<obj3.getProducts().size();index++)
					{
						recomendedproducts.add(obj3.getProducts().get(index));
					}
					for(int index=0;index<a.getProducts().size();index++)
					{
						recomendedproducts.add(a.getProducts().get(index));
					}
					
					
//					//out.println("<html><head><title>Search Results></title></head><body  background='images/pharoBackground.png'><center>");
//					out.println("<html><head><title>Search Results</title></head><body><center>"
//							+ "<h1><font face='Bradley Hand ITC' size='36'>Online Product Comparator</font></H1>");
//					
//				
//						out.println("<table border=1>");
//						out.println("<tr><td><h2><font face='Bradley Hand ITC'>BestBuy Products</font></h2>");
//						if(bestbuyproducts.size()!=0)
//						{
//						out.println("<table>");
//						int i=0;
//						int value;
//						if(bestbuyproducts.size()<10){
//							value=bestbuyproducts.size();							
//						}else{
//							value=10;
//						}
//						//for(int index=0;index<bestbuyproducts.size();index++)
//							for(int index=0;index<value;index++)
//						{
//							ProductInfo info=bestbuyproducts.get(index);
//							if((i++)%2==0)
//							{
//								//out.println("<tr bgcolor='#fdf5e6'>");
//								
//								out.println("<tr bgcolor='#E5DFD3'>");
//								
//							}
//							else
//							{
//								out.println("<tr bgcolor='#84849C'>");
//							}
//							
//				//			out.println("<td>"+info.getBrandName()+"</td>");
//							out.println("<td>"+(index+1)+"</td>");
//							out.println("<td>"+info.getDescription()+"</td>");
//							out.println("<td>"+info.getMaxprice()+"</td>");
//							out.println("<td>"+info.getRating()+"</td>");
//						}
//
//						out.println("</table></td>");
//						}else{
//							out.println(" Query result not found...</td>");
//							
//						}
//					
//						out.println("<td><h2><font face='Bradley Hand ITC'>Amazon Products</font></h2>");
//						if(amazonproducts.size()!=0){
//							
//						out.println("<table>");
//						int j=0;
//						int value;
//						if(amazonproducts.size()<10){
//							value=bestbuyproducts.size();							
//						}else{
//							value=10;
//						}
//						//for(int index=0;index<amazonproducts.size();index++)
//							for(int index=0;index<value;index++)
//						{
//							ProductInfo info=amazonproducts.get(index);
//							if((j++)%2==0)
//							{
//								//out.println("<tr bgcolor='#fdf5e6'>");
//								
//								out.println("<tr bgcolor='#E5DFD3'>");
//								
//							}
//							else
//							{
//								out.println("<tr bgcolor='#84849C'>");
//							}
//							
//				//			out.println("<td>"+info.getBrandName()+"</td>");
//							out.println("<td>"+(index+1)+"</td>");
//							out.println("<td>"+info.getDescription()+"</td>");
//							out.println("<td>"+info.getMaxprice()+"</td>");
//							out.println("<td>"+info.getRating()+"</td>");
//						}
//						out.println("</table></td></tr>");
//						}else{
//								out.println("Query result not found...</td></tr>");						
//						}
//						
//						out.println("<tr><td><h2><font face='Bradley Hand ITC'>Shopperscnet Products</font></h2>");
//						if(shopperscnetproducts.size()!=0){
//						out.println("<table>");
//						int k=0;
//						int value;
//						if(shopperscnetproducts.size()<10){
//							value=bestbuyproducts.size();							
//						}else{
//							value=10;
//						}
//						//for(int index=0;index<amazonproducts.size();index++)
//							for(int index=0;index<value;index++)
//						{
//							ProductInfo info=shopperscnetproducts.get(index);
//							if((k++)%2==0)
//							{
//								//out.println("<tr bgcolor='#fdf5e6'>");
//								
//								out.println("<tr bgcolor='#E5DFD3'>");
//								
//							}
//							else
//							{
//								out.println("<tr bgcolor='#84849C'>");
//							}
//							
//				//			out.println("<td>"+info.getBrandName()+"</td>");
//							out.println("<td>"+(index+1)+"</td>");
//							out.println("<td>"+info.getDescription()+"</td>");
//							out.println("<td>"+info.getMaxprice()+"</td>");
//							out.println("<td>"+info.getRating()+"</td>");
//						}
//							out.println("</table></td>");
//						}else{
//							out.println("Query result not found...</td>");
//							
//						}
//						out.println("<td><h2><font face='Bradley Hand ITC'>Recomended Products</font></h2>");
//						if(recomendedproducts.size()!=0){
//						out.println("<table>");
//						int l=0;
//						int value;
//						if(recomendedproducts.size()<10){
//							value=recomendedproducts.size();							
//						}else{
//							value=10;
//						}
//						//for(int index=0;index<amazonproducts.size();index++)
//							for(int index=0;index<value;index++)
//						{
//								Random r=new Random();
//								int randomnumber=r.nextInt(recomendedproducts.size()+1-1)+1;
//							ProductInfo info=recomendedproducts.get(randomnumber);
//							if((l++)%2==0)
//							{
//								//out.println("<tr bgcolor='#fdf5e6'>");
//								
//								out.println("<tr bgcolor='#E5DFD3'>");
//								
//							}
//							else
//							{
//								out.println("<tr bgcolor='#84849C'>");
//							}
//							
//				//			out.println("<td>"+info.getBrandName()+"</td>");
//							out.println("<td>"+(index+1)+"</td>");
//							out.println("<td>"+info.getDescription()+"</td>");
//							out.println("<td>"+info.getMaxprice()+"</td>");
//							out.println("<td>"+info.getRating()+"</td>");
//						}out.println("</table></td></tr>");
//				}else{
//					out.println("No Recommendations ...");
//					
//				}
//						
//						out.println("</td></tr></table>");
//						out.println("<a href='search.jsp'><strong><font size='4'>Search</font></strong></a>");
//						out.println("</center></body></html>");
//						out.close();
					
					
					
					
				
					out.println("<html><head><title>Search Results</title></head><body><center>"
							+ "<h1><font face='Bradley Hand ITC' size='36'>Online Product Comparator</font></H1>");
					
				
					out.print("<a href='"+s1+"'><font face='Bradley Hand ITC'>BestBuy Products</font></a>");
					//	out.println("<h2><font face='Bradley Hand ITC'>BestBuy Products</font></h2>");
						
						if(bestbuyproducts.size()!=0)
						{
						out.println("<table>");
						int i=0;
						int value;
						if(bestbuyproducts.size()<10){
							value=bestbuyproducts.size();							
						}else{
							value=10;
						}
						//for(int index=0;index<bestbuyproducts.size();index++)
							for(int index=0;index<value;index++)
						{
							ProductInfo info=bestbuyproducts.get(index);
							if((i++)%2==0)
							{
								//out.println("<tr bgcolor='#fdf5e6'>");
								
								out.println("<tr bgcolor='#E5DFD3'>");
								
							}
							else
							{
								out.println("<tr bgcolor='#84849C'>");
							}
							
				//			out.println("<td>"+info.getBrandName()+"</td>");
							out.println("<td>"+(index+1)+"</td>");
							out.println("<td>"+info.getDescription()+"</td>");
							out.println("<td>"+info.getMaxprice()+"</td>");
							out.println("<td>"+info.getRating()+"</td>");
						}

						out.println("</table>");
						}else{
							out.println(" Query result not found...");
							
						}
					
						out.println("<h2><font face='Bradley Hand ITC'>Amazon Products</font></h2>");
						if(amazonproducts.size()!=0){
							
						out.println("<table>");
						int j=0;
						int value;
						if(amazonproducts.size()<10){
							value=amazonproducts.size();							
						}else{
							value=10;
						}
						//for(int index=0;index<amazonproducts.size();index++)
							for(int index=0;index<value;index++)
						{
							ProductInfo info=amazonproducts.get(index);
							if((j++)%2==0)
							{
								//out.println("<tr bgcolor='#fdf5e6'>");
								
								out.println("<tr bgcolor='#E5DFD3'>");
								
							}
							else
							{
								out.println("<tr bgcolor='#84849C'>");
							}
							
				//			out.println("<td>"+info.getBrandName()+"</td>");
							out.println("<td>"+(index+1)+"</td>");
							out.println("<td>"+info.getDescription()+"</td>");
							out.println("<td>"+info.getMaxprice()+"</td>");
							out.println("<td>"+info.getRating()+"</td>");
						}
						out.println("</table>");
						}else{
								out.println("Query result not found...");						
						}
						
						out.println("<h2><font face='Bradley Hand ITC'>Shopperscnet Products</font></h2>");
						if(shopperscnetproducts.size()!=0){
						out.println("<table>");
						int k=0;
						int value;
						if(shopperscnetproducts.size()<10){
							value=shopperscnetproducts.size();							
						}else{
							value=10;
						}
						//for(int index=0;index<amazonproducts.size();index++)
							for(int index=0;index<value;index++)
						{
							ProductInfo info=shopperscnetproducts.get(index);
							if((k++)%2==0)
							{
								//out.println("<tr bgcolor='#fdf5e6'>");
								
								out.println("<tr bgcolor='#E5DFD3'>");
								
							}
							else
							{
								out.println("<tr bgcolor='#84849C'>");
							}
							
				//			out.println("<td>"+info.getBrandName()+"</td>");
							out.println("<td>"+(index+1)+"</td>");
							out.println("<td>"+info.getDescription()+"</td>");
							out.println("<td>"+info.getMaxprice()+"</td>");
							out.println("<td>"+info.getRating()+"</td>");
						}
							out.println("</table>");
						}else{
							out.println("Query result not found...");
							
						}
						out.println("<td><h2><font face='Bradley Hand ITC'>Recomended Products</font></h2>");
						if(recomendedproducts.size()!=0){
							out.println("<table>");
						int l=0;
						int value;
						if(recomendedproducts.size()<10){
							value=recomendedproducts.size();							
						}else{
							value=10;
						}
						//for(int index=0;index<amazonproducts.size();index++)
							for(int index=0;index<value;index++)
						{
								Random r=new Random();
								int randomnumber=r.nextInt(recomendedproducts.size()+1-1)+1;
							ProductInfo info=recomendedproducts.get(randomnumber);
							if((l++)%2==0)
							{
								//out.println("<tr bgcolor='#fdf5e6'>");
								
								out.println("<tr bgcolor='#E5DFD3'>");
								
							}
							else
							{
								out.println("<tr bgcolor='#84849C'>");
							}
							
				//			out.println("<td>"+info.getBrandName()+"</td>");
							out.println("<td>"+(index+1)+"</td>");
							out.println("<td>"+info.getDescription()+"</td>");
							out.println("<td>"+info.getMaxprice()+"</td>");
							out.println("<td>"+info.getRating()+"</td>");
						}
							out.println("</table><br><br>");
						}else{
							out.println("No Recommendations<br><br>");							
						}
						
						
						
						out.println("<a href='search.jsp'><strong><font size='4'>Search</font></strong></a>");
						out.println("</center></body></html>");
						out.close();
					}			
				else
				{
					response.sendRedirect("search.jsp");
				}
					
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				out.close();
			}
		}
	}

}
