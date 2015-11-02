package edu.fema.testes;

import java.util.List;

import edu.fema.model.Lancamento;
import edu.fema.repository.Lancamentos;
import edu.fema.util.JpaUtil;

public class BuscaLancamentos {

	public static void main(String[] args) {
		Lancamentos lancamentosRepository = new Lancamentos(JpaUtil.getEntityManager());
		List<Lancamento> lancamentos;
		try {
			lancamentos = lancamentosRepository.todos();
			System.out.println("--------------- Listando --------------");
			for (Lancamento lanca : lancamentos) {
				System.out.println(lanca.getId() + "-" + lanca.getDescricao());
			}
		} catch (Exception ex) {
			System.out.println("Erro - " + ex.getMessage());
		}
	}
}
