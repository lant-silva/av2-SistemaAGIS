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
						<select class="input_data" id="disciplina" name="disciplina">
								<option value="0">Escolha uma Disciplina</option>
								<c:forEach var="d" items="${disciplinas }">
									<c:if test="${empty disciplina }">
										<option value="${d.codigo }">
											<c:out value="${d.nome }"/>
										</option>									
									</c:if>
								</c:forEach>
						</select>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Iniciar Gerenciamento">
					<td />
				</tr>
				</br>
				<tr>
					<c:if test="${foundD eq true }">
						<select class="input_data" id="conteudo" name="conteudo">
							<option value="0">Escolha a Aula</option>
							<c:forEach var="c" items="${conteudos }">
								<c:if test="${c.codigoDisciplina eq disciplina.codigo}">
									<option value="${c.codigo }">
										<c:out value="${c.descricao }"/>
									</option>									
								</c:if>
							</c:forEach>
						</select>
						<td>
							<input type="submit" id="botao" name="botao" value="Iniciar Chamada">
						<td />
					</c:if>
				</tr>
				<div align="center">
					<c:if test="${not empty erro }">
						<H2>
							<b><c:out value="${erro }" /></b>
						</H2>
					</c:if>
				</div>
			</table>
			</br>
			<div>
				<H2><b>Aula - </b><c:out value="${conteudo.descricao }"></c:out></H2>
				<c:if test="${not empty alunos }">
					<table class="table_round">
						<thead>
							<tr>
								<th>Nome</th>
								<th>RA</th>
								<th>Aula 1</th>
								<th>Aula 2</th>
								<th>Aula 3</th>
								<th>Aula 4</th>
								<th>Marcar tudo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="a" items="${alunos }">
								<td><c:out value="${a.nome }"></c:out></td>
								<td><c:out value="${a.ra }"></c:out></td>
								<td><input type="checkbox" name="p1" value="0"></td>
								<td><input type="checkbox" name="p2" value="0"></td>
								<td><input type="checkbox" name="p3" value="0"></td>
								<td><input type="checkbox" name="p4" value="0"></td>
								<td><input type="checkbox" name="pAll" value="0" onclick="checkAll()"></td>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</form>
	</div>
</body>
<script>
	function checkAll(){
		document.getElementById("p1").checked = true
		document.getElementById("p2").checked = true
		document.getElementById("p3").checked = true
		document.getElementById("p4").checked = true
	}
</script>
</html>