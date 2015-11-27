package io.bray.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class TreeGraphConverter {
	public String dotString = "graph{ \n";
	public void convertTreeToPNG(String outputFileName, TreeNode root){
		
		addTreeNodeToGraph(root);
		dotString += "}";
		
		File file = new File(outputFileName);
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(dotString);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dotString);
		try {
			Process p = Runtime.getRuntime().exec("dot/bin/dot " +outputFileName+" -Tjpeg -O"+outputFileName+".jpeg");
			p.waitFor();
			System.out.println("Exit Value: "+ p.exitValue());
			System.out.println(outputFileName+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addTreeNodeToGraph(TreeNode node){
		if(node.leftChild != null){
			dotString += node.data.toString() + "--" + node.leftChild.data.toString()+ ";\n";
			addTreeNodeToGraph(node.leftChild);
		}

		if(node.rightChild != null){
			dotString += node.data.toString() + "--" + node.rightChild.data.toString()+ ";\n";
			addTreeNodeToGraph(node.rightChild);
		}
		
	}
}
