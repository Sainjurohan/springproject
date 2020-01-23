<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>

	<h1>Employee Form</h1>
	<hr>
	<%@ include file = "header.jsp" %>

	<spring:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="emodel">

		<table>

			<tr>
				<td>First Name:</td>
				<td><spring:input path="fname" /></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><spring:input path="lname" /></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td>Male<spring:radiobutton path="gender" value="Male" /> Female<spring:radiobutton
						path="gender" value="Female" /></td>
			</tr>

			<tr>
				<td>Date Of Birth:</td>
				<td><spring:input path="dob" type="date" /></td>
			</tr>

			<tr>
				<td>Joining Date:</td>
				<td><spring:input path="joiningdate" type="date" /></td>
			</tr>

			<tr>
				<td>Company:</td>
				<td><spring:input path="comapany" /></td>
			</tr>

			<tr>
				<td>Post:</td>
				<td><spring:input path="post" /></td>
			</tr>

			<tr>
				<td>Salary:</td>
				<td><spring:input path="salary" /></td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><spring:input path="phone" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><spring:input path="email" /></td>
			</tr>

			<tr>
				<td>Country:</td>
				<td><spring:input path="address.country" /></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><spring:input path="address.city" /></td>
			</tr>

			<tr>
				<td>State:</td>
				<td><spring:select path="address.state">

						<spring:option value="">---Select---</spring:option>
						<spring:option value="state-1">State-1</spring:option>
						<spring:option value="state-2">State-2</spring:option>
						<spring:option value="state-3">State-3</spring:option>
						<spring:option value="state-4">State-4</spring:option>
						<spring:option value="state-5">State-5</spring:option>
						<spring:option value="state-6">State-6</spring:option>
						<spring:option value="state-7">State-7</spring:option>
					</spring:select></td>
			</tr>

			<tr>
				<td>ZIp :</td>
				<td><spring:input path="address.zip" /></td>
			</tr>

			<tr>

				<td><input type="submit" value="Update" /></td>
			</tr>


		</table>
		
		<spring:hidden path="id"/>
		<spring:hidden path="address.id"/>

	</spring:form>



</body>
</html>