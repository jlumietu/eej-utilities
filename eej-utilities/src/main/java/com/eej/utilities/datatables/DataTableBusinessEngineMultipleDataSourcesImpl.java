/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eej.utilities.annotation.DataTable;
import com.eej.utilities.model.DataBaseResultCollection;
import com.eej.utilities.model.DataTablePaginationRequest;
import com.eej.utilities.model.DefaultDataBaseResultCollection;

/**
 * @author DOIBALMI
 *
 */
public class DataTableBusinessEngineMultipleDataSourcesImpl extends
		DataTableBusinessEngineBaseImpl implements DataTableBusinessEngine {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private Map<String, SourceData> sourceDataMap;

	/**
	 * @return the sourceDataMap
	 */
	public Map<String, SourceData> getSourceDataMap() {
		return sourceDataMap;
	}

	/**
	 * @param sourceDataMap the sourceDataMap to set
	 */
	public void setSourceDataMap(Map<String, SourceData> sourceDataMap) {
		this.sourceDataMap = sourceDataMap;
	}

	/* (non-Javadoc)
	 * @see com.ib.utilities.datatables.DataTableBusinessEngineBaseImpl#getEntityListViewItemCollection(com.ib.utilities.model.DataTablePaginationRequest, java.lang.String)
	 */
	@Override
	public DataBaseResultCollection getEntityListViewItemCollection(
			DataTablePaginationRequest dataTablePaginationRequest,
			String entityKey) {
		DataBaseResultCollection collection = new DefaultDataBaseResultCollection();
		collection.setPageNumber(dataTablePaginationRequest.getPagina());
		try{
			Class<? extends Serializable> clazz = this.getContainer().getClass(entityKey);
			SourceData sourceData = this.getSourceData();
			if(clazz.isAnnotationPresent(DataTable.class)){
				DataTable annotation = clazz.getAnnotation(DataTable.class);
				if(!annotation.dataSource().equals("")){
					if(this.sourceDataMap.containsKey(annotation.dataSource())){
						sourceData = this.sourceDataMap.get(annotation.dataSource());
					}
				}
			}
			collection.setTotalRows(sourceData.getListViewCount(dataTablePaginationRequest, clazz));
			collection.setLista(sourceData.getListView(dataTablePaginationRequest, clazz));
		}catch(Throwable t){
			logger.error("Error " + t.getMessage(), t);
			collection.setTotalRows(0);
		}
		return collection;
	}
	
	

}
