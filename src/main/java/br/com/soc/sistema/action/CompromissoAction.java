package br.com.soc.sistema.action;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.CompromissoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.business.AgendaBusiness;
import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.vo.FuncionarioVo;
import br.com.soc.sistema.exception.BusinessException;

public class CompromissoAction extends Action {

	private List<CompromissoVo> compromissos = new ArrayList<>();

	private CompromissoBusiness business = new CompromissoBusiness();
	private CompromissoVo compromissoVo = new CompromissoVo();
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private List<AgendaVo> agendas = new ArrayList<>();
	private FuncionarioBusiness funcionarioBusiness = new FuncionarioBusiness();
	private AgendaBusiness agendaBusiness = new AgendaBusiness();

	public String todos() {

		compromissos.addAll(business.trazerTodosOsCompromissos());

		return SUCCESS;
	}

	public String novo() {

		comboListaApoio();

		if (compromissoVo.getCodigoFuncionario() == null)
			return INPUT;

		try {

			business.salvarCompromisso(compromissoVo);

			return REDIRECT;

		} catch (BusinessException e) {

			addActionError(e.getMessage());

			return INPUT;
		}
	}

	public String editar() {

		comboListaApoio();

		if (compromissoVo.getRowid() == null)
			return REDIRECT;

		try {

			compromissoVo = business.buscarCompromissoPor(compromissoVo.getRowid());

			return INPUT;

		} catch (BusinessException e) {

			addActionError(e.getMessage());

			return SUCCESS;
		}
	}

	public String atualizar() {

		comboListaApoio();

		if (compromissoVo.getRowid() == null)
			return REDIRECT;

		try {

			business.atualizarCompromisso(compromissoVo);

			return REDIRECT;

		} catch (BusinessException e) {

			addActionError(e.getMessage());

			return INPUT;
		}
	}

	public String excluir() {

		comboListaApoio();

		if (compromissoVo.getRowid() == null)
			return REDIRECT;

		try {

			business.excluirCompromisso(compromissoVo.getRowid());

			return REDIRECT;

		} catch (BusinessException e) {

			addActionError(e.getMessage());

			return SUCCESS;
		}
	}

	public List<CompromissoVo> getCompromissos() {

		return compromissos;
	}

	public void setCompromissos(List<CompromissoVo> compromissos) {

		this.compromissos = compromissos;
	}

	public CompromissoVo getCompromissoVo() {

		return compromissoVo;
	}

	public void setCompromissoVo(CompromissoVo compromissoVo) {

		this.compromissoVo = compromissoVo;
	}

	public List<FuncionarioVo> getFuncionarios() {

		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {

		this.funcionarios = funcionarios;
	}

	public List<AgendaVo> getAgendas() {

		return agendas;
	}

	public void setAgendas(List<AgendaVo> agendas) {

		this.agendas = agendas;
	}

	public void comboListaApoio() {

		funcionarios = funcionarioBusiness.trazerTodosOsFuncionarios();

		agendas = agendaBusiness.trazerTodasAsAgendas();
	}

}