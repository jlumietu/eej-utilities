/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.List;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public abstract class AbstractDataBaseResultCollection implements
		DataBaseResultCollection {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private List<? extends Serializable> lista;
	private int totalRows;
	private int pageNumber;

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#getLista()
	 */
	public List<? extends Serializable> getLista() {
		return this.lista;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#setLista(java.util.List)
	 */
	public void setLista(List<? extends Serializable> lista) {
		this.lista = lista;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#getTotalRows()
	 */
	public int getTotalRows() {
		return this.totalRows;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#setTotalRows(int)
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows; 
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#getPageNumber()
	 */
	public int getPageNumber() {
		return this.pageNumber;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataBaseResultCollection#setPageNumber(int)
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
