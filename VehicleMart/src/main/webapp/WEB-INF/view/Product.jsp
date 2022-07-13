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
	<br><br>
	
	<form:form action="addProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
	<table align="center" class="table-bordered">
		<tr>
			<td colspan="2">
				<center>Product Details</center>
			</td>
		</tr>
		
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName"/></td>
		</tr>
		
		<tr>
			<td>Available Quantity</td>
			<td><form:input path="quantity"/></td>
		</tr>
		
		<tr>
			<td>Price</td>
			<td><form:input path="price"/></td>
		</tr>
		
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc"/></td>
		</tr>
		
		<tr>
			<td>Category</td>
			<td>
				<form:select path="categoryId">
				<form:option value="0" label="...Select Category"/>
				<form:options items="${categoryList}"/>
				</form:select>
				
			</td>
		</tr>
		<tr>
			<td>Brand</td>
			<td><form:input path="brand"/></td>
		</tr>
		
		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="pimage"/></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<center><input type="submit" value="Add Product" class="btn btn-info"/></center>
			</td>
		</tr>
	</table>
	</form:form>
	<br><br>
	<table class="table-bordered">
		<tr>
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Product Description</td>
			<td>Category Id</td>
			<td>Brand</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Operations</td>
		</tr>
		
		<c:forEach items="${listOfProduct }" var="product">
		<tr>
			<td>${product.productId }</td>
			<td>${product.productName }</td>
			<td>${product.productDesc }</td>
			<td>${product.categoryId }</td>
			<td>${product.brand }</td>
			<td>${product.quantity }</td>
			<td>${product.price }</td>
			
			<td><a href="<c:url value="/editProduct/${product.productId }"/>" class="btn btn-success">Update</a></td>
	      	<td><a href="<c:url value="/deleteProduct/${product.productId }"/>" class="btn btn-danger">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>