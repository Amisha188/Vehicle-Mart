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
	<form action="<c:url value="/updateCategory"/>" method = "POST">
	<table class="table" align="center">
		<tr>
			<td colspan="3">
				<center><h3>Category</h3></center>
			</td>
		</tr>
		<tr>
			<td>Category Id</td>
			<td><input type="text" name="categoryId" value="${category.categoryId }" readonly/></td>
		</tr>
		<tr>
			<td>Category Name</td>
			<td><input type="text" name="categoryName" value="${category.categoryName }"/></td>
		</tr>
		<tr>
			<td>Category Description</td>
			<td>
				<input type="text" name="categoryDesc"  value="${category.categoryDescri }"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<center><input type="submit" value="Update Category" class="btn btn-primary"/></center>
			</td>
		</tr>
	</table>
</form>
</body>
</html>