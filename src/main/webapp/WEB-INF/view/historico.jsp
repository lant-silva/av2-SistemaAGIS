<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGIS - Histórico</title>
<link rel="stylesheet" type="text/css" href='<c:url value = "./resources/css/styles.css"/>'>
<header>
	<h1 align="center">Histórico do Aluno</h1>
	<div>
		<jsp:include page="menusecretaria.jsp" />
	</div>
</header>
</head>
<body>
	<form action="historico" method="post">
		<div align="center" class="container">
			<tr>
				<td colspan="3"><input class="input_data" type="text" id="ra"
					name="ra" placeholder="R.A" value="${aluno.ra }" maxlength="9"
					oninput="this.value = this.value.replace(/[^0-9]/g, '')">
				<td />
				<td><input type="submit" id="botao" name="botao"
					value="Consultar Historico">
				</td>
			</tr>
		</div>
		<br/>
		<div align="center">
			<c:if test="${not empty saida }">
				<H2>
					<b><c:out value="${saida }" /></b>
				</H2>
			</c:if>
		</div>
		<br />
		<div align="center">
			<c:if test="${not empty erro }">
				<H2>
					<b><c:out value="${erro }" /></b>
				</H2>
			</c:if>
		</div>
		</br>
	</form>
</body>
</html>