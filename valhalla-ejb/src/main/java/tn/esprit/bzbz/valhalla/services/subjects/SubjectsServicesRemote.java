package tn.esprit.bzbz.valhalla.services.subjects;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;

@Remote
public interface SubjectsServicesRemote {
	List<ReportSubject> findAllReportedSubjects();

	List<ReportSubject> findReportedSubjectsInSection(Section section);
}
