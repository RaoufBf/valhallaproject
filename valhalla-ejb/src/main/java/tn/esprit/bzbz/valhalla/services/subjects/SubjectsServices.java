package tn.esprit.bzbz.valhalla.services.subjects;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;

/**
 * Session Bean implementation class SubjectsServices
 */
@Stateless
public class SubjectsServices implements SubjectsServicesRemote, SubjectsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SubjectsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReportSubject> findAllReportedSubjects() {
		return entityManager.createQuery("select rs from ReportSubject rs").getResultList();

	}

	@Override
	public List<ReportSubject> findReportedSubjectsInSection(Section section) {
		return entityManager.createQuery("select rs from ReportSubject rs where rs.subject.section LIKE :se")
				.setParameter("se", section).getResultList();

	}

}
