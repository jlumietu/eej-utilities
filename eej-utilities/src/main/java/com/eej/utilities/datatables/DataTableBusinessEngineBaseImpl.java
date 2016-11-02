/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.eej.utilities.model.DataBaseResultCollection;
import com.eej.utilities.model.DataTablePaginationRequest;
import com.eej.utilities.model.DefaultDataBaseResultCollection;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class DataTableBusinessEngineBaseImpl implements DataTableBusinessEngine {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private SourceData sourceData;
	
	private DataTableCollectionContainer container;

	/* (non-Javadoc)
	 * @see com.eej.utilities.datatables.DataTableBusinessEngine#getComponentListViewItemCollection(com.eej.utilities.model.DataTablePaginationRequest)
	 */
	public DataBaseResultCollection getEntityListViewItemCollection(
			DataTablePaginationRequest dataTablePaginationRequest, String entityKey) {
		DataBaseResultCollection collection = new DefaultDataBaseResultCollection();
		collection.setPageNumber(dataTablePaginationRequest.getPagina());
		try{
			Class<? extends Serializable> clazz = container.getClass(entityKey);
			collection.setTotalRows(this.sourceData.getListViewCount(dataTablePaginationRequest, clazz));
			collection.setLista(this.sourceData.getListView(dataTablePaginationRequest, clazz));
		}catch(Throwable t){
			logger.error("Error " + t.getMessage(), t);
			collection.setTotalRows(0);
		}
		return collection;
	}

	/**
	 * @return the sourceData
	 */
	public SourceData getSourceData() {
		return sourceData;
	}

	/**
	 * @param sourceData the sourceData to set
	 */
	public void setSourceData(SourceData sourceData) {
		this.sourceData = sourceData;
	}

	/**
	 * @return the container
	 */
	public DataTableCollectionContainer getContainer() {
		return container;
	}

	/**
	 * @param container the container to set
	 */
	public void setContainer(DataTableCollectionContainer container) {
		this.container = container;
	}
	
	

}
