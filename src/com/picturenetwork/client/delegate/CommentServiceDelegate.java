package com.picturenetwork.client.delegate;

import java.util.List;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.PictureNetwork.persistance.User;
import com.PictureNetwork.services.CommentServicesRemote;
import com.picturenetwork.client.locator.ServiceLocator;

public class CommentServiceDelegate {

	private static final String jndiName = "ejb:/PictureNetwork/CommentServices!com.PictureNetwork.services.CommentServicesRemote";

	private static CommentServicesRemote getProxy() {
		return (CommentServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void createComment(Comment comment) {

		getProxy().createComment(comment);
	}

	public static Comment findCommentById(int id) {

		return getProxy().findCommentById(id);
	}

	public static void updateComment(Comment comment) {

		 getProxy().updateComment(comment);

	}

	public static void removeComment(Comment comment) {

	     getProxy().removeComment(comment);

	}

	public static List<Comment> findAllComment() {
		return getProxy().findAllComment();
	}

	/*public static List<Comment> findCommentBySubject(Subject subject) {
		return getProxy().findCommentBySubject(subject);
	}*/
	
	public static List<Comment> findCommentBySubject(int idsubject) {
		
	return getProxy().findCommentBySubject(idsubject);
     }

	public static List<Comment> findCommentByUser(User user) {
		return getProxy().findCommentByUser(user);
	}

}
