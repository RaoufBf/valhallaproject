package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote;

public class SignInTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SignInServicesRemote sisr = (SignInServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SignInServices!tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote");
		System.out.println("ID: " + sisr.signIn("moatezbkilani@gmail.com", "mbk"));

	}

}
