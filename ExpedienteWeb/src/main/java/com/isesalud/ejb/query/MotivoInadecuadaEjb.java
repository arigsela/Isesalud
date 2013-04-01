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
import com.isesalud.model.MotivoInadecuada;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MotivoInadecuadaEjb extends BaseManagerEJB<MotivoInadecuada>{
	public List<MotivoInadecuada> getAllMotivos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MotivoInadecuada> query = builder.createQuery(getModelClass());
		Root<MotivoInadecuada> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<MotivoInadecuada> getModelClass() {
		return MotivoInadecuada.class;
	}
	
}
