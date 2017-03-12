package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote;
import tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote;

public class ReportedSubjectTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubjectsServicesRemote sisr = (SubjectsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SubjectsServices!tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote");
		Context context1 = new InitialContext();
		SectionsServicesRemote sisr1 = (SectionsServicesRemote) context1.lookup(
				"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");

		List<Section> lists = sisr1.findAllSections();
		List<ReportSubject> listrs = sisr.findReportedSubjectsInSection(lists.get(2));
		for (ReportSubject e : listrs) {
			System.out.println(e.getReason() + " " + e.getUser().getId() + " " + e.getSubject().getId());
		}

	}

}
