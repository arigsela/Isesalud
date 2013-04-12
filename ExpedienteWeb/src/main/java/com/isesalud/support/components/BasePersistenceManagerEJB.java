/**
 * 
 */
package com.isesalud.support.components;

import javax.ejb.EJBException;
//import com.ebizlink.pandora2.core.msg.enumeration.DatabaseMsgEnum;
//import com.ebizlink.pandora2.core.msg.util.PM;

import com.isesalud.support.CompareUtil;

public abstract class BasePersistenceManagerEJB<T extends BaseModel> extends BaseManagerEJB<T> implements BasePersistenceManager<T>
{
	/**
	 */
	@Override
	public T save(final T model) throws EJBException
	{
		try
		{
			if (model.isEmpty())
			{
				doValid(model);
				doBeforeAdd(model);
				doBeforeAddUpdate(model);
				doAdd(model);
				doAfterAdd(model);
			}
			else
			{
				doValid(model);
				doBeforeUpdate(model);
				doBeforeAddUpdate(model);
				doUpdate(model);
				doAfterUpdate(model);
			}
			doAfterAddUpdate(model);
			//doAudit();
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return model;
	}

	/**
	 */
	@Override
	public T delete(final Long modelID) throws EJBException
	{
		T model = null;
		try
		{
			if (CompareUtil.isEmpty(model = get(modelID)))
			{
				//throw new ValidationException(PM.getMe().getMsg(DatabaseMsgEnum.RECORD_NOT_FOUND));
			}
			doBeforeDelete(model);
			doDelete(model);
			doAfterDelete(model);
			//doAudit();
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return model;
	}

	/**
	 */
	private void doValid(final T model) throws EJBException
	{
		//model.valid();
	}

	/**
	 */
	private void doAdd(final T model) throws EJBException
	{
		em.persist(model);
	}

	/**
	 */
	private T doUpdate(final T model) throws EJBException
	{
		return em.merge(model);
	}

	/**
	 */
	private void doDelete(final T model) throws EJBException
	{
		em.remove(model);
	}

	/**
	 */
	protected void doBeforeAdd(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doBeforeUpdate(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doBeforeAddUpdate(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doBeforeDelete(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doAfterAdd(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doAfterUpdate(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doAfterAddUpdate(final T model) throws EJBException
	{
	}

	/**
	 */
	protected void doAfterDelete(final T model) throws EJBException
	{
	}
}
