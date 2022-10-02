package edu.senac.aula10;

import java.util.Random;

public class ExemploFila {
	
	private static final Integer TAMANHO_LISTA = 10;
	
	public static void main(String[] args) {
		Fila<Integer> queue = new Fila<>();
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_LISTA-1;i++)
			queue.add(random.ints(1, TAMANHO_LISTA + 100).findAny().getAsInt());
		
		System.out.println("-------------------------");
		System.out.println("## Fila:" + queue);
		System.out.println("## Tamanho:" + queue.size());
		System.out.println("-------------------------");		

		for (int i=0;i<=TAMANHO_LISTA-1;i++) {
			Integer elemento = queue.remove();
			System.out.println("-------------------------");
			System.out.println("## Elemento Removido:" + elemento);
			System.out.println("## Fila:" + queue);
			System.out.println("## Tamanho:" + queue.size());
			System.out.println("## Primeiro da fila: " + queue.peek());
			System.out.println("-------------------------");			
		}
		
	}

}
