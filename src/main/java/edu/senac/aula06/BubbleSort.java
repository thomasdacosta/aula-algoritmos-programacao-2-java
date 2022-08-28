package edu.senac.aula06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class BubbleSort {
	
	private static final Integer TAMANHO_VETOR = 1000;
	
	public static void main(String[] args) throws IOException {
		System.out.println(BubbleSort.class +  " - Ordenando aguarde..."); 
		Integer valores[] = new Integer[TAMANHO_VETOR];
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_VETOR-1;i++) 
			valores[i] = random.nextInt(1, TAMANHO_VETOR);
		
		gerarArquivo(valores, "entrada");

		Instant start = Instant.now();
		
		boolean existeTroca = false;
		while (!existeTroca) {
			Integer aux = 0;
			existeTroca = true;
			for (int i=0;i<=valores.length-1;i++) {
				if (i == valores.length-1)
					break;
				
				if (valores[i+1] < valores[i]) {
					existeTroca = false;
					aux = valores[i+1];
					valores[i+1] = valores[i];
					valores[i] = aux;
				}
			}
		}
		
		Instant end = Instant.now();
		System.out.println(BubbleSort.class + " - ##### Duração da ordenação: " + Duration.between(start, end));
		
		gerarArquivo(valores, "saida");
	}
	
	private static void gerarArquivo(Integer valores[], String suffix) throws IOException {
		System.out.println(BubbleSort.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Path.of("./bubbleSortDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("bubbleSort-" + suffix + ".txt"));
		for (Integer valor : valores)
			Files.writeString(bubbleSortArquivo, valor + "\r\n", 
					StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
		System.out.println(BubbleSort.class + " - Arquivo gerado com sucesso" );
	}

}
