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
	<h1><c:out value="${question.question}"/></h1>
	<h2> Tags: </h2>
	<c:forEach items="${question.tagList}" var="tag">
		<p>${tag.name}</p>
	</c:forEach>
	
	
		<h1>What is Your Answer</h1>
		<form:form method="POST" action="/answer"  modelAttribute="answer">
			<form:hidden path="question" value="${question.id }"/>
			<p>
				<form:label path="answerText">Answer: </form:label>
				<form:input type="text" path="answerText" />
			</p>
				
			<input type="submit" value="Create" />
		</form:form>
		
	<c:forEach items="${question.answerList}" var="answer">
		<p>-${answer.answerText}</p>
	</c:forEach>
	</div>
</body>
</html>