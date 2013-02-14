/**
 * 
 */
package com.isesalud.support.exceptions;

import java.util.List;

import javax.ejb.ApplicationException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@ApplicationException(rollback = true)
@SuppressWarnings("serial")
public final class ValidationException extends BaseException
{
	/**
	 */
	public ValidationException(List<String> messages)
	{
		super(messages);
	}

	/**
	 */
	public ValidationException(String message)
	{
		super(message);
	}
}
