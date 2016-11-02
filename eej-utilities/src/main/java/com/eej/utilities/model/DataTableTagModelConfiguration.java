/**
 * 
 */
package com.eej.utilities.model;

import com.eej.utilities.ApplicationVersion;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class DataTableTagModelConfiguration extends DataTableTagModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	public String listView;
	
	public String pageNotFoundUri;
	
	public String entityReplaceSectionPattern;

	/**
	 * 
	 */
	public DataTableTagModelConfiguration() {
		super();
	}

	/**
	 * @param tagModel
	 */
	public DataTableTagModelConfiguration(DataTableTagModelConfiguration tagModel) {
		this.setContentType(tagModel.getContentType());
		this.setEntityReplaceSectionPattern(tagModel.getEntityReplaceSectionPattern());
		this.setListView(tagModel.getListView());
		this.setPageName(tagModel.getPageName());
		this.setPageNotFoundUri(tagModel.getPageNotFoundUri());
		this.setResultListName(tagModel.getResultListName());
		this.setRowsPerPage(tagModel.getRowsPerPage());
		this.setServerSide(tagModel.isServerSide());
		this.setSourceData(tagModel.getSourceData());
		this.setTableName(tagModel.getTableName());
	}

	/**
	 * @return the listView
	 */
	public String getListView() {
		return listView;
	}

	/**
	 * @param listView the listView to set
	 */
	public void setListView(String listView) {
		this.listView = listView;
	}

	/**
	 * @return the pageNotFoundUri
	 */
	public String getPageNotFoundUri() {
		return pageNotFoundUri;
	}

	/**
	 * @param pageNotFoundUri the pageNotFoundUri to set
	 */
	public void setPageNotFoundUri(String pageNotFoundUri) {
		this.pageNotFoundUri = pageNotFoundUri;
	}

	/**
	 * @return the entityReplaceSectionPattern
	 */
	public String getEntityReplaceSectionPattern() {
		return entityReplaceSectionPattern;
	}

	/**
	 * @param entityReplaceSectionPattern the entityReplaceSectionPattern to set
	 */
	public void setEntityReplaceSectionPattern(String entityReplaceSectionPattern) {
		this.entityReplaceSectionPattern = entityReplaceSectionPattern;
	}

}
