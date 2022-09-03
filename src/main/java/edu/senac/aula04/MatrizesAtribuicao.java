package edu.senac.aula04;

public class MatrizesAtribuicao {

	public static void main(String[] args) {
		int valor[][] = {
							{0, 0 ,0 ,0},
							{0, 1 ,1 ,0},
							{0, 1 ,1 ,0},
							{0, 0 ,0 ,0} 
		 		  		};
		
		valor[0][0] = 9;
		valor[3][3] = 9;
		
		for (int i=0;i<=valor.length-1;i++) {
			for (int j=0;j<=valor[0].length-1;j++)
				System.out.print(valor[i][j]);
			System.out.println();
		}
		
	}

}
