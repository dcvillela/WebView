package edu.fema.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.fema.model.Lancamento;
import edu.fema.model.Pessoa;
import edu.fema.model.TipoLancamento;
import edu.fema.repository.Lancamentos;
import edu.fema.repository.Pessoas;
import edu.fema.util.JpaUtil;

// A anotação @Named torna possível o acesso ao bean CDI por Expression Language, através de seu nome
@Named
@javax.faces.view.ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private CadastroLancamentos cadastro;
	@Inject
	private Pessoas pessoas;
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;
	@Inject
	private Lancamentos lancamentos;

	// @PostConstruct
	// public void init(){
	// prepararCadastro();
	// }

	public void prepararCadastro() {
		this.todasPessoas = this.pessoas.todas();
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	public List<String> pesquisarDescricoes(String descricao) {
		return this.lancamentos.descricoesQueContem(descricao);
	}

	public void descricaoModificada(ValueChangeEvent event) {
		System.out
				.println("------------ ValueChangeEvent descricaoModificada --------");
		System.out.println("Valor antigo: " + event.getOldValue());
		System.out.println("Novo valor: " + event.getNewValue());
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.salvar(this.lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage(
					"Lançamento salvo com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		if (this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento
					.getDataVencimento());
		}
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public CadastroLancamentos getCadastro() {
		return cadastro;
	}

	public void setCadastro(CadastroLancamentos cadastro) {
		this.cadastro = cadastro;
	}

	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}

	public void setTodasPessoas(List<Pessoa> todasPessoas) {
		this.todasPessoas = todasPessoas;
	}

}
