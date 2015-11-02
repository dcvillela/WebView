package edu.fema.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fema.model.Pessoa;

public class NovaPessoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa p1 = new Pessoa();
		p1.setNome("Ford");
		System.out.println("Criando " + p1.getNome());
		// Persistir pessoa
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("FinanceiroPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(p1);
			tx.commit();
			System.out.println("Pessoa: " + p1.getNome() + " criada!");
		} catch (Exception ex) {
			System.out.println("Erro 1: " + ex.getMessage());
		} finally {
			em.close();
			emf.close();
		}

	}

}
