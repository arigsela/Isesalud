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
import com.isesalud.model.PreviaEnfermedad;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean

public class PreviaEnfermedadEjb extends BaseManagerEJB<PreviaEnfermedad>{

	public List<PreviaEnfermedad> getAllPreviasEnfermedades() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PreviaEnfermedad> query = builder.createQuery(getModelClass());
		Root<PreviaEnfermedad> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	@Override
	public Class<PreviaEnfermedad> getModelClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
