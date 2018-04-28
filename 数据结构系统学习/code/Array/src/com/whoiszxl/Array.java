package com.whoiszxl;

/**
 * �Զ�������
 * @author whoiszxl
 *
 */
public class Array {
	
	/**
	 * ����Ԫ�ش洢
	 */
	private int[] data;
	
	/**
	 * �����С
	 */
	private int size;
	
	/**
	 * ��ʼ�������С
	 * @param capacity �����С 
	 */
	public Array(int capacity) {
		data = new int[capacity];
		size = 0;
	}
	
	public Array() {
		this(20);
	}
	
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void addLast(int e) {
		add(size, e);
	}
	
	public void addFirst(int e) {
		add(0, e);
	}
	
	public void add(int index, int e) {
		if(size == data.length) {
			throw new IllegalArgumentException("���ʧ�ܣ�������������");
		}
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("���ʧ�ܣ������λ�ò��Ϸ�");
		}
		
		for (int i = size - 1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}
	
}
