/**
 * 
 */
package com.eej.utilities.datatables;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eej.utilities.annotation.DataTable;
import com.eej.utilities.exception.NoDataTableAnnotationException;
import com.eej.utilities.exception.UnregisteredDataTableClassException;
import com.eej.utilities.model.DataTableTagModel;
import com.eej.utilities.model.DataTableTagModelConfiguration;
import com.eej.utilities.model.factory.DataTableTagModelConfigurationFactory;
import com.eej.utilities.annotation.DataTableLinkParam;
import com.eej.utilities.annotation.DataTableRowLink;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class DataTableCollectionContainerImpl implements DataTableCollectionContainer {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private List<String> packagesToScan = null;
	// TODO
	
	private Map<String, String> dataTableInstances = null;
	
	private DataTableTagModelConfigurationFactory tagModelConfigurationFactory;
	
	private boolean strictCategoryMode = false;

	/**
	 * @param packagesToScan
	 */
	protected DataTableCollectionContainerImpl(List<String> packagesToScan) {
		super();
		this.packagesToScan = packagesToScan;
	}
	
	public DataTableCollectionContainerImpl(){
		super();
	}
	
	/**
	 * @param strictCategoryMode
	 */
	public DataTableCollectionContainerImpl(boolean strictCategoryMode) {
		super();
		this.strictCategoryMode = strictCategoryMode;
	}

	/**
	 * @param dataTables
	 */
	public DataTableCollectionContainerImpl(Map<String, String> dataTableInstances) {
		super();
		this.dataTableInstances = dataTableInstances;
	}
	
	/*private final void loadResources(){
	if(dataTableInstances == null || dataTableInstances.size() > 0){
		if(this.packagesToScan != null && packagesToScan.size() > 0){
			Package thePackage = System.
		}			
	}
	}*/
	
	/**
	 * 
	 */
	public boolean contains(String keyForClass){
		logger.debug("this.dataTableInstances = " + this.dataTableInstances);
		return this.dataTableInstances.containsKey(keyForClass);
	}
	
	/**
	 * 
	 */
	public DataTableTagModel getModel(String keyForClass, String category) throws NoDataTableAnnotationException{
		Class<? extends Serializable> clazz = this.getClass(keyForClass);
		DataTable annotation = clazz.getAnnotation(DataTable.class); 
		logger.debug("keyForClass = " + keyForClass + ", category = " + category);
		DataTableTagModelConfiguration tagModelConfiguration = this.getModelConfiguration(keyForClass, category);
		DataTableTagModel tagModel = null;
		if(tagModelConfiguration != null){
			tagModel = new DataTableTagModel(tagModelConfiguration);
		}else{
			return null;
		}
		logger.debug("this.tagModelConfiguration.getSourceData()= " + tagModelConfiguration.getSourceData());
		logger.debug("tagModel.getSourceData()= " + tagModel.getSourceData());
		tagModel.setSourceData(tagModel.getSourceData().replace(tagModelConfiguration.getEntityReplaceSectionPattern(), keyForClass));
		tagModel.setTableName(annotation.tableName());
		if(!annotation.pageName().equals("")){
			tagModel.setPageName(annotation.pageName());
		}else if(tagModel.getPageName() != null && tagModel.getPageName().length() > 0){
			tagModel.setPageName("lbl_" + (keyForClass.length() > 0?keyForClass.substring(0, 1).toUpperCase() + keyForClass.substring(1):""));
		}
		if(clazz.isAnnotationPresent(DataTableRowLink.class)){
			DataTableRowLink linkAnnotation = clazz.getAnnotation(DataTableRowLink.class);
			if(linkAnnotation!= null){
				tagModel.setAllowNewRowCreation(linkAnnotation.allowNewRowCreation());
				// NO, en ese caso ver si tiene @DataTableRowLink!!!
				if(linkAnnotation.allowNewRowCreation() && linkAnnotation.mappingEndPoint() != null){
					StringBuilder link = new StringBuilder("");
					for(Field f : clazz.getDeclaredFields()){
						if (f.isAnnotationPresent(DataTableLinkParam.class)){
							DataTableLinkParam linkParamAnnotation = f.getAnnotation(DataTableLinkParam.class);
							if(linkParamAnnotation != null){
								// Modification, multiple DataTableLinkParam support in new row creation
								if(link.length() > 0){
									link.append("&");
								}
								link.append(linkParamAnnotation.paramName());
								if(f.getType().isPrimitive()){
									link.append("=-1");
								}else{
									link.append("=null");
								}
							}
						}
					}
					if(link != null && !link.equals("")){
						if(linkAnnotation.includeTimestamp()){
							if(link.length() > 0){
								link.append("&");
							}
							link.append("ts=").append(String.valueOf(System.currentTimeMillis()));
						}
						tagModel.setNewRowCreationUrlEndpoint(linkAnnotation.mappingEndPoint().concat("?").concat(link.toString()));
					}
				}
			}
		}
		logger.debug("tagModel.getPageName " + tagModel.getPageName());
		logger.debug("tagModel.getResultListName " + tagModel.getResultListName());
		logger.debug("tagModel.getSourceData " + tagModel.getSourceData());
		logger.debug("tagModel.getTableName " + tagModel.getTableName());
		logger.debug("tagModel.isServerSide " + tagModel.isServerSide());
		return tagModel;
	}
	
	@Override
	public DataTableTagModelConfiguration getModelConfiguration(
			String keyForClass, String category) throws NoDataTableAnnotationException {
		Class<? extends Serializable> clazz = this.getClass(keyForClass);
		DataTable annotation = clazz.getAnnotation(DataTable.class);
		String tagModelConfigKey = null;
		if(this.strictCategoryMode){
			if((category == null || category.equals("")) && annotation.tagModelConfigName().equals("")){
				tagModelConfigKey = keyForClass;
			}else if(category.equals(keyForClass)){
				tagModelConfigKey = keyForClass;
			}else if(category.equals(annotation.tagModelConfigName())){
				tagModelConfigKey = category;
			}else{
				return null;
			}
		}else{
			tagModelConfigKey = keyForClass;
			if(!annotation.tagModelConfigName().equals("")){
				tagModelConfigKey = annotation.tagModelConfigName(); 
			}
		}
		DataTableTagModelConfiguration tagModelConfiguration = this.tagModelConfigurationFactory.getDataTableTagModelConfiguration(tagModelConfigKey);
		return tagModelConfiguration;
	}
	
	/**
	 * 
	 * @param keyForClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Class<? extends Serializable> getClass(String keyForClass) throws NoDataTableAnnotationException{
		logger.debug("getClass(String keyForClass) = " + keyForClass);
		if(!this.contains(keyForClass)){
			throw new UnregisteredDataTableClassException(keyForClass + " is unregistered");
		}
		String className = this.dataTableInstances.get(keyForClass);
		logger.debug("className = " + className);
		Class<?> clazz = null;
		try{
			clazz = Class.forName(className);			
		}catch(Exception e){
			throw new UnregisteredDataTableClassException(e.getMessage(), e);
		}
		if(!clazz.isAnnotationPresent(DataTable.class)){
			throw new NoDataTableAnnotationException(clazz.getName());
		}
		return (Class<? extends Serializable>)clazz;
	}

	/**
	 * @return the dataTableInstances
	 */
	public Map<String, String> getDataTableInstances() {
		return dataTableInstances;
	}

	/**
	 * @param dataTableInstances the dataTableInstances to set
	 */
	public void setDataTableInstances(Map<String, String> dataTableInstances) {
		this.dataTableInstances = dataTableInstances;
	}

	/**
	 * @return the tagModelConfiguration
	 */
	public DataTableTagModelConfigurationFactory getTagModelConfiguration() {
		return tagModelConfigurationFactory;
	}

	/**
	 * @param tagModelConfiguration the tagModelConfiguration to set
	 */
	public void setTagModelConfigurationFactory(
			DataTableTagModelConfigurationFactory tagModelConfigurationFactory) {
		this.tagModelConfigurationFactory = tagModelConfigurationFactory;
	}

	/**
	 * @return the strictCategoryMode
	 */
	public boolean isStrictCategoryMode() {
		return strictCategoryMode;
	}

	/**
	 * @param strictCategoryMode the strictCategoryMode to set
	 */
	public void setStrictCategoryMode(boolean strictCategoryMode) {
		this.strictCategoryMode = strictCategoryMode;
	}

		
	
}
