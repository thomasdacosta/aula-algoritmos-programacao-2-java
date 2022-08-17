package edu.senac.aula02;

public interface ExemploInterface {
	
	public static void main(String[] args) {
		Humano pessoa = new Pessoa();
		pessoa.falar("Sou uma pessoa");
		
		Humano funcionario = new Funcionario();
		funcionario.falar("Sou um funcionário feliz");
	}
	
}
