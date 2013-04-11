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
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

import com.isesalud.ejb.persistence.UserPersistenceEjb;
import com.isesalud.ejb.query.RoleEjb;
import com.isesalud.ejb.query.UserEjb;
import com.isesalud.model.Role;
import com.isesalud.model.User;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.components.EditModeEnum;
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
	
	private boolean hashPassword;
	
	private final String editUserDlg = "NewUserDialog.show()";
	private final String editPassDlg = "PasswordChangeDlg.show()";
	
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
	
	@Inject @Any
	private Event<User> userEvent;
	
	public DualListModel<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(DualListModel<Role> roles) {
		this.roles = roles;
	}
	
	private void loadDataIntoPickList(boolean edit){
		
		roleList = roleManager.getRoles();
		selectedRoleList = new ArrayList<Role>(getModel().getRoles());
		
		if(edit){
			roleList.removeAll(selectedRoleList);
		}
		
		setRoles(new DualListModel<Role>(roleList, selectedRoleList));
	}
	
	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		loadDataIntoPickList(false);
		
		getModel().setEnabled(true);
		
		super.doAfterAdd();
	}
	
	@Override
	protected void doAfterEdit() throws BaseException {
		
		getModel().setHashPassword(hashPassword);
		
		loadDataIntoPickList(true);
		
		super.doAfterEdit();
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		if(roles.getTarget().size() == 0){
			throw new OperationException("No se especifico ningun rol para el usuario");
		}
		
		if(getEditMode() == EditModeEnum.ADDING){
			User user = userManager.getUserByUsername(getModel());
			if(user != null){
				throw new OperationException("El usuario ya existe.");
			}
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
		
		userEvent.fire(getModel());
		
		if(!conversation.isTransient()){
			conversation.end();
		}
	}
	
	@Override
	protected void doAfterDelete() throws BaseException {
		userEvent.fire(getModel());
		super.doAfterDelete();
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
	
	public boolean isEditMode(){
		return (getEditMode() == EditModeEnum.EDITING) ? true : false;
	}
	
	private void setHashParam(ActionEvent e){
		String hashPass = (String) e.getComponent().getAttributes().get("hashPass");
		if(hashPass.equals("true"))
			this.hashPassword = true;
		else if (hashPass.equals("false"))
			this.hashPassword = false;
	}
	
	@Override
	public void add(ActionEvent actionEvent) {
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		super.add(actionEvent);
	}
	
	@Override
	public void edit(ActionEvent actionEvent) {
		
		if(getModel().isEmpty()){
			JSFUtil.error("Seleccione a un usuario primero de la tabla");
			return;
		}
		
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		setHashParam(actionEvent);
		
		super.edit(actionEvent);
		
		RequestContext ctx = RequestContext.getCurrentInstance();
		
		if(hashPassword)
			ctx.execute(editPassDlg);
		else
			ctx.execute(editUserDlg);
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
