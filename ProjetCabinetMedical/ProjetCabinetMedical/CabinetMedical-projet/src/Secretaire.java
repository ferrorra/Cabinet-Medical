import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Secretaire extends JPanel {
	private static JPanel Secret;
	private  static JTextField textField_31;
	private  static JTextField textField_32;
	private   static JTextField textField_33;
	private  static JComboBox textField_46 = new JComboBox();
	private static JTextField textField_47;
   private  static JTextField txtAaaammjj;
   private Calendrier calendrier = new Calendrier();
	private JTable table_1;
	private Connection cn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	public static JTextField getTextField_31() {
		return textField_31;
	}
	public static JTextField getTextField_32() {
		return textField_32;
	}
	public static JTextField getTextField_33() {
		return textField_33;
	}
	public static JComboBox getTextField_46() {
		return textField_46;
	}
	public static JTextField getTextField_47() {
		return textField_47;
	}
	public static JTextField getTxtAaaammjj() {
		return txtAaaammjj;
	}
	public static JPanel getSecret() {
		return Secret;
	}
	public void switchpanels(JLayeredPane panlay, JPanel panel)
	{
		panlay.removeAll();
		panlay.add(panel);
		panlay.repaint();
		panlay.revalidate();
	}
	/**
	 * Create the panel.
	 */
	public void modifierRDV() {     //modifier les infos du rendez vous à partir de la table
		
		
		int row=1;
		 row=table_1.getSelectedRow();
		String numRDV= (table_1.getModel().getValueAt(row, 0)).toString();
		String cin= (table_1.getModel().getValueAt(row, 1)).toString();
		String dateRDV = (table_1.getModel().getValueAt(row, 2)).toString();
		String numTel = (table_1.getModel().getValueAt(row, 3)).toString();
		String email = (table_1.getModel().getValueAt(row, 4)).toString();
		String probleme = (table_1.getModel().getValueAt(row, 5)).toString();

		try {
			cn=connection.cnx();
			String sql="update RDV set codePatient  = ?, dateRDV  = ?, numTel = ?,email = ?,probleme = ? where numRDV = ?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, cin); 
		ps.setString(2, dateRDV);
		ps.setString(3, numTel);
		ps.setString(4, email);
		ps.setString(5, probleme);
		ps.setString(6, numRDV);
	
		int result = ps.executeUpdate();
		if(result != 0) {
			JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
			
		}else 	JOptionPane.showMessageDialog(null, "Il y a eu un problème...");
		
		}catch(Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			 
		}finally {
			try {
				ps.close();
				afficherListeRDV();  //recharger la table des rdvs
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						try {
							rs.close();
							ps.close();
						
						}catch(Exception ee) {}
		
		}
		}
	}
	public void enregistrerRDV() {   //enregistrer un rdv
		try {	
			cn=connection.cnx();
		String sql="insert into RDV(numRDV, codePatient, dateRDV, numTel, email, probleme) values (?, ?, ?, ?, ?, ?) ";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_47.getText());
		ps.setString(2, textField_31.getText());
		ps.setString(3, txtAaaammjj.getText());
		ps.setString(4, textField_32.getText());
		ps.setString(5, textField_33.getText());
		ps.setString(6,  textField_46.getSelectedItem().toString());
		int result=ps.executeUpdate();
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Rendez vous enregistré !");
		}
		else {
			JOptionPane.showMessageDialog(null, "Il y a un problème ...");
		}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}finally {
		try {
			rs.close();
			ps.close();				
		}catch(Exception e) {}
	}
	}
	public void afficherListeRDV() {     //affichage de tous les rdvs dans une table
		try {
			cn=connection.cnx();
			String sql="select *  from RDV ";
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
				
			
			}catch(Exception e) {}
		}
	}
	public void annulerRDV() throws Exception {  //suppression d'un rdv
		int row=1;
		 row=table_1.getSelectedRow();
		String cin= (table_1.getModel().getValueAt(row, 0)).toString();
		cn=connection.cnx();
		String sql="delete from RDV where numRDV  = ? ";
		ps=cn.prepareStatement(sql);
		ps.setString(1, cin);				
		ps.executeUpdate();	
	}
	public  Secretaire() {
		
		 Secret = new JPanel();
		Secret.setBackground(SystemColor.window);
		Secret.setLayout(null);
		
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(SystemColor.window);
		layeredPane_1.setBounds(10, 41, 1014, 653);
		Secret.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.textHighlightText);
		layeredPane_1.add(panel_10, "name_14301519335600");
		panel_10.setLayout(null);
		
		JLabel lblEnregistrerUnNouveau = new JLabel("Enregistrer un nouveau rendez-vous");
		lblEnregistrerUnNouveau.setForeground(SystemColor.textHighlight);
		lblEnregistrerUnNouveau.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 45));
		lblEnregistrerUnNouveau.setBounds(10, 11, 603, 50);
		panel_10.add(lblEnregistrerUnNouveau);
		
		textField_31 = new JTextField();
		textField_31.setBounds(213, 190, 268, 40);
		panel_10.add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(213, 260, 268, 40);
		panel_10.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(213, 327, 268, 40);
		panel_10.add(textField_33);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setForeground(SystemColor.textHighlight);
		lblCin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblCin.setBounds(53, 187, 151, 40);
		panel_10.add(lblCin);
		
		JLabel lblNumroDeTlphone = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblNumroDeTlphone.setForeground(SystemColor.textHighlight);
		lblNumroDeTlphone.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNumroDeTlphone.setBounds(53, 258, 151, 40);
		panel_10.add(lblNumroDeTlphone);
		
		JLabel lblAdresseEmail = new JLabel("Adresse Email");
		lblAdresseEmail.setForeground(SystemColor.textHighlight);
		lblAdresseEmail.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAdresseEmail.setBounds(53, 328, 151, 40);
		panel_10.add(lblAdresseEmail);
		
		JButton btnEnregistrerRendezvous = new JButton("Enregistrer Rendez-Vous");

		btnEnregistrerRendezvous.setForeground(SystemColor.textHighlight);
		btnEnregistrerRendezvous.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnEnregistrerRendezvous.setBounds(238, 544, 223, 41);
		panel_10.add(btnEnregistrerRendezvous);
		
		txtAaaammjj = new JTextField();
		txtAaaammjj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtAaaammjj.setText("");
				txtAaaammjj.setForeground(SystemColor.black);
			}
		});
		txtAaaammjj.setForeground(SystemColor.activeCaptionBorder);
		txtAaaammjj.setText("AAAA-MM-JJ");
		txtAaaammjj.setColumns(10);
		txtAaaammjj.setBounds(213, 395, 268, 40);
		panel_10.add(txtAaaammjj);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(SystemColor.textHighlight);
		lblDate.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblDate.setBounds(53, 395, 151, 40);
		panel_10.add(lblDate);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(213, 118, 268, 40);
		panel_10.add(textField_47);
		
		JLabel lblNumroDuRendezvous = new JLabel("Num\u00E9ro du rendez-vous");
		lblNumroDuRendezvous.setForeground(SystemColor.textHighlight);
		lblNumroDuRendezvous.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblNumroDuRendezvous.setBounds(53, 118, 151, 40);
		panel_10.add(lblNumroDuRendezvous);
		
		JLabel lblProblme = new JLabel("Probl\u00E8me");
		lblProblme.setForeground(SystemColor.textHighlight);
		lblProblme.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblProblme.setBounds(53, 457, 151, 40);
		panel_10.add(lblProblme);
		
		
		textField_46.setModel(new DefaultComboBoxModel(new String[] {"simpleConsultation", "maladieGrave", "traitementHebdomadaire", "consultationUrgente"}));
		textField_46.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		textField_46.setForeground(SystemColor.textHighlight);
		textField_46.setBackground(SystemColor.window);
		textField_46.setBounds(213, 468, 268, 20);
		panel_10.add(textField_46);
		
		JButton btnEcrireDesNotes = new JButton("Ecrire des notes");
		btnEcrireDesNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 calendrier.setVisible(true);   //ouvrir un calendrier dynamique pour écrire des notes
			}
		});
		btnEcrireDesNotes.setForeground(SystemColor.textHighlight);
		btnEcrireDesNotes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnEcrireDesNotes.setBounds(636, 67, 223, 41);
		panel_10.add(btnEcrireDesNotes);
		
		JButton btnConsulterMaBoite = new JButton("Consulter ma boite mail");
		btnConsulterMaBoite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {  //consulter le gmail de la secretaire
				try {
					Desktop.getDesktop().browse(new URL("https://mail.google.com/mail/u/0/#inbox").toURI());
				} catch (Exception e) {
					
					 
				} 
			}
		});
		btnConsulterMaBoite.setForeground(SystemColor.textHighlight);
		btnConsulterMaBoite.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnConsulterMaBoite.setBounds(636, 127, 223, 41);
		panel_10.add(btnConsulterMaBoite);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.textHighlightText);
		layeredPane_1.add(panel_11, "name_14310489530700");
		panel_11.setLayout(null);
		
		JLabel lblLaListeDes = new JLabel("La liste des rendez-vous");
		lblLaListeDes.setForeground(SystemColor.textHighlight);
		lblLaListeDes.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 45));
		lblLaListeDes.setBounds(10, 11, 389, 50);
		panel_11.add(lblLaListeDes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		scrollPane_1.setForeground(Color.WHITE);
		scrollPane_1.setBounds(105, 172, 804, 396);
		panel_11.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if(event.getKeyCode()==KeyEvent.VK_ENTER) {
					modifierRDV();     
				}
			}
		});


		table_1.setGridColor(SystemColor.textHighlight);
		table_1.setBackground(SystemColor.textHighlight);
		table_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		table_1.setForeground(Color.WHITE);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblTrierPar = new JLabel("Cliquez pour trier :");
		lblTrierPar.setForeground(SystemColor.textHighlight);
		lblTrierPar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		lblTrierPar.setBounds(307, 70, 149, 44);
		panel_11.add(lblTrierPar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {     //trier les rdvs selon des critéres de temps 
				cn=connection.cnx();
				String sql="select *  from RDV where dateRDV";
				if(comboBox_1.getSelectedIndex()== 0) {
					sql=sql.concat("= date('now')");
				}
				 if(comboBox_1.getSelectedIndex()==1) {
					sql=sql.concat(" BETWEEN date('now') AND date('now','+7 day')");
				}
				 if(comboBox_1.getSelectedIndex()==2) {
						sql=sql.concat(" BETWEEN date('now') AND date('now','+1 month')");
					}
				 if(comboBox_1.getSelectedIndex()==3) {
						sql=sql.concat(" BETWEEN date('now') AND date('now','+1 years')");
					}
				try {
					
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}finally {
					try {
						rs.close();
						ps.close();
					
					}catch(Exception e) {}
				}
			}
		});
		comboBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_1.setEnabled(true);   //activer le comboBox pour trier
			}
		});
		comboBox_1.setEnabled(false);
		comboBox_1.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		comboBox_1.setForeground(SystemColor.textHighlight);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Jour", "Semaine", "Mois", "Ann\u00E9e"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(466, 87, 119, 20);
		panel_11.add(comboBox_1);
		
		JButton btnAnnulerRendezvous = new JButton("Annuler rendez-vous");
		btnAnnulerRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		
				
				
				try {
				annulerRDV();														
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {
					afficherListeRDV();
						
							
							}catch(Exception e) {}
						}
			}
		});
		btnAnnulerRendezvous.setForeground(SystemColor.textHighlight);
		btnAnnulerRendezvous.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnAnnulerRendezvous.setBounds(414, 579, 182, 41);
		panel_11.add(btnAnnulerRendezvous);
		
		JLabel maj = new JLabel("Mettre \u00E0 jour un rendez vous en appyant deux fois sur entrer");
	
		maj.setVisible(false);
		maj.setForeground(Color.RED);
		maj.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		maj.setBounds(290, 127, 439, 44);
		panel_11.add(maj);
		
		JButton btnNewButton_4 = new JButton("Ajouter Rendez-Vous");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_1, panel_10);
				textField_47.setText("");
				textField_31.setText("");
				textField_32.setText("");
				textField_33.setText("");
				txtAaaammjj.setText("AAAA-MM-JJ");	
				txtAaaammjj.setForeground(Color.GRAY);
			}
		});
		btnNewButton_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnNewButton_4.setForeground(SystemColor.textHighlight);
		btnNewButton_4.setBounds(10, 0, 182, 41);
		Secret.add(btnNewButton_4);
		
		JButton brdv = new JButton("Liste des rendez vous");
		brdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_1, panel_11);//changer panel
				
				maj.setVisible(false);
	             afficherListeRDV();
			}
		});
		brdv.setForeground(SystemColor.textHighlight);
		brdv.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		brdv.setBounds(187, 0, 182, 41);
		Secret.add(brdv);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread t = new Thread(new Runnable() {
					  public void run() {
					    while (true) {
					    	maj.setVisible(!maj.isVisible()); //faire clignoter le message

					      try {
					        Thread.sleep(500); 
					      } catch (InterruptedException e) { 
					    	  JOptionPane.showMessageDialog(null, e.getMessage());
					      }
					    }
					  }
					});

					t.start();
				
			}
		});
		btnEnregistrerRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                          enregistrerRDV();
				
			}
		});
	}
}
