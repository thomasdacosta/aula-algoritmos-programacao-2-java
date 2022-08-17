package edu.senac.aula02;

public class Funcionario extends Pessoa {
	
	private double salario;
	private String cargo;
	
	public Funcionario() {
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public void falar(String frase) {
		System.out.println("Funcionário:" + frase);
	}	

}
