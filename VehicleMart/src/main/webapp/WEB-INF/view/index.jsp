<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/Header.jsp" %>
<html>
<body>
	<div class="container">
		<h2>HOME Page</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			
			<!-- Indicator -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="<c:url value="images/banner1.jpg"/>" alt="Los Angeles" style="width:100%; height:450px;"/>
				</div>
				<div class="item">
					<img src="<c:url value="images/banner2.jpg"/>" alt="Chicago" style="width:100%; height:450px;"/>
				</div>
				<div class="item">
					<img src="<c:url value="images/banner3.jpg"/>" alt="Chicago" style="width:100%; height:450px;"/>
				</div>
			</div>
			
			<!-- Left and rigth controles -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicom-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicom-chevron-rigth"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
</body>
</html>
