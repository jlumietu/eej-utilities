/**
 * 
 */
package com.eej.utilities.datatables;

import com.eej.utilities.exception.EmptyDataBaseResultCollectionException;
import com.eej.utilities.exception.NoDataTableAnnotationException;
import com.eej.utilities.model.DataTableObject;
import com.eej.utilities.model.DataBaseResultCollection;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public interface DataTableBuilder {

	DataTableObject getDataTable(DataBaseResultCollection collection, Class<?> clazz) 
			throws EmptyDataBaseResultCollectionException, NoDataTableAnnotationException;
	
	
	
}
