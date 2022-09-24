package edu.senac.aula06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Ordernacao {

	private boolean logOperacoes = false;

	private Integer valores[] = null;
	private Duration tempoOrdenacao = null;

	private OrdenacaoListener listener = null;

	public Ordernacao() {
	}

	public void gerarValoresVetor(int tamanhoVetor) {
		valores = new Integer[tamanhoVetor];
		Random random = new Random();
		for (int i = 0; i <= tamanhoVetor - 1; i++)
			valores[i] = random.ints(1, tamanhoVetor).findAny().getAsInt();
	}

	public void logOperacoes() {
		if (!logOperacoes)
			return;

		for (int i = 0; i <= valores.length - 1; i++)
			System.out.print(valores[i] + " ");

		System.out.println();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}

	public void bubbleSort() {
		Instant start = Instant.now();

		int aux = 0;
		for (int i = 0; i < valores.length - 1; i++) {
			for (int j = 0; j < valores.length - i - 1; j++) {
				if (valores[j] > valores[j + 1]) {
					aux = valores[j];
					valores[j] = valores[j + 1];
					valores[j + 1] = aux;
				}

				logOperacoes();
				if (listener != null)
					listener.onExecution(valores);
			}
		}

		Instant end = Instant.now();
		tempoOrdenacao = Duration.between(start, end);
		System.out.println("##### Duração da ordenação - BubbleSort: " + tempoOrdenacao);
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
			logOperacoes();
			if (listener != null)
				listener.onExecution(valores);
		}
		Instant end = Instant.now();
		tempoOrdenacao = Duration.between(start, end);
		System.out.println("##### Duração da ordenação - InsertionSort: " + tempoOrdenacao);
	}

	public void selectionSort() {
		Instant start = Instant.now();

		int posMenorValor = 0;

		for (int i = 0; i <= valores.length - 1; i++) {
			posMenorValor = i;
			for (int j = 0; j <= valores.length - 1; j++) {
				if (valores[posMenorValor] <= valores[j]) {
					posMenorValor = j;
					int aux = valores[i];
					valores[i] = valores[posMenorValor];
					valores[j] = aux;
					logOperacoes();
					if (listener != null)
						listener.onExecution(valores);
				}
			}
		}

		Instant end = Instant.now();
		tempoOrdenacao = Duration.between(start, end);
		System.out.println("##### Duração da ordenação - SelectionSort: " + tempoOrdenacao);
	}

	public void gerarArquivo(String prefix) throws IOException {
		System.out.println("Gravando em um arquivo - " + prefix);
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./" + prefix + "Diretorio" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve(prefix + ".txt"));
		for (Integer valor : this.valores)
			Files.write(bubbleSortArquivo, (valor + "\r\n").getBytes(StandardCharsets.ISO_8859_1),
					StandardOpenOption.APPEND);
		System.out.println(BubbleSort.class + " - Arquivo gerado com sucesso - " + prefix);
	}

	public Integer[] getValores() {
		return valores;
	}

	public void setListener(OrdenacaoListener listener) {
		this.listener = listener;
	}

	public boolean isLogOperacoes() {
		return logOperacoes;
	}

	public void setLogOperacoes(boolean logOperacoes) {
		this.logOperacoes = logOperacoes;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		Ordernacao ordernacao = new Ordernacao();

		ordernacao.gerarValoresVetor(10000);
		ordernacao.bubbleSort();

		ordernacao.gerarValoresVetor(10000);
		ordernacao.insertionSort();

		ordernacao.gerarValoresVetor(10000);
		ordernacao.selectionSort();

		scanner.close();
	}

}
