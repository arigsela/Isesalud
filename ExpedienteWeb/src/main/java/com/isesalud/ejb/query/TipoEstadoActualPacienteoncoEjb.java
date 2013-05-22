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
import com.isesalud.model.TipoEstadoActualPacienteOnco;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoEstadoActualPacienteoncoEjb extends BaseManagerEJB<TipoEstadoActualPacienteOnco>{

	public List<TipoEstadoActualPacienteOnco> getAllTiposEstadoActualPacienteOnco(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TipoEstadoActualPacienteOnco> query = builder.createQuery(getModelClass());
		Root<TipoEstadoActualPacienteOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}

	@Override
	public Class<TipoEstadoActualPacienteOnco> getModelClass() {
		return TipoEstadoActualPacienteOnco.class;
	}
}
