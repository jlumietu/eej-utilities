package com.eej.utilities.model.factory;

import com.eej.utilities.model.DataTableTagModelConfiguration;

public interface DataTableTagModelConfigurationFactory {

	/**
	 * 
	 * @param keyEntry
	 * @return
	 */
	public abstract DataTableTagModelConfiguration getDataTableTagModelConfiguration(
			String keyEntry);
	
	/**
	 * 
	 * @return
	 */
	public abstract DataTableTagModelConfiguration getDataTableTagModelBaseConfiguration();
	
	/**
	 * 
	 * @param entityKey
	 * @param tagModelConfiguration
	 */
	public abstract void addDataTableTagModelConfiguration(String entityKey, DataTableTagModelConfiguration tagModelConfiguration);

}