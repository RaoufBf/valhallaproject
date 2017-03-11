package tn.esprit.bzbz.valhalla.services.recoverPassword;

import javax.ejb.Remote;

@Remote
public interface RecoverPasswordServicesRemote {
	boolean sendNewPassword(String mail);
}
