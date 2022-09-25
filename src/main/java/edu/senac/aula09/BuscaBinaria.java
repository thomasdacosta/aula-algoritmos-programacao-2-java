package edu.senac.aula09;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import edu.senac.aula06.Ordernacao;

public class BuscaBinaria {

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

		int posicaoInicial, metadeVetor, tamanhoVetor;
		posicaoInicial = 0;
		tamanhoVetor = valores.length - 1;

		boolean encontrou = false;
		while (posicaoInicial <= tamanhoVetor) {
			metadeVetor = (posicaoInicial + tamanhoVetor) / 2;

			if (valores[metadeVetor] == valor) {
				System.out.println("##### Valor encontrado no vetor na posição " + metadeVetor);
				break;
			}

			if (valor < valores[metadeVetor]) // esquerda
				tamanhoVetor = metadeVetor - 1;
			else // direita
				posicaoInicial = metadeVetor + 1;
		}

		if (!encontrou)
			System.out.println("##### Valor não encontrado");

		Instant end = Instant.now();
		tempoOrdenacao = Duration.between(start, end);
		System.out.println("##### Duração da pesquisa - Busca Binária: " + tempoOrdenacao);
		
		scanner.close();
	}

}
