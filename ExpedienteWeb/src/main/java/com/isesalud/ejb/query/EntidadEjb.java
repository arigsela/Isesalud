package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.isesalud.model.Entidad;

/**
 * Session Bean implementation class EntidadQuery
 */
@Stateless
@LocalBean
public class EntidadEjb extends BaseManagerEJB<Entidad> {
	
	public List<Entidad> getEntidades(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Entidad> query = builder.createQuery(getModelClass());
		Root<Entidad> root = query.from(getModelClass());
		query.select(root);
		
		return getList(query);
	}

	@Override
	public Class<Entidad> getModelClass() {
		return Entidad.class;
	}
	
}
