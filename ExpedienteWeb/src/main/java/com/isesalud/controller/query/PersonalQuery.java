/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.ejb.query.PersonalEjb;
import com.isesalud.model.Personal;
import com.isesalud.model.Puesto;
import com.isesalud.model.Unidadmedica;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */

@Named
@ViewScoped
public class PersonalQuery extends BaseQueryController<Personal>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912437410895342130L;
	
	@EJB
	private PersonalEjb personalEjb;

	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Personal> getQueryList() {
		Personal params = new Personal();
		
		return ejb.getUnidadMedicaByMunicipio(params);
	}
	/*protected List<Personal> getQueryList() {
		return personalEjb.getAll();
	}
*/
	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
}
