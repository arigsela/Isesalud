/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.MotivoReferenciaEjb;
import com.isesalud.model.MotivoReferencia;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("MotivoReferencia")
@RequestScoped
public class MotivoReferenciaConverter extends AbstractConverter<MotivoReferencia, MotivoReferenciaEjb>{

	@EJB
	private MotivoReferenciaEjb manager;
	
	@Override
	protected MotivoReferenciaEjb getCManager() {
		return this.manager;
	}
}
