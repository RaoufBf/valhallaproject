package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class FindUserTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
		User user = userServicesRemote.findById(1);
		user.setLastName("OKAAAAAAAAAY");
		userServicesRemote.updateUser(user);

	}

}
