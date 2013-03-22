/**
 * 
 */
package com.isesalud.ejb.query;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.isesalud.model.User;
import com.isesalud.model.User_;
import com.isesalud.support.components.BaseManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class UserEjb extends BaseManagerEJB<User> {

	@Override
	public Class<User> getModelClass() {
		return User.class;
	}
	
	public User getUserByUsername(User params){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(getModelClass());
		Root<User> root = query.from(getModelClass());
		query.select(root);
		query.where(builder.equal(root.get(User_.username), params.getUsername()));
		return getUnique(query);
	}
	
	public List<User> getUserList(User params){
		List<User> model = null;
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(getModelClass());
		Root<User> root = query.from(getModelClass());
		query.select(root);
		
		Predicate likeNameRestriction = builder.like(root.get(User_.name), params.getName() + "%");
		Predicate likeFNameRestriction = builder.like(root.get(User_.fName), params.getfName() + "%");
		Predicate likeMNameRestriction = builder.like(root.get(User_.mName), params.getmName() + "%");
		
		query.where(builder.and(likeNameRestriction, likeFNameRestriction, likeMNameRestriction));
		
		model = getList(query);
		
		return model;
	}

}
