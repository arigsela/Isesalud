/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.StudyEjb;
import com.isesalud.model.Department;
import com.isesalud.model.Study;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class StudyQuery extends BaseQueryController<Study> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287350645840967475L;
	
	@EJB
	private StudyEjb manager;
	
	private Study study;

	@Override
	protected List<Study> getQueryList() {
		return manager.getStudiesbyType(study);
	}
	
	@Override
	protected void initComponents() throws BaseException {
		setStudy(new Study());
		Department department = new Department();
		department.setId(1L);
		getStudy().setDepartment(department);
		super.initComponents();
	}
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

	public Study getStudy() {
		return study;
	}
	
	public void setStudy(Study study) {
		this.study = study;
	}
	
	@SuppressWarnings("cdi-observer")
	public void updateSelectMenu(@Observes(notifyObserver=Reception.IF_EXISTS) Department dept){
		this.study.setDepartment(dept);
		loadData();
	}
}
