package com.whoiszxl;

/**
 * 二分搜索樹
 * @author whoiszxl
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
	
	
	private class Node {
		public E e;
		public Node left,right;
		
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;	
		}
	}
	
	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	
	/**
	 * 獲取二分搜索樹的元素個數
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 二分搜索樹是否為空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void add(E e) {
		root = add(root, e);
	}
	
	/**
	 * 向以node为根的二分搜索树中插入元素E，使用递归
	 * @param node
	 * @param e
	 */
	private Node add(Node node, E e) {

		if(node == null) {
			size++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			node.right = add(node.right, e);
		}
		
		return node;
	}
	
	/**
	 * 二分搜索树是否包含元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	
	private boolean contains(Node node, E e) {
		if(node == null) {
			return false;
		}
		
		if(e.compareTo(node.e) == 0) {
			return true;
		}else if(e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		}else {
			return contains(node.right, e);
		}
	}
	
	
	/**
	 * 二分搜索树前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}
	
	
		
	private void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}


	private void generateBSTString(BST<E>.Node node, int depth, StringBuilder res) {
		if(node == null) {
			res.append(generateDepthString(depth)+"null\n");
			return;
		}
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth+1, res);
		generateBSTString(node.right, depth+1, res);
	}


	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}
	
}
