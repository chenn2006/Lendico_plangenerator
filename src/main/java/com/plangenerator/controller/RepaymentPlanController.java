package com.plangenerator.controller;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plangenerator.domain.Repayment;
import com.plangenerator.domain.Request;
import com.plangenerator.service.RepaymentServiceImpl;

/**
 * A web controller for generating repayment plans.
 * 
 * @author chennuru
 *
 */
@RestController
@RequestMapping("/generate-plan")
public class RepaymentPlanController {
	@Autowired
	RepaymentServiceImpl repaymentServiceImpl = new RepaymentServiceImpl();
	@PostMapping
	public  List<Repayment> generatePlan(
			@RequestBody Request request) {
		
		/* Obtain the request parameters. */
		Double loanAmount = request.getLoanAmount();
		Double nominalRate = request.getNominalRate();
		Integer duration = request.getDuration();
		
		Date startDate = request.getStartDate();
		Instant instant = startDate.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localStartDate = LocalDateTime.ofInstant(instant, zone);
		
		/* Delegates the execution to the service. */
		List<Repayment> repayments=null;
		try {
		 repayments = repaymentServiceImpl.generatePlan(loanAmount, nominalRate,
				duration, localStartDate);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return repayments;
	}
}