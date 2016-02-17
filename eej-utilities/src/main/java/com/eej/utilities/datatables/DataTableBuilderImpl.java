/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.eej.utilities.annotation.DataTable;
import com.eej.utilities.annotation.DataTableColumn;
import com.eej.utilities.annotation.DataTableColumnLink;
import com.eej.utilities.annotation.DataTableLinkParam;
import com.eej.utilities.annotation.DataTableRowLink;
import com.eej.utilities.exception.EmptyDataBaseResultCollectionException;
import com.eej.utilities.exception.NoDataTableAnnotationException;
import com.eej.utilities.model.DataBaseResultCollection;
import com.eej.utilities.model.DataTableElement;
import com.eej.utilities.model.DataTableHeader;
import com.eej.utilities.model.DataTableObject;
import com.eej.utilities.model.DataTableResult;

/**
 * @author jlumietu
 *
 */
public class DataTableBuilderImpl implements DataTableBuilder {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private String appRootContext;

	/* (non-Javadoc)
	 * @see com.ib.utilities.datatables.DataTableBuilder#getDataTable(com.ib.utilities.model.DataBaseResultCollection)
	 */
	public DataTableObject getDataTable(DataBaseResultCollection collection, Class<?> clazz) 
			throws EmptyDataBaseResultCollectionException, NoDataTableAnnotationException{
		
		String nombre = "";
		String nombreDeLista = "";
		
		/*if(collection == null || collection.getLista() == null || collection.getLista().size() == 0){
			throw new EmptyDataBaseResultCollectionException();
		}*/
		
		if(!clazz.isAnnotationPresent(DataTable.class)){
			throw new NoDataTableAnnotationException("Class " + clazz.getName() + " not annotated with "  + DataTable.class.getName());
		}		
		
		DataTable annotation = (DataTable)clazz.getAnnotation(DataTable.class);
		logger.debug("DataTable annotation.nombreLista = " + annotation.nombreLista());
		logger.debug("DataTable annotation.tableName = " + annotation.tableName());
		nombre = annotation.tableName();
		nombreDeLista = annotation.nombreLista();
		
		DataTableObject table = new DataTableObject(nombre, nombreDeLista, collection.getTotalRows());
		
		String rowLink = null;
		boolean attachTimestamp = false;
		if(clazz.isAnnotationPresent(DataTableRowLink.class)){
			DataTableRowLink rowLinkAnnotation = clazz.getAnnotation(DataTableRowLink.class);
			rowLink = rowLinkAnnotation.mappingEndPoint();
			attachTimestamp = rowLinkAnnotation.includeTimestamp();
		}
		List<Field> fields = new ArrayList<Field>();
		Map<String, Field> linkParams = new HashMap<String, Field>();
		
		for(Field field : clazz.getDeclaredFields()){
			if(rowLink!=null && field.isAnnotationPresent(DataTableLinkParam.class)){
				DataTableLinkParam linkParam = field.getAnnotation(DataTableLinkParam.class);
				linkParams.put(linkParam.paramName(), field);
			}
			if(field.isAnnotationPresent(DataTableColumn.class)){
				DataTableColumn tableColumn = field.getAnnotation(DataTableColumn.class);
				DataTableHeader tableHeader = new DataTableHeader();
				tableHeader.setColumnName(tableColumn.columnName());
				tableHeader.setColumnSearch(tableColumn.columnSearch());
				tableHeader.setDataType(tableColumn.dataType().getValue());
				tableHeader.setDefaultClass(tableColumn.defaultClass());
				tableHeader.setDefaultContent(tableColumn.defaultContent());
				tableHeader.setDefaultSort(tableColumn.defaultSort());
				tableHeader.setDisplayColumn(tableColumn.displayColumn());
				tableHeader.setSearchable(tableColumn.searchable());
				tableHeader.setSortable(tableColumn.sortable());
				tableHeader.setWidth(tableColumn.width());
				// Para evitar que casque al introducir cabeceras si los campos
				// a mostrar están desordenados
				while(table.getTableHeaders().size() < tableColumn.colIndex()){
					table.getTableHeaders().add(null);
				}
				table.getTableHeaders().add(tableColumn.colIndex(), tableHeader);
				fields.add(field);
			}			
		}
		
		if(collection == null || collection.getLista() == null || collection.getLista().size() == 0){
			table.setTotalDisplayRecords(0);
			return table;
		}
		
		for(Serializable s : collection.getLista()){
			DataTableResult result = new DataTableResult();
			List<DataTableElement> resultado = new ArrayList<DataTableElement>();
			String linkRef = "";
			if(rowLink!=null){
				linkRef = this.appRootContext==null?rowLink:appRootContext.concat(rowLink);
				if(linkParams != null || attachTimestamp){
					linkRef = linkRef.concat("?");
				}
				if(linkParams != null && linkParams.size() > 0 ){
					boolean first = true;
					for(String pName: linkParams.keySet()){
						if(!first){
							linkRef = linkRef.concat("&");
						}
						first = false;
						String linkParamValue = "";
						try{
							Field fLink = linkParams.get(pName);
							fLink.setAccessible(true);
							linkParamValue = fLink.get(s).toString();
						}catch(Exception e){
							logger.error("Error accessing url param value " + e.getMessage(), e);
						}
						linkRef = linkRef.concat(pName).concat("=").concat(linkParamValue);
					}
				}
				if(attachTimestamp){
					if(linkRef.endsWith("?")){
						linkRef = linkRef.concat("ts=").concat(String.valueOf(System.currentTimeMillis()));
					}else{
						if(!linkRef.endsWith("&")){
							linkRef = linkRef.concat("&");
						}
						linkRef = linkRef.concat("ts=").concat(String.valueOf(System.currentTimeMillis()));
					}
				}
			}
			for(Field f : fields){
				if(f.isAnnotationPresent(DataTableColumn.class)){
					f.setAccessible(true);
					String columnLink = null;
					if(f.isAnnotationPresent(DataTableColumnLink.class)){
						try{
							DataTableColumnLink cl = f.getAnnotation(DataTableColumnLink.class);
							columnLink = this.appRootContext==null?cl.mappingEndPoint():appRootContext.concat(cl.mappingEndPoint());
							columnLink = columnLink.endsWith("?")?columnLink: columnLink.concat("?");
							Field columnLinkValue = clazz.getDeclaredField(cl.paramProperty());
							columnLinkValue.setAccessible(true);
							columnLink = columnLink.concat(cl.paramName()).concat("=").concat((String.valueOf(columnLinkValue.get(s))));
							if(cl.includeTimestamp()){
								columnLink = columnLink.endsWith("?")?columnLink:columnLink.concat("&");
								columnLink = columnLink.concat("ts=" + System.currentTimeMillis());
							}
						}catch(Throwable t){
							logger.warn("Error building column link: " + t.getMessage(), t);
						}
					}else{
						columnLink = linkRef;
					}
					DataTableElement element = new DataTableElement();
					DataTableColumn tableColumn = f.getAnnotation(DataTableColumn.class);
					try{
						Object o = f.get(s);
						element.setCellColor(tableColumn.cellColor());
						element.setColIndex(String.valueOf(tableColumn.colIndex()));
						element.setFontColor(tableColumn.fontColor());
						if(f.getType().equals(Date.class)){
							DateFormat format = new SimpleDateFormat(tableColumn.dateConversionPattern());
							o = format.format((Date)o);
						}
						if(!tableColumn.imgSrc().equals("")){
							element.setImgSrc(true);
							element.setLinkText(tableColumn.imgSrc());
							element.setText(tableColumn.imgSrc());
						}else{
							element.setImgSrc(false);
							element.setLinkText(o.toString());
							element.setText(o.toString());
						}
						element.setLinkTitle(o.toString());
						element.setLinkRef(columnLink);
						if(!columnLink.equals("") && !element.getImgSrc()){
							element.setText("_column" + tableColumn.colIndex());
						}
					}catch(Exception e){
						logger.error("Error " + e.getMessage(), e);
					}
					resultado.add(tableColumn.colIndex(), element);
					
					
				}
			}
			Map<String, DataTableElement> map = new TreeMap<String, DataTableElement>();
			for(DataTableElement ele : resultado){
				map.put("column" + ele.getColIndex(), ele);
			}
			//result.setResultado(resultado); 
			result.setResultados(map);
			table.getResultados().add(result);
			
		}
		table.setTotalDisplayRecords(collection.getTotalRows());
		return table;
	}

	/**
	 * @return the appRootContext
	 */
	public String getAppRootContext() {
		return appRootContext;
	}

	/**
	 * @param appRootContext the appRootContext to set
	 */
	public void setAppRootContext(String appRootContext) {
		this.appRootContext = appRootContext;
	}
	
	

}
