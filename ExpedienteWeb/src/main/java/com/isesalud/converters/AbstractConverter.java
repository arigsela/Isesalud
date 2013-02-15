/**
 * 
 */
package com.isesalud.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.jboss.solder.logging.Logger;

import com.isesalud.support.CompareUtil;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseManager;
import com.isesalud.support.components.BaseModel;

/**
 * @author Jesus Espinoza Hernandez
 *
 * Faces converter base class. 
 */
public abstract class AbstractConverter<T extends BaseModel, M extends BaseManager<T>> implements Converter {
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent uic, String modelID) {
		T model = null;
        try
        {
        	
                if (!CompareUtil.isEmpty(modelID))
                {
                        model = getCManager().get(Long.valueOf(modelID));
                }
        }
        catch (NumberFormatException n)
        {
        }
        catch (Throwable t)
        {
                JSFUtil.fatal();
                log.fatal(t.getMessage(), t);
        }
        return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext ctx, UIComponent uic, Object model) {
		return !CompareUtil.isEmpty(model) ? ((T) model).getId().toString() : null;
	}
	
	/**
	 * Defines a database manager to fetch entities for conversion. Must be derived from
	 * BaseManager class.
     */
    protected abstract M getCManager();

}

