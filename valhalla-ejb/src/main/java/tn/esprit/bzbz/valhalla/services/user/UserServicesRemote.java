package tn.esprit.bzbz.valhalla.services.user;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.User;

@Remote
public interface UserServicesRemote {
	User findByEmail(String email);

	void banUser(Integer id);

	User findById(Integer id);

	public void updateUser(User user);
}
