package edu.senac.ordenacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Ordernacao {

	private static final Integer TAMANHO_VETOR = 15;

	private Integer valores[] = new Integer[TAMANHO_VETOR];

	public Ordernacao() {
	}

	public void gerarValoresVetor() {
		Random random = new Random();
		for (int i = 0; i <= TAMANHO_VETOR - 1; i++)
			valores[i] = random.nextInt(1, TAMANHO_VETOR);
	}

	public void imprimirVetor() {
		for (int i = 0; i <= TAMANHO_VETOR - 1; i++) {
			System.out.print(valores[i] + " ");
		}
		System.out.println("");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {}
	}

	public void bubbleSort() {
		Instant start = Instant.now();

		boolean existeTroca = false;
		while (!existeTroca) {
			Integer aux = 0;
			existeTroca = true;
			for (int i = 0; i <= valores.length - 1; i++) {
				if (i == valores.length - 1)
					break;

				if (valores[i + 1] < valores[i]) {
					existeTroca = false;
					aux = valores[i + 1];
					valores[i + 1] = valores[i];
					valores[i] = aux;
				}
				imprimirVetor();
			}
		}

		Instant end = Instant.now();
		System.out.println("##### Duração da ordenação - BubbleSort: " + Duration.between(start, end));
	}

	public void insertionSort() {
		Instant start = Instant.now();
		for (int i = 0; i < valores.length; i++) {
			int j = i;
			int x = valores[j];
			while (j > 0 && x < valores[j - 1]) {
				valores[j] = valores[j - 1];
				j--;
			}
			valores[j] = x;
			imprimirVetor();
		}
		Instant end = Instant.now();
		System.out.println("##### Duração da ordenação - InsertionSort: " + Duration.between(start, end));
	}

	public void gerarArquivo(String prefix) throws IOException {
		System.out.println("Gravando em um arquivo - " + prefix);
		Path bubbleSortDiretorio = Files.createDirectory(Path.of("./" + prefix + "Diretorio" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve(prefix + ".txt"));
		for (Integer valor : this.valores)
			Files.writeString(bubbleSortArquivo, valor + "\r\n", StandardCharsets.ISO_8859_1,
					StandardOpenOption.APPEND);
		System.out.println(BubbleSort.class + " - Arquivo gerado com sucesso - " + prefix);
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		Ordernacao ordernacao = new Ordernacao();
		ordernacao.gerarValoresVetor();
		ordernacao.bubbleSort();

		ordernacao.gerarValoresVetor();
		ordernacao.insertionSort();

		scanner.close();
	}

}
