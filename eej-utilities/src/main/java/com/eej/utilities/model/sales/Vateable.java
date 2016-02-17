package com.eej.utilities.model.sales;

public interface Vateable {

	/**
	 * @return the total
	 */
	public abstract double getTotal();

	/**
	 * @param total the total to set
	 */
	public abstract void setTotal(double total);

	/**
	 * @return the vat
	 */
	public abstract double getVat();

	/**
	 * @param vat the vat to set
	 */
	public abstract void setVat(double vat);

	/**
	 * @return the totalWithVat
	 */
	public abstract double getTotalWithVat();

	/**
	 * @param totalWithVat the totalWithVat to set
	 */
	public abstract void setTotalWithVat(double totalWithVat);

}