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
import com.isesalud.model.SintomaCancerMama;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean

public class SintomaCancerMamaEjb extends BaseManagerEJB<SintomaCancerMama>{

	public List<SintomaCancerMama> getAllSintomasCancerMama() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SintomaCancerMama> query = builder.createQuery(getModelClass());
		Root<SintomaCancerMama> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<SintomaCancerMama> getModelClass() {
		return SintomaCancerMama.class;
	}

}
