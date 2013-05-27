package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

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

	private ResultadoImagen selectedResultado;

	private ResultadoImagen detallesresultado;

	private Date initDate;
	private Date finalDate;

	@EJB
	private ResultadoImagenEjb resultadoImagenEjb;

	public ResultadoImagen getDetallesresultado() {
		return detallesresultado;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public Date getInitDate() {
		return initDate;
	}
	
	@Override
	protected void init() throws BaseException {
		super.init();
		finalDate = new Date();
		initDate = new Date();
	}

	@Override
	protected List<ResultadoImagen> getQueryList() {
		return this.resultadoImagenEjb.getPendingInterpretationsByDate(
				initDate, finalDate);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

	public ResultadoImagen getSelectedResultado() {
		return selectedResultado;
	}

	public void onSelectedRow(SelectEvent e) {
		detallesresultado = resultadoImagenEjb.getFULL(getSelectedResultado()
				.getId());
	}

	public void setDetallesresultado(ResultadoImagen detallesresultado) {
		this.detallesresultado = detallesresultado;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public void setSelectedResultado(ResultadoImagen selectedResultado) {
		this.selectedResultado = selectedResultado;
	}

}
