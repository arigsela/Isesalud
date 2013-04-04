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
import com.isesalud.model.resultadoImagen;
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

	@Override
	public Class<resultadoImagen> getModelClass() {
		return resultadoImagen.class;
	}
	
}
