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
import com.isesalud.model.SystemSettings;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class SystemSettingsEjb extends BaseManagerEJB<SystemSettings> {
	
	public List<SystemSettings> getAllSystemSettings(){
		List<SystemSettings> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SystemSettings> query = builder.createQuery(getModelClass());
		Root<SystemSettings> root = query.from(getModelClass());
		query.select(root);
		model = getList(query);
		return model;
	}
	
	@Override
	public Class<SystemSettings> getModelClass() {
		return SystemSettings.class;
	}
	

}
