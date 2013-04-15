/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.isesalud.model.Department;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Stateless
@LocalBean
public class DepartmentPersistenceEjb extends BasePersistenceManagerEJB<Department>{

	@Override
	public Class<Department> getModelClass() {
		return Department.class;
	}
	
}
