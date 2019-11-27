package com.code.quest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.code.quest.service.FindBestPlanService;
import com.code.quest.ui.model.Feature;
import com.code.quest.ui.model.Plan;
import com.code.quest.ui.model.request.PlanPriceRequestModel;
import com.code.quest.ui.model.response.PlanResponse;

@Service
public class FindBestPlanServiceImpl implements FindBestPlanService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	/*
	 * Get the plan based on the features requested.
	 * 
	 */
	@Override
	public PlanResponse getBestPlan(PlanPriceRequestModel model) {

		Plan[] plans = model.getAllPlans();
		Feature[] selectedFeatures = model.getSelectedFeatures();

		List<Feature> selectedFeaturesList = Arrays.asList(selectedFeatures);
		logger.debug("selectedFeaturesList :" + selectedFeaturesList);
		List<String> shortListedFeatures = selectedFeaturesList.stream().map(x -> x.getName()).distinct()
				.collect(Collectors.toList());

		logger.debug("shortListedFeatures :" + shortListedFeatures);
		logger.debug("plans" + Arrays.asList(plans));
		List<Plan> planList = Arrays.asList(plans);
		
		//sor the list based on the least amount first. Used lambda in place of a usual Comparator
		planList.sort((o1, o2) -> o1.getCost() >= o2.getCost() ? 1 : -1);
		logger.debug("plans after sorting :" + Arrays.asList(plans));

		//Use java steam to find the best possible plan containing all plans.
		Optional<Plan> resultPlan = planList.stream()
				.filter(plan -> plan.getFeaturesAsList().containsAll(shortListedFeatures)).findFirst();
		List<Plan> returnValue = new ArrayList<Plan>();
		if (resultPlan.isPresent()) {
			returnValue.add(resultPlan.get());
			return convertToPlanResponse(returnValue);
		} else {
			
			//If there is no single plan found, find a combination of plans 
			returnValue = findMatchingPlan(shortListedFeatures, planList);
			return returnValue != null && returnValue.size() > 0 ? convertToPlanResponse(returnValue) : null;
		}
	}
	
	/*
	 * This method find the plan for given features.
	 * 
	 */

	public List<Plan> findMatchingPlan(List<String> source, List<Plan> planList) {

		List<Plan> returnValue = new ArrayList<Plan>();
		for (Plan plan : planList) {

			if (source.removeAll(plan.getFeaturesAsList())) {
				returnValue.add(plan);
				if (source.size() > 0)
					continue;
				else
					break;
			}
		}

		return source.isEmpty() ? returnValue : null;
	}
	
	
	/*
	 * Converts the identified plan(s) to UI Specific format.
	 * 
	 */
	public PlanResponse convertToPlanResponse(List<Plan> plan) {
		PlanResponse returnValue = null;
		double cost = 0;
		List<String> planNameList = new ArrayList<String>();
		if (plan != null && plan.size() > 0) {
			for (Plan currValue : plan) {
				cost += currValue.getCost();
				planNameList.add(currValue.getName());
			}
			returnValue = new PlanResponse(cost, planNameList.toArray(new String[planNameList.size()]));
		}

		return returnValue;
	}
}
