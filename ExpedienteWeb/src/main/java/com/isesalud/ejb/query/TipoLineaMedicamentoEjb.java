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
import com.isesalud.model.TipoLineaMedicamento;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoLineaMedicamentoEjb extends BaseManagerEJB<TipoLineaMedicamento>{
	
	public List<TipoLineaMedicamento> getAllTiposLIneaMedicamento(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoLineaMedicamento> query = builder.createQuery(getModelClass());
		Root<TipoLineaMedicamento> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoLineaMedicamento> getModelClass() {
		return TipoLineaMedicamento.class;
	}
}
