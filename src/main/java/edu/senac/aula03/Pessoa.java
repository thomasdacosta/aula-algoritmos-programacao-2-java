package edu.senac.aula03;

import java.io.Serializable;

import edu.senac.aula02.Humano;

/**
 * Classe corrigida para o Java 8
 */
public class Pessoa implements Humano, Serializable {
	
	private static final long serialVersionUID = -911770391334640100L;
	
	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private int passos;
	
	public Pessoa() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int andar() {
		passos++;
		return passos;
	}
	
	public void falar(String frase) {
		System.out.println(frase);
	}	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", altura=" + altura + ", peso=" + peso + ", passos="
				+ passos + "]";
	}

}
