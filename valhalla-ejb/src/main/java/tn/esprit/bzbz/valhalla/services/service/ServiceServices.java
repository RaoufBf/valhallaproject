package tn.esprit.bzbz.valhalla.services.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Service;

/**
 * Session Bean implementation class ServiceServices
 */
@Stateless
@LocalBean
public class ServiceServices implements ServiceServicesRemote, ServiceServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ServiceServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Service findServiceById(Integer id) {
		try {
			return (Service) entityManager.createQuery("select s from Service s where s.id LIKE :servName")
					.setParameter("servName", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public void createService(String serviceName, String description, String image) {
		Service newService = new Service(serviceName, description, image);
		entityManager.persist(newService);
	}

	@Override
	public Boolean deleteService(Integer id) {
		Service serviceToFind = this.findServiceById(id);
		if (serviceToFind != null) {
			entityManager.merge(serviceToFind);
			entityManager.remove(serviceToFind);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateService(Integer id, String name, String description, String image) {
		Service serviceToUpdate = this.findServiceById(id);
		if (serviceToUpdate != null) {
			if (!name.equals(""))
				serviceToUpdate.setServiceName(name);
			if (!description.equals(""))
				serviceToUpdate.setDescription(description);
			if (!image.equals(""))
				serviceToUpdate.setImage(image);
			entityManager.merge(serviceToUpdate);
			entityManager.persist(serviceToUpdate);
			return true;
		}
		return false;
	}

}
