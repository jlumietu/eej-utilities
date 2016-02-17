/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.Map;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class DataTablePaginationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private int numero = 15;
	
	private int pagina = 1;
	
	private String colOrd;
	
	private String dirOrd;
	
	private String searchGeneral;
	
	private Map<String, String> colsFilter;

	

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the pagina
	 */
	public int getPagina() {
		return pagina;
	}

	/**
	 * @param pagina the pagina to set
	 */
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return the colOrd
	 */
	public String getColOrd() {
		return colOrd;
	}

	/**
	 * @param colOrd the colOrd to set
	 */
	public void setColOrd(String colOrd) {
		this.colOrd = colOrd;
	}

	/**
	 * @return the dirOrd
	 */
	public String getDirOrd() {
		return dirOrd;
	}

	/**
	 * @param dirOrd the dirOrd to set
	 */
	public void setDirOrd(String dirOrd) {
		this.dirOrd = dirOrd;
	}

	/**
	 * @return the searchGeneral
	 */
	public String getSearchGeneral() {
		return searchGeneral;
	}

	/**
	 * @param searchGeneral the searchGeneral to set
	 */
	public void setSearchGeneral(String searchGeneral) {
		this.searchGeneral = searchGeneral;
	}

	/**
	 * @return the colsFilter
	 */
	public Map<String, String> getColsFilter() {
		return colsFilter;
	}

	/**
	 * @param colsFilter the colsFilter to set
	 */
	public void setColsFilter(Map<String, String> colsFilter) {
		this.colsFilter = colsFilter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(super.toString());
		sb.append(":").append(this.searchGeneral).append(";");
		return sb.toString();
	}
	
	

	
}
