package br.com.soc.sistema.action;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.business.RelatorioCompromissoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.RelatorioCompromissoVo;
import br.com.soc.sistema.relatorio.ExportadorExcel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class RelatorioCompromissoAction extends Action {

	private List<RelatorioCompromissoVo> relatorio = new ArrayList<>();
	private RelatorioCompromissoBusiness business = new RelatorioCompromissoBusiness();
	private ExportadorExcel exportadorExcel = new ExportadorExcel();

	private String dataInicial;
	private String dataFinal;

	private InputStream inputStream;

	public String tela() {
		return SUCCESS;
	}

	public String gerar() {

		relatorio = business.buscarPorPeriodo(dataInicial, dataFinal);

		return SUCCESS;
	}

	public String exportar() {

		relatorio = business.buscarPorPeriodo(dataInicial, dataFinal);

		inputStream = new ByteArrayInputStream(exportadorExcel.gerarExcel(relatorio));

		return SUCCESS;
	}

	public List<RelatorioCompromissoVo> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(List<RelatorioCompromissoVo> relatorio) {
		this.relatorio = relatorio;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
}
