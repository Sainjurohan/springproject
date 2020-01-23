<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>
</head>
<body>


	<!-- Start navigation bar -->
	<nav class="navbar navbar-default navbar-static-top" style="background:#A0B0C0">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">GTC Movember</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/home">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/upload">Upload</a></li>
					<li><a href="${pageContext.request.contextPath}/email">Contact</a></li>
					<li><a href="${pageContext.request.contextPath}/gallary">Gallary</a></li>
					<li><a href="${pageContext.request.contextPath}/employee">EmployeeForm</a></li>
					<li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/logout">Logout<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End navigation bar -->


	<h2><b>Welcome : ${sessionScope.active.fname}</b></h2>
	
	<!--  for displaying the value of username-->

</body>
</html>