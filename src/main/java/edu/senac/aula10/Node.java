package edu.senac.aula10;

public class Node<E> {

	private Node<E> node;
	private E object; 

	public Node<E> getNode() {
		return node;
	}

	public void setNode(Node<E> node) {
		this.node = node;
	}

	public E getObject() {
		return object;
	}

	public void setObject(E object) {
		this.object = object;
	}

}
