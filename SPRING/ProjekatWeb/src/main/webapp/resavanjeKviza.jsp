<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kviz</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
	<div class="header">
        <header>
			<h1>${kviz.kategorija}</h1>
		</header>
	</div>
	
	<hr>
	
	<form action="<c:url value='/kviz/predajaKviza' />" method="post">
		<input type="hidden" name="kvizId" value="${kviz.kvizId}"/>
			<c:forEach items="${pitanja}" var="pitanje">
					<div class="header">
						<p>${pitanje.tekst}</p>
					</div>
					<div class="radio">
						<label>
	                        <input type="radio" name="odabranaOpcija[${pitanje.pitanjeId}]" value="${pitanje.opcija1}"/>
	                        ${pitanje.opcija1}
	                    </label><br>
	                    <label>
	                        <input type="radio" name="odabranaOpcija[${pitanje.pitanjeId}]" value="${pitanje.opcija2}"/>
	                        ${pitanje.opcija2}
	                    </label><br>
	                    <label>
	                        <input type="radio" name="odabranaOpcija[${pitanje.pitanjeId}]" value="${pitanje.opcija3}"/>
	                        ${pitanje.opcija3}
	                    </label><br>
	                    <label>
	                        <input type="radio" name="odabranaOpcija[${pitanje.pitanjeId}]" value="${pitanje.opcija4}"/>
	                        ${pitanje.opcija4}
	                    </label><br>
	                 </div>
			</c:forEach>
		
		<div class="header">
			<button type="submit" style="width: 100px; height: 60px; margin-bottom: 10px; margin-top: 40px;">Zavrsi kviz</button>
		</div>
	</form>
</body>
</html>