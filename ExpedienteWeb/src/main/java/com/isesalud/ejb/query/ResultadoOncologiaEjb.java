package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.isesalud.model.ResultadoOncologia;
import com.isesalud.support.components.BaseManagerEJB;

@Stateless
@LocalBean
public class ResultadoOncologiaEjb extends BaseManagerEJB<ResultadoOncologia>{

	public List<ResultadoOncologia> getAllResultados(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ResultadoOncologia> query = builder.createQuery(getModelClass());
		Root<ResultadoOncologia> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<ResultadoOncologia> getModelClass() {
		return ResultadoOncologia.class;
	}
}
