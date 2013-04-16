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

import com.isesalud.model.Modality;
import com.isesalud.model.Modality_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class ModalityEjb extends BaseManagerEJB<Modality>{

	public List<Modality> getAllModalities(){
		List<Modality> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Modality> query = builder.createQuery(getModelClass());
		Root<Modality> root = query.from(getModelClass());
		query.select(root);
		model = getList(query);
		return model;
	}

	public List<Modality> getModalitiesByDepartment(Modality params) {
		List<Modality> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Modality> query = builder.createQuery(getModelClass());
		Root<Modality> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(Modality_.department), params.getDepartment()));
		model = getList(query);
		return model;
		
	}
	
	public Class<Modality> getModelClass(){
		return Modality.class;
	}
	
}
