package com.eej.utilities.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;



public class DataTableResult {


	Map<String, DataTableElement> resultados;

	/**
	 * @return the resultado
	 */
	@JsonValue
	public Map<String, DataTableElement> getResultados() {
		return resultados;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultados(Map<String, DataTableElement> resultados) {
		this.resultados = resultados;
	}
	
	
}
