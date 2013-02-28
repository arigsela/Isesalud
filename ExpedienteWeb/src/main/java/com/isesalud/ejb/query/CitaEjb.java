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
import com.isesalud.model.Cita;
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
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
}
