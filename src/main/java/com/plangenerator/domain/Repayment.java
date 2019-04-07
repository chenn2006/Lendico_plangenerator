package com.plangenerator.domain;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Class that represents a repayment.
 * 
 * @author chennuru
 *
 */
public class Repayment {
	private Double borrowerPaymentAmount;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private LocalDateTime date;
	
	private Double initialOutstandingPrincipal;
	private Double interest;
	private Double principal;
	private Double remainingOutstandingPrincipal;

	/**
	 * Gets the Repayment's {@code borrowerPaymentAmount}.
	 *
	 * @return the {@code Repayment}'s {@code borrowerPaymentAmount}
	 */
	public Double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	/**
	 * Gets the Repayment's {@code date}.
	 *
	 * @return the {@code Repayment}'s {@code date}
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Gets the Repayment's {@code initialOutstandingPrincipal}.
	 *
	 * @return the {@code Repayment}'s {@code initialOutstandingPrincipal}
	 */
	public Double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	/**
	 * Gets the Repayment's {@code interest}.
	 *
	 * @return the {@code Repayment}'s {@code interest}
	 */
	public Double getInterest() {
		return interest;
	}

	/**
	 * Gets the Repayment's {@code principal}.
	 *
	 * @return the {@code Repayment}'s {@code principal}
	 */
	public Double getPrincipal() {
		return principal;
	}

	/**
	 * Gets the Repayment's {@code remainingOutstandingPrincipal}.
	 *
	 * @return the {@code Repayment}'s {@code remainingOutstandingPrincipal}
	 */
	public Double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	/**
	 * Sets the Repayment's {@code borrowerPaymentAmount}.
	 *
	 * @param borrowerPaymentAmount
	 *            the {@code Repayment}'s {@code borrowerPaymentAmount} to set
	 */
	public void setBorrowerPaymentAmount(Double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	/**
	 * Sets the Repayment's {@code date}.
	 *
	 * @param date
	 *            the {@code Repayment}'s {@code date} to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * Sets the Repayment's {@code initialOutstandingPrincipal}.
	 *
	 * @param initialOutstandingPrincipal
	 *            the {@code Repayment}'s {@code initialOutstandingPrincipal} to
	 *            set
	 */
	public void setInitialOutstandingPrincipal(
			Double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	/**
	 * Sets the Repayment's {@code interest}.
	 *
	 * @param interest
	 *            the {@code Repayment}'s {@code interest} to set
	 */
	public void setInterest(Double interest) {
		this.interest = interest;
	}

	/**
	 * Sets the Repayment's {@code principal}.
	 *
	 * @param principal
	 *            the {@code Repayment}'s {@code principal} to set
	 */
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	/**
	 * Sets the Repayment's {@code remainingOutstandingPrincipal}.
	 *
	 * @param remainingOutstandingPrincipal
	 *            the {@code Repayment}'s {@code remainingOutstandingPrincipal}
	 *            to set
	 */
	public void setRemainingOutstandingPrincipal(
			Double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n");
		builder.append("[borrowerPaymentAmount=");
		builder.append(borrowerPaymentAmount);
		builder.append(", date=");
		builder.append(date);
		builder.append(", initialOutstandingPrincipal=");
		builder.append(initialOutstandingPrincipal);
		builder.append(", interest=");
		builder.append(interest);
		builder.append(", principal=");
		builder.append(principal);
		builder.append(", remainingOutstandingPrincipal=");
		builder.append(remainingOutstandingPrincipal);
		builder.append("]");
		return builder.toString();
	}
}