/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.ModalityEjb;
import com.isesalud.model.Modality;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class ModalityQuery extends BaseQueryController<Modality>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2608730413367939219L;
	@EJB
	private ModalityEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}
	
	@Override
	protected List<Modality> getQueryList() {
		return ejb.getAllModalities();
	}
	
	@Override
	protected int getQueryRowCount() {
		return 0;
	}



	
}
