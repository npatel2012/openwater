package com.externalui.example.client.jbpm;


import static javax.xml.xpath.XPathConstants.STRING;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class BpmsClientThread {

	// BPMS connection values
    public String server = "http://localhost:8080/business-central/";
    public String username = "adminuser";
    public String password = "bpmsuite1!";
    
    // Default sample input values
	private String fi_retailerName = "Default RetailerName";
	private String fi_retailerID = "Default Value";
	private String fi_contactEmail = "Default Value";
	private String fi_spid = "Default Value";
	private String fi_address = "Default Value";
	private String fi_otherAddress = "Default Value";
	private String fi_otherDetails = "Default Value";
	private String fi_typeOfWork = "Default Value";
	private String fi_installMeterType = "Default Value";
	private String fi_installMeterSize = "Default Value";
	private String fi_installMeterDetails = "Default Value";
	private String fi_contactNHH = "Default Value";
	private String fi_contactName = "Default Value";
	private String fi_contactNumber = "Default Value";
	private String fi_notifyRetailerOfFieldVisit = "Default Value";
	
	
    private Jbpm6ClientImpl client;
    private String processid = null;

   public BpmsClientThread() {

    }
   
   private void init() {
       client = new Jbpm6ClientImpl(server, username, password, true);
   }
   
	private int generateRandomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(100);
	}

    public String starBusinessProcess(HashMap<String, String> hm) {

    	String response = null;
    	
    	Thread t = Thread.currentThread();
    	String threadName = "thread-no-"+generateRandomNumber();
    	t.setName(threadName);
    	
        init();
        System.out.println(Thread.currentThread());
        
		fi_retailerName = hm.get("fi_retailerName");
		fi_retailerID = hm.get("fi_retailerID");
		fi_contactEmail = hm.get("fi_contactEmail");
		fi_spid = hm.get("fi_spid");
		fi_address = hm.get("fi_address");
		fi_otherAddress = hm.get("fi_otherAddress");
		fi_otherDetails = hm.get("fi_otherDetails");
		fi_typeOfWork = hm.get("fi_typeOfWork");
		fi_installMeterType = hm.get("fi_installMeterType");
		fi_installMeterSize = hm.get("fi_installMeterSize");
		fi_installMeterDetails = hm.get("fi_installMeterDetails");
		fi_contactNHH = hm.get("fi_contactNHH");
		fi_contactName = hm.get("fi_contactName");
		fi_contactNumber = hm.get("fi_contactNumber");
		fi_notifyRetailerOfFieldVisit = hm.get("fi_notifyRetailerOfFieldVisit");        
        
        try {
			response = client.startProcess("org.openwater:openwaterproject:1.0.0",
                    "openwaterproject.meteringprocess",
                    "fi_retailerName="+fi_retailerName+
                    ",fi_retailerID="+fi_retailerID+
                    ",fi_contactEmail="+fi_contactEmail+
                    ",fi_spid="+fi_spid+
                    ",fi_address="+fi_address+
                    ",fi_otherAddress="+fi_otherAddress+
                    ",fi_otherDetails="+fi_otherDetails+
                    ",fi_typeOfWork="+fi_typeOfWork+
                    ",fi_installMeterType="+fi_installMeterType+
                    ",fi_installMeterSize="+fi_installMeterSize+
                    ",fi_installMeterDetails="+fi_installMeterDetails+
                    ",efi_contactNHH="+Boolean.getBoolean(fi_contactNHH)+
                    ",fi_contactName="+fi_contactName+
                    ",fi_contactNumber="+fi_contactNumber+
                    ",efi_notifyRetailerOfFieldVisit="+Boolean.getBoolean(fi_notifyRetailerOfFieldVisit));

            System.out.println("Process started 1: " + response);

            Document doc = null;
            try {
                doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(response.toString().getBytes()));
                System.out.println("Process  2: " + doc.getDoctype());
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            XPath xpath = XPathFactory.newInstance().newXPath();

            try {
                processid = (String) xpath.evaluate("/process-instance-response/id", doc, STRING);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

        } catch (HttpException e) {
            e.printStackTrace();
        }
        
        System.out.println("Process 3: [" + processid + "]"); // Display the string.  
        return processid;
    }
}
