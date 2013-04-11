/**
 * 
 */
package com.isesalud.support.components;


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
	
	/**
	 */
	public abstract T getFULL(final Long modelID);

}
