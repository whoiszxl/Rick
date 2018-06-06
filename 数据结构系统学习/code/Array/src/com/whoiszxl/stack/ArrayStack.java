package com.whoiszxl.stack;

import com.whoiszxl.array.Array;

public class ArrayStack<E> implements Stack<E> {
	
	private Array<E> array;
	
	public ArrayStack(int capacity) {
		array = new Array<>(capacity);
	}
	
	public ArrayStack() {
		array = new Array<>();
	}

	@Override
	public int getSize() {
		return array.size();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}
	
	@Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.size() ; i ++){
            res.append(array.get(i));
            if(i != array.size() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack);
		
		System.out.println(stack.peek());
		
	}

}
