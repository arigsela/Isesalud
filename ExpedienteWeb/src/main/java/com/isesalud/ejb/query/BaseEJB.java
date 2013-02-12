/**
 * 
 */
package com.isesalud.ejb.query;

import java.security.Principal;
import javax.annotation.Resource;
//import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import org.hibernate.envers.AuditReaderFactory;
//import com.ebizlink.pandora2.core.exception.BaseException;
//import com.ebizlink.pandora2.server.model.BaseRevisionModel;

public abstract class BaseEJB
{
	@PersistenceContext
	protected EntityManager em;

	@Resource
	protected SessionContext sc;

	//@EJB
	//protected BaseRevisionManager<? extends BaseRevisionModel> rm;

	/**
	 */
	public Principal getPrincipal()
	{
		return sc.getCallerPrincipal();
	}

	/**
	 */
	/*protected void doAudit() throws BaseException
	{
		//AuditReaderFactory.get(em).getCurrentRevision(rm.getRevisionModelClass(), false).setUserName(getPrincipal().getName());
	}*/
}
