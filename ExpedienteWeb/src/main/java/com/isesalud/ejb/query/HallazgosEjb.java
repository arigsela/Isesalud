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
import com.isesalud.model.Hallazgos;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class HallazgosEjb extends BaseManagerEJB<Hallazgos>{

	public List<Hallazgos> getAllHallazgos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Hallazgos> query = builder.createQuery(getModelClass());
		Root<Hallazgos> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<Hallazgos> getModelClass() {
		return Hallazgos.class;
	}

}
