/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.UserEjb;
import com.isesalud.model.User;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;


/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class UsersQuery extends BaseQueryController<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8370233037948437707L;
	
	@EJB
	private UserEjb userEjb;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	protected void init() throws BaseException {
		this.user = new User();
		
		super.init();
	}

	@Override
	protected List<User> getQueryList() {
		return userEjb.getUserList(user);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
	public void OnUserCreatedOrUpdated(@Observes User user) {
		try {
			clear();
		} catch (BaseException e) {
			JSFUtil.error(e.getMessages());
		}
	}

}
