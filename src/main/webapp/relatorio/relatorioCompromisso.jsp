<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório de Compromissos</title>

<s:if test="hasActionErrors()">
    <div class="alert alert-danger" role="alert">
        <strong>Atenção!</strong>
        <s:actionerror />
    </div>
</s:if>

<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>

<body style="background-color: #cceae8;">
	<jsp:include page="/cabecalho.jsp" />
	
	<div class="container">
		<div class="row mt-5 mb-2">
			<div class="col-sm p-0">
				<h2 style="color: blacl;">Relatório de Compromissos</h2>

			</div>

		</div>

		<s:form action="gerarRelatorioCompromissos">

			<div class="input-group">

				<span class="input-group-text"> <strong>Período</strong>
				</span>

				<s:textfield cssClass="form-control" id="dataInicial"
					name="dataInicial" type="date" />

				<s:textfield cssClass="form-control" id="dataFinal" name="dataFinal"
					type="date" />

				<button class="btn btn-primary" type="submit">
					<s:text name="label.pesquisar" />

				</button>
			</div>

			<div class="row mt-3">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th>Código Funcionário</th>
							<th>Nome Funcionário</th>
							<th>Código Agenda</th>
							<th>Procedimento</th>
							<th>Data</th>
							<th>Hora</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="relatorio">
							<tr>
								<td>${codigoFuncionario}</td>
								<td>${nomeFuncionario}</td>
								<td>${codigoAgenda}</td>
								<td>${nomeAgenda}</td>
								<td>${data}</td>
								<td>${horario}</td>
							</tr>
						</s:iterator>
					</tbody>

					<tfoot class="table-secondary">

						<tr>

							<td colspan="6"><s:if
									test="relatorio != null && !relatorio.isEmpty()">

									<button type="submit"
										formaction="exportarRelatorioCompromissos.action"
										class="btn btn-success">Exportar Excel</button>
								</s:if></td>

						</tr>

					</tfoot>

				</table>
				<div class="row mt-3 mb-4">
					<div class="col-sm p-0">
						<a href="todosCompromissos.action" class="btn btn-primary"><s:text
								name="label.voltar" /></a>
					</div>
				</div>
			</div>

		</s:form>

	</div>



	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js">
        </script>

</body>

</html>