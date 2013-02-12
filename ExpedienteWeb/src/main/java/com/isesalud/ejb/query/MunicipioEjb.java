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

import com.isesalud.model.Municipio;

/**
 * @author Haysoos
 *
 */
@Stateless
@LocalBean
public class MunicipioEjb extends BaseManagerEJB<Municipio> {

	public List<Municipio> getAllMunicipios(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Municipio> query = builder.createQuery(getModelClass());
		Root<Municipio> root = query.from(getModelClass());
		query.select(root);
		
		return getList(query);
	}
	
	@Override
	public Class<Municipio> getModelClass() {
		return Municipio.class;
	}

}
