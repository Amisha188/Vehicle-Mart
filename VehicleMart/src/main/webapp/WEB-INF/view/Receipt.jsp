<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<table class="table table-bordered" align="center">
			<tr class="danger">
				<td colspan="6"><center>Receipt</center></td>
			</tr>
			
			<tr class="info">
				<td>Order Id</td>
				<td>ORD000${orderDetail.orderId }</td>
				
				<td>Date</td>
				<td colspan="2">${orderDetail.orderDate }</td>
			</tr>
			
			<tr>
				<td ><h3><center>Order Items</center></h3></td>
			</tr>
			
			<tr>
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Purchased Quantity</td>
				<td>Price</td>
				<td>SubTotal</td>
			</tr>
			
			<c:forEach items="${listOfCartItems}" var="cartItem">
				<tr class="info">
					<td>${cartItem.productId }</td>
					<td>${cartItem.productName }</td>
					<td>${cartItem.quantity }</td>
					<td>${cartItem.price }</td>
					<td>${cartItem.price * cartItem.quantity }</td>
				</tr>
			</c:forEach>
			
			<tr class="warning">
				<td colspan="4">Total Purchase Amount</td>
				<td colspan="1">${grandTotal }/-</td>
			</tr>
			
			<tr class="warning">
				<td colspan="2">Shipping Address</td>
				<td colspan="3">${orderDetail.shippingAddress }</td>
			</tr>
			
			
		</table>
	</div>
</body>
</html>