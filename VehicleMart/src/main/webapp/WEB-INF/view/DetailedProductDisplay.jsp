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
	<form action="<c:url value="/addToCart/${product.productId }"/>">
		<table class="table-bordered">
			<tr>
				<td rowspan="8">
					<img src="<c:url value="/images/${product.productId }.jpg"/>" height="300" alt="Generic placeholder thumbnail"/>
				</td>
			
			
				<td>Product Id</td>
				<td>${product.productId }</td>
			</tr>
			
				<td>Product Name</td>
				<td>${product.productName }</td>
			</tr>
			
				<td>Price</td>
				<td>INR ${product.price }/-</td>
			</tr>
			
				<td>Available Quantity</td>
				<td>${product.quantity }</td>
			</tr>
			
				<td>Category</td>
				<td>${product.categoryId }</td>
			</tr>
			
				<td>Manufacturer Id</td>
				<td>${product.manufacturerId }</td>
			</tr>
			
				<td>Product Description</td>
				<td>${product.productDesc }</td>
			</tr>
			
			
				<td>Quantity
				<select name="quantity">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				</select>
				</td>
				
				<td>
					<input type="submit" value="Add to Cart" class="btn btn-success"/>
				</td>
			</tr>
			</tr>
		</table>
	</form>
</body>
</html>