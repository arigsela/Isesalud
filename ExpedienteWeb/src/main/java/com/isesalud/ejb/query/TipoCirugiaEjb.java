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
import com.isesalud.model.TipoCirugia;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@LocalBean
@Stateless
public class TipoCirugiaEjb extends BaseManagerEJB<TipoCirugia>{

	public List<TipoCirugia> getAllTiposCirugia(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoCirugia> query = builder.createQuery(getModelClass());
		Root<TipoCirugia> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoCirugia> getModelClass() {
		return TipoCirugia.class;
	}
}
