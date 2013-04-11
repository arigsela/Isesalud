package com.isesalud.ejb.query;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.model.Paciente;
import com.isesalud.model.Paciente_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 */
@Stateless
@LocalBean
public class PacienteEjb extends BaseManagerEJB<Paciente> {
	
	@Inject
	private SecurityComponent securityComponent;
	
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
		List<Predicate> predicates = new ArrayList<Predicate>();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = builder.createQuery(getModelClass());
		Root<Paciente> root = query.from(getModelClass());
		Predicate likeName = builder.like(root.get(Paciente_.name), params.getName() + "%");
		Predicate likeLastName = builder.like(root.get(Paciente_.lastName), params.getLastName() + "%");
		Predicate likeMaternalName = builder.like(root.get(Paciente_.maternalLastName), params.getMaternalLastName() + "%");
		Predicate date = builder.equal(root.get(Paciente_.dateofBirth), params.getDateofBirth());
		Predicate unidad = builder.equal(root.get(Paciente_.unidadmedica), params.getUnidadmedica());
		Predicate municipio = builder.equal(root.get(Paciente_.municipio), securityComponent.getCurrentUser().getMunicipio());
		
		predicates.add(likeName);
		predicates.add(likeLastName);
		predicates.add(likeMaternalName);
		predicates.add(municipio);
		
		if(params.getDateofBirth() != null)
			predicates.add(date);
		
		if(params.getUnidadmedica() != null)
			predicates.add(unidad);
		
		Predicate and = builder.and(predicates.toArray(new Predicate[]{}));
		
		query.select(root).where(and);

		model = getList(query);
		
		return model;
	}

	@Override
	public Class<Paciente> getModelClass() {
		return Paciente.class;
	}

}
