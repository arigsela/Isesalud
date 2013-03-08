/**
 * 
 */
package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.isesalud.model.TipoEstudioCita;
import com.isesalud.model.TipoEstudioCita_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class TipoEstudioCitaEjb extends BaseManagerEJB<TipoEstudioCita> {

	public List<TipoEstudioCita> getTiposEstudiosCitas(){
		List<TipoEstudioCita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoEstudioCita> query = builder.createQuery(getModelClass());
		Root<TipoEstudioCita> root = query.from(getModelClass());
		query.select(root);
		
		model = getList(query);
		
		return model;
	}
	
	public List<TipoEstudioCita> getTipoEstudioCitaByTipo(TipoEstudioCita params){
		List<TipoEstudioCita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoEstudioCita> query = builder.createQuery(getModelClass());
		Root<TipoEstudioCita> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(TipoEstudioCita_.tipocita), params.getTipocita()));
		
		model = getList(query);
		
		return model;
	}
	
	@Override
	public Class<TipoEstudioCita> getModelClass() {
		return TipoEstudioCita.class;
	}

}
