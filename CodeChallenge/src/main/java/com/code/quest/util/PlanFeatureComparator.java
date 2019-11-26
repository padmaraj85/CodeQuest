package com.code.quest.util;

import java.util.Comparator;

import com.code.quest.ui.model.Plan;

public class PlanFeatureComparator implements Comparator<Plan> {

	@Override
	public int compare(Plan plan1, Plan plan2) {
		// TODO Auto-generated method stub
		return (plan1.getFeatures().length >= plan2.getFeatures().length) ? -1 : 1;

	}

}