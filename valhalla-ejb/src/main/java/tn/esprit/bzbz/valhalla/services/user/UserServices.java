package tn.esprit.bzbz.valhalla.services.user;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	@Resource(name = "java:jboss/mail/Gmail")
	private Session session;

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
		Message message = new MimeMessage(session);

		try {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userf.getEmail(), false));
			message.setSubject("Vous avez été banni du forum Valhalla");
			message.setText(
					"D'apres plusieurs réclamations des membres ou suite a un comportement inapproprié vous avez été banni du forum Valhalla");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
