package com.code.quest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.code.quest.service.NodePopulateService;
import com.code.quest.ui.model.Node;

@SpringBootTest
class CodeChallengeApplicationTests {

	@Autowired
	NodePopulateService service;
	
	@Test
	void testTraveseNode() {
		
		/*
		 * Construct the following binary tree 
		 *      1 
		 *   /  |  \ 
		 *  2   3   4 
		 * / \       \ 
		 * 5 6        7
		 * 
		 */
		
			Node root = new Node("1");
			Node n2 = new Node("2");
			Node n3 = new Node("3");
			Node n4 = new Node("4");
			Node n5 = new Node("5");
			Node n6 = new Node("6");
			Node n7 = new Node("7");

			root.setChildren(new Node[] { n2, n3, n4 });
			n2.setChildren(new Node[] { n5, n6 });
			n4.setChildren(new Node[] { n7 });
			
			List expectedList = Stream.of("1","2","3","4","5","6","7").collect(Collectors.toList());			

			assertEquals(expectedList,service.breadthFirstTraversal(root));

		}
	
	

}
