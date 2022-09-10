package edu.senac.aula04;

public class VetoresAtribuicao {

	public static void main(String[] args) {
		int vetor[] = new int[5];
		
		vetor[0] = 10;
		vetor[1] = 12;
		vetor[2] = 32;
		vetor[3] = 43;
		vetor[4] = 64;
		
		for (int i=0;i<=vetor.length-1;i++) {
			System.out.println("Valor:" + vetor[i]);
		}

	}

}
