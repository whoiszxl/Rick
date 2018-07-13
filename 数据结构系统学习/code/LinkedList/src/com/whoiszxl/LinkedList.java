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

	/**
	 * ���������ͷ���
	 */
	private Node dummyHead;
	private int size;

	public LinkedList() {
		//����ͷ����ڳ�ʼ����ʱ��ʼ��һ���սڵ�
		dummyHead = new Node(null, null);
		size = 0;
	}

	/**
	 * ��ȡ������Ԫ�صĸ���
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * ���������Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	

	/**
	 * ������indexλ������µ�Ԫ��e
	 * 
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add faild,Illegal index.");
		}
		
		//����ͷ���
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;

	}
	
	
	/**
	 * ���б�ͷ����µ�Ԫ��e
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * ��ĩβ���һ���µ�Ԫ��e
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}
	
	
	/**
	 * ͨ��index�±��ȡһ��Ԫ��e
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get faild,Illegal index.");
		}
		
		//ͨ������ͷ����õ�ʵ�ʵĵ�һ��Ԫ�ؽڵ�
		Node cur = dummyHead.next;
		//ͨ��forѭ����ѭ��index�Σ�cur.next��ǰ��index������index����Ľڵ㣬Ȼ��ֱ�ӷ���
		for(int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	/**
	 * ��ȡ�����0��Ԫ��
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}
	
	/**
	 * ��ȡ�������һ��Ԫ��
	 * @return
	 */
	public E getLast() {
		return get(size - 1);
	}
	
	
	/**
	 * ��indexλ�õ�ֵ����Ϊe
	 * @param index
	 * @param e
	 */
	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("set faild,Illegal index.");
		}
		
		Node cur = dummyHead.next;
		
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.e = e;
		
	}
	
	
	/**
	 * �����������Ƿ���e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		Node cur = dummyHead.next;
//		for (int i = 0; i < size; i++) {
//			if(cur.e.equals(e)) {
//				return true;
//			}
//			cur = cur.next;
//		}
		while(cur != null) {
			if(cur.e.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * ͨ���±�ɾ�������еĽڵ�Ԫ��
	 * @param i
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("remove faild,Illegal index.");
		}
		
		//��ȡ��index��ǰһ���ڵ�
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		//��ǰһ���ڵ��nextָ���һ���ڵ��ojbk��
		Node retNode = prev.next;
		prev.next = prev.next.next;
		retNode.next = null;
		size--;
		return retNode.e;
	}
	
	
	/**
	 * ɾ����һ��Ԫ��
	 */
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * ɾ����ĩβ��һ��Ԫ��
	 */
	public E removeLast() {
		return remove(size-1);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while(cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> a = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			a.addFirst(i);
		}
		System.out.println(a);
		a.removeFirst();
		
		System.out.println(a);
		
	}	
	
}
