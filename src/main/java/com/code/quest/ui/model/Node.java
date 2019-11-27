package com.code.quest.ui.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class Node {
	@NotNull
	String id;
	Node[] children;
	Node right;

	public Node(String id, Node[] children) {
		super();
		this.id = id;
		this.children = children;
	}

	public Node(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", children=" + Arrays.toString(children) + ", right=" + right + "]";
	}

}
