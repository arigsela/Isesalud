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
import com.isesalud.model.Department;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Stateless
@LocalBean
public class DepartmentEjb extends BaseManagerEJB<Department>{

	public List<Department> getAllDepartments(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Department> query = builder.createQuery(getModelClass());
		Root<Department> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	@Override
	public Class<Department> getModelClass() {
		return Department.class;
	}
	

}
