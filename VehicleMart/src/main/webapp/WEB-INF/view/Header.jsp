<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>	
<title>VehicleMart</title>

</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Vehicle Mart</a>
	    </div>
	    
	    <c:if test="${!sessionScope.loggedIn }">
	    <ul class="nav navbar-nav">
		    <li><a href="<c:url value="/login"/>">Login</a></li>
		    <li><a href="<c:url value="/register"/>">Register</a></li>
		    
		    <li><a href="<c:url value="/about_us"/>">About Us</a></li>
		   	<li><a href="<c:url value="/contact_us"/>">Contact Us</a></li>
		   	
		   	</ul>
		   	</c:if>
		   	
		   	<c:if test="${sessionScope.loggedIn }">
			   	<c:if test="${sessionScope.admin }">
			    <ul class="nav navbar-nav">
			    
				   	<li><a href="<c:url value="/productDisplay"/>">Product Catalog</a></li>
				   	<li><a href="<c:url value="/category"/>">Manage Category</a></li>
				    <li><a href="<c:url value="/product"/>">Manage Product</a></li>
				    <li><a href="<c:url value="/displayProfile"/>">Profile</a></li>
				    <li><a href="<c:url value="/cart"/>">Cart</a></li>
				    </ul>
			    </c:if>
			    
			    <c:if test="${!sessionScope.admin }">
			    <ul class="nav navbar-nav">
			    
				    <li><a href="<c:url value="/userHome"/>">Home</a></li>
				    <li class="dropdown"><a class="gropdown-toggle" data-toggle="dropdown">Category
					    <span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					    	<li><a href="<c:url value="/productDisplay"/>">Two Wheeler</a></li>
					    	<li><a href="<c:url value="/productDisplay"/>">Four Wheeler</a></li>
					    	<li><a href="<c:url value="/productDisplay"/>">Locomotive</a></li>
					    </ul>
				    </li>
				    <li><a href="<c:url value="/displayProfile"/>">Profile</a></li>
				    <li><a href="<c:url value="/cart"/>">Cart</a></li>
				    <li><a href="<c:url value="/about_us"/>">About Us</a></li>
		   			<li><a href="<c:url value="/contact_us"/>">Contact Us</a></li>
			    </ul>
			    </c:if>
			 </c:if>
		   
	    
	    <c:if test="${sessionScope.loggedIn }">
	    	<div class="nav navbar-nav navbar-right">
	    		<font color="white" face="calibri" size="3">Welcome :${sessionScope.username}</font>
	    		<a href="<c:url value="/performLogout"/>" class="btn btn-danger">Logout</a>
	    	</div>
	    
	    </c:if>
	  </div>
	</nav>
</body>
</html>