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
		user.setId(1);
		user.setEmail("mbk");
		user.setPassword("mbk");
		entityManager.persist(user);
	}
}
