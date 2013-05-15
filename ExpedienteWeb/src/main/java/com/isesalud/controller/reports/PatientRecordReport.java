/**
 * 
 */
package com.isesalud.controller.reports;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.omnifaces.util.Faces;

import com.isesalud.controller.support.PatientSelection;
import com.isesalud.support.components.BaseComponent;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@SessionScoped
public class PatientRecordReport extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7053363833129951785L;
	
	@Inject
	private PatientSelection patientSelection;
	
	public void jasperTest(ActionEvent event){
		if(patientSelection.getPaciente() == null)
			return;
		log.info("Generating patient record report");
		Connection con = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String dbName = "Isesalud";
		String dbUser = "root";
		String dbPassword = "Radiologia123";
		byte[] pdf = null;
		
		InputStream reportTemplate = this.getClass().getResourceAsStream("/ExpedientePaciente.jasper");
		
		try{
			JasperReport report = (JasperReport) JRLoader.loadObject(reportTemplate);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, dbUser, dbPassword);
			params.put("patientId", patientSelection.getPaciente().getId());
			JasperPrint printer = JasperFillManager.fillReport(report, params, con);
			pdf = JasperExportManager.exportReportToPdf(printer);
			Faces.sendFile(pdf, "Expediente.pdf", false);
		} catch (JRException e){
			log.error(e.getMessage());
		} catch (SQLException e){
			log.error(e.getMessage());
		} catch (ClassNotFoundException e){
			log.error(e.getMessage());
		} catch (IllegalAccessException e){
			log.error(e.getMessage());
		} catch (InstantiationException e){
			log.error(e.getMessage());
		} catch (IOException e){
			log.error(e.getMessage());
		}
		
		
	}

}
