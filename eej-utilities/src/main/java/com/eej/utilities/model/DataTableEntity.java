package com.eej.utilities.model;

import java.io.Serializable;

public interface DataTableEntity extends Serializable{

	/**
	 * @return the entity
	 */
	public abstract String getEntity();

	/**
	 * @param entity the entity to set
	 */
	public abstract void setEntity(String entity);

	/**
	 * @return the clazz
	 */
	public abstract Class<?> getClazz();

	/**
	 * @param clazz the clazz to set
	 */
	public abstract void setClazz(Class<?> clazz);

	/**
	 * @return the category
	 */
	public abstract String getCategory();

	/**
	 * @param category the category to set
	 */
	public abstract void setCategory(String category);

	/**
	 * @return the view
	 */
	public abstract String getView();

	/**
	 * @param view the view to set
	 */
	public abstract void setView(String view);

}