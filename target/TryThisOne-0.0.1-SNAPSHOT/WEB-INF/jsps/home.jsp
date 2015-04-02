<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>DB Test</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	type="text/css" rel="stylesheet" />
</head>
<body>

	<h2>Results</h2>

	<c:forEach var="row" items="${students}">
    Id ${row.idstudent}<br />
    First Name ${row.firstName}<br />
    Middle Name ${row.middleName}<br />
    Age ${row.age}<br />
    Courses<br />
		<c:forEach var="course" items="${row.courses}">
		Name:  ${course.name}<br />
    	Description:  ${course.description}<br />


		</c:forEach>
	</c:forEach>

</body>
</html>