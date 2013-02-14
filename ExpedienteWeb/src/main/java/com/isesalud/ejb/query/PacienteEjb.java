package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.isesalud.model.Paciente;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * Session Bean implementation class PacienteEjb
 */
@Stateless
@LocalBean
public class PacienteEjb extends BaseManagerEJB<Paciente> {
	
	public List<Paciente> getAllPatients(){
		List<Paciente> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = builder.createQuery(Paciente.class);
		Root<Paciente> root = query.from(Paciente.class);
		query.select(root);
		
		model = getList(query);
		
		return model;
	}

	@Override
	public Class<Paciente> getModelClass() {
		return Paciente.class;
	}

}
