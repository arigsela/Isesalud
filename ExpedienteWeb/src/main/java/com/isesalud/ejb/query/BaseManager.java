/**
 * 
 */
package com.isesalud.ejb.query;

import com.isesalud.model.BaseModel;

/**
 * @author Haysoos
 *
 */
public interface BaseManager<T extends BaseModel> {
	
	/**
	 */
	public abstract Class<T> getModelClass();

	/**
	 */
	public abstract T get(final Long modelID);

}
