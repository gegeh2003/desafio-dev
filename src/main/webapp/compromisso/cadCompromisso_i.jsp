<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Cadastro de Compromisso</title>

<s:if test="hasActionErrors()">
	<div class="alert alert-danger" role="alert">
		<strong>Atenção!</strong>
		<s:actionerror />
	</div>
</s:if>

<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>

<body style="background-color: #cceae8;">
	<jsp:include page="/cabecalho.jsp" />

	<div class="container">

		<s:form
			action="%{compromissoVo.rowid == null ? '/novoCompromissos.action' : '/atualizarCompromissos.action'}">

			<div class="card mt-5">

				<div class="card-header">

					<h5 class="card-title">Novo Compromisso</h5>

				</div>

				<div class="card-body">

					<div class="row align-items-center">

						<label for="id" class="col-sm-2 col-form-label text-center">Código:
						</label>

						<div class="col-sm-2">

							<s:textfield cssClass="form-control" id="id"
								name="compromissoVo.rowid" readonly="true" />
						</div>

					</div>

					<div class="row align-items-center mt-3">

						<label for="funcionario"
							class="col-sm-2 col-form-label text-center">Funcionário:</label>

						<div class="col-sm-4">

							<s:select cssClass="form-select" id="funcionario"
								name="compromissoVo.codigoFuncionario" list="funcionarios"
								listKey="rowid" listValue="nome" headerKey=""
								headerValue="%{getText('label.escolha')}" />
						</div>

					</div>

					<div class="row align-items-center mt-3">

						<label for="agenda" class="col-sm-2 col-form-label text-center">Agenda:</label>

						<div class="col-sm-4">

							<s:select cssClass="form-select" id="agenda"
								name="compromissoVo.codigoAgenda" list="agendas" listKey="rowid"
								listValue="nome" headerKey=""
								headerValue="%{getText('label.escolha')}" />
						</div>

					</div>

					<div class="row align-items-center mt-3">

						<label for="data" class="col-sm-2 col-form-label text-center">
							Data: </label>

						<div class="col-sm-4">

							<s:textfield cssClass="form-control" id="data"
								name="compromissoVo.data" type="date" />
						</div>

					</div>

					<div class="row align-items-center mt-3">

						<label for="horario" class="col-sm-2 col-form-label text-center">Horário:</label>

						<div class="col-sm-4">

							<s:textfield cssClass="form-control" id="horario"
								name="compromissoVo.horario"
								value="%{compromissoVo.horario != null ? compromissoVo.horario.substring(0, 5) : ''}"
								type="time" />

						</div>

					</div>

				</div>

				<div class="card-footer">

					<div class="form-row">

						<button type="submit" class="btn btn-primary col-sm-4 offset-sm-1">
							<s:text name="label.salvar" />
						</button>

						<button type="reset"
							class="btn btn-secondary col-sm-4 offset-sm-2">
							<s:text name="label.limpar" />
						</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>