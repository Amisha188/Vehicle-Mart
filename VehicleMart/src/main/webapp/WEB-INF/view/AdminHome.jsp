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

	<div class="row">
		<c:forEach items="${listOfProduct }" var="product">
			<div class="col-sm-4 col-md-3">
				<a href="<c:url value="/detailedProductDisplay/${product.productId}"/>" class="thumbnail">
					<img src="<c:url value="/images/${product.productId }.jpg"/>" alt="Generic placeholder thumbnail"/>
				</a>
				
				<p align="center">${product.productName }</p>
				<p align="center">Price : INR ${product.price }</p>
				<p align="center">Available quantity : ${product.quantity }</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>