/**
 * 
 */
package com.isesalud.support;

import java.util.List;
import javax.faces.context.FacesContext;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public final class JAASUtil
{
	/**
	 */
	public static final Boolean inRole(final String role)
	{
		return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
	}

	/**
	 */
	public static final Boolean inRole(final List<String> roleList)
	{
		for (final String role : roleList)
		{
			if (inRole(role))
			{
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	/**
	 */
	public static final Boolean isAdmin()
	{
		return inRole("ADMIN");
	}
	
}
