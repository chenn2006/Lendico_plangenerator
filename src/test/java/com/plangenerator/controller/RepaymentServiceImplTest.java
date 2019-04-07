package com.plangenerator.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.plangenerator.domain.Repayment;
import com.plangenerator.domain.Request;
import com.plangenerator.service.RepaymentServiceImpl;

public class RepaymentServiceImplTest {
	@Autowired
	private RepaymentServiceImpl service;
	
	@Before
	public void setUp() throws Exception {

		/* Dummy values for mocking. */
		
		Double nominalRate = 5.0;
		
		Double initialOutstandingPrincipal = new Double(5000);
		Double interest = new Double(20.83);
		Double annuity = new Double(219.36);
		Double principal = new Double(198.53);
		
		RepaymentServiceImpl repaymentMock = mock(RepaymentServiceImpl.class);
		when(repaymentMock.calculateInterest(nominalRate,
				initialOutstandingPrincipal))
						.thenReturn(new Double(20.83));
		when(repaymentMock.calculatePrincipal(interest, annuity))
				.thenReturn(new Double(198.53));
		when(repaymentMock.calculateRemainingOutstandingPrincipal(
				initialOutstandingPrincipal, principal))
						.thenReturn(new Double(4801.47));
		when(repaymentMock.calculateInterest(nominalRate,
				initialOutstandingPrincipal));
		service = new RepaymentServiceImpl();
	}

	
	@Test
	public void shouldGeneratePlan() {
		Double loanAmount = new Double(5000.0);
		Double nominalRate = 5.0;
		int duration = 24;
		LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 0, 0, 1);
		
		List<Repayment> plan = service.generatePlan(loanAmount, nominalRate, 
				duration, startDate);
		Assert.assertNotNull(plan);
		Assert.assertEquals(duration, plan.size());
	}

	@Test
	public void shouldGenerateRepayment() {
		Double loanAmount = new Double(5000.0);
		Double nominalRate = 5.0;
		int duration = 24;
		LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 0, 0, 1);
		Double initialOutstandingPrincipal = new Double(5000);
		int monthsAfterStart = 0;
		
		
		Repayment repayment = service.generateRepayment(loanAmount, nominalRate,
				duration, startDate, initialOutstandingPrincipal,
				monthsAfterStart );
		Assert.assertNotNull(repayment);
	}
	@Test
	public void shouldCalculateRemainingOutstandingPrincipal() {
	Double initialOutstandingPrincipal = new Double(5000);
	Double Principal = new Double(4801);
	Double remaingOutStanding = service.calculateRemainingOutstandingPrincipal(initialOutstandingPrincipal,Principal );
	Assert.assertEquals(199, remaingOutStanding.doubleValue(), 0);
	}


	@Test
	public void shouldCalculateInterest() { 
		double nominalRate = 5.0;
		Double initialOutstandingPrincipal = new Double(5000);

		Double interest = service.calculateInterest(nominalRate,
				initialOutstandingPrincipal);
		Assert.assertEquals(20.83, interest.doubleValue(), 0);
	}

}
