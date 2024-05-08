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
		<jsp:include page="menusecretaria.jsp" />
	</div>
</header>
</head>
<body>
	<div align="center" class="container">
		<form action="secretariadispensa" method="post">
			<c:if test="${not empty dispensas }">
				<table class="table_round">
					<thead>
						<tr>
							<th>RA<th>
							<th>Aluno<th>
							<th>Curso</th>
							<th>Disciplina<th>
							<th>Motivo<th>
							<th>Aprovação</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="d" items="${dispensas }">
							<tr>
								<td><c:out value="${d.aluno.ra}" /></td>
								<td><c:out value="${d.aluno.nome}" /></td>
								<td><c:out value="${d.nomeCurso}" /></td>
								<td><c:out value="${d.disciplina.nome}" /></td>
								<td><c:out value="${d.motivo}" /></td>
								<td>
									<select class="input_data" id="aprovacao" name="aprovacao">
										<option value="0">Recusar</option>
										<option value="1">Aprovar</option>
									</select>
								</td>
								<td>
									<input type="submit" onclick="resolverDispensa('${d.aluno.ra}', '${d.disciplina.codigo}')">Concluir</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<br />
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
		</form>
	</div>
</body>
<script>
	function resolverDispensa(alunora, disciplina){		
		console.log(alunora);
		console.log(disciplina);
		if(confirm()){
			window.location.href = 'secretariadispensa?botao=Concluir&ra=' + alunora + '&disciplina=' + disciplina;
		}
		
	}
</script>
</html>