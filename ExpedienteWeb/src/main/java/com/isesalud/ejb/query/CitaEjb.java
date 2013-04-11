/**
 * 
 */
package com.isesalud.ejb.query;

import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.model.Cita;
import com.isesalud.model.Cita_;
import com.isesalud.model.Paciente;
import com.isesalud.model.Paciente_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Ari G. Sela M.
 *
 */

@Stateless
@LocalBean
public class CitaEjb extends BaseManagerEJB<Cita>{
	
	@Inject
	private SecurityComponent securityComponent;

	public List<Cita> getAllCita() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = builder.createQuery(getModelClass());
		Root<Cita> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	public List<Cita> getCitasByDateRange(Cita params){
		List<Cita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = builder.createQuery(getModelClass());
		Root<Cita> root = query.from(getModelClass());
		Join<Cita, Paciente> pat = root.join(Cita_.paciente, JoinType.LEFT);
		
		Predicate startDateP = builder.greaterThanOrEqualTo(root.get(Cita_.date), params.getStartDate());
		Predicate endDateP = builder.lessThanOrEqualTo(root.get(Cita_.date), params.getEndDate());
		Predicate municipio = builder.equal(pat.get(Paciente_.municipio), securityComponent.getCurrentUser().getMunicipio());
		
		query.select(root).where(builder.and(startDateP, endDateP, municipio));
		
		model = getList(query);
		
		return model;
	}
	
	public List<Cita> getCitasByDate(Cita params){
		List<Cita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = builder.createQuery(getModelClass());
		Root<Cita> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(Cita_.date), params.getDate()));
		
		model = getList(query);
		
		return model;
	}
	
	public List<Cita> getFutureCitasForSms(){
		List<Cita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = builder.createQuery(getModelClass());
		Root<Cita> root = query.from(getModelClass());
		query.select(root)
			.where(builder.and(builder.greaterThan(root.get(Cita_.date), new Date()),
					builder.equal(root.get(Cita_.enviadosms), false)));
		
		model = getList(query);
		
		return model;
	}
	
	public List<Cita> getCitasByDateAndStatus(Cita params){
		List<Cita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = builder.createQuery(getModelClass());
		Root<Cita> root = query.from(getModelClass());
		
		Predicate date = builder.equal(root.get(Cita_.date), params.getDate());
		Predicate status = builder.equal(root.get(Cita_.statuscita), params.getStatuscita());
		
		query.select(root).where(builder.and(date, status));
		
		model = getList(query);
		
		return model;
	}
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
}
