/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.EJBException;

import com.isesalud.ejb.query.BaseManager;
import com.isesalud.model.BaseModel;

public interface BasePersistenceManager<T extends BaseModel> extends BaseManager<T>
{
	/**
	 */
	public abstract T save(final T model) throws EJBException;

	/**
	 */
	public abstract T delete(final Long modelID) throws EJBException;
}