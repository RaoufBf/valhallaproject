package tn.esprit.bzbz.valhalla.services.user;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.User;

@Remote
public interface UserServicesRemote {
	User findByEmail(String email);

	void banUser(Integer id);

	User findById(Integer id);

	List<User> findAllUser();

	void upgradeUser(Integer id);

	void downgradeModerator(Integer id);
}
