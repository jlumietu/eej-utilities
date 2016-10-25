/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

/**
 * The main goal of this Interface is set a basic contract which some
 * user session dependent model info must accomplish and link to any field
 * which is annotated with corresponding @DataTable dependendency annotation.
 * 
 * @author DOIBALMI
 *
 */
public interface DataTableRowOwner extends Serializable {
	
	public abstract Serializable getRowOwnerSerializableKey();

}
