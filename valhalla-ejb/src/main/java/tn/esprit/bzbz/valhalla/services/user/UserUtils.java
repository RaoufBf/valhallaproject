package tn.esprit.bzbz.valhalla.services.user;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.User;

@Singleton
@LocalBean
@Startup
public class UserUtils {
	@PersistenceContext
	private EntityManager entityManager;

	public UserUtils() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		User user = new User();
		// user.setId(1);
		user.setUsername("MBK1");
		user.setPassword("mbk");
		user.setEmail("moatez.benkilani@esprit.tn");
		entityManager.persist(user);
		User user2 = new User();
		// user2.setId(2);
		user2.setUsername("MBK2");
		user2.setPassword("mbk");
		user2.setEmail("moatezbkilani@gmail.com");
		entityManager.persist(user2);
	}
}
