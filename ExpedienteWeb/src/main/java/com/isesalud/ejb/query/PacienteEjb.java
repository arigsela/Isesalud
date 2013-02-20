package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.isesalud.model.Paciente;
import com.isesalud.model.Paciente_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 */
@Stateless
@LocalBean
public class PacienteEjb extends BaseManagerEJB<Paciente> {
	
	public List<Paciente> getAllPatients(){
		List<Paciente> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = builder.createQuery(getModelClass());
		Root<Paciente> root = query.from(getModelClass());
		query.select(root);
		
		model = getList(query);
		
		return model;
	}
	
	public List<Paciente> getPatients(Paciente params){
		List<Paciente> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = builder.createQuery(getModelClass());
		Root<Paciente> root = query.from(getModelClass());
		Predicate likeName = builder.like(root.get(Paciente_.name), params.getName());
		Predicate likeLastName = builder.like(root.get(Paciente_.lastName), params.getLastName());
		Predicate likeMaternalName = builder.like(root.get(Paciente_.maternalLastName), params.getMaternalLastName());
		query.select(root);
		query.where(builder.and(likeName, likeLastName, likeMaternalName));
		
		model = getList(query);
		
		return model;
	}

	@Override
	public Class<Paciente> getModelClass() {
		return Paciente.class;
	}

}
