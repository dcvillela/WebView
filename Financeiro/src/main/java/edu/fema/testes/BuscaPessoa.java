package edu.fema.testes;

import javax.persistence.EntityManager;

import edu.fema.model.Pessoa;
import edu.fema.repository.Pessoas;
import edu.fema.util.JpaUtil;

public class BuscaPessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa retorno = null;
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			Pessoas pessoas = new Pessoas(manager);
			retorno = pessoas.porId(new Long(2));
			System.out.println("******************\nPessoa com id=2 é " + retorno.getNome());
		} finally {
			manager.close();
		}
	}

}
