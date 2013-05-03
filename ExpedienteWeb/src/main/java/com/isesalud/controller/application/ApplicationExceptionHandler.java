/**
 * 
 */
package com.isesalud.controller.application;

import javax.enterprise.context.NonexistentConversationException;
import javax.faces.context.FacesContext;

import org.jboss.solder.exception.control.CaughtException;
import org.jboss.solder.exception.control.Handles;
import org.jboss.solder.exception.control.HandlesExceptions;
import org.jboss.solder.logging.Logger;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@HandlesExceptions
public class ApplicationExceptionHandler {

	void handleObserverException(@Handles CaughtException<NonexistentConversationException> evt, Logger log){
		
		if(!evt.isMarkedHandled()){
			log.error("Caught NonExistentConversationException. Posible update of application or internal error found");
			final FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.getApplication().getNavigationHandler().handleNavigation(ctx, "", "/home?faces-redirect=true");
			ctx.renderResponse();
		}
		
		evt.handled();
	}
	
}
