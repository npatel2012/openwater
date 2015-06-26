package com.externalui.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.externalui.example.client.jbpm.BpmsClientThread;

public class SimpleServlet extends HttpServlet { 
	
	/**
	 * Auto generated code
	 */
	private static final long serialVersionUID = 1L;
	private String processId = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		
		// reading user inputs 
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("fi_retailerName", request.getParameter("efi_retailerName"));
		hm.put("fi_retailerID", request.getParameter("efi_retailerID"));
		hm.put("fi_contactEmail", request.getParameter("efi_contactEmail"));
		hm.put("fi_spid", request.getParameter("efi_spid"));
		hm.put("fi_address", request.getParameter("efi_address"));
		hm.put("fi_otherAddress", request.getParameter("efi_otherAddress"));
		hm.put("fi_otherDetails", request.getParameter("efi_otherDetails"));
		hm.put("fi_typeOfWork", request.getParameter("efi_typeOfWork"));
		hm.put("fi_installMeterType", request.getParameter("efi_installMeterType"));
		hm.put("fi_installMeterSize", request.getParameter("efi_installMeterSize") + "tempstring");
		hm.put("fi_installMeterDetails", request.getParameter("efi_installMeterDetails"));
		hm.put("fi_contactNHH", request.getParameter("efi_contactNHH"));
		hm.put("fi_contactName", request.getParameter("efi_contactName"));
		hm.put("fi_contactNumber", request.getParameter("efi_contactNumber") + "tempstring");
		hm.put("fi_notifyRetailerOfFieldVisit", request.getParameter("efi_notifyRetailerOfFieldVisit"));
	
		for (String key : hm.keySet()) {
			System.out.println(key + " " + hm.get(key) + " " + hm.get(key).getClass());
          }		
		
//		hm.put("numberOfTravelers", request.getParameter("numberOfTravelers") + "i"); // special case where the integer value should be submitted by appending "i" in the end to avoid java.lang.ClassCastException
		
		System.out.println("=====> Before sending request: HashMap values are: \n" + hm);
		BpmsClientThread t = new BpmsClientThread();
		processId = t.starBusinessProcess(hm);
		System.out.println("=====> After sending request: ");
		
		response.setCharacterEncoding("ISO-8859-1");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String content = "";
		
		if (processId == null) {
			content = getContent(getServletContext().getRealPath(File.separator) + "error.html");
		} else {
			content = getContent(getServletContext().getRealPath(File.separator) + "success_response.html");
			content = content.replace("CHANGEMEPROCESSID", processId);
		}
		
		out.println (content); 
	}

	private String getContent(String file) {
		String tempContent = ""; 
		try {
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String str;
	        
	        while ((str = in.readLine()) != null) {
	            tempContent +=str;
	        }
	        in.close();
	    } catch (IOException e) {
	    	System.out.println("IOException caught: ");
	    	e.printStackTrace();
	    }
		return tempContent;
	}
}
