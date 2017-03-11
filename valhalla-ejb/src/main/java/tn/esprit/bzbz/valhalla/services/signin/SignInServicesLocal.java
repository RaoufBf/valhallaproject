package tn.esprit.bzbz.valhalla.services.signin;

import javax.ejb.Local;
import javax.naming.NamingException;

@Local
public interface SignInServicesLocal {
	int signIn(String email, String password) throws NamingException;
}
