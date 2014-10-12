package com.picturenetwork.client.delegate;

import java.util.List;

import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.SubjectServicesRemote;
import com.picturenetwork.client.locator.ServiceLocator;

public class SubjectServiceDelegate {

	private static final String jndiName = "ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote";

	private static SubjectServicesRemote getProxy() {
		return (SubjectServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void createSubject(Subject subject) {
		getProxy().createSubject(subject);

	}

	public static Subject findSubjectById(int id) {

		return getProxy().findSubjectById(id);
	}

	public static Subject findSubjectByTitle(String title) {

		return getProxy().findSubjectByTitle(title);
	}

	public static void updateSubject(Subject subject) {

		getProxy().updateSubject(subject);
		//SubjectServicesRemote	subjectserviceRemote = (SubjectServicesRemote) ServiceLocator.getInstance().lookupProxy("/edu.esprit.freelancer.ejb/CategoryService!edu.esprit.freelancer.ejb.services.CategoryServiceRemote");
		
		//categoryServiceRemote.updateCategory(c);
	}

	
	

	public static List<Subject> findAllSubject() {
		return getProxy().findAllSubject();
	}

	
}
