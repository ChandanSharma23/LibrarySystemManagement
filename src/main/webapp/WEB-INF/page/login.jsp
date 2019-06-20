<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/style.css" var="mainCss"></spring:url>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${mainCss}" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div>
Welcome to elibrary
</div>
<div id="login" style="display: block" class="container">
<form method= "POST" action="dashBoard" style="top: 50px !important;">
<h1>Login here</h1>
 <div class="form-group">
    <input type="text" name="userName" 
  		placeholder="Enter user name" class="form-control"/> 
  </div>
  <div class="form-group">
    <input type="password" name="userPassword" 
  		placeholder="Enter password" class="form-control"/>
  </div>

  		 <input type="submit" value="login"class="btn btn-default"/>
</form><br> No account yet ? click ->
<button onclick="showSignUp()">Sign up</button>
to register.
</div>
<div id="signup"  style="display: none">
<form method= "GET">
<div class="form-group">
	<input type="text" name="userName" 
  		placeholder="enter your user name"class="form-control"/> <br>
  		</div>
  <div class="form-group">
  		<input type="password" name="userPassword" 
  		placeholder="Enter password"class="form-control"/><br>
  		</div>
 <div class="form-group">
	<input type="text" name="userRollno" 
  placeholder="enter your roll no."class="form-control"/> <br>
  		</div>
   <div class="form-group">
   <input type="text" name="userDob" 
  		placeholder="enter your DOB"class="form-control"/><br>
  		</div>
  		 <input type="submit" value="save"/><br>
<button onclick="showlogin()">already registered?click here to login here</button>
</form>
</div></html>
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