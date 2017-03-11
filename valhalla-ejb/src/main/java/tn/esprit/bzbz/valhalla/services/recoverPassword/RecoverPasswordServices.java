package tn.esprit.bzbz.valhalla.services.recoverPassword;

import java.util.Random;

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
 * Session Bean implementation class RecoverPasswordServices
 */
@Stateless
public class RecoverPasswordServices implements RecoverPasswordServicesRemote, RecoverPasswordServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@Resource(name = "java:jboss/mail/Gmail")
	private Session session;

	/**
	 * Default constructor.
	 */
	public RecoverPasswordServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sendNewPassword(String mail) {

		try {
			char[] chars = "abcdefghijklmnopqrstuvwxyz-0123456789$.+/_".toCharArray();
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			String newpassword = sb.toString();
			User user = (User) entityManager.createQuery("select u from User u where u.email LIKE :custName")
					.setParameter("custName", mail).getSingleResult();
			user.setPassword(newpassword);
			entityManager.merge(user);
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail, false));
			message.setSubject("Nouveau mot de passe pour votre compte sur Valhalla Forum");
			message.setText("Votre nouveau mot de passe est: " + newpassword);
			Transport.send(message);
			return true;
		} catch (NoResultException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
