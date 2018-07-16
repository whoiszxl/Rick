package com.whoiszxl;

public class Main {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = {5,3,6,8,4,2,1};
		
		for (int i : nums) {
			bst.add(i);
		}
		
		bst.preOrder();
		
		System.out.println();
		
		System.out.println(bst);
	}
	
}
