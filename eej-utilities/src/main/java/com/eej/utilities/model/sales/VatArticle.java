/**
 * 
 */
package com.eej.utilities.model.sales;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class VatArticle implements Serializable, Vateable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private double total;
	
	private double vat;
	
	private double totalWithVat;

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#getTotal()
	 */
	@Override
	public double getTotal() {
		return total;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#setTotal(double)
	 */
	@Override
	public void setTotal(double total) {
		this.total = total;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#getVat()
	 */
	@Override
	public double getVat() {
		return vat;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#setVat(double)
	 */
	@Override
	public void setVat(double vat) {
		this.vat = vat;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#getTotalWithVat()
	 */
	@Override
	public double getTotalWithVat() {
		return totalWithVat;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.sales.Vateable#setTotalWithVat(double)
	 */
	@Override
	public void setTotalWithVat(double totalWithVat) {
		this.totalWithVat = totalWithVat;
	}
	
	
	
	

}
