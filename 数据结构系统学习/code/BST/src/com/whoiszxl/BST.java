package com.whoiszxl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ����������
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
	 * �@ȡ�����������Ԫ�؂���
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * �����������Ƿ���
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void add(E e) {
		root = add(root, e);
	}
	
	/**
	 * ����nodeΪ���Ķ����������в���Ԫ��E��ʹ�õݹ�
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
	 * �����������Ƿ����Ԫ��e
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
	 * ����������ǰ�����,
	 * ����Ȼ�ģ���õı�����ʽ
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

	
	/**
	 * �����������������
	 */
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(BST<E>.Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	
	/**
	 * �����������������
	 */
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(BST<E>.Node node) {
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}
	
	
	/**
	 * �����������ķǵݹ�ǰ�����
	 * 1. �Ƚ����ڵ�push��ջ��
	 * 2. pop�����ϵĽڵ㣬���ڵ�����ҽڵ��ٴ�push��ջ��
	 * 3. ѭ��������ֱ����׶�
	 */
	public void preOrderNR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			
			Node cur = stack.pop();
			System.out.println(cur.e);
			
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
	
	/**
	 * �����������Ĳ������
	 * 1. �Ƚ����ڵ�add��������
	 * 2. ÿ��ȡ�����е�ͷ�ڵ㣬Ȼ���ٽ�ͷ���ڵ�����ҽڵ�������
	 */
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node cur = q.remove();
			System.out.println(cur.e);
			
			if(cur.left!=null) {
				q.add(cur.left);
			}
			if(cur.right!=null) {
				q.add(cur.right);
			}
		}
	}
	
	
	/**
	 * Ѱ�Ҷ�������������СԪ��
	 * @return
	 */
	public E minimum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty.");
		}
		return minimum(root).e;
	}


	/**
	 * Ѱ�Ҷ�������������СԪ��
	 * 1. ��Ϊ��СԪ������������ˣ�����ֻ��Ҫһֱ�ݹ�left��ȥ������
	 * @param node
	 * @return
	 */
	private Node minimum(BST<E>.Node node) {
		if(node.left == null) {
			return node;
		}
		return minimum(node.left);
	}
	
	
	/**
	 * Ѱ�Ҷ��������������Ԫ��
	 * @return
	 */
	public E maximum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty.");
		}
		return maximum(root).e;
	}


	/**
	 * Ѱ�Ҷ�������������СԪ��
	 * 1. ��Ϊ��СԪ������������ˣ�����ֻ��Ҫһֱ�ݹ�left��ȥ������
	 * @param node
	 * @return
	 */
	private Node maximum(BST<E>.Node node) {
		if(node.right == null) {
			return node;
		}
		return maximum(node.right);
	}
	
	public E removeMin() {
		//��ȡ����СֵȻ���䷵��
		E e = minimum();
		//ʵ�ʽ���ɾ�������Ĳ���
		root = removeMin(root);	
		return e;
	}


	private Node removeMin(BST<E>.Node node) {
		//����ݹ鵽�Ľڵ����ڵ�Ϊ�գ������������Сֵ��
		if(node.left == null) {
			//�Ƚ������Сֵ�ڵ���ҽڵ��ȴ���
			Node rightNode = node.right;
			//Ȼ������ڵ���ҽڵ����
			node.right = null;
			//size��С
			size--;
			//Ȼ�󽫴��浽���ҽڵ�ֱ�ӷ���
			return rightNode;
			
		}
		
		//���������Сֵ���͵ݹ������ڵ�ֱ���Ǹ���С�ڵ㣬Ȼ��ÿ�λ�ȡ����ֵ����left�У���������С�ڵ��ʱ����Զ���node.left������
		node.left = removeMin(node.left);
		return node;
	}

	
	
	public E removeMax() {
		E e = maximum();
		root = removeMax(root);	
		return e;
	}


	private Node removeMax(BST<E>.Node node) {
		
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
			
		}
		
		node.right = removeMax(node.right);
		return node;
	}
	
	
	/**
	 * �Ӷ�����������ɾ��Ԫ��Ϊe�Ľڵ�
	 * @param e
	 */
	public void remove(E e) {
		root = remove(root, e);
	}

	private BST<E>.Node remove(BST<E>.Node node, E e) {
		if(node == null) {
			return null;
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		}else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		}else { //e == node.e
			
			//��ɾ���ڵ�������Ϊ��
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			//��ɾ���ڵ�������Ϊ��
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			//��ɾ���ڵ�������������Ϊ��
			//�ҵ��ȴ�ɾ���ڵ�����С�ڵ㣨��ɾ���ڵ�����������С�ڵ㣩�����������ɾ���ڵ�
			Node successor = minimum(node.right);
			//ɾ����С�ڵ��᷵������ڵ��������Ȼ��ֵ����Ҫ�滻��ȥ�Ľڵ���ҽڵ�
			successor.right = removeMin(node.right);
			
			//����ȡ����Ҫ�滻��ȥ�Ľڵ�����������ɵ�ǰ�ڵ��������
			successor.left = node.left;
			
			//�������Ҫ��
			node.left = node.right = null;
			
			return successor;
		}
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
