<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value = "./resources/css/styles.css"/>'>
<title>AGIS - Aula</title>
<header>
	<h1 align="center">Gerenciamento de Aulas</h1>
	<div>
		<jsp:include page="menuprofessor.jsp" />
	</div>
</header>
</head>
<body>
	<div align="center" class="container">
		<form action="aula" method="post">
			<table>
				<tr>
					<td>
						<select class="input_data" id="professor" name="professor">
								<option value="0">Escolha um Professor</option>
								<c:forEach var="p" items="${professores }">
									<c:if test="${(empty professor) || (p.codigo ne aluno.curso.codigo)}">
										<option value="${c.codigo }">
											<c:out value="${c.nome }"/>
										</option>
									</c:if>
									<c:if test="${c.codigo eq aluno.curso.codigo }">
										<option value="${c.codigo }" selected="selected">
											<c:out value="${c.nome }"/>
										</option>
									</c:if>
								</c:forEach>
						</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>