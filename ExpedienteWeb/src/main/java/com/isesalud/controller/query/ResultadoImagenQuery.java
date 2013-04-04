package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.resultadoImagenEjb;
import com.isesalud.model.resultadoImagen;
import com.isesalud.support.components.BaseQueryController;

@Named
@ViewScoped
public class ResultadoImagenQuery extends BaseQueryController<resultadoImagen>{
/**
	 * 
	 */
	private static final long serialVersionUID = 392196039034549417L;
private resultadoImagenEjb ejb;

@PostConstruct
public void loadData(){
	setQueryListDM(getQueryList());
}

@Override
protected List<resultadoImagen> getQueryList() {
	return ejb.getAllResultados();
}

@Override
protected int getQueryRowCount() {
	return 0;
}
}
