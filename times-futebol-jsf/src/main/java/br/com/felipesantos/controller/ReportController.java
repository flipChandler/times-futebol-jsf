package br.com.felipesantos.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.felipesantos.dao.Person;
import br.com.felipesantos.util.UtilRelatorios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "reportController")
@ViewScoped
public class ReportController {
	
	@PostConstruct
	public void init() {
		
	}
	
	public void printPdf() throws JRException, IOException {
		List<Person> dataSource = new ArrayList<>();
		dataSource.add(new Person("Felipe", "Santos"));
		dataSource.add(new Person("Mikail", "Gorbachev"));
		dataSource.add(new Person("Martin", "King"));
		dataSource.add(new Person("Samuel", "Jackson"));
		String fileName = "names.pdf";
		String jasperPath = "/WEB-INF/reports/gonzalo.jasper";
		// this.getPdf(null, jasperPath, dataSource, fileName); 
		
		Map<String, Object> params = new HashMap<>();
		params.put("shipperName", "CEVA Ltda - 012522522500001-10");
		
		UtilRelatorios.imprimeRelatorio("gonzalo", params, dataSource);
	}
	
	public void getPdf(
			Map<String, Object> params, 
			String jasperPath, 
			List<?> dataSource,
			String fileName) throws JRException, IOException {
		String relativeWebpath = FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRealPath(jasperPath);
		
		File file = new File(relativeWebpath);
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
		JasperPrint jasperPrint = JasperFillManager.fillReport(file.getPath(), params, source);
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext()
				.getResponse();
		response.addHeader("Content-disposition", "attachment;filename=" + fileName);
		ServletOutputStream stream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		FacesContext.getCurrentInstance().responseComplete();
	}
}
