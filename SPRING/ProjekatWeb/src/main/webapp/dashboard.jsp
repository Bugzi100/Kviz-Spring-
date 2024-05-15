<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Glavni meni</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div class="header"><h1>Dobrodosli u glavni meni online kviza</h1></div>
	
	<div class="navbar">
		<nav>
			<a href="/Kviz/listaKvizova">Lista kvizova</a><br>
			<a href="/Kviz/kreiranjeKviza">Napravi kviz</a><br>
			<a href="/Kviz/istorijaRezultata">Istorija vasih rezultata</a><br>
			<a href="/Kviz/topKvizovi">Top 5 najpopularnijih kvizova</a><br>
			<!--<li>
				<form action="/Kviz/dodajPrijatelja" method="post">
					<label for="userP">Dodavanje prijatelja (unosi se korisnicko ime):</label><br>
					<input type="text" name="userP">
					<button type="submit">Dodaj</button>
				</form>
			</li>
			<li>
				<form action="<c:url value='/istorijaRezultataPrijatelja' />" method="get">
					<label for="prijateljId">Izaberite prijatelja:</label>
					<select name="prijateljId" required>
						<c:forEach items="${prijatelj}" var="p">
							<option value="${p.id}">${p.username}</option>
						</c:forEach>
					</select>
						
					<br>
						
					<button type="submit">Prikazi profil</button>
				</form>
			</li>-->
		</nav>
	</div>
</body>
</html>