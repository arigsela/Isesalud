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
import com.isesalud.ejb.query.DepartmentEjb;
import com.isesalud.model.Department;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Ari G. Sela M.
 *
 */

@Named
@ViewScoped
public class DepartmentQuery extends BaseQueryController<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -898892696853006426L;
	
	@EJB
	private DepartmentEjb ejb;
	
	private Department selectedDepartment;

	public Department getSelectedDepartment() {
		return selectedDepartment;
	}
	
	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}
	
	@Inject @Any
	private Event<Department> departmentChanged;

	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Department> getQueryList() {
		return ejb.getAllDepartments();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
	public void onDepartmentValueChanged(ValueChangeEvent e){
		if(e.getNewValue() != null && e.getNewValue().getClass() == Department.class){
			departmentChanged.fire((Department)e.getNewValue());
		}
	}
}
