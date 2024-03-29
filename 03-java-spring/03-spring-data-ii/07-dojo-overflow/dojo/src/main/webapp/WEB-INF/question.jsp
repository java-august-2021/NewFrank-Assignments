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
	<div class="container bg-dark text-white">
	
		<c:forEach items="${errors}" var="error">
			<p> ${error} </p>
		</c:forEach>
		
		<form:form method="POST" action="/create/question"  modelAttribute="newQuestion">
			<h1>What is Your Question</h1>
			<p>
				<form:label path="question">Question:</form:label>
				<form:input type="text" path="question" />
			</p>

			<p>
				<form:label path="tags">Tags:</form:label>
				<form:input path="tags"/>
			</p>
			
			<input type="submit" value="Create" />
		</form:form>
	</div>
</body>
</html>