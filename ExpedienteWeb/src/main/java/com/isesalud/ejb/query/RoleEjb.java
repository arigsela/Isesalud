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

import com.isesalud.model.Role;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class RoleEjb extends BaseManagerEJB<Role> {

	@Override
	public Class<Role> getModelClass() {
		return Role.class;
	}
	
	public List<Role> getRoles(){
		List<Role> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Role> query = builder.createQuery(getModelClass());
		Root<Role> role = query.from(getModelClass());
		
		query.select(role);
		
		model = getList(query);
		
		return model;
	}

}
