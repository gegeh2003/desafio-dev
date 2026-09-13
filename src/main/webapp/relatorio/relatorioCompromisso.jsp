<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><s:text name="label.titulo.pagina.relatorio.compromisso" /></title>

    <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>

<body>

<div class="container mt-4">

    <h2>Relatório de Compromissos</h2>

    <s:form action="gerarRelatorioCompromissos" method="post">

        <div class="row">

            <div class="col-md-4">
                <label for="dataInicial" class="form-label">Data inicial</label>

                <s:textfield
                    cssClass="form-control"
                    id="dataInicial"
                    name="dataInicial"
                    type="date"/>
            </div>

            <div class="col-md-4">
                <label for="dataFinal" class="form-label">Data final</label>

                <s:textfield
                    cssClass="form-control"
                    id="dataFinal"
                    name="dataFinal"
                    type="date"/>
            </div>

        </div>

        <div class="mt-3">
            <button type="submit" class="btn btn-primary">Gerar relatório</button>
            
            <s:if test="relatorio !=null && !relatorio.isEmpty()">
            	<button type="submit" 
            			formaction="exportarRelatorioCompromissos.action" 
            			class="btn btn-success" >Exportar Excel</button>
            
            </s:if>
        </div>

    </s:form>

    <s:if test="relatorio != null && !relatorio.isEmpty()">

        <hr>

        <h4>Compromissos encontrados</h4>

        <table class="table table-bordered table-striped mt-3">

            <thead>
                <tr>
                    <th>Código Funcionário</th>
                    <th>Nome Funcionário</th>
                    <th>Código Agenda</th>
                    <th>Nome Agenda</th>
                    <th>Data</th>
                    <th>Hora</th>
                </tr>
            </thead>

            <tbody>

                <s:iterator value="relatorio">

                    <tr>
                        <td><s:property value="codigoFuncionario"/></td>
                        <td><s:property value="nomeFuncionario"/></td>
                        <td><s:property value="codigoAgenda"/></td>
                        <td><s:property value="nomeAgenda"/></td>
                        <td><s:property value="data"/></td>
                        <td><s:property value="horario"/></td>
                    </tr>

                </s:iterator>

            </tbody>

        </table>

    </s:if>

</div>

</body>
</html>