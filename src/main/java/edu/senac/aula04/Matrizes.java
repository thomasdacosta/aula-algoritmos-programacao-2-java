package edu.senac.aula04;

public class Matrizes {

	public static void main(String[] args) {
		int valor[][] = {
							{0, 0 ,0 ,0},
							{0, 1 ,1 ,0},
							{0, 1 ,1 ,0},
							{0, 0 ,0 ,0} 
		 		  		};
		
		for (int i=0;i<=valor.length-1;i++) {
			for (int j=0;j<=valor[0].length-1;j++)
				System.out.print(valor[i][j]);
			System.out.println();
		}
		
	}

}
