package edu.senac.aula10;

public class Node<E> {

	private Node<E> nextNode;
	private Node<E> prevNode;
	private E object; 

	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> node) {
		this.nextNode = node;
	}

	public Node<E> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<E> prevNode) {
		this.prevNode = prevNode;
	}

	public E getObject() {
		return object;
	}

	public void setObject(E object) {
		this.object = object;
	}

}
