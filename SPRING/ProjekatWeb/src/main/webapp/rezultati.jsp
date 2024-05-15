<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezultati Kviza</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
	<div class="header">
        <header>
			<h1>Rezultati Kviza</h1>
		</header>
	</div>
	
	<div class="header2">
		<h3>Vasi odgovori:</h3>
	</div>
	
	<div class="ul">
		<ul>
			<c:forEach items="${rezultatiPitanja}" var="rp">
				<li>
					Pitanje: ${rp.pitanje.tekst}<br>
					Vas odgovor: ${rp.odabranaOpcija}<br>
					Tacan odgovor:
					<span style="color: ${rp.tacno ? 'green' : 'red'};">
						${rp.tacno ? 'Da' : 'Ne'}
					</span>
					<hr>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<div class="header2">
		<h3>Skor: ${skor}/10</h3>
	</div>
</body>
</html>