package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.isesalud.model.Entidad;
import com.isesalud.model.Entidad_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 */
@Stateless
@LocalBean
public class EntidadEjb extends BaseManagerEJB<Entidad> {
	
	public List<Entidad> getAllEntidades(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Entidad> query = builder.createQuery(getModelClass());
		Root<Entidad> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	public List<Entidad> getEntidadForAutoComplete(Entidad params){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Entidad> query = builder.createQuery(getModelClass());
		Root<Entidad> root = query.from(getModelClass());
		query.select(root).where(builder.and(
				builder.like(root.get(Entidad_.name),"%" + params.getName() + "%")));
		return getList(query);
	}
	
	@Override
	public Class<Entidad> getModelClass() {
		return Entidad.class;
	}
	
}
