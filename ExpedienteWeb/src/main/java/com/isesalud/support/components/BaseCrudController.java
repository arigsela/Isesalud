/**
 * 
 */
package com.isesalud.support.components;

import javax.faces.event.ActionEvent;

import com.isesalud.support.JAASUtil;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.exceptions.BaseException;
import com.isesalud.support.msg.DbMessages;
import com.isesalud.support.msg.InfoMessages;
import com.isesalud.util.PM;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
public abstract class BaseCrudController extends BaseController
{
	private EditModeEnum editMode;

	/**
	 */
	@Override
	public void clear() throws BaseException
	{
		super.clear();
		editMode = EditModeEnum.NONE;
	}

	/**
	 */
	public EditModeEnum getEditMode()
	{
		return editMode;
	}

	/**
	 */
	public void setEditMode(EditModeEnum editMode)
	{
		this.editMode = editMode;
	}

	/**
	 */
	public void add(ActionEvent actionEvent)
	{
		try
		{
			doBeforeAdd();
			doAdd();
			doAfterAdd();
			doAfterAddEdit();
			setEditMode(EditModeEnum.ADDING);
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
	public void edit(ActionEvent actionEvent)
	{
		try
		{
			doBeforeEdit();
			doEdit();
			doAfterEdit();
			doAfterAddEdit();
			setEditMode(EditModeEnum.EDITING);
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
	public void delete(ActionEvent actionEvent)
	{
		try
		{
			doBeforeDelete();
			doDelete();
			doAfterDelete();
			clear();
		}
		catch (BaseException b)
		{
			JSFUtil.error(b.getMessages());
		}
		catch (Throwable t)
		{
			JSFUtil.error(PM.getMe().getMsg(DbMessages.RECORD_NOT_DELETED));
			log.error(t.getMessage(), t);
		}
	}

	/**
	 */
	public void save(ActionEvent actionEvent)
	{
		try
		{
			doBeforeSave();
			doSave();
			doAfterSave();
			clear();
		}
		catch (BaseException b)
		{
			JSFUtil.error(b.getMessages());
		}
		catch (Throwable t)
		{
			JSFUtil.error(PM.getMe().getMsg(DbMessages.RECORD_NOT_UPDATED));
			log.error(t.getMessage(), t);
		}
	}

	/**
	 */
	public void cancel(ActionEvent actionEvent)
	{
		try
		{
			doBeforeCancel();
			doCancel();
			doAfterCancel();
			clear();
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
	public Boolean getAddEnabled()
	{
		return getEditMode().equals(EditModeEnum.ADDING) && (JAASUtil.isAdmin() || JAASUtil.inRole(getAddRole()));
	}

	/**
	 */
	public Boolean getEditEnabled()
	{
		return getEditMode().equals(EditModeEnum.EDITING) && (JAASUtil.isAdmin() || JAASUtil.inRole(getEditRole()));
	}

	/**
	 */
	public Boolean getDeleteEnabled()
	{
		return getEditMode().equals(EditModeEnum.EDITING) && (JAASUtil.isAdmin() || JAASUtil.inRole(getDeleteRole()));
	}

	/**
	 */
	protected abstract String getAddRole();

	/**
	 */
	protected abstract String getEditRole();

	/**
	 */
	protected abstract String getDeleteRole();

	/**
	 */
	protected abstract void doAdd() throws BaseException;

	/**
	 */
	protected abstract void doEdit() throws BaseException;

	/**
	 */
	protected abstract void doDelete() throws BaseException;

	/**
	 */
	protected abstract void doSave() throws BaseException;

	/**
	 */
	protected abstract void doCancel() throws BaseException;

	/**
	 */
	protected void doBeforeAdd() throws BaseException
	{
	}

	/**
	 */
	protected void doBeforeEdit() throws BaseException
	{
	}

	/**
	 */
	protected void doBeforeDelete() throws BaseException
	{
	}

	/**
	 */
	protected void doBeforeSave() throws BaseException
	{
	}

	/**
	 */
	protected void doBeforeCancel() throws BaseException
	{
	}

	/**
	 */
	protected void doAfterAdd() throws BaseException
	{
	}

	/**
	 */
	protected void doAfterEdit() throws BaseException
	{
	}

	/**
	 */
	protected void doAfterAddEdit() throws BaseException
	{
	}

	/**
	 */
	protected void doAfterDelete() throws BaseException
	{
		JSFUtil.info(PM.getMe().getMsg(InfoMessages.SUCCESS));
	}

	/**
	 */
	protected void doAfterSave() throws BaseException
	{
		JSFUtil.info(PM.getMe().getMsg(InfoMessages.SUCCESS));
	}

	/**
	 */
	protected void doAfterCancel() throws BaseException
	{
		JSFUtil.info(PM.getMe().getMsg(InfoMessages.CANCELED));
	}
}
