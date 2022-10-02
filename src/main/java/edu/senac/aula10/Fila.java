package edu.senac.aula10;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Fila<E> implements Queue<E> {
	
	private static final String METHOD_NOT_IMPLEMENTED = "Método não implementado";
	
	private Integer size = 0;
	private Node<E> node = new Node<>();
	private E[] nodes = null; 
	
	@Override
	public boolean add(E e) {
		return addElement(e);
	}
	
	@Override
	public boolean offer(E e) {
		return addElement(e);
	}
	
	@SuppressWarnings("unchecked")
	private boolean addElement(E e) {
		if (e == null)
			throw new NullPointerException();
		
		if (size > Integer.MAX_VALUE)
			throw new IllegalArgumentException();
		
		if (this.node.getObject() == null && this.node.getNode() == null) {
			this.node.setObject(e);
			size++;
		} else {
			Node<E> node = this.node;
			while (node.getNode() != null) {
				node = node.getNode();
			}
			
			Node<E> newNode = new Node<>();
			newNode.setObject(e);
			node.setNode(newNode);
			size++;
		}
		
		if (nodes == null) {
			nodes = (E[]) Array.newInstance(e.getClass(), size);
			nodes[0] = e;
		} else {
			E[] es = (E[]) Array.newInstance(e.getClass(), size);
			es[0] = e;
			System.arraycopy(nodes, 0, es, 1, es.length-1);
			nodes = es;
		}
		
		return true;
	}
	
	@Override
	public E remove() {
		if (this.node.getObject() == null)
			throw new NoSuchElementException();
		
		return removeElement();
	}
	
	@Override
	public E poll() {
		if (this.node.getObject() == null)
			return null;
		
		return removeElement();
	}
	
	private E removeElement() {
		E value = this.node.getObject();
		this.node = this.node.getNode();
		
		if (this.node == null)
			this.node = new Node<>();
		
		size--;
		return value;
	}
	
	@Override
	public E element() {
		if (this.node.getObject() == null)
			throw new NoSuchElementException();
		
		return this.node.getNode().getObject();
	}
	
	@Override
	public E peek() {
		return this.node.getObject();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void clear() {
		this.node = new Node<>();
		size = 0;
	}
	
	@Override
	public boolean contains(Object o) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public Iterator<E> iterator() {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public Object[] toArray() {
		return nodes;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public boolean remove(Object o) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new RuntimeException(METHOD_NOT_IMPLEMENTED);
	}
	
	@Override
	public String toString() {
		String elements = "";
		Node<E> node = this.node;
		elements = "[";
		while (node.getNode() != null) {
			elements += (node.getObject() == null ? "" : node.getObject()) + ",";
			node = node.getNode();
		}
		elements += (node.getObject() == null ? "" : node.getObject()) + "]";
		return elements;
	}

}
