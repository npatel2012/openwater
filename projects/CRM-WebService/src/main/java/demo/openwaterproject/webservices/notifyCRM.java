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
			@WebParam(name = "retailerName") String retailerName,
			@WebParam(name = "retailerID") java.lang.String retailerID,
			@WebParam(name = "contactEmailID") java.lang.String contactEmailID,
			@WebParam(name = "SPID") java.lang.String spid)
	{

		System.out.println("notifyCRM:submit WebService Invoked,");
		System.out.println("reatilerName:" +retailerName +" retailerID:" +retailerID + " contactEmailID:" +contactEmailID +" SPID:" +spid);
		return "received";
	}
	
	@WebResult(name = "response")
	@WebMethod()
	public String notifyRetailer(
			@WebParam(name = "retailerName") String retailerName,
			@WebParam(name = "retailerID") java.lang.String retailerID,
			@WebParam(name = "contactEmailID") java.lang.String contactEmailID,
			@WebParam(name = "fieldSiteVisitDate") java.lang.String fieldSiteVisitDate)
	{

		System.out.println("notifyCRM:notifyRetailer WebService Invoked,");
		System.out.println("reatilerName:" +retailerName +" retailerID:" +retailerID + " contactEmailID:" +contactEmailID +" fieldSiteVisitDate:" +fieldSiteVisitDate);
		return "received";
	}
	
	
}
