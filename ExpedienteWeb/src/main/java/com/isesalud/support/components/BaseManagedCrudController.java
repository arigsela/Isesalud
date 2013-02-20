/**
 * 
 */
package com.isesalud.support.components;

import com.isesalud.support.CompareUtil;
import com.isesalud.support.exceptions.BaseException;
import com.isesalud.support.exceptions.ValidationException;
import com.isesalud.support.msg.DbMessages;
import com.isesalud.util.PM;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
public abstract class BaseManagedCrudController<T extends BaseModel, M extends BasePersistenceManager<T>> extends BaseCrudController
{
	private T model;

	/**
	 */
	@Override
	public void clear() throws BaseException
	{
		super.clear();
		model = getNewModel();
	}

	/**
	 */
	public T getModel()
	{
		if (model == null)
		{
			model = getNewModel();
		}
		return model;
	}

	/**
	 */
	public void setModel(T model)
	{
		this.model = model;
	}

	/**
	 */
	@Override
	protected void doAdd() throws BaseException
	{
		model = getNewModel();
	}

	/**
	 */
	@Override
	protected void doEdit() throws BaseException
	{
		if (CompareUtil.isEmpty(model = getCrudManager().getFULL(getModel().getId())))
		{
			throw new ValidationException(PM.getMe().getMsg(DbMessages.RECORD_NOT_FOUND));
		}
	}

	/**
	 */
	@Override
	protected void doDelete() throws BaseException
	{
		getCrudManager().delete(getModel().getId());
	}

	/**
	 */
	@Override
	protected void doSave() throws BaseException
	{
		getCrudManager().save(getModel());
	}

	/**
	 */
	@Override
	protected void doCancel() throws BaseException
	{
	}

	/**
	 */
	protected abstract M getCrudManager();

	/**
	 */
	protected abstract T getNewModel();
}
