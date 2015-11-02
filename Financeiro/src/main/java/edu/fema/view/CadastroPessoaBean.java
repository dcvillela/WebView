package edu.fema.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.fema.model.Pessoa;
import edu.fema.repository.Pessoas;

// A anotação @Named torna possível o acesso ao bean CDI por Expression Language, através de seu nome
@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroPessoas cadastro;

	private Pessoa pessoa;

	@Inject
	private Pessoas pessoas;

	// @PostConstruct
	// public void init() {
	// prepararCadastro();
	// }

	public CadastroPessoaBean() {
		super();
		this.pessoa = new Pessoa();
	}

	public void prepararCadastro() {
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.pessoa);
			this.pessoa = new Pessoa();
			context.addMessage(null, new FacesMessage(
					"Pessoa salva com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public CadastroPessoas getCadastro() {
		return cadastro;
	}

	public void setCadastro(CadastroPessoas cadastro) {
		this.cadastro = cadastro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}

}
