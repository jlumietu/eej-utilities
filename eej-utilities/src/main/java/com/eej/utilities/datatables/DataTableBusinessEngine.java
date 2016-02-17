/**
 * 
 */
package com.eej.utilities.datatables;

import com.eej.utilities.model.DataBaseResultCollection;
import com.eej.utilities.model.DataTablePaginationRequest;

/**
 * @author jlumietu
 *
 */
public interface DataTableBusinessEngine {

	DataBaseResultCollection getEntityListViewItemCollection(DataTablePaginationRequest dataTablePaginationRequest, String entityKey);
	
}
