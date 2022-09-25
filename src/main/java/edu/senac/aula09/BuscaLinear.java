package edu.senac.aula09;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import edu.senac.aula06.Ordernacao;

public class BuscaLinear {

	public static void main(String[] args) {
		Duration tempoOrdenacao = null;

		Ordernacao ordernacao = new Ordernacao();
		ordernacao.gerarValoresVetor(100000);
		ordernacao.insertionSort();

		Integer valores[] = ordernacao.getValores();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite um valor para pesquisar:");
		int valor = scanner.nextInt();

		Instant start = Instant.now();

		boolean encontrou = false;
		for (int i = 0; i <= valores.length - 1; i++) {
			if (valor == valores[i]) {
				encontrou = true;
				System.out.println("##### Valor encontrado no vetor na posição " + i);
				break;
			}
		}

		if (!encontrou)
			System.out.println("##### Valor não encontrado");

		Instant end = Instant.now();
		tempoOrdenacao = Duration.between(start, end);
		System.out.println("##### Duração da pesquisa - Busca Linear: " + tempoOrdenacao);

		scanner.close();
	}

}
