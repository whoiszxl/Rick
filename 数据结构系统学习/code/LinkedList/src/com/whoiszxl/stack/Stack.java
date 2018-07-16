package com.whoiszxl.stack;

/**
 * 栈功能实现接口
 * @author whoiszxl
 *
 * @param <E>
 */
public interface Stack<E> {

	/**
	 * 获取栈的大小
	 * @return
	 */
    int getSize();
    
    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();
    
    /**
     * 最顶端添加一个元素
     * @param e
     */
    void push(E e);
    
    /**
     * 最顶端弹出一个元素
     * @return
     */
    E pop();
    
    /**
     * 获取最顶端的元素
     * @return
     */
    E peek();
}
