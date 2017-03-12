package tn.esprit.bzbz.valhalla.services.sections;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Section;

/**
 * Session Bean implementation class SectionsServices
 */
@Stateless
public class SectionsServices implements SectionsServicesRemote, SectionsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SectionsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Section> findAllSections() {
		return entityManager.createQuery("select s from Section s").getResultList();
	}

}
