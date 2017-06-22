<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Management</title>
</head>
<body>
<%@ include file="adminnav.jsp" %>
 
<h1>Category Data</h1>

<form:form action="categorydetailsk" method="POST" commandName="category">
	<table>
	    <tr>
		
			<td><form:hidden path="categoryid" />
			
		</tr>
		<tr>
			<td>Category name</td>
			<td><form:input path="categoryname" />
			<form:errors path="categoryname" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr>
			<td>gender</td>
			<td><form:input path="gender" value=""/>
			<form:errors path="gender" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr><td><form:label path="suppliername">Supplier Name:</form:label></td>
               <td><select name="Suppliername">
   				 <option value="${category.suppliername}">${category.suppliername}</option>
   				 <c:forEach var="Supplier" items="${supplier}">
   				 <option value="${Supplier.supname}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
		<tr>
			<td colspan="2">
			<c:if test="${msg1}">
				<input type="submit" name="action" value="Add" />
				</c:if>
				<c:if test="${msg2}">
				<input type="submit" name="action" value="update" />
				</c:if>
			</td>
		</tr>
	</table>
</form:form>

<br>
<table border="1">
	<th>Category ID</th>
	<th>Category Name</th>
	<th>gender</th>
	<th>SupplierName</th>
    <th>VIEW</th>
	<th>EDIT</th>
	<th>DELETE</th>
	
	<c:forEach items="${categoryList}" var="category">
		<tr>
			<td>${category.categoryid}</td>
			<td>${category.categoryname}</td>
			<td>${category.gender}</td>
			<td>${category.suppliername}</td>
			
 <td><a href="<c:url value='/viewcategory?categoryid=${category.categoryid}'/>"/>
 <button style="font-size:10pt;color:white;background-color:#008000;border:3px solid #336600;padding:8px" >VIEW</button></a></td>
 
  <td><a href="<c:url value='/editcategory?categoryid=${category.categoryid}'/>"> 
  <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a></td>
  <td><a href="<c:url value='/deletecategory?categoryid=${category.categoryid}'/>">
   <button style="font-size:10pt;color:white;background-color:#ff8080;border:3px solid #336600;padding:8px" >DELETE</button></a></td>

		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<c:if test="${msg}">
	        <table border="1">
	<th>Category ID</th>
	<th>Category Name</th>
	<th>gender</th>
	<th>SupplierName</th>

	
		<tr>
			<td>${category.categoryid}</td>
			<td>${category.categoryname}</td>
			<td>${category.gender}</td>
			<td>${category.suppliername}</td>

	
	
</table>
</c:if>
</body>
</html>