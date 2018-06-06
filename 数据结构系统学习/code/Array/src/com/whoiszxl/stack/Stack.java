package com.whoiszxl.stack;

/**
 * ջ��ʵ�ֽӿ�
 * @author whoiszxl
 *
 * @param <E>
 */
public interface Stack<E> {
	
	int getSize();
	boolean isEmpty();
	
	void push(E e);
	E pop();
	E peek();
}
