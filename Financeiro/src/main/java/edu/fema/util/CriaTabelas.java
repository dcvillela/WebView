package edu.fema.util;

// Fontes
// https://github.com/algaworks/ebook-javaee
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class CriaTabelas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Persistence.createEntityManagerFactory("FinanceiroPU");
			JOptionPane.showMessageDialog(null, "Tabelas criadas");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro - " + ex.getMessage());;
		}
	}

}
