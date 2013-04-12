/**
 * 
 */
package com.isesalud.support.components;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.jboss.solder.logging.Logger;

import com.isesalud.support.CompareUtil;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@SuppressWarnings("serial")
public abstract class BaseQueryController<T> extends BaseComponent {

	protected Logger log = Logger.getLogger(getClass());
	
	private List<T> queryListDM;
	
	@Override
	public void clear() throws BaseException {
		super.clear();
		queryListDM = null;
	}
	
	public List<T> getQueryListDM() {
		return queryListDM;
	}
	
	public void setQueryListDM(List<T> queryListDM) {
		this.queryListDM = queryListDM;
	}
	
	public Boolean isLoaded(){
		return !CompareUtil.isEmpty(getQueryListDM()) && getQueryListDM().size() > 0;
	}
	
	public void query(ActionEvent e){
		try{
			this.queryListDM = getQueryList();
		} catch(Throwable t){
			JSFUtil.fatal();
			log.fatal(t.getMessage(), t);
		}
		
	}
	
	/**
	 */
	protected abstract List<T> getQueryList();

	/**
	 */
	protected abstract int getQueryRowCount();
}
