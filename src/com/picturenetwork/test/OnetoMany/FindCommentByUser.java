package com.picturenetwork.test.OnetoMany;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.User;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.UserServicesRemote;

public class FindCommentByUser {

	public static void main(String[] args) {
CommentServicesRemote proxy = null;
UserServicesRemote proxy1 = null;
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote)ctx.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");	
			proxy1 = (UserServicesRemote)ctx.lookup("ejb:/PictureNetwork/UserServices!com.PictureNetwork.services.UserServicesRemote");	
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		User u =proxy1.findUserById(1);
		List<Comment> comment = proxy.findCommentByUser(u);
		for(Comment c:comment)
			System.out.println(c.getComm());
	}
}
