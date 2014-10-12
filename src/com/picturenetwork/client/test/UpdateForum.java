package com.picturenetwork.client.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Forum;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.ForumServicesRemote;

public class UpdateForum {
	public static void main(String[] args) {
		ForumServicesRemote proxy = null;

		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (ForumServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/ForumServices!com.PictureNetwork.services.ForumServicesRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		}

		Forum f1 = new Forum("PiDev");
		
		f1.setIdforum(2);
		f1.setTitle("PiDevModifier");
		
		proxy.updateForum(f1);	
		
	}
}
