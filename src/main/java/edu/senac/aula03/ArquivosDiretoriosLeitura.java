package edu.senac.aula03;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * Classe corrigida para o Java 8
 */
public class ArquivosDiretoriosLeitura {
	
	public static void main(String[] args) throws Exception {
		Path path = criarArquivo();
//		String conteudo = Files.readString(path, StandardCharsets.ISO_8859_1);
//		System.out.println("Conte�do do Arquivo:\r\n" + conteudo);
		
		String conteudo = new String(Files.readAllBytes(path), StandardCharsets.ISO_8859_1);
		System.out.println("Conte�do do Arquivo:\r\n" + conteudo);
	}
	
	public static Path criarArquivo() throws Exception {
		Path novoDiretorio = Files.createDirectory(Paths.get("./novoDiretorio-" + UUID.randomUUID()));
		System.out.println("Novo diret�rio:" + novoDiretorio.toAbsolutePath());
		
		Path novoArquivo = Files.createFile(novoDiretorio.resolve("novoArquivo.txt"));
		System.out.println("Novo arquivo:" + novoArquivo.toAbsolutePath());

		for (int i=0;i<=9;i++)
			Files.write(novoArquivo, ("Valor gerado � " + UUID.randomUUID() + "\r\n").getBytes(StandardCharsets.ISO_8859_1)
					, StandardOpenOption.APPEND);
		
		return novoArquivo;
	}

}
