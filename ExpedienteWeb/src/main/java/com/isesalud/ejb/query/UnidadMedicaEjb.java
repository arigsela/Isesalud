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

import com.isesalud.model.Unidadmedica;
import com.isesalud.model.Unidadmedica_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class UnidadMedicaEjb extends BaseManagerEJB<Unidadmedica> {

	public List<Unidadmedica> getAllUnidadesMedicas(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Unidadmedica> query = builder.createQuery(getModelClass());
		Root<Unidadmedica> root = query.from(getModelClass());
		query.select(root);
		
		return getList(query);
	}
	
	public List<Unidadmedica> getUnidadMedicaByMunicipio(Unidadmedica params){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Unidadmedica> query = builder.createQuery(getModelClass());
		Root<Unidadmedica> root = query.from(getModelClass());
		query.select(root).where(builder.and(
				builder.equal(root.get(Unidadmedica_.municipio), params.getMunicipio())),
				builder.like(root.get(Unidadmedica_.name), params.getName() + "%"));
		
		return getList(query);
	}
	
	@Override
	public Class<Unidadmedica> getModelClass() {
		return Unidadmedica.class;
	}

}
