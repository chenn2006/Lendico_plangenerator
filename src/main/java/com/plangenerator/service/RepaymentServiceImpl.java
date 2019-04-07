package com.plangenerator.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.plangenerator.domain.Repayment;
@Service
public class RepaymentServiceImpl implements PepaymentService{
	
	public   List<Repayment> generatePlan(Double loanAmount,
			double nominalRate,
			int duration,
			LocalDateTime startDate) {

		List<Repayment> repayments = new ArrayList<>();
		Double initialOutstandingPrincipal = loanAmount;

		/* Fulfill the repayment plan with monthly calculations. */
		for (int i = 0; i < duration; i++) {
			Repayment repayment = generateRepayment(loanAmount, nominalRate,
					duration, startDate, initialOutstandingPrincipal, i);

			/* Rerolls the initial outstanding principal for the next month. */
			Double remainingOutstandingPrincipal = repayment
					.getRemainingOutstandingPrincipal();
			initialOutstandingPrincipal = remainingOutstandingPrincipal;

			repayments.add(repayment);
		}

		
		return repayments;
	}
	public  Repayment generateRepayment(Double loanAmount,
			double nominalRate,
			int duration,
			LocalDateTime startDate,
			Double initialOutstandingPrincipal,
			int monthsAfterStart) {

		Repayment repayment = new Repayment();

		/* Date. */
		LocalDateTime date = startDate.plusMonths(monthsAfterStart);
		repayment.setDate(date);

		/* Interest. */
		Double interest = calculateInterest(nominalRate,
				initialOutstandingPrincipal);
		repayment.setInterest(interest);

		/* Annuity. */
		Double annuity = calculate(loanAmount,
				nominalRate, duration);
		repayment.setBorrowerPaymentAmount(annuity);

		/* Principal. */
		Double principal = calculatePrincipal(interest,
				annuity);
		repayment.setPrincipal(principal);

		/* Initial outstanding principal. */
		repayment.setInitialOutstandingPrincipal(initialOutstandingPrincipal);

		/* Remaining outstanding principal. */
		Double remainingOutstandingPrincipal = calculateRemainingOutstandingPrincipal(
						initialOutstandingPrincipal, principal);
		repayment.setRemainingOutstandingPrincipal(
				remainingOutstandingPrincipal);

		return repayment;
	}
	public  Double calculate(Double loanAmount, double nominalRate,
			int duration) {

		/* Normalise the rate as a percentage. */
		nominalRate = nominalRate / 100.0;

		/* Divide the nominal rate by the number of months in a year. */
		double nominalRateByMonth = nominalRate / 12.0;

		/* Calculates the annuity based on the formula. */
		double annuity = (loanAmount.doubleValue() * nominalRateByMonth) /
				(1 - Math.pow(1 + nominalRateByMonth, -duration));

		/* Encapsulate and round the result. */
		Double result = new Double(annuity);
		result =Double.parseDouble(String.format("%.2f", result));
		return result;
	}
	public Double calculateRemainingOutstandingPrincipal(
			Double initialOutstandingPrincipal, Double principal) {

		/* Calculates the remaining outstanding principal. */
		Double remainingOutstandingPrincipal;
		remainingOutstandingPrincipal = initialOutstandingPrincipal- principal;

		/* the value cannot be negative, it is set to zero instead. */
		if (remainingOutstandingPrincipal.compareTo(Double.MIN_VALUE) < 0) {

			remainingOutstandingPrincipal =Double.parseDouble(String.format("%.2f", remainingOutstandingPrincipal));
		}

		return remainingOutstandingPrincipal;
	}

	
	public   Double calculatePrincipal(Double interest,
			Double annuity) {

		Double principal = annuity-interest;

		principal =Double.parseDouble(String.format("%.2f", principal));
		return principal;
	}

	
	public  Double calculateInterest(double nominalRate,
			Double initialOutstandingPrincipal) {

		/* Calculates the interest. */
		Double interest = new Double(
				nominalRate * 30 * initialOutstandingPrincipal.doubleValue()
						/ 360);

		/* Divides by 100 and rounds it 2 decimal points. */

		interest = interest/100;
		interest = Double.parseDouble(String.format("%.2f", interest));
		return interest;
	}

}
