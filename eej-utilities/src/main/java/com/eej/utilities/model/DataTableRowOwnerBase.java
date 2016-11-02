/**
 * 
 */
package com.eej.utilities.model;

import java.io.Serializable;

import com.eej.utilities.ApplicationVersion;
import com.erax.principal.PrincipalSerializableId;

/**
 * @author jlumietu - Mikel Ibiricu Alfaro
 *
 */
public class DataTableRowOwnerBase implements DataTableRowOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = ApplicationVersion.APP_VERSION;
	
	private PrincipalSerializableId principalSerializableId;
	
	/**
	 * 
	 * @param principalSerializableId
	 */
	public DataTableRowOwnerBase(PrincipalSerializableId principalSerializableId) {
		super();
		this.principalSerializableId = principalSerializableId;
	}

	/* (non-Javadoc)
	 * @see com.erax.principal.PrincipalSerializableId#getId()
	 */
	@Override
	public Serializable getId() {
		return this.principalSerializableId.getId();
	}

	/* (non-Javadoc)
	 * @see com.eej.utilities.model.DataTableRowOwner#getRowOwnerSerializableKey()
	 */
	@Override
	public Serializable getRowOwnerSerializableKey() {
		return this.getId();
	}

}
