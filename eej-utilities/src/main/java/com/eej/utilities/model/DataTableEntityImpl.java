/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author DOIBALMI
 *
 */
public class DataTableEntityImpl implements Serializable, DataTableEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;

	private String entity;
	
	private Class<?> clazz;
	
	private String category;
	
	private String view;

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#getEntity()
	 */
	@Override
	public String getEntity() {
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#setEntity(java.lang.String)
	 */
	@Override
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#getClazz()
	 */
	@Override
	public Class<?> getClazz() {
		return clazz;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#setClazz(java.lang.Class)
	 */
	@Override
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#getCategory()
	 */
	@Override
	public String getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#setCategory(java.lang.String)
	 */
	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#getView()
	 */
	@Override
	public String getView() {
		return view;
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableEntity#setView(java.lang.String)
	 */
	@Override
	public void setView(String view) {
		this.view = view;
	}
	
	
	
}
