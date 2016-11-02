/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;
import java.util.List;

import com.eej.utilities.model.DataTablePaginationRequest;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public interface SourceData {

	List<? extends Serializable> getListView(
			DataTablePaginationRequest request, 
			Class<? extends Serializable> clazz);
	
	int getListViewCount(DataTablePaginationRequest request, 
			Class<? extends Serializable> clazz);
	
}
