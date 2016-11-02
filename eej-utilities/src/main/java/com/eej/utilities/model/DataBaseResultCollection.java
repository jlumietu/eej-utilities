/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public interface DataBaseResultCollection extends Serializable{

	List<? extends Serializable> getLista();
	
	void setLista(List<? extends Serializable> lista);
	
	int getTotalRows();
	
	void setTotalRows(int totalRows);
	
	int getPageNumber();
	
	void setPageNumber(int pageNumber);
	
}
