<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
   body{

background-repeat: no-repeat;
background-position: right top;
background: url("<c:url value="/resources/images/background1.jpg" />")
}
  .container { max-width: 360px; }
  </style>
  </head>
<body>

   <c:if test="${msg}">
   
   
   
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
      
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


			<div class="container">
			<div class="row">
			<div class="panel panel-primary " style="border-color:purple;">
				<div class="panel-body">
				<form:form commandName="usersignup" method="post" action="signup">
					<div class="form-group">
						<label for="username">UserName:${msg12}</label>
						<form:errors path="username" cssStyle="color: #ff0000"  />
						<form:input path="username" id="username" class="form-Control" />
					</div>

					<div class="form-group">
	
						<label for="password">Password:</label> 
						<form:errors path="password" cssStyle="color: #ff0000" />
						<form:input type="password" path="password" id="password"
							class="form-Control" />
					</div>
					<div class="form-group">
						<label for="name">name:</label>
						<form:errors path="name" cssStyle="color: #ff0000" />
						<form:input type="name" path="name" id="name"
							class="form-Control" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:errors path="email" cssStyle="color: #ff0000" />
						<form:input type="email" pattern="[^ @]*@[^ @]*" path="email" id="email" class="form-Control" />
					</div>
					
					<div class="form-group">
						<label for="mobilenumber">Mobile Number:</label>
						<form:errors path="mobilenumber" cssStyle="color: #ff0000" />
						<form:input path="mobilenumber" id="mobilenumber" class="form-Control" />
					</div>
					<div class="form-group">
						<label for="dob">DateOfBirth:</label>
						<form:errors path="dob" cssStyle="color: #ff0000" />
						<form:input type="Date" path="dob" value="10/12/2017" id="dob" class="form-Control" />
					</div>
			<button type="submit" class="btn btn-default" style="background-color:purple;color:white;">Submit</button>
			</form:form>			
			</div>
			</div>
			</div>
			</div>
			</c:if>
			<c:if test="${msg1}">
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
</sec:authorize>


			<div class="container">
			<div class="row">
			<div class="panel panel-primary " style="border-color:purple;">
				<div class="panel-body">
				
                            
				
					
				<form:form commandName="usersignup" method="post" action="updateuser">
					<div class="form-group">
						<label for="username">UserName:</label>
						<form:errors path="username" cssStyle="color: #ff0000" />
						<form:input path="username" id="username" value="${user.username}" class="form-Control" />
					</div>

					<div class="form-group">
	
						<label for="password">Password:</label> 
						<form:errors path="password" cssStyle="color: #ff0000" />
						<form:input type="password" path="password" id="password" value="${user.password}"
							class="form-Control" />
					</div>
					<div class="form-group">
						<label for="name">name:</label>
						<form:errors path="name" cssStyle="color: #ff0000" />
						<form:input type="name" path="name" id="name" value="${user.name}"
							class="form-Control" />
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<form:errors path="email" cssStyle="color: #ff0000" />
						<form:input type="email" pattern="[^ @]*@[^ @]*" path="email" id="email" value="${user.email}" class="form-Control" />
					</div>
					
					<div class="form-group">
						<label for="mobilenumber">Mobile Number:</label>
						<form:errors path="mobilenumber" cssStyle="color: #ff0000" />
						<form:input path="mobilenumber" id="mobilenumber" value="${user.mobilenumber}" class="form-Control" />
					</div>
					<div class="form-group">
						<label for="dob">DateOfBirth:</label>
						<form:errors path="dob" cssStyle="color: #ff0000" />
						<form:input type="Date" path="dob" id="dob" value="${user.dob}" class="form-Control" />
					</div>
			<button type="submit" class="btn btn-default" style="background-color:purple;color:white;">Update</button>
			</form:form>			
			</div>
			</div>
			</div>
			</div>
			</c:if>
			<c:if test="${msg2}">
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
</sec:authorize>

			<table border="2"  width="100%">
<tr >
<th>DateOfBirth</th>
<th>MailId</th>
<th>MobileNumber</th>
<th>UserName</th>
<th>Password</th>
<th>Name</th>
<th colspan="6">admin tools</th>
</tr>
<c:forEach items="${user}" var="user1">
<tr >
 <td> ${user1.dob}<br></td>
 <td> ${user1.email}<br></td>
 <td> ${user1.mobilenumber}<br></td>
  <td>${user1.username}<br></td>
  <td>${user1.password}<br></td>
 
  <td>${user1.name}<br></td>
  
  <td><a href="<c:url value='/viewofeachuser?username=${user1.username}'/>"> <button style="font-size:10pt;color:white;background-color:#00ff00;border:3px solid #336600;padding:8px" >VIEW</button></a></td> 
   
    
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${msg3}">

<sec:authorize access="hasRole('ROLE_ADMIN')">
<%@ include file="adminnav.jsp" %>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<%@ include file="usernav.jsp" %>
</sec:authorize>


<table border="2"  width="100%">
<tr >
<th>DateOfBirth</th>
<th>MailId</th>
<th>MobileNumber</th>
<th>UserName</th>
<th>Password</th>
<th>RegId</th>
<th>Role</th>
<th>Status</th>
<th>Name</th>

</tr>

<tr >
 <td> ${user1.dob}<br></td>
 <td> ${user1.email}<br></td>
 <td> ${user1.mobilenumber}<br></td>
  <td>${user1.username}<br></td>
  <td>${user1.password}<br></td>
  <td>${user1.registrationid}<br></td>
  <td>${user1.role}<br></td>
  <td>${user1.status}<br></td>
  <td>${user1.name}<br></td>
  <td><a href="edituser?username=<%=session.getAttribute("loggedInUser")%>">ProfileEdit</a></td>
  </tr>
  </table>
  </c:if>
	<%@ include file="footer.jsp" %>

		</body>
</html>