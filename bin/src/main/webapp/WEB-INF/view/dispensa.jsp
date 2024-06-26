<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value = "./resources/css/styles.css"/>'>
<title>AGIS - Requisição de Dispensa</title>
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
			<table>
				<tr>
					<td colspan="3"><input class="input_data" type="text" id="ra"
						name="ra" placeholder="R.A" value="${aluno.ra }" maxlength="9"
						oninput="this.value = this.value.replace(/[^0-9]/g, '')">
					<td />
					<td><input type="submit" id="botao" name="botao"
						value="Consultar Aluno">
					</td>
				</tr>
			</table>
			<table>
				<c:if test="${found eq true or not empty disciplinas }">
					<tr>
						<td colspan="3"><select class="input_data" id="disciplina" name="disciplina">
								<option value="0">Escolha uma Disciplina</option>
								<c:forEach var="d" items="${disciplinas }">
									<option value="${d.codigo }" selected="selected">
										<c:out value="${d.nome }"/>
									</option>
								</c:forEach>
						</select>
						<td />
					<tr>
				</c:if>
			</table>
		</form>
	</div>
</body>
</html>