package tn.esprit.bzbz.valhalla.services.sections;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Section;

@Remote
public interface SectionsServicesRemote {
	List<Section> findAllSections();
}
