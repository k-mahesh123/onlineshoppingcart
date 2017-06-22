<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
</head>
<body>
 
<c:if test="${msg11}">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">OnlineShop-Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      
      <li><a href="product">product</a></li>
       <li><a href="contact">AboutAs</a></li>
        <li><a href="contact">ContactUs</a></li>
        
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
</c:if>




<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
</sec:authorize>
<h1>Product Data</h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<form:form action="productdetailsk" method="POST" commandName="product"  enctype="multipart/form-data">
	<table>
	    <tr>
			
			<td><form:hidden path="productid" />
			
		</tr>
		<tr>
			<td>Product name</td>
			<td><form:input path="productname" />
			<form:errors path="productname" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr>
			<td>Product Warranty</td>
			<td><form:input path="productwaranty" value=""/>
			<form:errors path="productwaranty" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr>
			<td>Product price</td>
			<td><form:input path="productprice" value=""/>
			<form:errors path="productprice" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr><td><form:label path="img">Product Image:</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>  
           </tr>
		<tr><td><form:label path="suppliername">Supplier Name:</form:label></td>
               <td><select name="Suppliername">
   				 <option value="${product.suppliername}">${product.suppliername}</option>
   				 <c:forEach var="Supplier" items="${supplier}">
   				 <option value="${Supplier.supname}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
    		<tr><td><form:label path="categoryname">Category Name:</form:label></td>
               <td><select name="categoryname">
   				 <option value="${product.categoryname}">${product.categoryname}</option>
   				 <c:forEach var="category" items="${category}">
   				 <option value="${category.categoryname}">${category.categoryname}</option>
    		</c:forEach>
    		</select></td></tr>
		<tr>
			<td colspan="2">
			<c:if test="${msg2}">
				<input type="submit" name="action" value="Add" />
				</c:if>
				<c:if test="${msg3}">
				<input type="submit" name="action" value="update" />
				</c:if>
			</td>
		</tr>
	</table>
</form:form>
</sec:authorize>
<c:if test="${msg}">
<br>
<table border="1">
    <th>productImage</th>
	<th>product ID</th>
	<th>Product Name</th>
	<th>productPrice</th>
	<th>SupplierName</th>
	<th>CategoryName</th>
	<th>ProductWaranty</th>
	
    
	
	<c:forEach items="${productList}" var="product">
		<tr>
		<td><img src='<c:url value="/resources/imgs/${product.image}"/>'/></td>
			<td><h3>${product.productid}</h3></td>
			<td><h3>${product.productname}</h3></td>
			<td><h2>${product.productprice}</h2></td>
			<td><h3>${product.suppliername}</h3></td>
			<td><h3>${product.categoryname}</h3></td>
			<td><h3>${product.productwaranty}</h3></td>
			
 

<td>
 <sec:authorize access="hasRole('ROLE_ADMIN')">
  <a href="<c:url value='/editproduct?productid=${product.productid}'/>"> 
  <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a>
  <a href="<c:url value='/deleteproduct?productid=${product.productid}'/>"> 
  <button style="font-size:10pt;color:white;background-color:#ff8080;border:3px solid #336600;padding:8px" >DELETE</button></a>
</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="<c:url value='/viewCart?productid=${product.productid}'/>">
		<button style="font-size:10pt;color:white;background-color:green;border:3px solid #336600;padding:8px">AddToCart</button></a>
	</sec:authorize>
	<c:if test="${msg10}">
		<a href="<c:url value='/viewCart?productid=${product.productid}'/>">
		<button style="font-size:10pt;color:white;background-color:green;border:3px solid #336600;padding:8px">AddToCart</button></a>
		</c:if>
		<a href="<c:url value='/viewproduct?productid=${product.productid}'/>"/>
		<button style="font-size:10pt;color:white;background-color:green;border:3px solid #336600;padding:8px">view</button></a></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>
	<br>
	<br>
	<c:if test="${msg1}">
	        <table border="1">
	<th>productImage</th>
	<th>product ID</th>
	<th>Product Name</th>
	<th>productPrice</th>
	<th>SupplierName</th>
	<th>CategoryName</th>
	<th>ProductWaranty</th>
	<th>Tools</th>
    
	
	
		<tr>
		<td><img src='<c:url value="/resources/imgs/${product.image}"/>'/></td>
			<td><h3>${product.productid}</h3></td>
			<td><h3>${product.productname}</h3></td>
			<td><h2>${product.productprice}</h2></td>
			<td><h3>${product.suppliername}</h3></td>
			<td><h3>${product.categoryname}</h3></td>
			<td><h3>${product.productwaranty}</h3></td>
	<sec:authorize access="hasRole('ROLE_USER')">
		<td><a href="<c:url value='/viewCart?productid=${product.productid}'/>">
		<button style="font-size:10pt;color:white;background-color:green;border:2px solid #336600;padding:6px">AddToCart</button></a></td>
		</sec:authorize>
		<c:if test="${msg10}">
		<td><a href="<c:url value='/viewCart?productid=${product.productid}'/>">
		<button style="font-size:10pt;color:white;background-color:green;border:2px solid #336600;padding:6px">AddToCart</button></a></td>
	</c:if>
</table>
</c:if>
<%@ include file="footer.jsp" %>
</body>
</html>