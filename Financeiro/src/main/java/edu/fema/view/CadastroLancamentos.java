package edu.fema.view;

import java.util.Date;

import javax.inject.Inject;

import edu.fema.model.Lancamento;
import edu.fema.repository.Lancamentos;
import edu.fema.util.Transactional;

public class CadastroLancamentos {

	private static final long serialVersionUID = 1L;

	@Inject
	private Lancamentos lancamentos;

	@Transactional
	public void salvar(Lancamento lancamento) throws NegocioException {
		if (lancamento.getDataPagamento() != null
				&& lancamento.getDataPagamento().after(new Date())) {
			throw new NegocioException(
					"Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentos.guardar(lancamento);
	}

	@Transactional
	public void excluir(Lancamento lancamento) throws NegocioException {
		lancamento = this.lancamentos.porId(lancamento.getId());
		if (lancamento.getDataPagamento() != null) {
			throw new NegocioException(
					"Não é possível excluir um lançamento pago!");
		}
		this.lancamentos.remover(lancamento);
	}

}
