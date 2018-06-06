package com.whoiszxl.array;

/**
 * �Զ�������
 * @author whoiszxl
 *
 */
public class Array<E> {
	
	/**
	 * ����Ԫ�ش洢
	 */
	private E[] data;
	
	/**
	 * �����С
	 */
	private int size;
	
	/**
	 * ��ʼ�������С
	 * @param capacity �����С 
	 */
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * �o�����캯��
	 * Ĭ����������Ϊ20
	 */
	public Array() {
		this(20);
	}
	
	/**
	 * ��ȡ����Ԫ�صĸ���
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * ��ȡ���������
	 * @return
	 */
	public int getCapacity() {
		return data.length;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * ��������һ��Ԫ��
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}
	
	/**
	 * �ʼ���һ��Ԫ��
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * ��index��λ�������һ��eԪ��
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
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
	
	
	/**
	 * ��ȡindex����λ�õ�Ԫ��
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("��ȡʧ�ܣ������λ�ò��Ϸ�");
		}
		return data[index];
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	
	/**
	 * �޸�index����λ�õ�Ԫ��Ϊe
	 * @param index
	 * @param e
	 */
    public void set(int index, E e){
    	if(index < 0 || index >= size) {
			throw new IllegalArgumentException("����ʧ�ܣ������λ�ò��Ϸ�");
		}
        data[index] = e;
    }
    
    /**
     * �����������Ƿ���Ԫ��e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)) {
            	return true;
            }
        }
        return false;
    }
    
    
    /**
     * ����������Ԫ��e���ڵ����������������Ԫ��e���򷵻�-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e)) {
            	return i;
            }
        }
        return -1;
    }
    
    /**
     * ɾ��������indexλ�õ�Ԫ��
     * @param index
     * @return
     */
    public E remove(int index) {
    	if(index < 0 || index >= size) {
    		throw new IllegalArgumentException("ɾ��ʧ�ܣ������λ�ò��Ϸ�");
    	}
    	E ret = data[index];
    	
    	for (int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
    	size--;
    	data[size] = null;
    	
    	if(size == data.length/4 && data.length/2 != 0) {
    		resize(data.length/2);
    	}
    	return ret;
    }
	
    
 // ��������ɾ����һ��Ԫ��, ����ɾ����Ԫ��
    public E removeFirst(){
        return remove(0);
    }

    // ��������ɾ�����һ��Ԫ��, ����ɾ����Ԫ��
    public E removeLast(){
        return remove(size - 1);
    }

    // ��������ɾ��Ԫ��e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1) {
        	remove(index);
        }
            
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
        	res.append(data[i]);
            if(i != size - 1) {
            	res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * ������ռ���������newCapacity��С
     * @param newCapacity
     */
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++) {
        	newData[i] = data[i];
        }
        data = newData;
    }
}
