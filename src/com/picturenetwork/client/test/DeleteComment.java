package com.picturenetwork.client.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.services.CommentServicesRemote;

public class DeleteComment {

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
		 
		     proxy.removeComment(c1);
	}
}
