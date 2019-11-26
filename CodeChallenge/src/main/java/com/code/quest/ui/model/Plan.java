package com.code.quest.ui.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Plan {

	String name;
	double cost;
	Feature[] features;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	public List<String> getFeaturesAsList() {
		return Arrays.asList(features).stream().map(x -> x.getName()).distinct().collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Plan [name=" + name + ", cost=" + cost + ", features=" + Arrays.toString(features) + "]";
	}

}
