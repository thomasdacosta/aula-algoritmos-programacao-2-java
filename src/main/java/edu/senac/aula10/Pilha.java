package edu.senac.aula10;

public class Pilha<E> {
	
	private Integer size = 0;
	private Node<E> node = new Node<>();
	private Node<E> lastNode = null;
	
    public boolean add(E e) {
		if (e == null)
			throw new NullPointerException();
		
		if (size > Integer.MAX_VALUE)
			throw new IllegalArgumentException();
		
		if (this.node.getObject() == null && this.node.getNextNode() == null) {
			this.node.setObject(e);
			this.lastNode = this.node;
			size++;
		} else {
			Node<E> node = this.node;
			while (node.getNextNode() != null) {
				node = node.getNextNode();
			}
			
			Node<E> newNode = new Node<>();
			newNode.setObject(e);
			newNode.setPrevNode(node);
			node.setNextNode(newNode);
			this.lastNode = newNode;
			size++;
		}
		
		return true;
    }	
    
    public E pop() {
    	if (size == 0)
    		return null;
    	
    	E e = this.lastNode.getObject();
    	
    	if (this.lastNode.getPrevNode() == null) {
    		this.node = new Node<>();
    		this.lastNode = node;
    		size--;
    		return this.lastNode.getObject(); 
    	}
    	
    	this.lastNode = this.lastNode.getPrevNode();
    	this.lastNode.setNextNode(null);
    	size--;
    	return e;
    }
    
    public E peek() {
    	return this.lastNode.getObject();
    }
    
    public boolean empty() {
    	return size == 0;
    }
    
    public int size() {
        return size;
    }
    
	@Override
	public String toString() {
		String elements = "";
		Node<E> node = this.node;
		elements = "[";
		while (node.getNextNode() != null) {
			elements += (node.getObject() == null ? "" : node.getObject()) + ",";
			node = node.getNextNode();
		}
		elements += (node.getObject() == null ? "" : node.getObject()) + "]";
		return elements;
	}    

}
