<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<td colspan="5"><center>Ordered Items</center></td>
			</tr>
			<tr>
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Purchased quantity</td>
				<td>Price</td>
				<td>Sub Total</td>
			</tr>
			
			<c:forEach items="${listOfCartItems }" var="cartItem">
				<tr class="info">
					<td>${cartItem.productId }</td>
					<td>${cartItem.productName }</td>
					<td>${cartItem.quantity }</td>
					<td>${cartItem.price }</td>
					<td>${cartItem.quantity * cartItem.price}</td>
				</tr>
			</c:forEach>
			
			<tr class="warning">
				<td colspan="4">Total Purchased Amount</td>
				<td colspan="1">${grandTotal }/-</td>
			</tr>
			
			<!--<tr class="warning">
				 <td colspan="5">Shipping Address</td>
			</tr> -->
			
			<form action="<c:url value="/updateAddress"/>" method="post">
				<tr class="info">
					<td>Shipping Address</td>
					<td colspan="3">
						<textarea name="address" cols="32" rows="1">${address}</textarea>
					</td>
					
					<td>
						<input type="submit" value="Update Address" class="btn btn-success"/>
					</td>
				</tr>
			</form>
			
			<tr class="warning">
				<td colspan="5"></td>
			</tr>
			
			<tr class="info">
				<td colspan="2">
					<center><a href="<c:url value="/cart"/>" class="btn btn-danger">Modify Cart</a></center>
				</td>
				<td colspan="3">
					<center><a href="<c:url value="/payment"/>" class="btn btn-danger">Make Payment</a></center>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>