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
import com.isesalud.model.ComplicacionOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ComplicacionOncoEjb extends BaseManagerEJB<ComplicacionOnco>{

	public List<ComplicacionOnco> getAllComplicacionesOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ComplicacionOnco> query = builder.createQuery(getModelClass());
		Root<ComplicacionOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<ComplicacionOnco> getModelClass() {
		return ComplicacionOnco.class;
	}
	
}
