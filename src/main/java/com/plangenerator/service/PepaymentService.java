package com.plangenerator.service;


import java.time.LocalDateTime;
import java.util.List;

import com.plangenerator.domain.Repayment;

public interface PepaymentService {
	
	public   List<Repayment> generatePlan(Double loanAmount,
			double nominalRate,
			int duration,
			LocalDateTime startDate);
	
	public   Repayment generateRepayment(Double loanAmount,
			double nominalRate,
			int duration,
			LocalDateTime startDate,
			Double initialOutstandingPrincipal,
			int monthsAfterStart);
	
	public Double calculate(Double loanAmount, double nominalRate,
			int duration);
	
	public Double calculateRemainingOutstandingPrincipal(
			Double initialOutstandingPrincipal, Double principal);
	
	public  Double calculatePrincipal(Double interest,
			Double annuity);
	
	public  Double calculateInterest(double nominalRate,
			Double initialOutstandingPrincipal);
}
