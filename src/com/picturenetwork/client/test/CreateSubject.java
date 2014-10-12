package com.picturenetwork.client.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.SubjectServicesRemote;

public class CreateSubject {

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

		Subject s1 = new Subject("photo", "02-12-2010");

		proxy.createSubject(s1);

	}
}
