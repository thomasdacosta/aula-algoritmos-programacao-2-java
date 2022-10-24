package edu.senac.aula11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * Link: https://www.geeksforgeeks.org/merge-sort/
 * 
 * @author thoma
 *
 */
public class MergeSort {
	
	private static final Integer TAMANHO_VETOR = 100000;
	
	public static void main(String args[]) throws IOException {
		int valores[] = new int[TAMANHO_VETOR];
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_VETOR-1;i++)
			valores[i] = random.ints(1, TAMANHO_VETOR).findAny().getAsInt();		
		
		gerarArquivo(valores, "entrada");
		Instant start = Instant.now();

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(valores, 0, valores.length - 1);
		
		Instant end = Instant.now();
		System.out.println(MergeSort.class + " - ##### Duração da ordenação: " + Duration.between(start, end));		

		gerarArquivo(valores, "saida");
	}
	
	public void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	private static void gerarArquivo(int valores[], String suffix) throws IOException {
		System.out.println(MergeSort.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./mergeSortDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("mergeSort-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.write(bubbleSortArquivo, (valor + "\r\n").getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
		System.out.println(MergeSort.class + " - Arquivo gerado com sucesso" );
	}	

}
