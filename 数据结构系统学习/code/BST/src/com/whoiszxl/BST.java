package com.whoiszxl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	 * 二分搜索树前序遍历,
	 * 最自然的，最常用的遍历方式
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
	 * 二分搜索树中序遍历
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
	 * 二分搜索树后序遍历
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
	 * 二分搜索树的非递归前序遍历
	 * 1. 先将根节点push到栈中
	 * 2. pop出顶上的节点，将节点的左右节点再次push到栈中
	 * 3. 循环操作，直到最底端
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
	 * 二分搜索树的层序遍历
	 * 1. 先将根节点add到队列中
	 * 2. 每次取出队列的头节点，然后再将头部节点的左右节点继续入队
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
	 * 寻找二分搜索树的最小元素
	 * @return
	 */
	public E minimum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty.");
		}
		return minimum(root).e;
	}


	/**
	 * 寻找二分搜索树的最小元素
	 * 1. 因为最小元素在树的最左端，所以只需要一直递归left下去就能了
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
	 * 寻找二分搜索树的最大元素
	 * @return
	 */
	public E maximum() {
		if(size == 0) {
			throw new IllegalArgumentException("BST is empty.");
		}
		return maximum(root).e;
	}


	/**
	 * 寻找二分搜索树的最小元素
	 * 1. 因为最小元素在树的最左端，所以只需要一直递归left下去就能了
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
		//获取到最小值然后将其返回
		E e = minimum();
		//实际进行删除操作的操作
		root = removeMin(root);	
		return e;
	}


	private Node removeMin(BST<E>.Node node) {
		//如果递归到的节点的左节点为空，则这个就是最小值了
		if(node.left == null) {
			//先将这个最小值节点的右节点先存着
			Node rightNode = node.right;
			//然后将这个节点的右节点清空
			node.right = null;
			//size减小
			size--;
			//然后将储存到的右节点直接返回
			return rightNode;
			
		}
		
		//如果不是最小值，就递归调用左节点直到那个最小节点，然后将每次获取到的值存入left中，遍历到最小节点的时候就自动和node.left接上了
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
	 * 从二分搜索树中删除元素为e的节点
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
			
			//待删除节点左子树为空
			if(node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			//待删除节点右子树为空
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			//待删除节点左右子树都不为空
			//找到比待删除节点大的最小节点（待删除节点右子树的最小节点），用其替代待删除节点
			Node successor = minimum(node.right);
			//删除最小节点后会返回这个节点的子树，然后赋值给需要替换上去的节点的右节点
			successor.right = removeMin(node.right);
			
			//将获取到需要替换上去的节点的左子树换成当前节点的左子树
			successor.left = node.left;
			
			//清除不需要的
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
