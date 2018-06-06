package com.whoiszxl.array;

/**
 * 自定义数组
 * @author whoiszxl
 *
 */
public class Array<E> {
	
	/**
	 * 数组元素存储
	 */
	private E[] data;
	
	/**
	 * 数组大小
	 */
	private int size;
	
	/**
	 * 初始化数组大小
	 * @param capacity 数组大小 
	 */
	public Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * 無參構造函數
	 * 默认数组容量为20
	 */
	public Array() {
		this(20);
	}
	
	/**
	 * 获取数组元素的个数
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 获取数组的容量
	 * @return
	 */
	public int getCapacity() {
		return data.length;
	}
	
	/**
	 * 判断数组是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 在最后添加一个元素
	 * @param e
	 */
	public void addLast(E e) {
		add(size, e);
	}
	
	/**
	 * 最开始添加一个元素
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * 在index的位置上添加一个e元素
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
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
	
	
	/**
	 * 获取index索引位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("获取失败，传入的位置不合法");
		}
		return data[index];
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	
	/**
	 * 修改index索引位置的元素为e
	 * @param index
	 * @param e
	 */
    public void set(int index, E e){
    	if(index < 0 || index >= size) {
			throw new IllegalArgumentException("设置失败，传入的位置不合法");
		}
        data[index] = e;
    }
    
    /**
     * 查找数组中是否有元素e
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
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
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
     * 删除数组中index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
    	if(index < 0 || index >= size) {
    		throw new IllegalArgumentException("删除失败，传入的位置不合法");
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
	
    
 // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
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
     * 将数组空间的容量变成newCapacity大小
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
