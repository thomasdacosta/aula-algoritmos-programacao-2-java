package edu.senac.aula03.poo;

import java.io.IOException;
import java.util.UUID;

public class ArquivoOperacoes {
	
	public static void main(String[] args) {
		try {
			Arquivo arquivo = new Arquivo();
			arquivo.criarArquivo("./arquivoTexto.txt");
			
			for (int i=0;i<=19;i++)
				arquivo.escreverLinha("Valor gerado é " + UUID.randomUUID() + "\r\n");
			
			for (String linha: arquivo.linhas())
				System.out.println(linha);
			
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
	}

}
