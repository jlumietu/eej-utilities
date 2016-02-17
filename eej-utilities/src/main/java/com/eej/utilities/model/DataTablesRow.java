package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;

public class DataTablesRow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;

	private int colIndex;
	
	private String text;
	
	private String linkText;
	
	private String linkRef;
	
	private String linkTitle;
	
	private String imgSrc;
	
	private String fontColor;
	
	private String cellColor;

	/**
	 * @return the colIndex
	 */
	public int getColIndex() {
		return colIndex;
	}

	/**
	 * @param colIndex the colIndex to set
	 */
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the linkText
	 */
	public String getLinkText() {
		return linkText;
	}

	/**
	 * @param linkText the linkText to set
	 */
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	/**
	 * @return the linkRef
	 */
	public String getLinkRef() {
		return linkRef;
	}

	/**
	 * @param linkRef the linkRef to set
	 */
	public void setLinkRef(String linkRef) {
		this.linkRef = linkRef;
	}

	/**
	 * @return the linkTitle
	 */
	public String getLinkTitle() {
		return linkTitle;
	}

	/**
	 * @param linkTitle the linkTitle to set
	 */
	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	/**
	 * @return the imgSrc
	 */
	public String getImgSrc() {
		return imgSrc;
	}

	/**
	 * @param imgSrc the imgSrc to set
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	/**
	 * @return the fontColor
	 */
	public String getFontColor() {
		return fontColor;
	}

	/**
	 * @param fontColor the fontColor to set
	 */
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * @return the cellColor
	 */
	public String getCellColor() {
		return cellColor;
	}

	/**
	 * @param cellColor the cellColor to set
	 */
	public void setCellColor(String cellColor) {
		this.cellColor = cellColor;
	}
	
	


}
