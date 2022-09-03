package edu.senac.aula03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * Classe corrigida para o Java 8
 */
public class ArquivosDiretoriosReadersInputStreams {
	
	public static void main(String[] args) throws Exception {
		Path arquivo = criarArquivo();
		
		System.out.println("## Primeira forma de leitura");
		try (BufferedReader bufferedReader = Files.newBufferedReader(arquivo, StandardCharsets.ISO_8859_1)) {
//			for (String linha : bufferedReader.lines().toList())
			while (bufferedReader.lines().iterator().hasNext()) {
				String linha = bufferedReader.readLine();
				System.out.println(linha);
			}
				
		}

		System.out.println("## Segunda forma de leitura");
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Files.newInputStream(arquivo)))) {
//			for (String linha : bufferedReader.lines().toList())
			while (bufferedReader.lines().iterator().hasNext()) {
				String linha = bufferedReader.readLine();
				System.out.println(linha);
			}
							
		}		
	}
	
	public static Path criarArquivo() throws Exception {
//		Path novoDiretorio = Files.createDirectory(Path.of("./novoDiretorio-" + UUID.randomUUID()));
		Path novoDiretorio = Files.createDirectory(Paths.get("./novoDiretorio-" + UUID.randomUUID()));
		System.out.println("Novo diretório:" + novoDiretorio.toAbsolutePath());
		
		Path novoArquivo = Files.createFile(novoDiretorio.resolve("novoArquivo.txt"));
		System.out.println("Novo arquivo:" + novoArquivo.toAbsolutePath());

		for (int i=0;i<=9;i++)
			Files.write(novoArquivo, ("Valor gerado é " + UUID.randomUUID() + "\r\n").getBytes(StandardCharsets.ISO_8859_1), 
					StandardOpenOption.APPEND);
//			Files.writeString(novoArquivo, "Valor gerado é " + UUID.randomUUID() + "\r\n", 
//				StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
		
		return novoArquivo;
	}	

}
