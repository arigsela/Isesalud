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

import com.isesalud.model.Study;
import com.isesalud.model.Study_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class StudyEjb extends BaseManagerEJB<Study> {

	public List<Study> getStudies(){
		List<Study> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Study> query = builder.createQuery(getModelClass());
		Root<Study> root = query.from(getModelClass());
		query.select(root);
		
		model = getList(query);
		
		return model;
	}
	
	public List<Study> getStudiesbyType(Study params){
		List<Study> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Study> query = builder.createQuery(getModelClass());
		Root<Study> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(Study_.department), params.getDepartment()));
		model = getList(query);
		return model;
	}
	
	@Override
	public Class<Study> getModelClass() {
		return Study.class;
	}

}
