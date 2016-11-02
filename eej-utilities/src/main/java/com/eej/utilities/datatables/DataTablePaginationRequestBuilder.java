/**
 * 
 */
package com.eej.utilities.datatables;

import javax.servlet.http.HttpServletRequest;

import com.eej.utilities.model.DataTablePaginationRequest;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public interface DataTablePaginationRequestBuilder {

	DataTablePaginationRequest getDataTablePaginationRequest(HttpServletRequest req);
}
