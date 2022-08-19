package edu.senac.aula03;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ArquivosDiretoriosListar {
	
	public static void main(String[] args) throws Exception {
		Path diretorioAtual = Path.of(".");
				
		System.out.println("## Listando todos os arquivos do diretório");
		try (Stream<Path> arquivos = Files.list(diretorioAtual)) {
		    for (Path arquivo : arquivos.toList())
		    	System.out.println(arquivo.normalize().toAbsolutePath());
		}

		System.out.println("## Buscando um arquivo");
		try (DirectoryStream<Path> arquivos = Files.newDirectoryStream(diretorioAtual, "*.xml")) {
		    for (Path arquivo : arquivos)
		    	System.out.println(arquivo.normalize().toAbsolutePath());
		}		
	}

}
