package tn.esprit.bzbz.valhalla.services.section;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Section;


@Remote
public interface SectionServicesRemote {

	Boolean createSection(Integer serviceId, String sectionName, String description, String image, String state);

	Boolean deleteSection(Integer sectionId);
	
	Section findSectionById(Integer id);
	
	Boolean updateSection(Integer sectionId, String name, String description, String image,Integer serviceId);
		
}
