package tn.esprit.bzbz.valhalla.services.recoverPassword;

import javax.ejb.Local;

@Local
public interface RecoverPasswordServicesLocal {
	boolean sendNewPassword(String mail);
}
