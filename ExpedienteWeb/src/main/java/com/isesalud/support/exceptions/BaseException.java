package com.isesalud.support.exceptions;

import java.util.Arrays;
import java.util.List;

import com.isesalud.support.CharUtil;
import com.isesalud.support.CompareUtil;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
public abstract class BaseException extends Exception
{
	private List<String> messages;

	/**
	 */
	protected BaseException(List<String> messages)
	{
		this.messages = messages;
	}

	/**
	 */
	protected BaseException(String message)
	{
		this.messages = Arrays.asList(message);
	}

	/**
	 */
	public List<String> getMessages()
	{
		return messages;
	}

	/**
	 */
	public String getMessagesAsPlainText()
	{
		final StringBuilder sb = new StringBuilder();

		for (final String message : getMessages())
		{
			if (!CompareUtil.isEmpty(sb.toString()))
			{
				sb.append(CharUtil.getLineSeparator());
			}
			sb.append(message);
		}
		return sb.toString();
	}
}
