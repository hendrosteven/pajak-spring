package com.brainmatic.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/user/print")
public class UserPrintController {


	@Autowired
	DataSource dataSource;

	@RequestMapping(method = RequestMethod.GET)
	public void printReport(HttpServletResponse response) {
		try {
			InputStream jasperStream = this.getClass()
					.getResourceAsStream("/user_list.jasper");
			JasperReport jasperReport = (JasperReport) 
					JRLoader.loadObject(jasperStream);
			Map<String, Object> param = new HashMap<>();
			JasperPrint jasperPrint = JasperFillManager
					.fillReport(jasperReport, param, dataSource.getConnection());
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=User-List.pdf");
			final OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
