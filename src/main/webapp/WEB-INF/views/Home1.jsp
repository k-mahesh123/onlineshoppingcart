<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
</sec:authorize>

<c:if test="${msg}">
Loading.........
<% response.setHeader("Refresh", "1;url=home"); %>
</c:if>

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
  
<div class="container">
  
</div>

<h1>${success}</h1>
</c:if>
<c:if test="${msg6}">
<center>
<h1>WelCome To   OnlineShopping</h1>
<h1>CONTACT-AS</h1>
<H3>NAME:MAHESH KUMAR</H3>
<H3>MOBILE:9703208911</H3>
<H3>EMAIL:MAHESH.970308911</H3>
<H3>ADDRESS:HYDERABAD
    POSTAL:502313
</center>
</c:if>

<%@ include file="coursosel.jsp" %>
<%@ include file="footer.jsp" %>
</body>
</html>