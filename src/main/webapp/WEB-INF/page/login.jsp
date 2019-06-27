<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/style.css" var="mainCss"></spring:url>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style type="text/css">
	.container {
    width: 401px;
}</style> 
<style>
.mess{
text-align:center;
}</style>
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
<div class="container" style="margin-top: 30px;">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: lightsteelblue;color: darkolivegreen">
        <p class="navbar-brand"> Welcome to e-Library Service Portal</p>
    </nav>
</div>
<div style="margin-top: 40px">
	<div class="mess">${message}</div>
		<div id="login" style="display: block" class="container">
	
	<form:form method="POST" action="dashBoard" style="top: 50px !important; " modelAttribute="user">
			
			<div class="form-group">
			RollNumber:
				<form:input path="roll" type="number" class="form-control" required="required"/>
			</div>
			
			<div class="form-group">
			Password: 
			<form:input path="password" type="password" class="form-control" required="required" />
			</div>
			<input type="submit" value="login" class="btn btn-default" />
		</form:form>
		<br> No account yet ? click ->
		<button onclick="showSignUp()">Sign up</button>
		to register.
	</div>



	<div id="signup" style="display: none" class="container">

	<form:form method="POST" action="save" modelAttribute="user">
	
	<div class="form-group">
	Name:
			<form:input path="name" type="text" class="form-control" required="required" />
	</div>
	
	<div class="form-group">
	 Password:
		<form:input path="password" type ="password" class="form-control" required="required"/>
	</div>
	
	<div class="form-group">
	Roll no:
		<form:input path="roll" type="number" class="form-control" required="required" />
	</div>
	<input type="submit" value="save" />
	
	<button onclick="showlogin()">already registered?click here to
		login here</button>
	</form:form>
	</div>
<script type="text/javascript">
	var button = document.getElementById('login'); // Assumes element with id='button'

	function showSignUp() {
		var div = document.getElementById('login');
		var div2 = document.getElementById('signup');
		div.style.display = 'none';
		div2.style.display = 'block';
	};

	function showlogin() {
		var div = document.getElementById('login');
		var div2 = document.getElementById('signup');
		div.style.display = 'block';
		div2.style.display = 'none';
	};
</script>
</body>
</html>