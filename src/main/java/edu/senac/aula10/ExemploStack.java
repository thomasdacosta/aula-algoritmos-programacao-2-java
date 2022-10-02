package edu.senac.aula10;

import java.util.Random;
import java.util.Stack;

public class ExemploStack {
	
	private static final Integer TAMANHO_LISTA = 10;
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		Random random = new Random();
		
		for (int i=0;i<=TAMANHO_LISTA-1;i++)
			stack.add(random.ints(1, TAMANHO_LISTA + 100).findAny().getAsInt());
		
		System.out.println("-------------------------");
		System.out.println("## Pilha:" + stack);
		System.out.println("## Tamanho:" + stack.size());
		System.out.println("-------------------------");
		
		for (int i=0;i<=TAMANHO_LISTA-1;i++) {
			Integer elemento = stack.pop();
			System.out.println("-------------------------");
			System.out.println("## Elemento Removido:" + elemento);
			System.out.println("## Pilha:" + stack);
			System.out.println("## Tamanho:" + stack.size());
			System.out.println("## Último da pilha: " + stack.peek());
			System.out.println("-------------------------");			
		}		
	}

}
