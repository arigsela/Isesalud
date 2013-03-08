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
import com.isesalud.model.Statuscita;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Stateless
@LocalBean
public class StatusCitaEjb extends BaseManagerEJB<Statuscita>{

	public List<Statuscita> getAllStatusCita(){
		List<Statuscita> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Statuscita> query = builder.createQuery(getModelClass());
		Root<Statuscita> root = query.from(getModelClass());
		query.select(root);
		
		model = getList(query);
		
		return model;
	}
	
	@Override
	public Class<Statuscita> getModelClass() {
		return Statuscita.class;
	}
	
}
