package com.isesalud.support;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import com.isesalud.support.msg.ErrorMessages;
import com.isesalud.support.msg.LogMessages;
import com.isesalud.util.PM;

public final class JSFUtil
{
	/**
	 */
	private static final void addMessage(final Severity severity, final String summary, final String detail)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	/**
	 */
	public static final void info(final String message)
	{
		addMessage(FacesMessage.SEVERITY_INFO, PM.getMe().getMsg(LogMessages.INFO), message);
	}

	/**
	 */
	public static final void warn(final String message)
	{
		addMessage(FacesMessage.SEVERITY_WARN, PM.getMe().getMsg(LogMessages.WARN), message);
	}

	/**
	 */
	public static final void error(final String message)
	{
		addMessage(FacesMessage.SEVERITY_ERROR, PM.getMe().getMsg(LogMessages.ERROR), message);
	}

	/**
	 */
	public static final void error(final List<String> messageList)
	{
		for (final String message : messageList)
		{
			error(message);
		}
	}

	/**
	 */
	public static final void fatal()
	{
		addMessage(FacesMessage.SEVERITY_FATAL, PM.getMe().getMsg(LogMessages.FATAL), PM.getMe().getMsg(ErrorMessages.GENERAL));
	}
}
