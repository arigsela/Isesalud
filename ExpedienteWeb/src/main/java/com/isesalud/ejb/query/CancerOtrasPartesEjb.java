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
import com.isesalud.model.CancerOtrasPartes;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean

public class CancerOtrasPartesEjb extends BaseManagerEJB<CancerOtrasPartes>{

	public List<CancerOtrasPartes> getAllCancerOtrasPartes() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<CancerOtrasPartes> query = builder.createQuery(getModelClass());
		Root<CancerOtrasPartes> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	
	@Override
	public Class<CancerOtrasPartes> getModelClass() {
		return CancerOtrasPartes.class;
	}

}
