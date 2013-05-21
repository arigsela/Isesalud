package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.isesalud.model.HistoriaClinicaOnco;
import com.isesalud.model.HistoriaClinicaOnco_;
import com.isesalud.support.components.BaseManagerEJB;

@Stateless
@LocalBean
public class ResultadoOncologiaEjb extends BaseManagerEJB<HistoriaClinicaOnco>{

	public List<HistoriaClinicaOnco> getAllResultados(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<HistoriaClinicaOnco> query = builder.createQuery(getModelClass());
		Root<HistoriaClinicaOnco> root = query.from(getModelClass());
		query.select(root);
		return getList(query);
	}
	
	public List<HistoriaClinicaOnco> getResultadosByPatient(HistoriaClinicaOnco params){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<HistoriaClinicaOnco> query = builder.createQuery(getModelClass());
		Root<HistoriaClinicaOnco> root = query.from(getModelClass());
		query.select(root).where(builder.equal(root.get(HistoriaClinicaOnco_.paciente), params.getPaciente()));
		return getList(query);
	}

	@Override
	public Class<HistoriaClinicaOnco> getModelClass() {
		return HistoriaClinicaOnco.class;
	}
}
