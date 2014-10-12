package com.picturenetwork.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.PictureNetwork.persistance.Subject;
import com.picturenetwork.client.delegate.SubjectServiceDelegate;

public class TableModelSubject extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Subject> subjectlist = new ArrayList<Subject>();
	
	//Subject s = new Subject();
	
	String[] header = { "idsubject","Date","Title" };

	public TableModelSubject() {
		subjectlist = SubjectServiceDelegate.findAllSubject();
		//SubjectServiceDelegate.updateSubject(s);
	}

	@Override
	public int getRowCount() {
		return subjectlist.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return subjectlist.get(rowIndex).getIdsubject();
		case 1:
			return subjectlist.get(rowIndex).getDate();
		case 2:
			return subjectlist.get(rowIndex).getTitle();

		default:
			return null;
		}
	}

	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	
}
