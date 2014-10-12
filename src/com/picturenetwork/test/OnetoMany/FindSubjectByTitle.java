package com.picturenetwork.test.OnetoMany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;
import com.picturenetwork.client.delegate.SubjectServiceDelegate;

public class FindSubjectByTitle {

	public static void main(String[] args) {
		
		SubjectServicesRemote proxy1 = null;
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy1 = (SubjectServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Subject s= new Subject();
		
		s=proxy1.findSubjectByTitle("photo");
		
	}
}
