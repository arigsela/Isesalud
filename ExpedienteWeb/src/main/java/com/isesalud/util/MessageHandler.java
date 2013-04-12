package com.isesalud.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public abstract class MessageHandler
{
	private ResourceBundle rb;

	/**
	 */
	protected MessageHandler(String resource)
	{
		rb = ResourceBundle.getBundle(resource);
	}

	/**
	 */
	public String getMsg(final Class<?> c, final String key)
	{
		return rb.getString(c.getCanonicalName().concat(".").concat(key));
	}

	/**
	 */
	public String getMsg(final Class<?> c, final String key, final Object... parameters)
	{
		return MessageFormat.format(getMsg(c, key), parameters);
	}

	/**
	 */
	public String getMsg(final Enum<?> e)
	{
		return getMsg(e.getClass(), e.name());
	}

	/**
	 */
	public String getMsg(final Enum<?> e, final Object... parameters)
	{
		return MessageFormat.format(getMsg(e.getClass(), e.name()), parameters);
	}
}
