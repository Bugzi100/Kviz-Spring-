<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prijava</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div class="header">
        <header>
            <h2>Prijava</h2>
        </header>
    </div>
	<form action="/Kviz/login" method="post">
		<div class="input-group">
			<input type="text" name="username" placeholder="Korisnicko ime:" required><br>
			
			<input type="password" name="password" placeholder="Lozinka:" required><br>
			
			<button type="submit">Prijavi se</button>
		</div>
	</form>
	
	<c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>