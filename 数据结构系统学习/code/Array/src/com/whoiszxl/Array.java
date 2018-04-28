package com.whoiszxl;

/**
 * 自定义数组
 * @author whoiszxl
 *
 */
public class Array {
	
	/**
	 * 数组元素存储
	 */
	private int[] data;
	
	/**
	 * 数组大小
	 */
	private int size;
	
	/**
	 * 初始化数组大小
	 * @param capacity 数组大小 
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
			throw new IllegalArgumentException("添加失败，数组容量不够");
		}
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("添加失败，传入的位置不合法");
		}
		
		for (int i = size - 1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}
	
}
