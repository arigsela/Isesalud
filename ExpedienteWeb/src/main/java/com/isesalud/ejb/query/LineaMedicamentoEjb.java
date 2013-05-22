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
import com.isesalud.model.LineaMedicamento;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class LineaMedicamentoEjb extends BaseManagerEJB<LineaMedicamento>{

	public List<LineaMedicamento> getAllLineasMedicamentos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<LineaMedicamento> query = builder.createQuery(getModelClass());
		Root<LineaMedicamento> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<LineaMedicamento> getModelClass() {
		return LineaMedicamento.class;
	}
}
