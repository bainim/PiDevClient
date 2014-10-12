package com.picturenetwork.test.OnetoMany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;

public class CascadeRemove {

	public static void main(String[] args) {
		
		CommentServicesRemote proxy = null;

		SubjectServicesRemote proxy1 = null;
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");

			ctx = new InitialContext();
			proxy1 = (SubjectServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}

		
		// int id = (Integer.parseInt(table.getModel().getValueAt(row, 0).toString()));
	}
}
