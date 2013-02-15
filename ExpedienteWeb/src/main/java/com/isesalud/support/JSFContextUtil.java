/**
 * 
 */
package com.isesalud.support;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public final class JSFContextUtil
{
	/**
	 */
	public static final void invalidate()
	{
		final ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession) ec.getSession(Boolean.FALSE)).invalidate();
	}

	/**
	 */
	public static final void redirect() throws IOException
	{
		final ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String cp = (cp = ec.getRequestContextPath()).endsWith("/") ? cp : cp.concat("/");
		ec.redirect(cp);
	}
}
