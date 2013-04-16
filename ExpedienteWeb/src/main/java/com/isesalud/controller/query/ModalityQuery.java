/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import com.isesalud.ejb.query.ModalityEjb;
import com.isesalud.model.Department;
import com.isesalud.model.Modality;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class ModalityQuery extends BaseQueryController<Modality>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2608730413367939219L;
	
	private Modality selectedmodality;
	
	private Modality modality;
	
	public Modality getSelectedmodality() {
		return selectedmodality;
	}
	
	public void setSelectedmodality(Modality selectedmodality) {
		this.selectedmodality = selectedmodality;
	}
	
	@EJB
	private ModalityEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}
	
	@Inject @Any
	private Event<Modality> modalityChanged;

	protected void initComponents() throws BaseException {
		setModality(new Modality());
		Department department = new Department();
		department.setId(1L);
		getModality().setDepartment(department);
		super.initComponents();
	}
	
	public Modality getModality() {
		return modality;
	}
	
	public void setModality(Modality modality) {
		this.modality = modality;
	}
	
	@Override
	protected List<Modality> getQueryList() {
	return ejb.getModalitiesByDepartment(modality);
	}
	
	@Override
	protected int getQueryRowCount() {
		return 0;
	}

	public void onModalityValueChanged(ValueChangeEvent e){
		if(e.getNewValue() != null && e.getNewValue().getClass() == Modality.class){
			modalityChanged.fire((Modality)e.getNewValue());
		}
	}
	
	@SuppressWarnings("cdi-observer")
	public void updateSelectMenu(@Observes(notifyObserver=Reception.IF_EXISTS) Department department){
		this.modality.setDepartment(department);
		loadData();
	}

	
}
