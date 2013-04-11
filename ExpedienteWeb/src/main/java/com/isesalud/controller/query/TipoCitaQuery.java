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
import com.isesalud.ejb.query.TipocitaEjb;
import com.isesalud.model.Tipocita;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Ari G. Sela M.
 *
 */

@Named
@ViewScoped
public class TipoCitaQuery extends BaseQueryController<Tipocita>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -898892696853006426L;
	
	@EJB
	private TipocitaEjb ejb;
	
	private Tipocita selectedTipoCita;
	
	public Tipocita getSelectedTipoCita() {
		return selectedTipoCita;
	}
	
	public void setSelectedTipoCita(Tipocita selectedTipoCita) {
		this.selectedTipoCita = selectedTipoCita;
	}
	
	@Inject @Any
	private Event<Tipocita> tipoCitaChanged;

	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Tipocita> getQueryList() {
		return ejb.getAllTipoCita();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
	public void onTipocitaValueChanged(ValueChangeEvent e){
		if(e.getNewValue() != null && e.getNewValue().getClass() == Tipocita.class){
			tipoCitaChanged.fire((Tipocita)e.getNewValue());
		}
	}
}
