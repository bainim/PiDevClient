package com.picturenetwork.test.OnetoMany;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.services.CommentServicesRemote;

public class FindAllComment {

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

		List<Comment> comment = null;
		comment= proxy.findAllComment();
		
		for(Comment c:comment){
			System.out.println(c.getComm());
		}
	}
}
