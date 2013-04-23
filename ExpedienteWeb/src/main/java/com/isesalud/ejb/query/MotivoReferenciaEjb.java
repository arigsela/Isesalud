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
import com.isesalud.model.MotivoReferencia;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MotivoReferenciaEjb extends BaseManagerEJB<MotivoReferencia>{
	
	public List<MotivoReferencia> getAllMotivos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MotivoReferencia> query = builder.createQuery(getModelClass());
		Root<MotivoReferencia> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<MotivoReferencia> getModelClass() {
		return MotivoReferencia.class;
	}
}
