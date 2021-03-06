JBoss BPM Suite Open Water Metering Demo
========================================
This is a POC/Demo for Water company implementing a business process.


Instructions to follow
----------------------


1. git clone this project using following command on local machine:
	```
	git clone https://github.com/npatel2012/openwater.git	
	```

2. Download and add following binaries from Red Hat Customer Portal and place in /installs folder
	- JBoss EAP 6.4 installer: jboss-eap-6.4.0-installer.jar
	- JBoss BPMS 6.1.0 installer:i jboss-bpmsuite-6.1.0.GA-installer.jar

3. Run init.sh setup script using following command	
	```
	./init.sh
	```

4. Start BPMS instance using following command	
	```
	./target/jboss-eap-6.4/bin/standalone.sh	
	```

5. Login to business-central via following link and `build & deploy` artifacts from there	
	```
	http://localhost:8080/business-central (u:adminuser/p:bpmsuite1!)
	```

6. Start business process via one of the following methods:
	```
	Using External UI Form http://localhost:8080/retailer-external-form-1.0/
	Using form available via Business Central
	```

7. Login to JBoss Administration Console via following link:
	```
	http://localhost:9990/console/index.html (u:admin/p:jbosseap1!)
	```


You are ready to go now!!!
