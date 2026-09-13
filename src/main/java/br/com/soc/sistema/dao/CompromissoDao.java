package br.com.soc.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.vo.AgendaVo;
import br.com.soc.sistema.vo.CompromissoVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class CompromissoDao extends Dao {

	public void insertCompromisso(CompromissoVo compromissoVo) {

		StringBuilder query = new StringBuilder(
				"INSERT INTO compromisso (cd_funcionario, cd_agenda, data, horario) values (?, ?, ?, ?)");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;

			ps.setInt(i++, Integer.parseInt(compromissoVo.getCodigoFuncionario()));
			ps.setInt(i++, Integer.parseInt(compromissoVo.getCodigoAgenda()));
			ps.setDate(i++, java.sql.Date.valueOf(compromissoVo.getData()));
			ps.setTime(i++, java.sql.Time.valueOf(compromissoVo.getHorario() + ":00"));

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarCompromisso(CompromissoVo compromissoVo) {

		StringBuilder query = new StringBuilder(
				"UPDATE compromisso SET cd_funcionario = ?, cd_agenda = ?, data = ?, horario = ? WHERE rowid = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;

			ps.setInt(i++, Integer.parseInt(compromissoVo.getCodigoFuncionario()));
			ps.setInt(i++, Integer.parseInt(compromissoVo.getCodigoAgenda()));
			ps.setDate(i++, java.sql.Date.valueOf(compromissoVo.getData()));
			ps.setTime(i++, java.sql.Time.valueOf(compromissoVo.getHorario() + ":00"));
			ps.setString(i++, compromissoVo.getRowid());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CompromissoVo> findAllCompromissos() {

		StringBuilder query = new StringBuilder("SELECT c.rowid id, " + "c.cd_funcionario codigoFuncionario, "
				+ "f.nm_funcionario nomeFuncionario, " + "c.cd_agenda codigoAgenda, " + "a.nm_agenda nomeAgenda, "
				+ "a.periodo_disponivel periodoAgenda, " + "c.data data, " + "c.horario horario "
				+ "FROM compromisso c " + "INNER JOIN funcionario f ON c.cd_funcionario = f.rowid "
				+ "INNER JOIN agenda a ON c.cd_agenda = a.rowid");

		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()) {

			List<CompromissoVo> compromissos = new ArrayList<>();

			while (rs.next()) {
				CompromissoVo vo = new CompromissoVo();
				vo.setRowid(rs.getString("id"));
				vo.setCodigoFuncionario(rs.getString("codigoFuncionario"));
				vo.setCodigoAgenda(rs.getString("codigoAgenda"));
				vo.setPeriodoAgenda(rs.getString("periodoAgenda"));
				vo.setNomeAgenda(rs.getString("nomeAgenda"));
				vo.setData(rs.getString("data"));
				vo.setHorario(rs.getString("horario"));

				compromissos.add(vo);
			}
			return compromissos;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public CompromissoVo findByCodigo(Integer codigo) {

		StringBuilder query = new StringBuilder(

				"SELECT rowid id, cd_funcionario codigoFuncionario, "
						+ "cd_agenda codigoAgenda, data data, horario horario " + "FROM compromisso WHERE rowid = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;
			ps.setInt(i++, codigo);

			try (ResultSet rs = ps.executeQuery()) {

				CompromissoVo vo = null;

				while (rs.next()) {

					vo = new CompromissoVo();

					vo.setRowid(rs.getString("id"));
					vo.setCodigoFuncionario(rs.getString("codigoFuncionario"));
					vo.setCodigoAgenda(rs.getString("codigoAgenda"));
					vo.setData(rs.getString("data"));
					vo.setHorario(rs.getString("horario"));
				}

				return vo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void excluirCompromisso(String rowid) {

		StringBuilder query = new StringBuilder("DELETE FROM compromisso WHERE rowid = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;
			ps.setString(i++, rowid);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
