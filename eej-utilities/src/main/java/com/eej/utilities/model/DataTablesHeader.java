/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu
 *
 */
public class DataTablesHeader implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private String columnName;
	
	private boolean searchable;
	
	private boolean columnSearch;
	
	private boolean sortable;
	
	private boolean defaultSort;
	
	private String width;
	
	private String dataType;
	
	private boolean displayColumn;
	
	private String defaultClass;
	
	private String defaultSearch;
	
	private String defaultContent;

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the searchable
	 */
	public boolean isSearchable() {
		return searchable;
	}

	/**
	 * @param searchable the searchable to set
	 */
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * @return the columnSearch
	 */
	public boolean isColumnSearch() {
		return columnSearch;
	}

	/**
	 * @param columnSearch the columnSearch to set
	 */
	public void setColumnSearch(boolean columnSearch) {
		this.columnSearch = columnSearch;
	}

	/**
	 * @return the sortable
	 */
	public boolean isSortable() {
		return sortable;
	}

	/**
	 * @param sortable the sortable to set
	 */
	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	/**
	 * @return the defaultSort
	 */
	public boolean isDefaultSort() {
		return defaultSort;
	}

	/**
	 * @param defaultSort the defaultSort to set
	 */
	public void setDefaultSort(boolean defaultSort) {
		this.defaultSort = defaultSort;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the displayColumn
	 */
	public boolean isDisplayColumn() {
		return displayColumn;
	}

	/**
	 * @param displayColumn the displayColumn to set
	 */
	public void setDisplayColumn(boolean displayColumn) {
		this.displayColumn = displayColumn;
	}

	/**
	 * @return the defaultClass
	 */
	public String getDefaultClass() {
		return defaultClass;
	}

	/**
	 * @param defaultClass the defaultClass to set
	 */
	public void setDefaultClass(String defaultClass) {
		this.defaultClass = defaultClass;
	}

	/**
	 * @return the defaultSearch
	 */
	public String getDefaultSearch() {
		return defaultSearch;
	}

	/**
	 * @param defaultSearch the defaultSearch to set
	 */
	public void setDefaultSearch(String defaultSearch) {
		this.defaultSearch = defaultSearch;
	}

	/**
	 * @return the defaultContent
	 */
	public String getDefaultContent() {
		return defaultContent;
	}

	/**
	 * @param defaultContent the defaultContent to set
	 */
	public void setDefaultContent(String defaultContent) {
		this.defaultContent = defaultContent;
	}
	
	

}

