/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.erax.principal.PrincipalSerializableId;

/**
 * The main goal of this Interface is set a basic contract which some
 * user session dependent model info must accomplish and link to any field
 * which is annotated with corresponding @DataTable dependendency annotation.
 * 
 * @author DOIBALMI
 *
 */
public interface DataTableRowOwner extends PrincipalSerializableId, Serializable {
	
	public abstract Serializable getRowOwnerSerializableKey();

}
