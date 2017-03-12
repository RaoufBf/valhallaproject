package tn.esprit.bzbz.valhalla.services.user;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;
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
		User user3 = new User();
		// user2.setId(2);
		user3.setUsername("MBK3");
		user3.setPassword("mbk");
		user3.setEmail("moatez.ben.kilani@gmail.com");
		entityManager.persist(user3);
		Service service1 = new Service();
		Service service2 = new Service();
		service1.setDescription("Sport");
		service1.setServiceName("Sport");
		service2.setDescription("Cinema");
		service2.setServiceName("Cinema");
		entityManager.persist(service1);
		entityManager.persist(service2);
		Section section1 = new Section();
		section1.setDescription("Foot");
		section1.setSectionName("Foot");
		section1.setService(service1);
		entityManager.persist(section1);
		Section section2 = new Section();
		section2.setDescription("Thril");
		section2.setSectionName("Thril");
		section2.setService(service2);
		entityManager.persist(section2);
		Section section3 = new Section();
		section3.setDescription("Rom");
		section3.setSectionName("Rom");
		section3.setService(service2);
		entityManager.persist(section3);
		Subject subject1 = new Subject();
		subject1.setSection(section1);
		subject1.setSubjectName("Allo j'aime le foot");
		subject1.setUser(user);
		entityManager.persist(subject1);
		Subject subject2 = new Subject();
		subject2.setSection(section1);
		subject2.setSubjectName("Allo j'aime le football");
		subject2.setUser(user2);
		entityManager.persist(subject2);
		Subject subject3 = new Subject();
		subject3.setSection(section2);
		subject3.setSubjectName("Allo j'aime le thrill");
		subject3.setUser(user);
		entityManager.persist(subject3);
		Subject subject4 = new Subject();
		subject4.setSection(section2);
		subject4.setSubjectName("Allo j'aime le Thriller");
		subject4.setUser(user3);
		entityManager.persist(subject4);
		ReportSubject rs1 = new ReportSubject(user3, subject1, "OK");
		entityManager.persist(rs1);
		ReportSubject rs2 = new ReportSubject(user, subject1, "OK");
		entityManager.persist(rs2);
		ReportSubject rs3 = new ReportSubject(user2, subject3, "OK");

		entityManager.persist(rs3);
		ReportSubject rs4 = new ReportSubject(user3, subject3, "OK");

		entityManager.persist(rs4);
	}
}
