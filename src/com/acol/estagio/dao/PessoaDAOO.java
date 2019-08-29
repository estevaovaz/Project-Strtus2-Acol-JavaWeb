package com.acol.estagio.dao;

import java.util.ArrayList;
import java.util.List;

import com.acol.estagio.bean.Pessoa;

public class PessoaDAOO {

	private static List<Pessoa> lista = new ArrayList<Pessoa>();
	
	public static void cadastra(Pessoa estagiario) {
		lista.add(estagiario);
	}
	
	public static List<Pessoa> recuperarTodos() {
		return lista;
	}
	
	public static void remover(Pessoa p) {
		lista.remove(p);
	}
}
