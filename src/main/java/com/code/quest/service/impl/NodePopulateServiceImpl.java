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
// Refer to JUnit to test this method
		return traverseNode(root);
	} 
	
	
	
	/*
	 * If target is present populate the right node property,
	 * 
	 */
	public List traverseNode(Node root) {
// Refer to JUnit to test this method
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
	
}