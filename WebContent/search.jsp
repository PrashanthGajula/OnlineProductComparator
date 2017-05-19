<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
</head>
<body bgcolor="#F5F5F5">
<center>
<H2><font face="Bradley Hand ITC" size="36">Online Product Comparator</font></H2>

<form name="search" action="regServlet" method="post">
<input type="hidden" name="pagename" value="search"/>
<table>

<tr>
<td>What are you looking for* </td>
<td><input type="text" name="product"></td>
</tr>
<tr>

<td>Brand*</td>
<td><input type="text" name="brandname"></td>
</tr>
<tr>
<td>Color Specifications</td>
<td>
  <select name="color">
  <option value="null">Select a color</option>
  <option value="red">Red</option>
  <option value="black">Black</option>
  <option value="white">White</option>
  <option value="grey">grey</option>
  </select>
  </td>
 </tr>
 <tr>
  <td>MinimumPrice</td>
  <td><input type="text" name="minprice"></td>
  </tr>
  <tr><td>MaximumPrice </td>
  <td><input type="text" name="maxprice"></td>
  </tr>
  <tr>
  <td><input type="submit" value="Search">
  </td>
  </tr>
 </table>
</form>
<br>


<marquee behavior="scroll">
<br>
<br>
<br>
<br>
<a href="http://www.amazon.com/Bose-QuietComfort-25-Headphones-Black/dp/B00M1NEUKK/ref=sr_1_1?s=electronics&ie=UTF8&qid=1429481682&sr=1-1&keywords=bose+headphones"> <img  src=images/bose-m.png width="220" height="180"></a>
<a href="http://www.jbl.com/over-ear-headphones/JBL+BASSLINE.html?cgid=over-ear-headphones&dwvar_JBL%20BASSLINE_color=Black#start=1"><img alt="Natural" src="images/jbl-m.png" width="220" height="180"></a>
<a href="http://www.amazon.com/Canon-EOS-Rebel-T5-Professional/dp/B00J34YO92/ref=sr_1_5?s=electronics&ie=UTF8&qid=1429482144&sr=1-5&keywords=canon+rebel+t5i"><img alt="Natural" src="images/1113canon02.jpg" width="220" height="180"></a>
<a href="http://www.amazon.com/Nikon-DX-Format-Digital-18-140mm-3-5-5-6G/dp/B00F5E3N46/ref=sr_1_2?s=electronics&ie=UTF8&qid=1429484716&sr=1-2&keywords=nikon+d7100"><img alt="Natural" src="images/91vmPXN6bxL._SL1500_.jpg" width="220" height="180"></a>
<a href="http://www.bestbuy.com/site/alienware-17-17-3-led-notebook-intel-core-i7-i7-4710mq-2-50-ghz-black/1312334517.p?id=mp1312334517&skuId=1312334517"><img alt="Natural" src="images/cnet_dell_alw17_gallery_07_800.jpg" width="220" height="180"></a>
<a href="http://www.bestbuy.com/site/apple-macbook-air-latest-model-13-3-display-intel-core-i5-4gb-memory-128gb-flash-storage-silver/1581921.p?id=1219056464137&skuId=1581921"><img alt="Natural" src="images/overview_wireless_hero.jpg" width="220" height="180"></a>
<a href="http://www.amazon.com/Powerbeats-Wireless--Ear-Headphone-Red/dp/B00IYA2YV6/ref=sr_1_3?s=electronics&ie=UTF8&qid=1429484964&sr=1-3&keywords=beats+earbuds+wireless"><img alt="Natural" src="images/433318-beats-powerbeats2-wireless.jpg" width="220" height="180"></a>
<a href="http://www.cnet.com/products/beats-studio-wireless-series/"><img alt="Natural" src="images/beats-m.png" width="220" height="180"></a>
<a href="http://www.bestbuy.com/site/apple-iphone-5-with-16gb-memory-mobile-phone-pre-owned-black-slate-at-t/9454095.p?id=1219430518152&skuId=9454095"><img alt="Natural" src="images/apple-iphone5-features.jpg" width="220" height="180"></a>
<a href="http://www.amazon.com/Motorola-Nexus-32GB-Unlocked-Midnight/dp/B00R1984DI/ref=sr_1_1?s=wireless&ie=UTF8&qid=1429485176&sr=1-1&keywords=nexus+6"><img alt="Natural" src="images/motorola-nexus-6.jpg" width="220" height="180"></a>
</marquee>

</center>
</body>
</html>