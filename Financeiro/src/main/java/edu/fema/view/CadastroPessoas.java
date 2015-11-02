package edu.fema.view;

import java.util.Date;

import javax.inject.Inject;

import edu.fema.model.Pessoa;
import edu.fema.repository.Pessoas;
import edu.fema.util.Transactional;

public class CadastroPessoas {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoas;

	@Transactional
	public void salvar(Pessoa pessoa) {
		this.pessoas.guardar(pessoa);
	}

	@Transactional
	public void excluir(Pessoa pessoa) {
		pessoa = this.pessoas.porId(pessoa.getId());
		this.pessoas.remover(pessoa);
	}

}
