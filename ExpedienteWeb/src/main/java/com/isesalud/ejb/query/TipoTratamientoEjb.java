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
import com.isesalud.model.TipoTratamiento;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoTratamientoEjb extends BaseManagerEJB<TipoTratamiento>{

	public List<TipoTratamiento> getAllTiposTratamiento(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoTratamiento> query = builder.createQuery(getModelClass());
		Root<TipoTratamiento> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoTratamiento> getModelClass() {
		return TipoTratamiento.class;
	}
}
