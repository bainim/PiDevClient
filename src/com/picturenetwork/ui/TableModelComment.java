package com.picturenetwork.ui;

import java.util.ArrayList;
import java.util.List;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.picturenetwork.client.delegate.CommentServiceDelegate;
import com.picturenetwork.client.delegate.SubjectServiceDelegate;

public class TableModelComment {

	List<Comment> list_comment = new ArrayList<Comment>();
    String[] header = {"Idcomment","date",  "comm"};

    
    public TableModelComment(int idsubject) {
		list_comment = CommentServiceDelegate.findCommentBySubject(idsubject);
	    list_comment = CommentServiceDelegate.findAllComment();
	}

    public int getRowCount() {
		return list_comment.size();
	}

	public int getColumnCount() {
		return header.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return list_comment.get(rowIndex).getIdcomment();
		case 1:
			return list_comment.get(rowIndex).getDatecomment();
		case 2:
			return list_comment.get(rowIndex).getComm();

		default:
			return null;
		}
	}
}
