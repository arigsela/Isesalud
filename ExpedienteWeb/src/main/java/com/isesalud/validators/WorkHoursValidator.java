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
		
		if(isDateInThePast(evalDate)){
			FacesMessage msg = new FacesMessage("Atencion:", "No se puede agendar la cita en el pasado");
			throw new ValidatorException(msg);
		}
		
	}
	
	/**
	 * Checks if date is in the past from now.
	 * @param evalDate: Date to be evaluated
	 * @return true if date is in the past, false otherwise
	 */
	public boolean isDateInThePast(DateTime evalDate){
		return evalDate.isBefore(DateTime.now());

	}

}
