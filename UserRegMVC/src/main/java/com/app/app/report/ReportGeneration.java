package com.app.app.report;

import java.util.List;

import com.app.app.pojos.User;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class ReportGeneration{
	public void generateReport(List<User> users) throws Exception {
		String reportTemplatePath = "D:\\CDAC\\JAVA2\\LabAssignments\\UserRegMVC\\src\\main\\java\\com\\app\\app\\report\\JasperReport.jrxml";
		JasperDesign jasperDesign = JRXmlLoader.load(reportTemplatePath);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
		String outputPath = "D:\\CDAC\\JAVA2\\LabAssignments\\UserRegMVC\\src\\main\\java\\com\\app\\app\\report\\Users.pdf";
		JasperExportManager.exportReportToPdfFile(print, outputPath);
	}
}
