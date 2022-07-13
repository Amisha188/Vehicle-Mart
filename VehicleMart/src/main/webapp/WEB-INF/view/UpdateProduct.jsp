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
	<c:url var="updateProduct" value="/updateProduct"/>
	<form:form action="${updateProduct }" modelAttribute="product" method="post"  enctype="multipart/form-data">
	<table align="center" class="table-bordered">
		<tr>
			<td colspan="2">
				<center>Update Product</center>
			</td>
		</tr>
		<tr>
			<td>Product Id</td>
			<td><form:input path="productId"/></td>
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
				<center><input type="submit" value="Update Product"/></center>
			</td>
		</tr>
	</table>
	</form:form>

</body>
</html>