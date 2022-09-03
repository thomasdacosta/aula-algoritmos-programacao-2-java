package edu.senac.aula04;

public class VetoresAtribuicao {

	public static void main(String[] args) {
		int vetor[] = new int[5];
		
		vetor[0] = 0;
		vetor[1] = 1;
		vetor[2] = 2;
		vetor[3] = 3;
		vetor[4] = 4;
		
		for (int i=0;i<=vetor.length-1;i++) {
			System.out.println("Valor:" + vetor[i]);
		}

	}

}
