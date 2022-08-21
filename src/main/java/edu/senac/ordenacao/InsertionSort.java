package edu.senac.ordenacao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class InsertionSort {
	
	private static final Integer TAMANHO_VETOR = 10000;
	
	public static void main(String[] args) throws IOException {
		System.out.println(InsertionSort.class +  " - Ordenando aguarde..."); 
		Integer valores[] = new Integer[TAMANHO_VETOR];
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_VETOR-1;i++) 
			valores[i] = random.nextInt(1, TAMANHO_VETOR);
		
		gerarArquivo(valores, "entrada");

		Instant start = Instant.now();
		
		for (int i = 0; i < valores.length; i++) {
			int j = i;
			int x = valores[j];
			while (j > 0 && x < valores[j - 1]) {
				valores[j] = valores[j - 1];
				j--;
			}
			valores[j] = x;
		}
		
		Instant end = Instant.now();
		System.out.println(InsertionSort.class + " - ##### Duração da ordenação: " + Duration.between(start, end));
		
		gerarArquivo(valores, "saida");
	}
	
	private static void gerarArquivo(Integer valores[], String suffix) throws IOException {
		System.out.println(InsertionSort.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Path.of("./insertionSortDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("insertionSort-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.writeString(bubbleSortArquivo, valor + "\r\n", 
					StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
		System.out.println(InsertionSort.class + " - Arquivo gerado com sucesso" );
	}	

}
