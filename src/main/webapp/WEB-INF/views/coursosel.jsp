
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
<center>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="<c:url value="/resources/imgs/0.jpg" />"/> 
      </div>
      <div class="item">
         <img src="<c:url value="/resources/imgs/1.jpg" />" />
      </div>
      
      <div class="item">
         <img src="<c:url value="/resources/imgs/2.jpg" />" />
      </div>

      <div class="item">
        <img src="<c:url value="/resources/imgs/3.jpg" />"/>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/imgs/4.jpg" />" "/>
      </div>

      <div class="item">
         <img src="<c:url value="/resources/imgs/5.jpg" />"/>
      </div>
      <div class="item">
         <img src="<c:url value="/resources/imgs/6.jpg" />" />
      </div>

      <div class="item">
        <img src="<c:url value="/resources/imgs/7.jpg" />"/>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/imgs/8.jpg" />" "/>
      </div>

      <div class="item">
         <img src="<c:url value="/resources/imgs/9.jpg" />"/>
      </div>
      

      <div class="item">
        <img src="<c:url value="/resources/imgs/11.jpg" />"/>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/imgs/12.jpg" />" "/>
      </div>

      <div class="item">
         <img src="<c:url value="/resources/imgs/13.jpg" />"/>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>  
</center>
      <div class="container">
  <br>
  <br>
  <br>
  
  <div class="row">
      
      
      
      <div class="col-md-3">
      <div class="thumbnail">
        
          <img src="<c:url value="/resources/imgs/0.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
       <div class="col-md-3">
      <div class="thumbnail">
        
          <img src="<c:url value="/resources/imgs/1.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
       
          <img src="<c:url value="/resources/imgs/2.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
       
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/3.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
      
     
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/4.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="#" target="#myCarousel">
         <img src="<c:url value="/resources/imgs/5.jpg" />" style="width:255;height:300;"/>
          
        </a>
      </div>
    </div>
     <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/7.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/8.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/9.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
     
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/11.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="/w3imgs/nature.jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/12.jpg" />" alt="Nature" style="width:255; height:300;"/>
          
        </a>
      </div>
    </div>
     <div class="col-md-3">
      <div class="thumbnail">
        <a href="/resources/imgs/download (1).jpg" target="_blank">
          <img src="<c:url value="/resources/imgs/6.jpg" />"style="width:255;height:300;"/>
          
        </a>
      </div>
    </div>
  </div>
</div>
      


</body>
</html>
