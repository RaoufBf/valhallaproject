package tn.esprit.bzbz.valhalla.services.user;

import javax.ejb.Local;

import tn.esprit.bzbz.valhalla.entity.User;

@Local
public interface UserServicesLocal {
	User findByEmail(String email);

	void banUser(Integer id);

	User findById(Integer id);

	public void updateUser(User user);
}
