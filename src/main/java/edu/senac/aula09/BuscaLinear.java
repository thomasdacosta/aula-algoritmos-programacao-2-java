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

public class BuscaLinear {

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
	
	private static void gerarArquivo(Integer valores[], String suffix) throws IOException {
		System.out.println(BuscaLinear.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./buscaLinearDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("buscaLinear-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.write(bubbleSortArquivo, (valor + "\r\n").getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
		System.out.println(BuscaLinear.class + " - Arquivo gerado com sucesso" );
	}	

}
