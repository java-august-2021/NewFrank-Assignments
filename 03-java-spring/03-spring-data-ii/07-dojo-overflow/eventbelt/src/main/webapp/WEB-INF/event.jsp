<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/create" modelAttribute="newEvent">
		<p>
			<form:label path="name">Name</form:label>
			<form:input type="text" path="name"/>
		</p>
		
				<p>
			<form:label path="date">Name</form:label>
			<form:input type="date" path="date"/>
			<form:errors path="date"/>
		</p>
		
				<p>
			<form:label path="location">Name</form:label>
			<form:input type="text" path="location"/>
		</p>
		
		<input type="submit" value="create">
	</form:form>
</body>
</html>