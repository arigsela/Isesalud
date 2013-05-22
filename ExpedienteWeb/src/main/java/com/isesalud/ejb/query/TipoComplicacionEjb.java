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
import com.isesalud.model.TipoComplicacion;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoComplicacionEjb extends BaseManagerEJB<TipoComplicacion>{

	public List<TipoComplicacion> getAllTiposComplicacion(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoComplicacion> query = builder.createQuery(getModelClass());
		Root<TipoComplicacion> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoComplicacion> getModelClass() {
		return TipoComplicacion.class;
	}
}
