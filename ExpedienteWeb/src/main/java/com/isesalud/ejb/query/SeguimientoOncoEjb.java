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
import com.isesalud.model.SeguimientoOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class SeguimientoOncoEjb extends BaseManagerEJB<SeguimientoOnco>{
	
	public List<SeguimientoOnco> getAllSeguimientosOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SeguimientoOnco> query = builder.createQuery(getModelClass());
		Root<SeguimientoOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<SeguimientoOnco> getModelClass() {
		return SeguimientoOnco.class;
	}
}
