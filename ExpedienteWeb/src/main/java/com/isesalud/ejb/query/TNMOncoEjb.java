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
import com.isesalud.model.TNMOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TNMOncoEjb extends BaseManagerEJB<TNMOnco>{

	public List<TNMOnco> getAllTNMOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TNMOnco> query = builder.createQuery(getModelClass());
		Root<TNMOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TNMOnco> getModelClass() {
		return TNMOnco.class;
	}
}
