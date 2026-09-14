# Sistema de Gestão de Funcionários, Agendas e Compromissos

Projeto desenvolvido para cadastro e gestão de funcionários, agendas e compromissos.

## Funcionalidades

- 👤 Cadastro de funcionários
- 📅 Cadastro de agendas
- 📋 Cadastro de compromissos
- ⏰ Validação de horários
- 📊 Relatório por período
- 📗 Exportação para Excel

## Tecnologias utilizadas

* Java 8
* Apache Struts 2
* Maven
* Bootstrap 5
* H2 Database
* Jetty
* Apache POI
* SOAP

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/
│   │   └── br.com.soc.sistema/
│   │       ├── action/
│   │       ├── business/
│   │       ├── dao/
│   │       ├── exception/
│   │       ├── infra/
│   │       ├── relatorio/
│   │       └── vo/
│   │
│   ├── resources/
│   │   └── CRIA_TABELAS_E_INSERE_REGISTROS_INICIAIS.sql
│   │
│   └── webapp/
│       ├── agenda/
│       ├── compromisso/
│       ├── funcionario/
│       └── relatorio/
│
└── pom.xml
```

## Regras de negócio

* O período disponível da agenda pode ser **Manhã**, **Tarde** ou **Ambos**.
* Não é permitido cadastrar ou alterar um compromisso fora do horário disponível da agenda selecionada.
* Um funcionário com compromissos cadastrados não pode ser excluído sem que seus compromissos sejam tratados.
* Uma agenda que possua compromissos cadastrados não pode ser excluída.
* O relatório exige data inicial e data final para realizar a consulta.
* A data inicial não pode ser maior que a data final.
