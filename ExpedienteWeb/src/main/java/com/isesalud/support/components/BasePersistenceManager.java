/**
 * 
 */
package com.isesalud.support.components;

import javax.ejb.EJBException;


public interface BasePersistenceManager<T extends BaseModel> extends BaseManager<T>
{
	/**
	 */
	public abstract T save(final T model) throws EJBException;

	/**
	 */
	public abstract T delete(final Long modelID) throws EJBException;
}