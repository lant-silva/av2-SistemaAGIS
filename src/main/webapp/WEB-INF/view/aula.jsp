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
					<!-- Combobox para achar o professor -->
						<select class="input_data" id="professor" name="professor">
								<option value="0">Escolha um Professor</option>
								<c:forEach var="p" items="${professores }">
									<option value="${p.codigo }">
										<c:out value="${p.nome }"/>
									</option>
								</c:forEach>
						</select>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar Professor">
					<td />
				</tr>
				</br>
				<tr>
					<!-- Caso o professor tenha sido encontrado, mostrar as disciplinas -->
					<c:choose>
						<c:when test="${foundP eq true }">
							<select class="input_data" id="professor" name="professor">
							<option value="0">Escolha a Disciplina</option>
							<c:forEach var="d" items="${disciplinas }">
								<option value="${d.codigo }">
									<c:out value="${d.nome }"/>
								</option>
							</c:forEach>
							</select>
							<td>
								<input type="submit" id="botao" name="botao" value="Iniciar Gerenciamento">
							<td />
						</c:when>
						<c:otherwise>
							<H2>
								<b><c:out value="${erro }" /></b>
							</H2>
						</c:otherwise>
					</c:choose>
					
					<c:if test="${not empty conteudos }">
					
					</c:if>
				</tr>
			</table>
			</br>
			<div>
				<c:if test="${not empty alunos }">
					<table class="table_round">
						<thead>
							<tr>
								<th>Nome</th>
							</tr>
						</thead>
					</table>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>