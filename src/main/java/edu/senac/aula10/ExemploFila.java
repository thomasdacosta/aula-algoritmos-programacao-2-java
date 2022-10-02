package edu.senac.aula10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.UUID;

public class ExemploFila {
	
	private static final Integer TAMANHO_LISTA = 10;
	
	public static void main(String[] args) throws IOException {
		StringBuffer mensagem = new StringBuffer();
		Fila<Integer> queue = new Fila<>();
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_LISTA-1;i++)
			queue.add(random.ints(1, TAMANHO_LISTA + 100).findAny().getAsInt());
		
		mensagem.append("-------------------------\r\n");
		mensagem.append("## Fila:" + queue + "\r\n");
		mensagem.append("## Tamanho:" + queue.size() + "\r\n");
		mensagem.append("-------------------------\r\n");		

		for (int i=0;i<=TAMANHO_LISTA-1;i++) {
			Integer elemento = queue.remove();
			mensagem.append("-------------------------\r\n");
			mensagem.append("## Elemento Removido:" + elemento + "\r\n");
			mensagem.append("## Fila:" + queue + "\r\n");
			mensagem.append("## Tamanho:" + queue.size() + "\r\n");
			mensagem.append("## Primeiro da fila: " + queue.peek() + "\r\n");
			mensagem.append("-------------------------\r\n");			
		}

		gerarArquivo(mensagem.toString(), "saida");
	}
	
	private static void gerarArquivo(String mensagem, String suffix) throws IOException {
		System.out.println(ExemploFila.class + " - Gravando em um arquivo" );
		Path bubbleSortDiretorio = Files.createDirectory(Paths.get("./exemploFilaDiretorio-" + suffix + "-" + UUID.randomUUID()));
		Path bubbleSortArquivo = Files.createFile(bubbleSortDiretorio.resolve("exemploFila-" + suffix + ".txt"));
		Files.write(bubbleSortArquivo, mensagem.getBytes(StandardCharsets.ISO_8859_1), StandardOpenOption.APPEND);
		System.out.println(ExemploFila.class + " - Arquivo gerado com sucesso" );
	}	

}
