package edu.fema.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import edu.fema.model.Lancamento;
import edu.fema.model.Pessoa;

import javax.persistence.TypedQuery;

public class Pessoas {

	private EntityManager manager;

	// Injeção de dependências (dependency injection ou DI)
	@Inject
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}

	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}

	public List<Pessoa> todas() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa",
				Pessoa.class);
		return query.getResultList();
	}
	
	public void adicionar(Pessoa pessoa) {
		this.manager.persist(pessoa);
	}
	
	public void guardar(Pessoa pessoa) {
		this.manager.merge(pessoa);
	}
	
	public void remover(Pessoa pessoa) {
		this.manager.remove(pessoa);
	}
}
