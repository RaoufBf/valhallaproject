package tn.esprit.bzbz.valhalla.services.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.User;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User findByEmail(String email) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.email LIKE :custName")
					.setParameter("custName", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}

	public void updateUser(User user) {
		entityManager.merge(user);
	}

	public User findById(Integer id) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.id LIKE :custId")
					.setParameter("custId", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}

	@Override
	public void banUser(Integer id) {
		User userf = findById(id);
		userf.setState("Banned");
		entityManager.merge(userf);
	}

}
