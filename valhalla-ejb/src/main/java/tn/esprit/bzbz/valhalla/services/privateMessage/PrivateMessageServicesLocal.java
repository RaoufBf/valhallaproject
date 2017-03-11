package tn.esprit.bzbz.valhalla.services.privateMessage;

import javax.ejb.Local;

import tn.esprit.bzbz.valhalla.entity.User;

@Local
public interface PrivateMessageServicesLocal {
	void sendPrivateMessage(User userOne, User userTwo, String content);
}
