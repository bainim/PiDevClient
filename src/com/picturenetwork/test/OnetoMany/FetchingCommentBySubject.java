package com.picturenetwork.test.OnetoMany;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.services.CommentServicesRemote;
import com.PictureNetwork.services.SubjectServicesRemote;

public class FetchingCommentBySubject {

	public static void main(String[] args) {
		CommentServicesRemote proxy = null;
		SubjectServicesRemote proxy1 = null;
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (CommentServicesRemote)ctx.lookup("ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote");	

			proxy1 = (SubjectServicesRemote) ctx
					.lookup("ejb:/PictureNetwork/SubjectServices!com.PictureNetwork.services.SubjectServicesRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		Subject s=proxy1.findSubjectById(1);
		List<Comment> comment = s.getComment();
		for(Comment c:comment)
			
		System.out.println(c.getComm());
	}
}
