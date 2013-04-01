/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.isesalud.ejb.persistence.UserPersistenceEjb;
import com.isesalud.ejb.query.RoleEjb;
import com.isesalud.ejb.query.UserEjb;
import com.isesalud.model.Role;
import com.isesalud.model.User;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;
import com.isesalud.support.exceptions.OperationException;


/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ConversationScoped
public class UserPersistence extends BaseManagedCrudController<User, UserPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3690853095759147481L;
	
	private List<Role> roleList;
	private List<Role> selectedRoleList;
	
	private DualListModel<Role> roles = new DualListModel<Role>();
	
	@EJB
	private UserPersistenceEjb manager;
	
	@EJB
	private RoleEjb roleManager;
	
	@EJB
	private UserEjb userManager;
	
	@Inject
	private Conversation conversation;
	
	public DualListModel<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(DualListModel<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		roleList = roleManager.getRoles();
		selectedRoleList = new ArrayList<Role>();
		
		setRoles(new DualListModel<Role>(roleList, selectedRoleList));
		
		super.doAfterAdd();
	}
	
	@Override
	protected void doAfterEdit() throws BaseException {
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		roleList = roleManager.getRoles();
		selectedRoleList = new ArrayList<Role>(getModel().getRoles());
		
		setRoles(new DualListModel<Role>(roleList, selectedRoleList));
		
		super.doAfterEdit();
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		if(roles.getTarget().size() == 0){
			throw new OperationException("No se especifico ningun rol para el usuario");
		}
		
		User user = userManager.getUserByUsername(getModel());
		if(user != null){
			throw new OperationException("El usuario ya existe.");
		}
		
		log.infov("Saving user {0} {1} {2}", getModel().getName(),
				getModel().getfName(),
				getModel().getmName());
		
		getModel().setRoles(new HashSet<Role>(roles.getTarget()));
		super.doBeforeSave();
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		roles = null;
		roleList = null;
		selectedRoleList = null;
		
		if(!conversation.isTransient()){
			conversation.end();
		}
	}
	
	@Override
	protected void doAfterCancel() throws BaseException {
		roles = null;
		roleList = null;
		selectedRoleList = null;
		super.doAfterCancel();
		
		if(!conversation.isTransient()){
			conversation.end();
		}
	}

	@Override
	protected UserPersistenceEjb getCrudManager() {
		return manager;
	}

	@Override
	protected User getNewModel() {
		return new User();
	}

	@Override
	protected String getAddRole() {
		return null;
	}

	@Override
	protected String getEditRole() {
		return null;
	}

	@Override
	protected String getDeleteRole() {
		return null;
	}

	@Override
	protected String getViewRole() {
		return null;
	}
}
