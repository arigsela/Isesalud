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

import com.isesalud.model.Personal;

/**
 * @author Haysoos
 *
 */
@Stateless
@LocalBean
public class PersonalEjb extends BaseManagerEJB<Personal> {

	public List<Personal> getAll(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Personal> query = builder.createQuery(getModelClass());
		Root<Personal> root = query.from(getModelClass());
		query.select(root);
		
		return getList(query);
	}
	
	@Override
	public Class<Personal> getModelClass() {
		return Personal.class;
	}

}
