package edu.fema.view;

import java.io.Serializable;
import java.util.List;

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
public class ConsultaPessoasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoas pessoasRepository;
	
	@Inject
	private CadastroPessoas cadastro;

	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	
	public void consultar() {
		this.pessoas = pessoasRepository.todas();
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.pessoaSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage("Pessoa "
					+ this.pessoaSelecionada.getNome()
					+ " excluída com sucesso!"));
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
}
