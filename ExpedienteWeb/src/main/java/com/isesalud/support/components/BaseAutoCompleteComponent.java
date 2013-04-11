/**
 * 
 */
package com.isesalud.support.components;

import java.util.List;

import org.primefaces.event.SelectEvent;

import com.isesalud.support.JSFUtil;
import com.isesalud.support.exceptions.BaseException;


/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
public abstract class BaseAutoCompleteComponent<T extends BaseModel, M extends BaseManager<T>> extends BaseComponent {

	/**
	 */
	public List<T> complete(final String description)
	{
		List<T> list = null;
		try
		{
			list = getList(description);
		}
		catch (Throwable t)
		{
			JSFUtil.fatal();
			log.fatal(t.getMessage(), t);
		}
		return list;
	}

	/**
	 */
	@SuppressWarnings("unchecked")
	public void select(final SelectEvent event)
	{
		try
		{
			doSelect((T) event.getObject());
		}
		catch (BaseException b)
		{
			JSFUtil.error(b.getMessages());
		}
		catch (Throwable t)
		{
			JSFUtil.fatal();
			log.fatal(t.getMessage(), t);
		}
	}

	/**
	 */
	protected void doSelect(final T model) throws BaseException
	{
	}

	/**
	 */
	protected abstract M getACManager();

	/**
	 */
	protected abstract List<T> getList(final String description);
}
