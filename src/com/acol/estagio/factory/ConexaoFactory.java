package com.acol.estagio.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory { 

	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/acol_estagio?useTimezone=true&serverTimezone=UTC";
	
	public static Connection conectar() throws SQLException{
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
		
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado com Sucesso!");
		} 
		
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Conex�o Falhou!");
		}
	}
}
