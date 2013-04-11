/**
 * 
 */
package com.isesalud.validators;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.joda.time.DateTime;

import com.isesalud.support.DateUtil;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@FacesValidator("WorkHoursValidator")
@RequestScoped
public class WorkHoursValidator implements Validator {

	
	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		
		Date date = (Date)value;
		DateTime evalDate = new DateTime(date);
		
		if(DateUtil.isDateInThePast(evalDate)){
			FacesMessage msg = new FacesMessage("Atencion:", "No se puede agendar la cita en el pasado");
			throw new ValidatorException(msg);
		}
		
	}

}
