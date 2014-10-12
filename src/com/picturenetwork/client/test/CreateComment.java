package com.picturenetwork.client.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;

public class CreateComment {

	public static void main(String[] args) {
		CommentServicesRemote proxy = null;

		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		}

		Comment c1 = new Comment("02-06-2013", "marwenbaini");
		Comment c2 = new Comment("08-12-2000", "birrasmi");
		Comment c3 = new Comment("07-05-2011", "bien");

		proxy.createComment(c1);
		proxy.createComment(c2);
		proxy.createComment(c3);

	}
}
