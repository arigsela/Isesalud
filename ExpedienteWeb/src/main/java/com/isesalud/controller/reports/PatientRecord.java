/**
 * 
 */
package com.isesalud.controller.reports;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.solder.resourceLoader.Resource;
import org.omnifaces.util.Faces;

import com.isesalud.controller.reports.engine.ReportGenerator;
import com.isesalud.controller.support.PatientSelection;
import com.isesalud.support.components.BaseController;


/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@RequestScoped
public class PatientRecord extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 449627322516785897L;
	
	@Inject @Resource("WEB-INF/classes/ExpedientePaciente.jasper")
	private InputStream reportTemplate;
	
	@Inject
	private ReportGenerator generator;
	
	@Inject
	private PatientSelection patientSelection;
	
	public void loadReport(ActionEvent e){
		Long patId = (Long)e.getComponent().getAttributes().get("patientId");
		boolean attach;
		
		if(patId == null){
			patId = patientSelection.getPaciente().getId();
			attach = false;
		} else {
			attach = true;
		}
	
		try {
			
			final Map<String, Object> params = new HashMap<String, Object>();
			params.put("patientId", patId);
			final byte[] pdf = generator.generateReport(this.reportTemplate, params);
			Faces.sendFile(pdf, "ExpedientePaciente.pdf", attach);
		} catch (IOException ex) {
			log.error(ex.getMessage());
		}
	}

	@Override
	protected String getViewRole() {
		return null;
	}

}
