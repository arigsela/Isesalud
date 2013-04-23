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
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ResultadoImagen> query = builder.createQuery(getModelClass());
		Root<ResultadoImagen> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(ResultadoImagen_.paciente), params.getPaciente()));
		
		model = getList(query);
		
		return model;
	}

	@Override
	public Class<ResultadoImagen> getModelClass() {
		return ResultadoImagen.class;
	}
	
}
