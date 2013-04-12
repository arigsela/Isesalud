/**
 * 
 */
package com.isesalud.ejb.query;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.isesalud.model.ResultadoImagen;
import com.isesalud.model.ResultadoImagen_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ResultadoImagenEjb extends BaseManagerEJB<ResultadoImagen>{
	
	public List<ResultadoImagen> getAllResultados(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ResultadoImagen> query = builder.createQuery(getModelClass());
		Root<ResultadoImagen> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	public List<ResultadoImagen> getResultado(ResultadoImagen params){
		List<ResultadoImagen> model =null;
		List<Predicate> predicates = new ArrayList<Predicate>();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ResultadoImagen> query = builder.createQuery(getModelClass());
		Root<ResultadoImagen> root = query.from(getModelClass());
		Predicate paciente = builder.equal(root.get(ResultadoImagen_.paciente), params.getPaciente());
		predicates.add(paciente);
		Predicate and = builder.and(predicates.toArray(new Predicate[]{}));
		query.select(root).where(and);

		model = getList(query);
		
		return model;
	}

	@Override
	public Class<ResultadoImagen> getModelClass() {
		return ResultadoImagen.class;
	}
	
}
