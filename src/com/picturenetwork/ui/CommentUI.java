package com.picturenetwork.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

import com.PictureNetwork.persistance.Comment;
import com.PictureNetwork.persistance.Subject;
import com.picturenetwork.client.delegate.CommentServiceDelegate;
import com.picturenetwork.client.delegate.SubjectServiceDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JComboBox;

public class CommentUI extends JFrame {

	DefaultTableModel dft;
	private JPanel contentPane;
	private JTable table;
	private JTextField numerosuject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommentUI frame = new CommentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CommentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblNsubject = new JLabel("N\u00B0:Subject");
		
		numerosuject = new JTextField();
		numerosuject.setColumns(10);
		
		JButton btnReloadCommets = new JButton("Reload Commets");
		btnReloadCommets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				empilTab();
			}
			
			public void empilTab() {

				List<Comment> allcomment = CommentServiceDelegate.findAllComment();
						
				Object[][] donnees = new Object[allcomment.size()][3];
				int i = allcomment.size();
				//System.out.println(i);
				int j = 0;
				for (Comment e : allcomment) {
					if (j <= i) {
						//System.out.println(j);

						donnees[j][0] = e.getIdcomment();
						donnees[j][1] = e.getDatecomment();
						donnees[j][2] = e.getComm();
						

						j++;
					}
				}
				String[] titres = { "Subject Number", "Title Of Subject", "Date Of creation" };

				dft = new DefaultTableModel(donnees, titres);
				table.setModel(dft);

			}
		});
		
		JLabel lblAddNewComment = new JLabel("Add New Comment");
		
		JTextArea addcommenttextArea = new JTextArea();
		
		JButton btnAddComment = new JButton("Add Comment");
		btnAddComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		final JComboBox comboBoxcom = new JComboBox();
		comboBoxcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			/*	Subject selectedItem = (Subject) comboBoxcom.getSelectedItem();
		        Integer IdSubject = selectedItem.

		        if (!IdSujet.equals(null)) {
		            jTable1.setModel(new CommentModelTable(IdSujet));
			}*/
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(btnReloadCommets))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(73)
								.addComponent(comboBoxcom, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddComment))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNsubject)
								.addGap(31)
								.addComponent(numerosuject, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addComponent(lblAddNewComment)
								.addGap(33)
								.addComponent(addcommenttextArea, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(431, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addcommenttextArea, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddNewComment)
						.addComponent(lblNsubject)
						.addComponent(numerosuject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(comboBoxcom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAddComment)))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReloadCommets)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
