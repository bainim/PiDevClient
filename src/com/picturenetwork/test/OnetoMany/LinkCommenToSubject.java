package com.picturenetwork.test.OnetoMany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;

public class LinkCommenToSubject {

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

		 //int id = (Integer.parseInt(table.getModel().getValueAt(row, 0).toString())); c'est la solution pour avoir le link pour tous les elements
		Subject s = proxy1.findSubjectById(1);

		
		Comment c1 = proxy.findCommentById(1);
		Comment c2 = proxy.findCommentById(2);
		Comment c3 = proxy.findCommentById(3);
		

		c1.setSubject(s);
		c2.setSubject(s);
		c3.setSubject(s);
		
		proxy.updateComment(c1);
		proxy.updateComment(c2);
		proxy.updateComment(c3);
	

	
}	
	

	
}
