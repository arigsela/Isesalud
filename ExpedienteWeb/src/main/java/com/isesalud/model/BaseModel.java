/**
 * 
 */
package com.isesalud.model;

import java.io.Serializable;

/**
 * @author Haysoos
 *
 */
@SuppressWarnings("serial")
public abstract class BaseModel implements Serializable {
	
	public abstract Long getId();
	
	public abstract void setId(Long id);
	
	public boolean isEmpty(){
		return getId().equals(0l);
	}

}
