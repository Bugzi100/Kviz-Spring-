<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Istorija rezultata prijatelja</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<h1>Istorija rezultata prijatelja</h1>
	
	<ul>
		<c:forEach items="${rezultatiPrijatelja}" var="rp">
			<li>
				Naslov kviza: ${rp.kviz.naslov}<br>
				Skor: ${rp.skor}/10
			</li>
		</c:forEach>
	</ul>
</body>
</html>