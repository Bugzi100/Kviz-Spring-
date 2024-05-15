<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Kvizova</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
	<div class="header">
        <header>
            <h1>Lista kvizova</h1>
        </header>
    </div>
    <div class="navbar">
		<c:forEach items="${kvizovi}" var="kviz">
			<a href="<c:url value='/resavanjeKviza/' />${kviz.kvizId}">${kviz.naslov }</a>
					
			<form action="<c:url value='/lajkujKviz' />" method="post" style="display: inline;">
		         <input type="hidden" name="kvizId" value="${kviz.kvizId}" />
		         <button type="submit">Svidja mi se kviz</button>
		    </form>
		</c:forEach>
	</div>
</body>
</html>