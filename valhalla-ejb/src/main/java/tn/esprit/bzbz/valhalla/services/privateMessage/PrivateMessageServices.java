package tn.esprit.bzbz.valhalla.services.privateMessage;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.User;

/**
 * Session Bean implementation class PrivateMessageServices
 */
@Stateless
public class PrivateMessageServices implements PrivateMessageServicesRemote, PrivateMessageServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@Resource(name = "java:jboss/mail/Gmail")
	private Session session;

	/**
	 * Default constructor.
	 */
	public PrivateMessageServices() {

	}

	@Override
	public void sendPrivateMessage(User userOne, User userTwo, String content) {
		Message messagetosend = new Message(content, userOne, userTwo);
		entityManager.persist(messagetosend);
		javax.mail.Message message = new MimeMessage(session);

		try {
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(userTwo.getEmail(), false));
			message.setSubject("Nouveau message sur Valhalla");
			message.setText("Vous avez recu un nouveau message de " + userOne.getUsername() + "sur le Valhalla forum");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
