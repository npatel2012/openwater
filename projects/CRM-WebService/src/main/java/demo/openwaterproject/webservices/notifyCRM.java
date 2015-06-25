package demo.openwaterproject.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService()
public class notifyCRM {

	@WebResult(name = "response")
	@WebMethod()
	public String submit(
			@WebParam(name = "retailerID") java.lang.String retailerID)
	{

		System.out.println("[Web Service Log] notifyCRM:submit WebService Invoked,");
		System.out.println("[Web Service Log] retailerID: [" +retailerID + "]");
		return "received submit() request - response from CRM";
	}
	
	@WebResult(name = "response")
	@WebMethod()
	public String notifyRetailer(
			@WebParam(name = "retailerID") java.lang.String retailerID)
	{

		System.out.println("[Web Service Log] notifyCRM:notifyRetailer WebService Invoked,");
		System.out.println("[Web Service Log] retailerID: [" +retailerID + "]");
		return "received notifyRetailer() request - response from CRM";
	}
	
	
}
