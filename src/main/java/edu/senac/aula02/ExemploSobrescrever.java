package edu.senac.aula02;

public class ExemploSobrescrever {
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.falar("Eu trabalho na empresa ABX");
		
		Pessoa pessoa = new Funcionario();
		pessoa.falar("Eu trabalho na empresa TXBUI");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.falar("Eu sou uma pessoa");
	}

}
