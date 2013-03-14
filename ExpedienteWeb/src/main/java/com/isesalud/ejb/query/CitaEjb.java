/**
 * 
 */
package com.isesalud.ejb.query;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.isesalud.model.Cita;
import com.isesalud.model.Cita_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Ari G. Sela M.
 *
 */

@Stateless
@LocalBean
public class CitaEjb extends BaseManagerEJB<Cita>{

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
		
		Predicate startDateP = builder.greaterThanOrEqualTo(root.get(Cita_.date), params.getStartDate());
		Predicate endDateP = builder.lessThanOrEqualTo(root.get(Cita_.date), params.getEndDate());
		
		query.select(root).where(builder.and(startDateP, endDateP));
		
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
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
}
