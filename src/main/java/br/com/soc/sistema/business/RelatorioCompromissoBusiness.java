package br.com.soc.sistema.business;

import java.util.List;

import br.com.soc.sistema.dao.RelatorioCompromissoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.RelatorioCompromissoVo;

public class RelatorioCompromissoBusiness {

	private RelatorioCompromissoDao dao;

	public RelatorioCompromissoBusiness() {
		this.dao = new RelatorioCompromissoDao();
	}

	public List<RelatorioCompromissoVo> buscarPorPeriodo(String dataInicial, String dataFinal) {

		if (dataInicial == null || dataInicial.isEmpty() || dataFinal == null || dataFinal.isEmpty()) {

			throw new BusinessException("Data inicial e data final sao obrigatorias");
		}

		if (dataInicial.compareTo(dataFinal) > 0) {
			throw new BusinessException("A data inicial não pode ser maior que a data final");

		}

		return dao.buscarPorPeriodo(dataInicial, dataFinal);
	}
}
