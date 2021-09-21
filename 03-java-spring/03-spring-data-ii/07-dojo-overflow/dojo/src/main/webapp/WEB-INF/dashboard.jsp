<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container bg-dark text-white">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">Question</th>
					<th scope="col">Tags</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${questions}" var="question">
					<tr>
						<td> <a href="/question/${question.id}"> -${question.question} </a> </td>
						<c:forEach items="${question.tagList}" var="Tag">
							<td>${Tag.name}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/create" class="btn btn-primary stretched-link">Create a Question</a>
	</div>


</body>
</html>