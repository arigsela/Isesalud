/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.HallazgosEjb;
import com.isesalud.model.Hallazgos;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class HallazgosQuery extends BaseQueryController<Hallazgos>{
/**
	 * 
	 */
	private static final long serialVersionUID = -2526879999781941616L;
private HallazgosEjb ejb;

@PostConstruct
public void loadData(){
	setQueryListDM(getQueryList());
}

@Override
protected List<Hallazgos> getQueryList() {
	return ejb.getAllHallazgos();
}

@Override
protected int getQueryRowCount() {
	return 0;
}
}
