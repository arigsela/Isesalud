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
import com.isesalud.model.TipoTratamientoQuimio;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoTratamientoQuimioEjb extends BaseManagerEJB<TipoTratamientoQuimio>{

	public List<TipoTratamientoQuimio> getAllTiposTratamientoQuimio(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoTratamientoQuimio> query = builder.createQuery(getModelClass());
		Root<TipoTratamientoQuimio> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoTratamientoQuimio> getModelClass() {
		return TipoTratamientoQuimio.class;
	}
}
