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
import com.isesalud.model.resultadoImagen;
import com.isesalud.model.resultadoImagen_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class resultadoImagenEjb extends BaseManagerEJB<resultadoImagen>{
	
	public List<resultadoImagen> getAllResultados(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<resultadoImagen> query = builder.createQuery(getModelClass());
		Root<resultadoImagen> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	public List<resultadoImagen> getResultado(resultadoImagen params){
		List<resultadoImagen> model =null;
		List<Predicate> predicates = new ArrayList<Predicate>();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<resultadoImagen> query = builder.createQuery(getModelClass());
		Root<resultadoImagen> root = query.from(getModelClass());
		Predicate paciente = builder.equal(root.get(resultadoImagen_.paciente), params.getPaciente());
		predicates.add(paciente);
		Predicate and = builder.and(predicates.toArray(new Predicate[]{}));
		query.select(root).where(and);

		model = getList(query);
		
		return model;
	}
	@Override
	public Class<resultadoImagen> getModelClass() {
		return resultadoImagen.class;
	}
	
}
