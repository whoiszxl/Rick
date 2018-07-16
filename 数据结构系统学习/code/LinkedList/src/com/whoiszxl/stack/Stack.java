package com.whoiszxl.stack;

/**
 * ջ����ʵ�ֽӿ�
 * @author whoiszxl
 *
 * @param <E>
 */
public interface Stack<E> {

	/**
	 * ��ȡջ�Ĵ�С
	 * @return
	 */
    int getSize();
    
    /**
     * �ж�ջ�Ƿ�Ϊ��
     * @return
     */
    boolean isEmpty();
    
    /**
     * ������һ��Ԫ��
     * @param e
     */
    void push(E e);
    
    /**
     * ��˵���һ��Ԫ��
     * @return
     */
    E pop();
    
    /**
     * ��ȡ��˵�Ԫ��
     * @return
     */
    E peek();
}
