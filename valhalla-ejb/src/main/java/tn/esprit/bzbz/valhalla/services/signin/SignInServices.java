package tn.esprit.bzbz.valhalla.services.signin;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.User;

/**
 * Session Bean implementation class SignInServices
 */
@Stateful
@LocalBean
public class SignInServices implements SignInServicesRemote, SignInServicesLocal {
	/*
	 * 0 : Pas de user avec cet email -1 : password incorrect autre : ID du user
	 */

	@PersistenceContext
	private EntityManager entityManager;

	public static int userConnecte;

	/**
	 * Default constructor.
	 */
	public SignInServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int signIn(String email, String password) throws NamingException {
		try {
			User userFound = (User) entityManager.createQuery("select u from User u where u.email LIKE :custName")
					.setParameter("custName", email).getSingleResult();
			if (!userFound.getPassword().equals(password)) {
				return -1;
			} else {
				Date sysdate = new Date();
				userFound.setLastLogin(sysdate);
				entityManager.merge(userFound);
				return userFound.getId();

			}

		} catch (NoResultException e) {
			return 0;
		}

	}

}
