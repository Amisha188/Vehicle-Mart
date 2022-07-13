<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<table class="table table-bordered">
		<tr class="danger">
			<td colspan="6"><center>Wish List</center></td>
		</tr>
		
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>SubTotal</td>
			<td>Operation</td>
		</tr>
		
		<c:forEach items="${listOfCartItems }" var="cartItem">
			<form action="<c:url value="/updateCartItem/${cartItem.cartItemId }" />" method="get">
			
				<tr class="info">
					<td>${cartItem.productId }</td>
					<td>${cartItem.productName }</td>
					<td><input type="number" value="${cartItem.quantity }" name="quantity" min="1" max="100"/></td>
					<td>${cartItem.price }</td>
					<td>${cartItem.price * cartItem.quantity }</td>
					<td>
						<input type="submit" value="Update" class="btn btn-success"/>
						<a href="<c:url value="deleteCartItem/${cartItem.cartItemId }"/>" class="btn btn-danger">Delete</a>
					</td>
				</tr>
			</form>
			
		</c:forEach>
		
		<tr class="warning">
			<td colspan="4">Total Purchase Amount</td>
			<td colspan="2">${grandTotal}</td>
		</tr>
		<tr class="info">
			<td colspan="3">
				<center><a href="<c:url value="/productDisplay"/>" class="btn btn-success">Go back to Product catalog</a></center>
			</td>
			<td colspan="3">
				<center><a href="<c:url value="/checkOut"/>" class="btn btn-primary">Check Out</a></center>
			</td>
		</tr>
	</table>
</div>


</body>
</html>