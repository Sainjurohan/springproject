
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload</title>
</head>
<body>
<h1>File Upload Interface</h1>
	<%@ include file= "header.jsp" %>
	
	<form action="upload" method="post" enctype="multipart/form-data" >
	
		Select File <input type="file" name="file"><br><br>
					<input type="submit" name="Upload">
	
			
	</form>
	<p>${msg }</p>

</body>
</html>