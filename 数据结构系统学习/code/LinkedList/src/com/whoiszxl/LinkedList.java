package com.whoiszxl;

public class LinkedList<E> {
	
	
	private class Node {
	
		public E e;
		public Node next;
		public Node(E e, LinkedList<E>.Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null, null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	private Node head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	/**
	 * ��ȡ������Ԫ�صĸ���
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * ���������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * ���б�ͷ����µ�Ԫ��e
	 * @param e
	 */
	public void addFirst(E e) {
		head = new Node(e, head);
		size++;
	}
	
	/**
	 * ������indexλ������µ�Ԫ��e
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Add faild,Illegal index.");
		}
		
		if(index == 0) {
			addFirst(e);
		}else {
			Node prev = head;
			for(int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}			
//			Node node = new Node(e);
//			node.next = prev.next;
//			prev.next = node;
			
			prev.next = new Node(e, prev.next);
			size++;
		}
	}
	
	/**
	 * ��ĩβ���һ���µ�Ԫ��e
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}
}
