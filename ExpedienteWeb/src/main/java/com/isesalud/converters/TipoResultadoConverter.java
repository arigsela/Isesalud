package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TipoResultadoEjb;
import com.isesalud.model.TipoResultado;

@Named
@FacesConverter("TipoResultadoConverter")
@RequestScoped
public class TipoResultadoConverter extends AbstractConverter<TipoResultado,TipoResultadoEjb>{

	@EJB
	private TipoResultadoEjb manager;
	
	@Override
	protected TipoResultadoEjb getCManager() {
		return this.manager;
	}

}
