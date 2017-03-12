package tn.esprit.bzbz.valhalla.services.service;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Service;

@Remote
public interface ServiceServicesRemote {
	
	void createService(String serviceName, String description,String image);
	
	Boolean deleteService(Integer id);
	
	Boolean updateService(Integer id, String name, String description, String image);
	
	Service findServiceById(Integer id);

}
