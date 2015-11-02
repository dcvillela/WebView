package edu.fema.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class MeuBean {

	private String nome;
	private int quantidadeCaracteres;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void transformar() {
		this.nome = this.nome.toUpperCase();
		this.quantidadeCaracteres = this.nome.length();
	}
	
	//public void transformar(AjaxBehaviorEvent event) {
	//	this.nome = this.nome.toUpperCase();
	//	this.quantidadeCaracteres = this.nome.length();
	//}

	public int getQuantidadeCaracteres() {
		return quantidadeCaracteres;
	}

	public void setQuantidadeCaracteres(int quantidadeCaracteres) {
		this.quantidadeCaracteres = quantidadeCaracteres;
	}

}
