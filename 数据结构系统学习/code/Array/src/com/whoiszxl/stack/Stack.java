package com.whoiszxl.stack;

/**
 * 栈的实现接口
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
