/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.List;

import javax.ejb.ApplicationException;

import com.isesalud.support.exceptions.BaseException;

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
