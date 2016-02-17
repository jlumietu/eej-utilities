/**
 * 
 */
package com.eej.utilities.model.factory;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eej.utilities.model.DataTableTagModelConfiguration;

/**
 * @author jlumietu
 *
 */
public class DataTableTagModelConfigurationFactoryImpl implements DataTableTagModelConfigurationFactory {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private Map<String, DataTableTagModelConfiguration> tagModelConfigurations;
	
	private DataTableTagModelConfiguration defaultTagModelConfiguration;
	
	/**
	 * 
	 */
	public DataTableTagModelConfigurationFactoryImpl() {
		super();
		this.tagModelConfigurations = new HashMap<String, DataTableTagModelConfiguration>();
	}	

	/**
	 * @param defaultTagModelConfiguration
	 */
	public DataTableTagModelConfigurationFactoryImpl(
			DataTableTagModelConfiguration defaultTagModelConfiguration) {
		super();
		this.defaultTagModelConfiguration = defaultTagModelConfiguration;
	}
	
	/**
	 * @param tagModelConfigurations
	 * @param defaultTagModelConfiguration
	 */
	public DataTableTagModelConfigurationFactoryImpl(
			Map<String, DataTableTagModelConfiguration> tagModelConfigurations,
			DataTableTagModelConfiguration defaultTagModelConfiguration) {
		super();
		this.tagModelConfigurations = tagModelConfigurations;
		this.defaultTagModelConfiguration = defaultTagModelConfiguration;
	}

	/**
	 * @return the tagModelConfigurations
	 */
	public Map<String, DataTableTagModelConfiguration> getTagModelConfigurations() {
		return tagModelConfigurations;
	}

	/**
	 * @param tagModelConfigurations the tagModelConfigurations to set
	 */
	public void setTagModelConfigurations(
			Map<String, DataTableTagModelConfiguration> tagModelConfigurations) {
		this.tagModelConfigurations = tagModelConfigurations;
	}

	/**
	 * @return the defaultTagModelConfiguration
	 */
	public DataTableTagModelConfiguration getDefaultTagModelConfiguration() {
		return defaultTagModelConfiguration;
	}

	/**
	 * @param defaultTagModelConfiguration the defaultTagModelConfiguration to set
	 */
	public void setDefaultTagModelConfiguration(
			DataTableTagModelConfiguration defaultTagModelConfiguration) {
		this.defaultTagModelConfiguration = defaultTagModelConfiguration;
	}
	
	/* (non-Javadoc)
	 * @see com.ib.utilities.model.factory.DataTableTagModelConfigurationFactory#getDataTableTagModelConfiguration(java.lang.String)
	 */
	@Override
	public DataTableTagModelConfiguration getDataTableTagModelConfiguration(String keyEntry){
		logger.debug("DataTableTagModelConfigurationFactoryImpl.tagModelConfigurations : " + this.tagModelConfigurations);
		logger.debug("keyEntry : " + keyEntry);
		if(this.tagModelConfigurations != null && this.tagModelConfigurations.size() > 0){
			DataTableTagModelConfiguration tagModel = this.tagModelConfigurations.get(keyEntry);
			if(tagModel != null){
				return tagModel;
			}
		}
		return this.defaultTagModelConfiguration;
	}
	
	/**
	 * 
	 * @return
	 */
	public DataTableTagModelConfiguration getDataTableTagModelBaseConfiguration(){
		DataTableTagModelConfiguration tagModel = new DataTableTagModelConfiguration(this.defaultTagModelConfiguration);
		return tagModel;
	}

	@Override
	public void addDataTableTagModelConfiguration(String entityKey,
			DataTableTagModelConfiguration tagModelConfiguration) {
		this.tagModelConfigurations.put(entityKey, tagModelConfiguration);
		
	}

}
