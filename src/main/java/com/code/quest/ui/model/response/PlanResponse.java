package com.code.quest.ui.model.response;

import java.util.Arrays;

public class PlanResponse {
	private double Cost;
	private String[] name;

	public PlanResponse() {

	}

	public PlanResponse(double cost, String[] name) {
		super();
		Cost = cost;
		this.name = name;
	}

	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PlanResponse [Cost=" + Cost + ", name=" + Arrays.toString(name) + "]";
	}

}
