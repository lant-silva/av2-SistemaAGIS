<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value = "./resources/css/styles.css"/>'>
<title>AGIS - Aula</title>
</head>
<body>
	<h1 align="center">Gerenciamento de Aulas</h1>
	<div>
		<jsp:include page="menuprofessor.jsp" />
	</div>
</body>
</html>