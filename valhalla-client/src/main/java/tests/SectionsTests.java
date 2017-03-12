package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.services.section.SectionServicesRemote;

public class SectionsTests {

	public static void main(String[] args)throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		SectionServicesRemote sectionServicesRemote = (SectionServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SectionServices!tn.esprit.bzbz.valhalla.services.section.SectionServicesRemote");
		//System.out.println(sectionServicesRemote.createSection(1, "section service 2", "description", "image", "state"));
		//sectionServicesRemote.deleteSection(2);
		sectionServicesRemote.updateSection(2, "test", "", "", null);
	}

}
