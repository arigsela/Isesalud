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
import com.isesalud.model.NotaEvolucionOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class NotaEvolucionOncoEjb extends BaseManagerEJB<NotaEvolucionOnco>{

	public List<NotaEvolucionOnco> getAllNotasEvolucionOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<NotaEvolucionOnco> query = builder.createQuery(getModelClass());
		Root<NotaEvolucionOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<NotaEvolucionOnco> getModelClass() {
		return NotaEvolucionOnco.class;
	}
}
