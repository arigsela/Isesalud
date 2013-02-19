package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
		CriteriaQuery<Paciente> query = builder.createQuery(Paciente.class);
		Root<Paciente> root = query.from(Paciente.class);
		root.fetch(Paciente_.canceresOtraPartes);
		root.fetch(Paciente_.previasenfermedades);
		root.fetch(Paciente_.parientescancermama);
		root.fetch(Paciente_.SintomasCancerMama);
		query.select(root);
		
		model = getList(query);
		
		return model;
	}

	@Override
	public Class<Paciente> getModelClass() {
		return Paciente.class;
	}

}
