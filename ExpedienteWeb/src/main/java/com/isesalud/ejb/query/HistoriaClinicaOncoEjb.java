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
import com.isesalud.model.HistoriaClinicaOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@LocalBean
@Stateless
public class HistoriaClinicaOncoEjb extends BaseManagerEJB<HistoriaClinicaOnco>{

	public List<HistoriaClinicaOnco> getAllHistoriasClinicasOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<HistoriaClinicaOnco> query = builder.createQuery(getModelClass());
		Root<HistoriaClinicaOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<HistoriaClinicaOnco> getModelClass() {
		return HistoriaClinicaOnco.class;
	}
}
