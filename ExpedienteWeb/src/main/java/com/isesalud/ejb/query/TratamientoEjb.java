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
import com.isesalud.model.Tratamiento;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TratamientoEjb extends BaseManagerEJB<Tratamiento>{

	public List<Tratamiento> getAllTratamientos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tratamiento> query = builder.createQuery(getModelClass());
		Root<Tratamiento> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<Tratamiento> getModelClass() {
		return Tratamiento.class;
	}
}
