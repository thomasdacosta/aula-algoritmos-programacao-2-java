package edu.senac.aula03;

import java.nio.file.Files;
import java.nio.file.Path;

public class ArquivosDiretoriosTemporarios {
	
	public static void main(String[] args) throws Exception {
		Path arquivoTemp1 = Files.createTempFile("prefixo-", ".txt");
		System.out.println("Arquivo tempor�rio:" + arquivoTemp1);
		
		Path diretorioTemp = Files.createTempDirectory("dir-prefix-");
		System.out.println("Diret�rio tempor�rio:" + diretorioTemp);
		
		Path arquivoTemp2 = Files.createTempFile(diretorioTemp, "prefixo-", ".txt");
		System.out.println("Arquivo tempor�rio:" + arquivoTemp2);
	}

}
