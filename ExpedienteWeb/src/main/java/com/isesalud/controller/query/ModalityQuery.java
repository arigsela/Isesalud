/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import com.isesalud.ejb.query.ModalityEjb;
import com.isesalud.model.Modality;
import com.isesalud.support.components.BaseQueryController;

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

	
	@Override
	protected List<Modality> getQueryList() {
	return ejb.getAllModalities();
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

	
}
