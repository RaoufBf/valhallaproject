package tn.esprit.bzbz.valhalla.services.signin;

import javax.ejb.Remote;
import javax.naming.NamingException;

@Remote
public interface SignInServicesRemote {
	int signIn(String email, String password) throws NamingException;
}
