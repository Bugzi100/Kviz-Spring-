<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Istorija Rezultata</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div class="header">
        <header>
			<h1>Istorija rezultata</h1>
		</header>
	</div>
	
	<div class="table">
		<table>
			<thead>
				<tr>
					<th>Kviz</th>
					<th>Skor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rezultati}" var="r">
					<tr>
						<td>${r.kviz.naslov}</td>
						<td>${r.skor}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>