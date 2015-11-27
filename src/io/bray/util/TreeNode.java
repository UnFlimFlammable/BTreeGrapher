package io.bray.util;

public class TreeNode<T>{
	public TreeNode<T> leftChild, rightChild, parent;
	public T data; 
	
	public TreeNode(T data){
		this.data = data;
	}
	
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
		this.leftChild = left;
		this.data = data;
		this.rightChild = right;
	}
}
