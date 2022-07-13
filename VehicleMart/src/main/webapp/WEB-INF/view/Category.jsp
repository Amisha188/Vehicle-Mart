<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Insert title here</title>
</head>
<body>
<form action="addCategory" method = "POST">
<table class="table" align="center">
	<tr>
		<td colspan="2">
			<center><h3>Category</h3></center>
		</td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="categoryName" /></td>
	</tr>
	<tr>
		<td>Category Description</td>
		<td>
			<input type="text" name="categoryDesc" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<center><input type="submit" value="Add Category" class="btn btn-primary"/></center>
		</td>
	</tr>
</table>
</form>


<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Category Id</th>
      <th scope="col">Category Name</th>
      <th scope="col">Category Description</th>
      <th scope="col" colspan="2">Operation</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listOfCategories}" var="category">
    	<tr>
	      <td>${category.categoryId}</td>
	      <td>${category.categoryName}</td>
	      <td>${category.categoryDescri}</td>
	      
	      <td><a href="<c:url value="/editCategory/${category.categoryId}"/>" class="btn btn-success">Update</a></td>
	      <td><a href="<c:url value="/deleteCategory/${category.categoryId}"/>" class="btn btn-danger">Delete</a></td>
	    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>