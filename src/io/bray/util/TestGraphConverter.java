package io.bray.util;

import java.util.Map;

import org.junit.Test;

public class TestGraphConverter {
	TreeGraphConverter converter = new TreeGraphConverter();
	@Test
	public void test() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
		     System.out.format("%s=%s%n", envName, env.get(envName));
		}

		TreeNode<Integer> root = new TreeNode<Integer>(new Integer(1));
		root.leftChild = new TreeNode<Integer>(new Integer(2));
		root.rightChild = new TreeNode<Integer>(new Integer(3));
		root.rightChild.leftChild = new TreeNode<Integer>(new Integer(4));
		root.leftChild.rightChild = new TreeNode<Integer>(new Integer(5));
		root.leftChild.rightChild.leftChild = new TreeNode<Integer>(new Integer(6));
		root.leftChild.leftChild = new TreeNode<Integer>(new Integer(999));
		converter.convertTreeToPNG("dankTest1", root);
	}

}
