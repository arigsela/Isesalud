package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.query.ResultadoImagenEjb;
import com.isesalud.model.ResultadoImagen;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

@Named
@ViewScoped
public class ResultadoImagenQuery extends BaseQueryController<ResultadoImagen> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 392196039034549417L;

	private ResultadoImagen searchParams;

	private ResultadoImagen selectedResultado;

	@Inject
	private PatientSelection patientSelection;

	private ResultadoImagen detallesresultado;

	@EJB
	private ResultadoImagenEjb resultadoImagenEjb;

	@Override
	protected void init() throws BaseException {
		searchParams = new ResultadoImagen();
	}

	@PostConstruct
	public void loadData() {
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<ResultadoImagen> getQueryList() {
		ResultadoImagen search = new ResultadoImagen();
		search.setPaciente(this.patientSelection.getPaciente());
		return resultadoImagenEjb.getResultado(search);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

	public void onSelectedRow(SelectEvent e) {
		detallesresultado = resultadoImagenEjb.getFULL(getSelectedResultado()
				.getId());
	}

	public ResultadoImagen getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(ResultadoImagen searchParams) {
		this.searchParams = searchParams;
	}

	public ResultadoImagen getSelectedResultado() {
		return selectedResultado;
	}

	public void setSelectedResultado(ResultadoImagen selectedResultado) {
		this.selectedResultado = selectedResultado;
	}

	public ResultadoImagen getDetallesresultado() {
		return detallesresultado;
	}

	public void setDetallesresultado(ResultadoImagen detallesresultado) {
		this.detallesresultado = detallesresultado;
	}

}
