package edu.senac.aula03.poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Arquivo {

	private String nomeArquivo;
	private Path arquivo;

	public Arquivo() {
	}

	public void criarArquivo(String nomeArquivo) throws IOException {
		this.nomeArquivo = nomeArquivo;
		if (!Files.exists(Path.of(nomeArquivo)))
			this.arquivo = Files.createFile(Path.of(nomeArquivo));
		else
			this.arquivo = Path.of(nomeArquivo);
	}

	public void escreverLinha(String linha) throws IOException {
		Files.writeString(this.arquivo, linha, StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
	}

	public List<String> linhas() throws IOException {
		try (BufferedReader bufferedReader = Files.newBufferedReader(arquivo, StandardCharsets.ISO_8859_1)) {
			return bufferedReader.lines().toList();
		}
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public Path getArquivo() {
		return arquivo;
	}

	public void setArquivo(Path arquivo) {
		this.arquivo = arquivo;
	}

}
