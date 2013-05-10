/**
 * 
 */
package com.isesalud.controller.reports.engine;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import com.isesalud.support.components.BaseComponent;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public class ReportGenerator extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7053363833129951785L;
	
	public byte[] generateReport(InputStream reportTemplate, Map<String, Object> params){
		if(reportTemplate == null)
			return null;
		
		Connection con = null;
		String dbDataSource = System.getProperty("com.isesalud.jasper.datasource");
		String dbName = System.getProperty("com.isesalud.jasper.dbname");
		String dbUser = System.getProperty("com.isesalud.jasper.dbuser");
		String dbPassword = System.getProperty("com.isesalud.jasper.dbpass");
		byte[] pdf = null;
		
		try{
			JasperReport report = (JasperReport) JRLoader.loadObject(reportTemplate);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(dbDataSource + dbName, dbUser, dbPassword);
			JasperPrint printer = JasperFillManager.fillReport(report, params, con);
			pdf = JasperExportManager.exportReportToPdf(printer);
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
		}
		
		return pdf;
	}

}
