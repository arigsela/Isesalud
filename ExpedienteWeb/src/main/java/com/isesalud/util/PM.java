/**
 * 
 */
package com.isesalud.util;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public final class PM extends MessageHandler {
	
	private static PM me;

	/**
	 */
	private PM()
	{
		super("messages");
	}

	/**
	 */
	public static synchronized PM getMe()
	{
		if (me == null)
		{
			me = new PM();
		}
		return me;
	}

}
