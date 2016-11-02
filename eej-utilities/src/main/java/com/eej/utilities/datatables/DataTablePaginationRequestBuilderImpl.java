/**
 * 
 */
package com.eej.utilities.datatables;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.eej.utilities.model.DataTablePaginationRequest;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class DataTablePaginationRequestBuilderImpl implements
		DataTablePaginationRequestBuilder {
	
	private Logger logger = Logger.getLogger(this.getClass());

	public DataTablePaginationRequest getDataTablePaginationRequest(
			HttpServletRequest request) {
		
		DataTablePaginationRequest req = new DataTablePaginationRequest();
		req.setNumero(15);
		req.setPagina(1); 
		req.setColOrd("0");
		req.setDirOrd("desc");
		if(null != request.getParameter("sEcho") && "" != request.getParameter("sEcho")){
			req.setNumero(Integer.parseInt(request.getParameter("iDisplayLength")));
		    req.setPagina(Integer.parseInt( request.getParameter("iDisplayStart")));
		    try{
		    	req.setColOrd(String.valueOf(Integer.parseInt( request.getParameter("iSortCol_0") )));
		    	req.setDirOrd(request.getParameter("sSortDir_0"));
		    }catch(Throwable t){
		    	// en la primera petición no hay paginación.
		    }
		    req.setSearchGeneral(request.getParameter("sSearch"));
		    int numberColumns = Integer.parseInt( request.getParameter("iColumns"));
		    HashMap<String, String> hashColsFilter = new HashMap<String, String>();
			for (int i = 0; i < numberColumns; i++){
				if (null != request.getParameter("sSearch_"+i)){
					hashColsFilter.put(Integer.toString(i), request.getParameter("sSearch_"+i));
				}
			}
			req.setColsFilter(hashColsFilter);
		}
		logger.debug("req.getNumero= " + req.getNumero());
		logger.debug("req.getPagina= " + req.getPagina());
		logger.debug("req.getColOrd= " + req.getColOrd());
		logger.debug("req.getDirOrd= " + req.getDirOrd());
	    return req;
	}

}
