/**
 * 
 */
package com.isesalud.support.components;

import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.isesalud.support.CompareUtil;
import com.isesalud.support.QueryHint;

public abstract class BaseManagerEJB<T extends BaseModel> extends BaseEJB implements BaseManager<T>
{
	/**
	 */
	@Override
	public T get(final Long modelID)
	{
		T model = null;
		try
		{
			model = em.find(getModelClass(), modelID);
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
	public T getFULL(final Long modelID)
	{
		T model = null;
		try
		{
			if (!CompareUtil.isEmpty(model = get(modelID)))
			{
				model.initLazyElements();
			}
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return model;
	}

	/**
	 */
	protected T getUnique(final CriteriaQuery<T> criteriaQuery)
	{
		T model = null;
		try
		{
			final TypedQuery<T> tq = em.createQuery(criteriaQuery);
			model = tq.getSingleResult();
		}
		catch (NoResultException n)
		{
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return model;
	}

	/**
	 */
	protected <X> List<X> getList(final CriteriaQuery<X> criteriaQuery, final QueryHint queryHint)
	{
		List<X> modelList = null;
		try
		{
			final TypedQuery<X> tq = em.createQuery(criteriaQuery);
			tq.setFirstResult(queryHint.getFirstResult());
			tq.setMaxResults(queryHint.getMaxResults());
			modelList = tq.getResultList();
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return modelList;
	}

	/**
	 */
	protected <X> List<X> getList(final CriteriaQuery<X> criteriaQuery)
	{
		List<X> modelList = null;
		try
		{
			final TypedQuery<X> tq = em.createQuery(criteriaQuery);
			modelList = tq.getResultList();
		}
		catch (Throwable t)
		{
			throw new EJBException(t.getMessage());
		}
		return modelList;
	}
}
