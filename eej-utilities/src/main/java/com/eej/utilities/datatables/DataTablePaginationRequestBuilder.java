/**
 * 
 */
package com.eej.utilities.datatables;

import javax.servlet.http.HttpServletRequest;

import com.eej.utilities.model.DataTablePaginationRequest;

/**
 * @author doibalmi
 *
 */
public interface DataTablePaginationRequestBuilder {

	DataTablePaginationRequest getDataTablePaginationRequest(HttpServletRequest req);
}
