
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
import com.isesalud.model.ParienteCancerMama;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean

public class ParienteCancerMamaEjb extends BaseManagerEJB<ParienteCancerMama>{
	
	public List<ParienteCancerMama> getAllParientesCancerMama() {
	CriteriaBuilder builder = em.getCriteriaBuilder();
	CriteriaQuery<ParienteCancerMama> query = builder.createQuery(getModelClass());
	Root<ParienteCancerMama> root = query.from(getModelClass());
	query.select(root);
	return getList(query);
	}

	@Override
	public Class<ParienteCancerMama> getModelClass() {
		return ParienteCancerMama.class;
	}

}
