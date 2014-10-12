package com.picturenetwork.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.PictureNetwork.persistance.Subject;
import com.picturenetwork.client.delegate.SubjectServiceDelegate;

public class ForumUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel dft;
	private JPanel contentPane;
	private JTable table;
	List<Subject> subject;
	private JTextField SubjectField_1;
	private JTextField textFielddate;
	private JTextField recherchetextField;
	private JTextField resultatrecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForumUI frame = new ForumUI();
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
	public ForumUI() {
		setTitle("Forum");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 107, 417, 169);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel subdel = (DefaultTableModel) table.getModel();

			/*	textFielddate.setText(subdel.getValueAt(table.getSelectedRow(),
						1).toString());
				SubjectField_1.setText(subdel.getValueAt(
						table.getSelectedRow(), 2).toString());*/

			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(12)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								395, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
								153, GroupLayout.PREFERRED_SIZE)));
		panel.setLayout(gl_panel);
		contentPane.add(panel);

		JButton boutonUpdate = new JButton("Update");
		boutonUpdate.setBounds(108, 353, 32, 23);

		final JLabel labelwrong = new JLabel("");
		labelwrong.setBounds(58, 387, 272, 33);
		contentPane.add(labelwrong);

		final JLabel message = new JLabel("");
		message.setBounds(82, 287, 272, 33);
		contentPane.add(message);

		boutonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		// *******************************************************************************Update
		// on Label4
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedId = table.getSelectedRow();
				System.out.println("nb:"+selectedId);
				Subject ss = SubjectServiceDelegate.findSubjectById(selectedId+1);
				System.out.println("nb2:"+selectedId);
			   ss.setTitle(SubjectField_1.getText());
			   SubjectServiceDelegate.updateSubject(ss);
				System.out.println("nb3:"+selectedId);
				table.setModel(new TableModelSubject());
				SubjectField_1.setText(null);

			}
		});
		// *********************************************************************************************End
		// Update

		lblNewLabel_4
				.setIcon(new ImageIcon(
						"D:\\Esprit3.1\\J2ee\\configuration-serveur\\image\\Document-config-icon.png"));
		lblNewLabel_4.setBounds(94, 318, 65, 75);
		contentPane.add(lblNewLabel_4);
		contentPane.add(boutonUpdate);

		JButton Reloadbutton = new JButton("Reload  Subjects");
		Reloadbutton.setBounds(381, 323, 141, 23);
		Reloadbutton.setFont(new Font("Showcard Gothic", Font.PLAIN, 12));
		// *************************************************************************SHOWING
		Reloadbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				empilTab();
			}

			public void empilTab() {

				List<Subject> allsubject = SubjectServiceDelegate
						.findAllSubject();
				Object[][] donnees = new Object[allsubject.size()][3];
				int i = allsubject.size();

				int j = 0;
				for (Subject e : allsubject) {
					if (j <= i) {

						donnees[j][0] = e.getIdsubject();
						donnees[j][1] = e.getDate();
						donnees[j][2] = e.getTitle();
						j++;
					}
				}
				String[] titres = { "Number","Date Of creation", "Title Of Subject" };

				dft = new DefaultTableModel(donnees, titres);
				table.setModel(dft);

			}

		});
		// ******************************************************************************End
		// Showing
		contentPane.add(Reloadbutton);

		JLabel lblNewLabel = new JLabel("Date Of Creation");
		lblNewLabel.setBounds(48, 24, 111, 18);
		lblNewLabel.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Title of Subject");
		lblNewLabel_1.setBounds(45, 55, 95, 18);
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.ITALIC, 13));
		contentPane.add(lblNewLabel_1);

		SubjectField_1 = new JTextField();
		SubjectField_1.setBounds(196, 53, 111, 20);
		SubjectField_1.setColumns(10);
		contentPane.add(SubjectField_1);

		textFielddate = new JTextField();
		textFielddate.setBounds(196, 22, 111, 20);
		textFielddate.setColumns(10);
		contentPane.add(textFielddate);
		// *************************************************************************************
		// ADDing
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!SubjectField_1.getText().trim().equals("")) {
					message.setText("");
					Subject s = new Subject();

					s.setDate(textFielddate.getText());

					s.setTitle(SubjectField_1.getText());

					SubjectServiceDelegate.createSubject(s);

					Session.getinstance().getStore().put("Forum", s);

					JOptionPane.showMessageDialog(null,
							"Operation of Adding Complete with success");
				} else {
					JOptionPane.showMessageDialog(null,
							"Operation of Adding Failed");
				}
			}
		});
		lblNewLabel_2
				.setIcon(new ImageIcon(
						"D:\\Esprit3.1\\J2ee\\configuration-serveur\\image\\download-icon.png"));
		lblNewLabel_2.setBounds(331, 24, 64, 64);
		contentPane.add(lblNewLabel_2);

		recherchetextField = new JTextField();
		recherchetextField.setBounds(572, 22, 112, 20);
		contentPane.add(recherchetextField);
		recherchetextField.setColumns(10);
		// *********************************************************************Search
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Subject s2 = (Subject) SubjectServiceDelegate
						.findSubjectByTitle(recherchetextField.getText());

				resultatrecherche.setText(String.valueOf(s2.getDate()));

			}
		});
		label_1.setIcon(new ImageIcon(
				"D:\\Esprit3.1\\J2ee\\configuration-serveur\\image\\Search-icon.png"));
		label_1.setBounds(487, 35, 75, 53);
		contentPane.add(label_1);

		resultatrecherche = new JTextField();
		resultatrecherche.setBounds(572, 68, 112, 20);
		contentPane.add(resultatrecherche);
		resultatrecherche.setColumns(10);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 699, 420);
		label.setIcon(new ImageIcon(
				"D:\\Esprit3.1\\J2ee\\configuration-serveur\\image\\wallpaper.jpg"));
		contentPane.add(label);

	}
}
