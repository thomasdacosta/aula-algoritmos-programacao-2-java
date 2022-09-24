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
import java.util.UUID;

import edu.senac.aula07.InsertionSort;

public class SelectionSort {
	
	private static final Integer TAMANHO_VETOR = 10000;
	
	public static void main(String[] args) throws IOException {
		System.out.println(SelectionSort.class +  " - Ordenando aguarde..."); 
		Integer valores[] = new Integer[TAMANHO_VETOR];
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_VETOR-1;i++)
			valores[i] = random.ints(1, TAMANHO_VETOR).findAny().getAsInt();
		
		gerarArquivo(valores, "entrada");

		Instant start = Instant.now();
		
		int posMenorValor = 0;
		
		for (int i=0;i<=valores.length-1;i++) {
			posMenorValor = i;
			for (int j=0;j<=valores.length-1;j++) {
				if (valores[posMenorValor] <= valores[j]) {
					posMenorValor = j;
					int aux = valores[i];
					valores[i] = valores[posMenorValor];
					valores[j] = aux;
				}
			}
		}
		
		System.out.println("");
		for (int i=0;i<=TAMANHO_VETOR-1;i++)
			System.out.println(valores[i] + " ");
		
		Instant end = Instant.now();
		System.out.println(InsertionSort.class + " - ##### Duração da ordenação: " + Duration.between(start, end));
		
		gerarArquivo(valores, "saida");
	}
	
	private static void gerarArquivo(Integer valores[], String suffix) throws IOException {
		System.out.println(SelectionSort.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./selectionSortDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("selectionSortSort-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.write(bubbleSortArquivo, (valor + "\r\n").getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
		System.out.println(SelectionSort.class + " - Arquivo gerado com sucesso" );
	}	

}
