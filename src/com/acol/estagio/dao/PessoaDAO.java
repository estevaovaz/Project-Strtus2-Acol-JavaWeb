package com.acol.estagio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.acol.estagio.bean.Pessoa;
import com.acol.estagio.factory.ConexaoFactory;

public class PessoaDAO {

	public void salvar(Pessoa p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO estagiario ");
		sql.append("(NOME, CPF, NOTA) ");
		sql.append("VALUES (?, ?, ?)");

		// String sql = "INSERT INTO estagiario (nome, cpf, nota) " + "VALUES(" +
		// p.getNome() + ", "
		// + p.getCpf() + ", " + p.getNota() + ")";

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getNome());
		comando.setInt(2, p.getCpf());
		comando.setInt(3, p.getNota());

		comando.executeUpdate();

	}

	public void cadastrar(Pessoa estagiario) throws SQLException {

		// SQL INSERÇÂO
		String sql = "INSERT INTO estagiario (NOME, CPF, NOTA) " + "VALUES(" + estagiario.getNome() + ", "
				+ estagiario.getCpf() + ", " + estagiario.getNota() + ")";

		Connection conexao = ConexaoFactory.conectar();

		// PreparedStatement s = conexao.prepareStatement(sql.toString());
		Statement s = conexao.createStatement();

		s.executeUpdate(sql);

		conexao.close();

	}

	public static ArrayList<Pessoa> recuperarTodos() throws SQLException {

		// SQL INSERÇÂO
		String sql = "SELECT * FROM estagiario";

		Connection conexao = ConexaoFactory.conectar();

		// PreparedStatement s = conexao.prepareStatement(sql.toString());
		Statement s = conexao.createStatement();

		ResultSet resultado = s.executeQuery(sql);

		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

		while (resultado.next()) {

			Pessoa p = new Pessoa();
			p.setNome(resultado.getString("nome"));
			p.setCpf(resultado.getInt("cpf"));
			p.setNota(resultado.getInt("nota"));

			lista.add(p);
		}

		conexao.close();
		return lista;
	}

	public void deletar(Pessoa p) throws SQLException {

		// SQL INSERÇAO

		try {
			String sql = "DELETE FROM estagiario WHERE id = " + p.getId()+ " ";

			Connection conexao = ConexaoFactory.conectar();
			Statement s = conexao.createStatement();

			s.executeUpdate(sql);

			conexao.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("ERRO:" + e.getMessage());
		}

	}
	

	public void editar(Pessoa p) throws SQLException {

		// SQL INSERÇAO
		try {
			String sql = "UPDATE estagiario SET nome = ?, cpf = ? , nota = ? WHERE id = " + p.getId();

			Connection conexao = ConexaoFactory.conectar();
			Statement s = conexao.createStatement();

			s.executeUpdate(sql);

			conexao.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("erro ao excluir");
		}
	}

	public void update(Pessoa p) throws SQLException {
		String sql = "UPDATE estagiario SET nome = ?, cpf = ? , nota = ? WHERE id = " + p.getId() + " ";

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql);

		if (p.getId() == p.getId()) {
			comando.setString(1, p.getNome());
			comando.setInt(2, p.getCpf());
			comando.setInt(3, p.getNota());

			comando.executeUpdate();

		} else {
			System.out.println("ERRO");
		}

	}
}
