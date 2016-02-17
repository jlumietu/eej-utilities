/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;

import com.eej.utilities.exception.NoDataTableAnnotationException;
import com.eej.utilities.model.DataTableTagModel;
import com.eej.utilities.model.DataTableTagModelConfiguration;

/**
 * @author doibalmi
 *
 */
public interface DataTableCollectionContainer {

	boolean contains(String keyForClass);
	
	Class<? extends Serializable> getClass(String keyForClass) throws NoDataTableAnnotationException;
	
	DataTableTagModel getModel(String keyForClass, String category) throws NoDataTableAnnotationException;
	
	DataTableTagModelConfiguration getModelConfiguration(String keyForClass, String category) throws NoDataTableAnnotationException;
	
}
