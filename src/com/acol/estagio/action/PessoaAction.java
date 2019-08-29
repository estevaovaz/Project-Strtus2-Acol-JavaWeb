package com.acol.estagio.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.acol.estagio.bean.Pessoa;
import com.acol.estagio.dao.PessoaDAO;
//import com.acol.estagio.dao.PessoaDAOO;
import com.opensymphony.xwork2.ActionSupport;

public class PessoaAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private List<Pessoa> lista;
	
	@Action(value = "cadastrar", results = { 
			@Result(name = "success", location = "/listar.jsp") })
	public String cadastrar() {
		try {
			
			lista = new ArrayList<Pessoa>();
			pessoa = new Pessoa();
			
			PessoaDAO dao = new PessoaDAO();
			dao.salvar(pessoa);
			
			 //PessoaDAO.cadastrar(pessoa);
			//addActionMessage("Pessoa cadastrada com sucesso!");
						
			lista = PessoaDAO.recuperarTodos();			
			return "success";
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addActionError("Deu erro");
			return "erro";
		}
	}
	
	
	@Action(value = "excluir", results = { 
			@Result(name = "success", location = "/excluir.jsp") })
	public String excluir() {
		try {
			
			lista = new ArrayList<Pessoa>();
			pessoa = new Pessoa();
					
			PessoaDAO dao = new PessoaDAO();
			dao.deletar(pessoa);
			
			//PessoaDAOO.remover(pessoa);
			//addActionMessage("Pessoa removida com sucesso!");		
			
			lista = PessoaDAO.recuperarTodos();			
			return "success";
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addActionError("Deu erro");
			return "erro";
		}
	}
	
	
	@Action(value = "editar", results = { 
			@Result(name = "success", location = "/editar.jsp") })
	public String editar() {
		try {
			
			lista = new ArrayList<Pessoa>();
			pessoa = new Pessoa();
				
			PessoaDAO dao = new PessoaDAO();
			dao.update(pessoa);		
									
			lista = PessoaDAO.recuperarTodos();			
			return "success";
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addActionError("Deu erro");
			return "erro";
		}
	}	
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getLista(){
		return lista;
	}
	
	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
	
}
