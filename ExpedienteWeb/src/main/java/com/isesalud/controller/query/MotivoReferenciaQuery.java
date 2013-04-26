/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.MotivoReferenciaEjb;
import com.isesalud.model.MotivoReferencia;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Jesus Espinoza Hernandez0
 *
 */
@Named
@ViewScoped
public class MotivoReferenciaQuery extends BaseQueryController<MotivoReferencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3023446886804637392L;
	
	@EJB
	private MotivoReferenciaEjb manager;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<MotivoReferencia> getQueryList() {
		return this.manager.getAllMotivos();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
