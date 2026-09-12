<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="label.titulo.pagina.consulta.agenda"/></title>
<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">

<div class="container">
	<div class="row mt-5">
		
		<table class="table table-light table-striped align-middle">
		
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Período Disponível</th>
					<th class="text-end">Ação</th>
				</tr>
			</thead>
			
			<tbody>
				<s:iterator value="agendas">
					<tr>
						
						<td>${rowid}</td>
						<td>${nome}</td>
						<td>${periodoDisponivel}</td>
						<td class="text-end">
						
							<s:url action="editarAgendas" var="editar">
								<s:param name="agendaVo.rowid" value="rowid"></s:param>
							</s:url>
							
							<a href="${editar}" class=" btn btn-warning text-white">
							<s:text name="label.editar"/>
							</a>
							
						
							<s:url action="excluirAgendas" var="excluir">
                                <s:param name="agendaVo.rowid" value="rowid"></s:param>
                            </s:url>
                            
                            <a href="#" 
                               class="btn btn-danger" 
                               data-bs-toggle="modal" 
                               data-bs-target="#confirmarExclusao"
                               data-url="<s:property value="#excluir"/>"
                               onclick="document.getElementById('botaoSimExcluir').href = this.getAttribute('data-url');">
								<s:text name="label.excluir"/>
							</a> 
				 	 </td>
				 </tr>
	 </s:iterator>	
</tbody>

<tfoot class="table-secondary">
	<tr>
		<td colspan="4">
			<s:url action="novoAgendas" var="novo"/>
		
		  <a href="${novo}" class="btn btn-success">Novo</a>
                    </td>
                </tr>

            </tfoot>

        </table>

    </div>

</div>

		<div class="modal fade" 
	     id="confirmarExclusao"
	     data-bs-backdrop="static" 
	     data-bs-keyboard="false"
	     tabindex="-1" 
	     aria-labelledby="staticBackdropLabel" 
	     aria-hidden="true">
	
	    <div class="modal-dialog" role="document">

        <div class="modal-content">

            <div class="modal-header">

                <h5 class="modal-title">Confirmar exclusão</h5>

                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

            </div>

            <div class="modal-body">

                <span>Deseja realmente excluir este registro?</span>

            </div>

            <div class="modal-footer">

                <a class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">Não</a>

                <a id="botaoSimExcluir" href="#" class="btn btn-primary" style="width:75px;">Sim</a>
            </div>
        </div>
    </div>
</div>
	
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>