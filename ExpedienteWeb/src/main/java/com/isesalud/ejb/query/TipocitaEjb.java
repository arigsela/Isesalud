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
import com.isesalud.model.Tipocita;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Stateless
@LocalBean
public class TipocitaEjb extends BaseManagerEJB<Tipocita>{

	public List<Tipocita> getAllTipoCita(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tipocita> query = builder.createQuery(getModelClass());
		Root<Tipocita> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	@Override
	public Class<Tipocita> getModelClass() {
		return Tipocita.class;
	}
	

}
