package tn.esprit.bzbz.valhalla.services.sections;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.bzbz.valhalla.entity.Section;

@Local
public interface SectionsServicesLocal {
	List<Section> findAllSections();
}
