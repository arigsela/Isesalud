/**
 * 
 */
package com.isesalud.support.components;

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
	
	@Override
	public int hashCode() {
		return getId().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return getId().equals(((BaseModel)obj).getId());
	}
	
	public void initLazyElements(){
		
	}

}
