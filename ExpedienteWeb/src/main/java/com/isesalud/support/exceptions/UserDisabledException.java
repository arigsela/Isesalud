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
@SuppressWarnings("serial")
@ApplicationException(rollback = true)
public class UserDisabledException extends BaseException {

	public UserDisabledException(List<String> messages){
		
		super(messages);
		
	}
	
	public UserDisabledException(String message){
		
		super(message);
		
	}

}
