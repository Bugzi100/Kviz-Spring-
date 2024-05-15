<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registracija</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div class="header">
        <header>
            <h2>Registracija</h2>
        </header>
    </div>
	<form action="/Kviz/registracija" method="post" modelAttribute="korisnik">
	
		<div class="input-group">
			<input type="text" name="ime" placeholder="Ime:" required><br>
		
			<input type="text" name="prezime" placeholder="Prezime:" required><br>
		
			<input type="text" name="username" placeholder="Korisnicko ime:" required><br>
		
			<input type="password" name="password" placeholder="Lozinka:" required><br>
		
			<input type="email" name="mail" placeholder="Email:" required><br>
		
			<button type="submit">Registruj se</button>
		</div>
	</form>
</body>
</html>