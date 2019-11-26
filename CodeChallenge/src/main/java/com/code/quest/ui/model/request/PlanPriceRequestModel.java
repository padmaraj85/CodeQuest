package com.code.quest.ui.model.request;

import java.util.Arrays;

import javax.validation.constraints.NotNull;

import com.code.quest.ui.model.Feature;
import com.code.quest.ui.model.Plan;

public class PlanPriceRequestModel {

	@NotNull
	private Plan[] allPlans;
	@NotNull
	private Feature[] selectedFeatures;

	public Plan[] getAllPlans() {
		return allPlans;
	}

	public void setAllPlans(Plan[] allPlans) {
		this.allPlans = allPlans;
	}

	public Feature[] getSelectedFeatures() {
		return selectedFeatures;
	}

	public void setSelectedFeatures(Feature[] selectedFeatures) {
		this.selectedFeatures = selectedFeatures;
	}

	@Override
	public String toString() {
		return "PlanPriceRequestModel [allPlans=" + Arrays.toString(allPlans) + ", selectedFeatures="
				+ Arrays.toString(selectedFeatures) + "]";
	}

}
