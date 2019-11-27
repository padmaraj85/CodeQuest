package com.code.quest.ui.model;

public class Feature {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	@Override
	public String toString() {
		return "Feature [name=" + name + "]";
	}

}
