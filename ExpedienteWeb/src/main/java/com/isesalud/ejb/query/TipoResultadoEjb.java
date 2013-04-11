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
import com.isesalud.model.TipoResultado;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoResultadoEjb extends BaseManagerEJB<TipoResultado>{
	
	public List<TipoResultado> getAllTiposResultados(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoResultado> query = builder.createQuery(getModelClass());
		Root<TipoResultado> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoResultado> getModelClass() {
		return TipoResultado.class;
	}
	
}
