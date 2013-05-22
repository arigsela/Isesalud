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
import com.isesalud.model.TipoMedicamento;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoMedicamentoEjb extends BaseManagerEJB<TipoMedicamento>{

	public List<TipoMedicamento> getAllTiposMedicamento(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoMedicamento> query = builder.createQuery(getModelClass());
		Root<TipoMedicamento> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoMedicamento> getModelClass() {
		return TipoMedicamento.class;
	}
}
