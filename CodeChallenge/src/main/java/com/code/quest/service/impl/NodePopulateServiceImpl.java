package com.code.quest.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.code.quest.service.NodePopulateService;
import com.code.quest.ui.model.Node;

@Service
public class NodePopulateServiceImpl implements NodePopulateService{	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public List breadthFirstTraversal(Node root) {
		// TODO Auto-generated method stub
		return traverseNode(root);
	} 
	
	
	
	/*
	 * If target is present populate the right node property,
	 * 
	 */
	public List traverseNode(Node root) {
		// implemented breadth first seach node traversal algorithm.
		 Node currentNode =root;
		 Queue queue = new LinkedList<Node>();
		 queue.add(currentNode);
		 
		 List traversedList = new ArrayList();
		 while(queue.size()>0) {
			 currentNode = (Node) queue.poll();
			 traversedList.add(currentNode.getId());
			 if(currentNode.getChildren()!=null) {
				 int length = currentNode.getChildren().length;
				 for (int i=0;i<length;i++) {
					 queue.add((currentNode.getChildren())[i]);
				 }
				 
			 }
		 }
 		 
		
		
		
		logger.debug("final root :"+traversedList);
		return traversedList;
	}

	/* sample test program*/
	public Node test(Node root) {

		/*
		 * Construct the following binary tree 
		 *      1 
		 *   /  |  \ 
		 *  2   3   4 
		 * / \       \ 
		 * 5 6        7
		 * 
		 */
		if (root == null) {
			root = new Node("1");
			Node n2 = new Node("2");
			Node n3 = new Node("3");
			Node n4 = new Node("4");
			Node n5 = new Node("5");
			Node n6 = new Node("6");
			Node n7 = new Node("7");

			root.setChildren(new Node[] { n2, n3, n4 });
			n2.setChildren(new Node[] { n5, n6 });
			n4.setChildren(new Node[] { n7 });
		}
		traverseNode(root);
		return root;
	
		

	}
	public static void main(String[] args) {
		new NodePopulateServiceImpl().test(null);
	}

	
}