package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;

public class ServicesTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

		serviceServicesRemote.createService("serviceName", "description", "image");

	}

}
