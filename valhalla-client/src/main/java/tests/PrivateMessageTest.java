package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class PrivateMessageTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote usr = (UserServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
		Context context1 = new InitialContext();
		PrivateMessageServicesRemote pr = (PrivateMessageServicesRemote) context1.lookup(
				"valhalla-ear/valhalla-ejb/PrivateMessageServices!tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote");

		User usr1 = usr.findById(1);
		User usr2 = usr.findById(2);
		pr.sendPrivateMessage(usr1, usr2, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

	}

}
