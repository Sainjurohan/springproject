<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>

</head>
<body id="home" background="image:">

	<header>
		<h1 align="center">Welcome to Employee Control Interface</h1>

	</header>
	
	
	<%@ include file = "header.jsp" %>
	

	<table id="myTable" class="table table-stripted">

		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Company</td>
				<td>Phone</td>
				<td>City</td>
				<td>Salary</td>
				<td>Action</td>
			</tr>

		</thead>

		<tbody>

			<c:forEach var="emp" items="${elist }">

				<tr>
					<td>${emp.fname}</td>
					<td>${emp.lname}</td>
					<td>${emp.comapany}</td>
					<td>${emp.phone}</td>
					<td>${emp.address.city }</td>
					<td>${emp.salary }</td>
					
					<td><input type="submit" class="btn btn-sucess" onclick="editEmp(${emp.id})"
						value="Edit" > <input type="submit"
						
					class="btn btn-danger"	onclick="deleteEmp(${emp.id})" value="Delete"></td>
				</tr>


			</c:forEach>

		</tbody>

	</table>

	<script type="text/javascript">
	
		function editEmp(id){
			
			window.location = "${pageContext.request.contextPath}/"+id+"/edit";
			
		}
		
function deleteEmp (id){
	
			var msg = confirm("do you want to delete??")
			
			if(msg == true){
			window.location = "${pageContext.request.contextPath}/"+id+"/delete";
			}
		}
		
$(document).ready( function () {
    $('#myTable').DataTable();
} );
	
	
	</script>

	<footer>
		<P></P>
	</footer>

	<!-- <P>  The time on the server is ${serverTime}. </P> -->
</body>
</html>
