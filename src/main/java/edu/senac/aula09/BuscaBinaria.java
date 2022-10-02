package edu.senac.aula09;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.UUID;

import edu.senac.aula06.Ordernacao;

public class BuscaBinaria {

	public static void main(String[] args) throws IOException {
		Duration tempoOrdenacao = null;

		Ordernacao ordernacao = new Ordernacao();
		System.out.println("##### Gerando valores...");
		
		ordernacao.gerarValoresVetor(200000);
		
		System.out.println("##### Ordenando...");
		ordernacao.insertionSort();

		Integer valores[] = ordernacao.getValores();
		gerarArquivo(valores, "ordenado");
		
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
	
	private static void gerarArquivo(Integer valores[], String suffix) throws IOException {
		System.out.println(BuscaBinaria.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./buscaBinariaDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("buscaBinaria-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.write(bubbleSortArquivo, (valor + "\r\n").getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
		System.out.println(BuscaBinaria.class + " - Arquivo gerado com sucesso" );
	}	

}
