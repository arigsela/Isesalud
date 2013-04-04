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
import com.isesalud.model.Gabinete;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class GabineteEjb extends BaseManagerEJB<Gabinete> {
	
	public List<Gabinete> getAllGabinetes(){
		List<Gabinete> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Gabinete> query = builder.createQuery(getModelClass());
		Root<Gabinete> root = query.from(getModelClass());
		query.select(root);
		model = getList(query);
		return model;
	}

	@Override
	public Class<Gabinete> getModelClass() {
		return Gabinete.class;
	}
	
}
