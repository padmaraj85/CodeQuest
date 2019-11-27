package com.code.quest.service;

import com.code.quest.ui.model.request.PlanPriceRequestModel;
import com.code.quest.ui.model.response.PlanResponse;

public interface FindBestPlanService {

	public PlanResponse getBestPlan(PlanPriceRequestModel model);

}
