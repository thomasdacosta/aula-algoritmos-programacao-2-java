package edu.senac.aula03;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

/**
 * Classe corrigida para o Java 8
 */
public class ArquivosDiretoriosWritersOutputStreams {
	
	public static void main(String[] args) throws Exception {
		Path arquivo = Files.createFile(Paths.get("arquivo.txt"));
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(arquivo, StandardCharsets.ISO_8859_1, 
				StandardOpenOption.APPEND)) {
			for (int i=0;i<=9;i++)
				bufferedWriter.write("Valor gerado é " + UUID.randomUUID() + "\r\n");
		}

		Path arquivo1 = Files.createFile(Paths.get("arquivo1.txt"));
		try (OutputStream outputStream = Files.newOutputStream(arquivo1, StandardOpenOption.APPEND)) {
			for (int i=0;i<=9;i++)
				outputStream.write(String.valueOf("Valor gerado é " + UUID.randomUUID() + "\r\n").getBytes());	
		}
	}

}
