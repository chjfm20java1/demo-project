<%@ page language="java"  import="java.util.*,daopack.*"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--<%
		ArrayList<Emp> list = (ArrayList<Emp>)(request.getAttribute("emps"));
		pageContext.setAttribute("emps", list);
	--%> 
	<%--  ${pageScope.emps} --%>
	<h1 style="color:blue">Employee Information Report:</h1>
	
	<table border="1">
	
	<c:forEach items="${requestScope.emps}" var="e">
	<tr>
              	<td>${e.getEmployee_id()}</td>
              	<td>${e.getFirst_name()}</td>
              	
              	<td>${e.getLast_name()}</td>
              	
                <td>${e.getSalary()}</td>
                
                
    </tr>
	</c:forEach>
	</table>

</body>
</html>