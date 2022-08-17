package edu.senac.aula02;

public class ExemploFuncionario {
	
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João da Silva");
		funcionario.setIdade(24);
		funcionario.setAltura(1.75);
		funcionario.setPeso(60.0);
		funcionario.setSalario(100000.00);

		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getIdade());
		System.out.println(funcionario.getAltura());
		System.out.println(funcionario.getPeso());

		System.out.println(funcionario.andar());
	}

}
