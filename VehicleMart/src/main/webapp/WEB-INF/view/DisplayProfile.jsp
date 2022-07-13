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
			<tr class="info">
				<td colspan="2"><center>Profile</center></td>
			</tr>
			<tr class="warning">
				<td>User Name</td>
				<td>${user.userName }</td>
			</tr>
			<tr class="warning">
				<td>User Email</td>
				<td>${user.email }</td>
			</tr>
			<tr class="warning">
				<td>Full Name</td>
				<td>${user.fullName }</td>
			</tr>
			<tr class="warning">
				<td>Address</td>
				<td>${user.address }</td>
			</tr>
			<tr class="warning">
				<td>User Role</td>
				<td>${user.userRole }</td>
			</tr>
			<tr class="info">
				<td><center><a href="<c:url value="/editProfile"/>" class="btn btn-success">Edit Profile</a></center></td>
				<td><center><a href="<c:url value="/deleteProfile"/>" class="btn btn-danger">Delete Profile</a></center></td>
			</tr>
		</table>
	</div>
</body>
</html>