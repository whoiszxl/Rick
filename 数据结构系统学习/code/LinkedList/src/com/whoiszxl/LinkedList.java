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
	 * 链表的虚拟头结点
	 */
	private Node dummyHead;
	private int size;

	public LinkedList() {
		//虚拟头结点在初始化的时初始化一个空节点
		dummyHead = new Node(null, null);
		size = 0;
	}

	/**
	 * 获取链表中元素的个数
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 返回链表是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	

	/**
	 * 在链表index位置添加新的元素e
	 * 
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add faild,Illegal index.");
		}
		
		//虚拟头结点
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;

	}
	
	
	/**
	 * 在列表头添加新的元素e
	 * 
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}

	/**
	 * 在末尾添加一个新的元素e
	 * 
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}
	
	
	/**
	 * 通过index下标获取一个元素e
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get faild,Illegal index.");
		}
		
		//通过虚拟头结点拿到实际的第一个元素节点
		Node cur = dummyHead.next;
		//通过for循环，循环index次，cur.next向前跳index次跳到index坐标的节点，然后直接返回
		for(int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.e;
	}
	
	/**
	 * 获取链表第0个元素
	 * @return
	 */
	public E getFirst() {
		return get(0);
	}
	
	/**
	 * 获取链表最后一个元素
	 * @return
	 */
	public E getLast() {
		return get(size - 1);
	}
	
	
	/**
	 * 将index位置的值设置为e
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
	 * 查找链表中是否含有e
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
	 * 通过下标删除链表中的节点元素
	 * @param i
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("remove faild,Illegal index.");
		}
		
		//获取到index的前一个节点
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		//将前一个节点的next指向后一个节点就ojbk了
		Node retNode = prev.next;
		prev.next = prev.next.next;
		retNode.next = null;
		size--;
		return retNode.e;
	}
	
	
	/**
	 * 删除第一个元素
	 */
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * 删除最末尾的一个元素
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
