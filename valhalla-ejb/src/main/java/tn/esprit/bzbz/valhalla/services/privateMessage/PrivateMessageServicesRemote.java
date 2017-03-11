package tn.esprit.bzbz.valhalla.services.privateMessage;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.User;

@Remote
public interface PrivateMessageServicesRemote {
	void sendPrivateMessage(User userOne, User userTwo, String content);
}
