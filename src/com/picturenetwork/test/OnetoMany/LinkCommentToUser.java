package com.picturenetwork.test.OnetoMany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.User;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.UserServicesRemote;

public class LinkCommentToUser {
	public static void main(String[] args) {

		CommentServicesRemote proxy = null;

		UserServicesRemote proxy1 = null;

		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");

			ctx = new InitialContext();
			proxy1 = (UserServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/UserServices!com.PictureNetwork.services.UserServicesRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		}

		User u = proxy1.findUserById(1);

		Comment c1 = proxy.findCommentById(1);
		Comment c2 = proxy.findCommentById(2);
		Comment c3 = proxy.findCommentById(3);

		c1.setUser(u);
		c2.setUser(u);
		c3.setUser(u);

		proxy.updateComment(c1);
		proxy.updateComment(c2);
		proxy.updateComment(c3);
	}

}
