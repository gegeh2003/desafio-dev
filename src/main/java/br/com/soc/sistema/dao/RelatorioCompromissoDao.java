package br.com.soc.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;

import br.com.soc.sistema.vo.RelatorioCompromissoVo;

public class RelatorioCompromissoDao extends Dao {

	public List<RelatorioCompromissoVo> buscarPorPeriodo(String dataInicial, String dataFinal) {

		StringBuilder query = new StringBuilder(
				"SELECT f.rowid codigoFuncionario, " + "f.nm_funcionario nomeFuncionario, " + "a.rowid codigoAgenda, "
						+ "a.nm_agenda nomeAgenda, " + "c.data data, " + "c.horario horario " + "FROM compromisso c "
						+ "INNER JOIN funcionario f ON c.cd_funcionario = f.rowid "
						+ "INNER JOIN agenda a ON c.cd_agenda = a.rowid " + "WHERE c.data BETWEEN ? AND ? "
						+ "ORDER BY c.data, c.horario");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())

		) {
			ps.setDate(1, java.sql.Date.valueOf(dataInicial));
			ps.setDate(2, java.sql.Date.valueOf(dataFinal));

			try (ResultSet rs = ps.executeQuery()) {

				List<RelatorioCompromissoVo> relatorio = new ArrayList<>();

				while (rs.next()) {

					RelatorioCompromissoVo vo = new RelatorioCompromissoVo();

					vo.setCodigoFuncionario(rs.getString("codigoFuncionario"));
					vo.setNomeFuncionario(rs.getString("nomeFuncionario"));
					vo.setCodigoAgenda(rs.getString("codigoAgenda"));
					vo.setNomeAgenda(rs.getString("nomeAgenda"));
					vo.setData(rs.getString("data"));
					vo.setHorario(rs.getString("horario"));

					relatorio.add(vo);
				}

				return relatorio;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
