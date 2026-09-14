<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark mb-4"
     style="background-color: #539091;">

    <div class="container">


        <a class="navbar-brand" href="todosFuncionarios.action">
            Clínica Vitta
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menuPrincipal"
                aria-controls="menuPrincipal"
                aria-expanded="false"
                aria-label="Navegação">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menuPrincipal">

            <ul class="navbar-nav me-auto">

                <li class="nav-item">
                    <a class="nav-link" href="todosFuncionarios.action">
                        Funcionários
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="todosAgendas.action">
                        Agendas
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="todosCompromissos.action">
                        Compromissos
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="telaRelatorioCompromissos.action">
                        Relatório
                    </a>
                </li>

            </ul>

        </div>
    </div>
</nav>
