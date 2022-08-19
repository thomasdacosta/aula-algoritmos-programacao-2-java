package edu.senac.aula03;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class ArquivosDiretoriosMoverExcluir {
	
	public static void main(String[] args) throws Exception {
		Path arquivoTemp = Files.createTempFile("prefixo", ".txt");
		Files.writeString(arquivoTemp, "Valor gerado é " + UUID.randomUUID(), StandardCharsets.ISO_8859_1);
		
		Path arquivoFinal = Files.move(arquivoTemp, Path.of("./" + arquivoTemp.getFileName()));
		System.out.println("Arquivo final:" + arquivoFinal);
		
		Files.delete(arquivoFinal);
	}

}
