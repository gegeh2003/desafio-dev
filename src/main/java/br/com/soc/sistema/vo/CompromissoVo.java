package br.com.soc.sistema.vo;

public class CompromissoVo {
	
	private String rowid;
	private String codigoFuncionario;
	private String codigoAgenda;
	private String data;
	private String horario;
	private String periodoAgenda;
	
	public CompromissoVo() {}
	
	 public CompromissoVo(String rowid, String codigoFuncionario, String codigoAgenda, String data, String horario) {
		 this.rowid = rowid;
		 this.codigoFuncionario = codigoFuncionario;
		 this.codigoAgenda = codigoAgenda;
		 this.data = data;
		 this.horario = horario;
	 }
	 
	 public String getRowid() {
		 return rowid;
	 }
	 
	 public void setRowid(String rowid) {
		 this.rowid = rowid;
	 }
	 
	 public String getCodigoFuncionario() {
		 return codigoFuncionario;
	 }
	 
	 public void setCodigoFuncionario(String codigoFuncionario) {
	        this.codigoFuncionario = codigoFuncionario;
	    }

	    public String getCodigoAgenda() {
	        return codigoAgenda;
	    }

	    public void setCodigoAgenda(String codigoAgenda) {
	        this.codigoAgenda = codigoAgenda;
	    }

	    public String getData() {
	        return data;
	    }

	    public void setData(String data) {
	        this.data = data;
	    }

	    public String getHorario() {
	        return horario;
	    }

	    public void setHorario(String horario) {
	        this.horario = horario;
	    }
	    
	    public String getPeriodoAgenda() {
	        return periodoAgenda;
	    }

	    public void setPeriodoAgenda(String periodoAgenda) {
	        this.periodoAgenda = periodoAgenda;
	    }

	    @Override
	    public String toString() {
	        return "CompromissoVo [rowid=" + rowid + ", codigoFuncionario=" + codigoFuncionario
	                + ", codigoAgenda=" + codigoAgenda + ", data=" + data + ", horario=" + horario + "]";
	    }
	 
}
