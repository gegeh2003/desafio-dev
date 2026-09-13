package br.com.soc.sistema.business;

import java.util.List;

import br.com.soc.sistema.dao.CompromissoDao;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.AgendaVo;
import java.time.LocalTime;

public class CompromissoBusiness {
	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private CompromissoDao dao;
	private AgendaBusiness agendaBusiness;

	public CompromissoBusiness() {
		this.dao = new CompromissoDao();
		this.agendaBusiness = new AgendaBusiness();
	}

	public List<CompromissoVo> trazerTodosOsCompromissos() {
		return dao.findAllCompromissos();
	}

	public void salvarCompromisso(CompromissoVo compromissoVo) {

		try {

			if (compromissoVo.getCodigoFuncionario().isEmpty() || compromissoVo.getCodigoAgenda().isEmpty()
					|| compromissoVo.getData().isEmpty() || compromissoVo.getHorario().isEmpty()) {

				throw new IllegalArgumentException("Todos os campos são obrigatórios");
			}

			validarHorario(compromissoVo);
			dao.insertCompromisso(compromissoVo);

		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Não foi possível realizar a inclusão do registro");
		}
	}

	public void atualizarCompromisso(CompromissoVo compromissoVo) {
		validarHorario(compromissoVo);
		dao.atualizarCompromisso(compromissoVo);
	}

	public CompromissoVo buscarCompromissoPor(String codigo) {

		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);

		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public void excluirCompromisso(String rowid) {
		dao.excluirCompromisso(rowid);
	}

	private void validarHorario(CompromissoVo compromissoVo) {

		AgendaVo agenda = agendaBusiness.buscarAgendaPor(compromissoVo.getCodigoAgenda());

		String periodo = agenda.getPeriodoDisponivel();

		LocalTime horario = LocalTime.parse(compromissoVo.getHorario());

		LocalTime inicio;
		LocalTime fim;

		if ("Manhã".equals(periodo)) {
			inicio = LocalTime.of(6, 0);
			fim = LocalTime.of(11, 59);

		} else if ("Tarde".equals(periodo)) {
			inicio = LocalTime.of(12, 0);
			fim = LocalTime.of(18, 0);

		} else {
			inicio = LocalTime.of(6, 0);
			fim = LocalTime.of(18, 0);
		}
		if (horario.isBefore(inicio) || horario.isAfter(fim)) {
			throw new BusinessException("O horário informado não está disponível");
		}
	}
}
