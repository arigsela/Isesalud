/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoResultadoEjb;
import com.isesalud.model.TipoResultado;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class TipoResultadoQuery extends BaseQueryController<TipoResultado>{
/**
	 * 
	 */
	private static final long serialVersionUID = -6505106688573876092L;
private TipoResultadoEjb ejb;
@PostConstruct
public void loadData(){
	setQueryListDM(getQueryList());
}

@Override
protected List<TipoResultado> getQueryList() {
	return ejb.getAllTiposResultados();
}

@Override
protected int getQueryRowCount() {
	return 0;
}
}
