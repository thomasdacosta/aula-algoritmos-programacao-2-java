package edu.senac.aula02;

import java.util.Scanner;

public class DadosPessoa {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Pessoa pessoa = new Pessoa();
		
		System.out.println("Digite o nome:");
		pessoa.setNome(scanner.nextLine());
		
		System.out.println("Digite a idade:");
		pessoa.setIdade(scanner.nextInt());
		
		System.out.println("Digite a altura:");
		pessoa.setAltura(scanner.nextDouble());		
		
		System.out.println("Digite o peso:");
		pessoa.setPeso(scanner.nextDouble());
		
		pessoa.andar();
		
		System.out.println(pessoa);
		
		scanner.close();
	}

}
