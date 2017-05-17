package com.demo.common;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.demo.util.export.XlsExporter;
import com.demo.util.export.XlsExporter.DataRetriver;

public abstract class ExportController{
	
	public static void export(HttpServletResponse response,
			DataRetriver dataRetriver,
			String[] properiesName,
			String[] headsName,
			Class beanClass,
			String fileName) {
		OutputStream  out = null;  
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName+".xls");
			out= response.getOutputStream();
			XlsExporter.export(out, dataRetriver, properiesName, headsName, beanClass, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
}
