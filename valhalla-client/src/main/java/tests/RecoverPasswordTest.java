package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.services.recoverPassword.RecoverPasswordServicesRemote;

public class RecoverPasswordTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		RecoverPasswordServicesRemote sisr = (RecoverPasswordServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/RecoverPasswordServices!tn.esprit.bzbz.valhalla.services.recoverPassword.RecoverPasswordServicesRemote");
		sisr.sendNewPassword("moatez.benkilani@esprit.tn");
	}

}
