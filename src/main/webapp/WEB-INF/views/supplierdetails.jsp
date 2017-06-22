<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Management</title>
</head>
<body>
<%@ include file="adminnav.jsp" %>
 
<h1>Supplier Data</h1>


<form:form action="supplieroperations" method="POST" commandName="supplier">
	<table>
	
	    <tr>
		
			<td><form:hidden path="supid" />
		
		</tr>
		<tr>
			<td>supplier name</td>
			<td><form:input path="supname" />
			<form:errors path="supname" cssStyle="color: #ff0000" /></td>
		</tr>
	
		<tr>
			<td>Supplier address</td>
			<td><form:input path="supaddress" />
			<form:errors path="supaddress" cssStyle="color: #ff0000" /></td>
		</tr>
		
		<tr>
			<td>supplier mailid</td>
			<td><form:input path="supemail" />
			<form:errors path="supemail" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr>
			<td>supplier contact</td>
			<td><form:input path="supcontact" />
			<form:errors path="supcontact" cssStyle="color: #ff0000" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<c:if test="${msg}">
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
	<th>Supplier ID</th>
	<th>Supplier Name</th>
	<th>supplier Address</th>
	<th>Supplier contact</th>
	<th>Supplier mail</th>
	<th>VIEW</th>
	<th>EDIT</th>
	<th>DELETE</th>
	<c:forEach items="${supplierList}" var="supplier">
		<tr>
			<td>${supplier.supid}</td>
			<td>${supplier.supname}</td>
			<td>${supplier.supaddress}</td>
			<td>${supplier.supcontact}</td>
			<td>${supplier.supemail}</td>
 <td><a href="<c:url value='/viewsupplier?supid=${supplier.supid}'/>"/>
 <button style="font-size:10pt;color:white;background-color:GREEN;border:3px solid #336600;padding:8px" >VIEW</button></a></td>
 
  <td><a href="<c:url value='/editsupplier?supid=${supplier.supid}'/>">
   <button style="font-size:10pt;color:white;background-color:#0080ff;border:3px solid #336600;padding:8px" >EDIT</button></a></td>
  <td><a href="<c:url value='/deletesupplier?supid=${supplier.supid}'/>"> 
  <button style="font-size:10pt;color:white;background-color:#ff8080;border:3px solid #336600;padding:8px" >DELETE</button></a></td>

		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<c:if test="${msg1}">
	        <table border="1">
	<th>SupplierID</th>
	<th>Supplier Name</th>
	<th>supplier Address</th>
	<th>Supplier contact</th>
	<th>Supplier mail</th>

	
		<tr>
			<td>${supplier.supid}</td>
			<td>${supplier.supname}</td>
			<td>${supplier.supaddress}</td>
			<td>${supplier.supcontact}</td>
			<td>${supplier.supemail}</td>

	</c:if>
	
</table>
<%@ include file="footer.jsp" %>
 
</body>
</html>