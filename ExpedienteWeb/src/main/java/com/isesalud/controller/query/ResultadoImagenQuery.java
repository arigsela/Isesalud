package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.query.resultadoImagenEjb;
import com.isesalud.model.resultadoImagen;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

@Named
@ViewScoped
public class ResultadoImagenQuery extends BaseQueryController<resultadoImagen>{
/**
	 * 
	 */
	private static final long serialVersionUID = 392196039034549417L;

	private resultadoImagen searchParams;
	
	private resultadoImagen selectedResultado;
	
	@Inject
	private PatientSelection patientSelection;
	
	@Inject @Any
	private javax.enterprise.event.Event<resultadoImagen> resultadoSelectedEvent;
	
	private resultadoImagen detallesresultado;
	
	@EJB
	private resultadoImagenEjb resultadoImagenEjb;
	
	@Override
	protected void init() throws BaseException {
		searchParams = new resultadoImagen();
	}
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<resultadoImagen> getQueryList() {
		resultadoImagen search = new resultadoImagen();
		search.setPaciente(this.patientSelection.getPaciente());
		return resultadoImagenEjb.getResultado(search);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

	public void onSelectedRow(SelectEvent e){
		detallesresultado = resultadoImagenEjb.getFULL(getSelectedResultado().getId());
		resultadoSelectedEvent.fire(detallesresultado);
	}
	
	public resultadoImagen getSearchParams() {
	return searchParams;
}

public void setSearchParams(resultadoImagen searchParams) {
	this.searchParams = searchParams;
}

public resultadoImagen getSelectedResultado() {
	return selectedResultado;
}

public void setSelectedResultado(resultadoImagen selectedResultado) {
	this.selectedResultado = selectedResultado;
}

public resultadoImagen getDetallesresultado() {
	return detallesresultado;
}

public void setDetallesresultado(resultadoImagen detallesresultado) {
	this.detallesresultado = detallesresultado;
}




}
