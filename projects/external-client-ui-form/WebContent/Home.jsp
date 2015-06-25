<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Form</title>

<style>

body {
	font-family: sans-serif;
}

#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#footer {
	text-align: center;
	padding: 1em;
}

form {
	border: 2px solid #f0f0f0;
}

form > div {
	padding: .5em;
}

form > div:nth-child(odd) {
	background-color: #f0f0f0;
}

form div label {
	display: inline-block;
	min-width: 25%;
}

form > div > div {
	display: inline-block;
}

input[type="submit"] {
	padding: .5em 1em .5em 1em;
	background-color: red;
	font-weight: bold;
	color: white;
	border: 0;
	margin: 1em;
	font-size: large;
}

h2 {
	font-size: large;
	color: red;
	margin: 0;
	padding: .4em;
	padding-top: 1.5em;
}

</style>

</head>
<body>

	<div id="header">
		<h1>RETAILER - WEB FORM</h1>
	</div>

	<div id="section">
		<form action="SimpleServlet">
			<h2>Retailer Details:</h2>
			
			<div>
				<label for = "efi_retailerName">Retailer Name*</label> 
				<div>
					<input type="text" id = "efi_retailerName" name="efi_retailerName" size="20px" />
				</div>
			</div>

			<div>
				<label for = "efi_retailerID">Retailer Reference ID*</label>
				<div>
					<input type="text" id = "efi_retailerID" name="efi_retailerID" size="20px" />
				</div>
			</div>
			
			<div>
				<label for = "efi_contactEmail">Email Address*</label>
				<div>
					<input type="text" id = "efi_contactEmail" name="efi_contactEmail" size="20px" />
				</div>
			</div>			

			<h2>Premises Details:</h2>
			<div>
				<label for = "efi_spid">SPID - unique premises ID*</label>
				<div>
					<input type="text" id = "efi_spid" name="efi_spid" size="20px" /> 
				</div>
			</div>
			
			<div>
				<label for = "efi_address">Address*</label>
				<div>
					<input type="text" id = "efi_address" name="efi_address" size="20px" /> 
				</div>
			</div>
			
			<div>
				<label for = "efi_otherAddress">Other Address</label>
				<div>
					<input type="text" id = "efi_otherAddress" name="efi_otherAddress" size="20px" /> 
				</div>
			</div>
			
			<div>
				<label for = "efi_otherDetails">Other Details (optional)</label>
				<div>
					<input type="text" id = "efi_otherDetails" name="efi_otherDetails" size="20px" /> 
				</div>
			</div>
			
			<h2>Type Of Work Details</h2>			
				
			<div>
				<label for = "efi_typeOfWork">Type Of Work*</label>
				<div>
					<select id = "efi_typeOfWork" name="efi_typeOfWork">
						<option value="installation">Installation</option>
						<option value="accuracy test">Accuracy Test</option>
						<option value="meter repair">Meter Repair</option>
						<option value="replacement due to fault">Replacement due to fault</option>
						<option value="change of meter">Change Of Meter</option>
					</select>
				</div>
			</div>

			<div>
				<label for = "efi_installMeterType">Install Meter Type</label>
				<div>
					<select id = "efi_installMeterType" name="efi_installMeterType">
						<option value="Standard">Standard</option>
						<option value="non-standard">Non Standard</option>
						<option value="unknown">Unknown</option>
					</select>
				</div>
			</div>
			<div> 
				<label for = efi_installMeterSize>Install Meter Size (in mm)</label>
			
				<div>	
					<input type="text" id = "efi_installMeterSize" name="efi_installMeterSize" size="20px" />
				</div>
			</div>

			<div>
				<label for = "efi_installMeterDetails">Install Meter Details</label>

				<div>
					<input type="text" id = "efi_installMeterDetails" name="efi_installMeterDetails" value="N/A" size="50px" />
				</div>
			</div>
			
			<h2>Consent Details:</h2>
			
			<div>
				<label for="efi_contactNHH">Contact NHH?*</label>
				<div>
						<br><input type="radio" name="efi_contactNHH" value="1">Yes
				</div>
				<div>
						<br><input type="radio" name="efi_contactNHH" value="0">No
				</div>
			</div>
			
			<div>
				<label for = "efi_contactName" onhelp="fill in if Contact NHH is set to 'YES' ">Contact Name (required if above set to 'YES') </label> 
				<div>
					<input type="text" id = "efi_contactName" name="efi_contactName" size="20px" />
				</div>
			</div>

			<div>
				<label for = "efi_contactNumber" onhelp="fill in if Contact NHH is set to 'YES'">Contact Number (required if above set to 'YES')</label>
				<div>
					<input type="text" id = "efi_contactNumber" name="efi_contactNumber" size="20px" />
				</div>
			</div>
			
			<div>
				<label for="efi_notifyRetailerOfFieldVisit">Notify Retailer of Field Visit*</label>
				<div>
						<br><input type="radio" name="efi_notifyRetailerOfFieldVisit" value="1">Yes
				</div>
				<div>
						<br><input type="radio" name="efi_notifyRetailerOfFieldVisit" value="0">No
				</div>
			</div>
			
		
			<input type="submit" value="SUBMIT"><br>
		</form>
	</div>

	<div id="footer">Powered by <strong>Red Hat JBoss BPM Suite</strong></div>

</body>
</html>
