<%@ page language="java" import="java.util.*,daopackage.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertServ" method="get">
<label for= "username"> Enter the userName:</label>
<input type="text" name="username"><br/><br/>
<label for= "password"> Enter the password:</label>
<input type="text" name="password"><br/><br/>
<label for= "role"> Enter the role:</label>
<input type="text" name="role"><br/><br/>
<input type="submit" value="click">
<input type="reset" value="cancel">


</form>
<a href="Insertserv">view details</a>
</body>
</html>