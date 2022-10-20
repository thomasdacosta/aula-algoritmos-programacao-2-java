package edu.senac.zenit.polar;

public class ZenitPolar {

	public String run(String source) {
		String dest = "";
		
		for (char c : source.toCharArray()) {
			char x = c; 
			switch (Character.toUpperCase(x)) {
				case 'Z':
					x = 'P';
					break;
				case 'P': 
					x = 'Z';
					break;
				case 'E': 
					x = 'O';
					break;
				case 'O': 
					x = 'E';
					break;
				case 'N': 
					x = 'L';
					break;
				case 'L': 
					x = 'N';
					break;
				case 'I': 
					x = 'A';
					break;
				case 'A': 
					x = 'I';
					break;
				case 'T': 
					x = 'R';
					break;
				case 'R': 
					x = 'T';
					break;					
			}
			
			if (Character.isLowerCase(c))
				x = Character.toLowerCase(x);
			else
				x = Character.toUpperCase(x);
				
			dest += x;
		}
		
		return dest;
	}
	
	public static void main(String[] args) {
		ZenitPolar zenitPolar = new ZenitPolar();
		System.out.println(zenitPolar.run("Uma leve justiça leva a várias compreensões"));
		System.out.println(zenitPolar.run("Todo mundo age não apenas por compulsão externa, mas também por necessidade íntima"));
		System.out.println(zenitPolar.run("Se for para o bem da Nação e felicidade geral, diga ao povo que fico"));
		System.out.println(zenitPolar.run("Amar foi um erro, o melhor a se fazer foi desistir do amor e viver a procura da paixão"));
	}
	
}