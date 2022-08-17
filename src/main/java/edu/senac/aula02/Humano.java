package edu.senac.aula02;

public interface Humano {

	String getNome();

	void setNome(String nome);

	int getIdade();

	void setIdade(int idade);

	double getAltura();

	void setAltura(double altura);

	double getPeso();

	void setPeso(double peso);

	void falar(String frase);

	int andar();

}
