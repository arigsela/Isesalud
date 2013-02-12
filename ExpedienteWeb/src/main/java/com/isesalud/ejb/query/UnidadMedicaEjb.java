/**
 * 
 */
package com.isesalud.ejb.query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.isesalud.model.Unidadmedica;

/**
 * @author Haysoos
 *
 */
public class UnidadMedicaEjb extends BaseManagerEJB<Unidadmedica> {

	public List<Unidadmedica> getAllUnidadesMedicas(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Unidadmedica> query = builder.createQuery(getModelClass());
		Root<Unidadmedica> root = query.from(getModelClass());
		query.select(root);
		
		return getList(query);
	}
	
	@Override
	public Class<Unidadmedica> getModelClass() {
		return Unidadmedica.class;
	}

}
