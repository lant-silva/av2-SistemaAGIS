<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value = "./resources/css/styles.css"/>'>
<title>AGIS - Confirmação de Dispensas</title>
<header>
	<h1 align="center">Requisição de Dispensa</h1>
	<div>
		<jsp:include page="menualuno.jsp" />
	</div>
</header>
</head>
<body>
	<div align="center" class="container">
		<form action="dispensa" method="post">
			<c:if test="${not empty dispensas }">
				<table class="table_round">
					<thead>
				</table>
			</c:if>
		</form>
		
	</div>
</body>
</html>