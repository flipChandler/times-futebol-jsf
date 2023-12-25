package br.com.felipesantos.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.felipesantos.dao.EstadoDAO;
import br.com.felipesantos.model.Estado;
import br.com.felipesantos.util.Util;

@Named(value = "controleEstado")
@ViewScoped
public class EstadoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoDAO<Estado> dao;
	private Estado estado;
	
	public EstadoController() {
	}
	
	public String listar() {
		return "/privado/estado/listar?faces-redirect=true";
	}
	
	public void novo() {
		estado = new Estado();
	}
	
	public void alterar(Object id) {
		try {
			estado = dao.findById(id);
			salvar();
		} catch (Exception e) {
			Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
		}
	}
	
	public void excluir(Object id) {
		try {
			estado = dao.findById(id);
			dao.remove(estado);
			Util.mensagemInformacao("Objeto removido com sucesso!");
		} catch (Exception e) {
			Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
		}
	}
	
	public void salvar() {
		try {
			if (estado.getId() == null) {
				dao.persist(estado);
			} else {
				dao.merge(estado);
			}
			Util.mensagemInformacao("Objeto persistido com sucesso!");
		} catch (Exception e) {
			Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
		}
	}

	public EstadoDAO<Estado> getDao() {
		return dao;
	}

	public void setDao(EstadoDAO<Estado> dao) {
		this.dao = dao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
}
