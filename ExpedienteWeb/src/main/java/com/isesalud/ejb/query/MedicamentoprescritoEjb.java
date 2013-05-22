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
import com.isesalud.model.MedicamentoPrescrito;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MedicamentoprescritoEjb extends BaseManagerEJB<MedicamentoPrescrito>{

	public List<MedicamentoPrescrito> getAllMedicamentosPrescritos(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<MedicamentoPrescrito> query = builder.createQuery(getModelClass());
		Root<MedicamentoPrescrito> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<MedicamentoPrescrito> getModelClass() {
		return MedicamentoPrescrito.class;
	}
}
