package tn.esprit.bzbz.valhalla.services.subjects;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;

@Local
public interface SubjectsServicesLocal {
	List<ReportSubject> findAllReportedSubjects();

	List<ReportSubject> findReportedSubjectsInSection(Section section);
}
