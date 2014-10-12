package com.picturenetwork.test.OnetoMany;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.SubjectServicesRemote;

public class FindAllSubject {

	public static void main(String[] args) {
		SubjectServicesRemote proxy = null;

		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (SubjectServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		List<Subject> subject = null;
		subject= proxy.findAllSubject();
		
		for(Subject s:subject){
			System.out.println(s.getTitle());
		}

	}

}
