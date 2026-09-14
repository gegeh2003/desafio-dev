package br.com.soc.sistema.action;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.AgendaBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.exception.BusinessException;

public class AgendaAction extends Action {

	private List<AgendaVo> agendas = new ArrayList<>();
	private AgendaBusiness business = new AgendaBusiness();
	private AgendaVo agendaVo = new AgendaVo();

	public String todos() {

		agendas.addAll(business.trazerTodasAsAgendas());

		return SUCCESS;
	}

	public String novo() {

		if (agendaVo.getNome() == null)
			return INPUT;

		try {
			business.salvarAgenda(agendaVo);
			return REDIRECT;

		} catch (BusinessException e) {
			addActionError(e.getMessage());
			return INPUT;
		}
	}

	public String editar() {

		if (agendaVo.getRowid() == null)
			return REDIRECT;

		try {
			agendaVo = business.buscarAgendaPor(agendaVo.getRowid());
			return INPUT;

		} catch (BusinessException e) {
			addActionError(e.getMessage());
			return SUCCESS;
		}
	}

	public String atualizar() {

		if (agendaVo.getRowid() == null)
			return REDIRECT;

		try {
			business.atualizarAgenda(agendaVo);
			return REDIRECT;

		} catch (BusinessException e) {
			addActionError(e.getMessage());
			return INPUT;
		}
	}

	public String excluir() {

		if (agendaVo.getRowid() == null)
			return REDIRECT;

		try {
			business.excluirAgenda(agendaVo.getRowid());
			return REDIRECT;

		} catch (BusinessException e) {
			addActionError(e.getMessage());
			return SUCCESS;
		}
	}

	public List<AgendaVo> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaVo> agendas) {
		this.agendas = agendas;
	}

	public AgendaVo getAgendaVo() {
		return agendaVo;
	}

	public void setAgendaVo(AgendaVo agendaVo) {
		this.agendaVo = agendaVo;
	}

}