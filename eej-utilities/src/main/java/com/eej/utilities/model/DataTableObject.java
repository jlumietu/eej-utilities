package com.eej.utilities.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.eej.utilities.ApplicationVersion;
import com.fasterxml.jackson.annotation.JsonProperty;


public class DataTableObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;

	private String tableName;
	
	private List<DataTableHeader> tableHeaders;
	
	//@JsonUnwrapped
	private List<DataTableResult> resultados;
	//private List<List<DataTableElement>> resultados;

	private String nombreLista;
	//Solo le va a hacer caso a esta variable cuando las acciones van al servidor
	
	@JsonProperty("iTotalRecords")
	private int totalRecords;
	
	@JsonProperty("iPageNumber")
	private int pageNumber = 0;
	
	@JsonProperty("iTotalDisplayRecords")
	private int totalDisplayRecords;
	
	public DataTableObject(String nombre, String nombreDeLista, int totRows){
		tableName = nombre;
		nombreLista = nombreDeLista;
		tableHeaders = new ArrayList<DataTableHeader>();
		resultados = new ArrayList<DataTableResult>();
		totalRecords = totRows;
	}
	public DataTableObject(String nombre, String nombreDeLista){
		tableName = nombre;
		nombreLista = nombreDeLista;
		tableHeaders = new ArrayList<DataTableHeader>();
		resultados = new ArrayList<DataTableResult>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<DataTableHeader> getTableHeaders() {
		return tableHeaders;
	}

	public void setTableHeaders(List<DataTableHeader> tableHeaders) {
		this.tableHeaders = tableHeaders;
	}

	public List<DataTableResult> getResultados() {
		return resultados;
	}

	public void setResultados(List<DataTableResult> lista) {
		this.resultados = lista;
		if(lista != null){
			this.setTotalDisplayRecords(lista.size());
		}
	}
	
	public String getNombreLista() {
		return nombreLista;
	}

		public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRows) {
		this.totalRecords = totalRows;
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the iTotalDisplayRecords
	 */
	public int getTotalDisplayRecords() {
		return totalDisplayRecords;
	}
	/**
	 * @param iTotalDisplayRecords the iTotalDisplayRecords to set
	 */
	public void setTotalDisplayRecords(int iTotalDisplayRecords) {
		this.totalDisplayRecords = iTotalDisplayRecords;
	}
	
	
	
}
