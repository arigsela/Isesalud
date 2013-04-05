/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.MotivoInadecuadaEjb;
import com.isesalud.model.MotivoInadecuada;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("MotivoInadecuadaConverter")
@RequestScoped
public class MotivoInadecuadaConverter extends AbstractConverter<MotivoInadecuada,MotivoInadecuadaEjb> {

	@EJB
	private MotivoInadecuadaEjb manager;
	
	@Override
	protected MotivoInadecuadaEjb getCManager() {
		return this.manager;
	}

}
