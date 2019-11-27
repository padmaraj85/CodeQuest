package com.code.quest.ui.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.quest.service.FindBestPlanService;
import com.code.quest.service.NodePopulateService;
import com.code.quest.ui.model.Node;
import com.code.quest.ui.model.request.PlanPriceRequestModel;
import com.code.quest.ui.model.response.PlanResponse;

@RestController
@RequestMapping("challenge")

public class CodeChallengeController {

	@Autowired
	FindBestPlanService planService;

	@Autowired
	NodePopulateService nodeService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = "question1", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> getQuestion1() {
		return new ResponseEntity<String>(
				"Let’s say a cloud service offers different plans. For example, Microsoft Office 365 has different plans called E1, F1, etc. Each plan has different features such as voice, email, archiving, etc. Now let's say the user selects a set of features he/she wants.The goal is to write code in Java that finds the combination of plans that offers all selected features at the lowest price. Note that in some cases, it will be just one plan, but in other cases you will need 2 or more plans to get all the features you want.",
				HttpStatus.OK);

	}

	@GetMapping(path = "question2", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> getQuestion2() {
		return ResponseEntity.ok().body(
				"Each Node represents an element of a tree and specifies a list of immediate children. The 'Children' property lists all children (in order) but the 'Right' property is set to null. Suppose you are given the root of a fully populated tree (i.e. a Node instance called rootNode). Write code in Java to set the 'Right' property so that each node is linked to right siblings without using a queue or stack (do not use recursive calls). Make sure to test your code with the sample tree below.");
	}

	@PostMapping(path = "question1/solution", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PlanResponse> getSolution1(@Valid @RequestBody PlanPriceRequestModel model) {

		logger.debug(" Solution 1 triggered :" + model);
		PlanResponse result = planService.getBestPlan(model);
		if (result == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(result);
	}

	@PostMapping(path = "question2/solution", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List getSolution2(@Valid @RequestBody Node root) {
		return nodeService.breadthFirstTraversal(root);
	}

}
