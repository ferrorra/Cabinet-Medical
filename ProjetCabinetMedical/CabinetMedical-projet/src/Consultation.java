

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;

public class Consultation extends JFrame {

	private JPanel contentPane;
	private static  JTextField textField_1;
	private static  JTextField textField_2;
	private static  JTextField textField_3;
	private  static JTextField textField_4;
	private  static JProgressBar progressBar;
	public static JProgressBar getProgressBar() {
		return progressBar;
	}

	private Connection cn=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	private JButton bbt;
	private JLabel bbbt;
	 private JTable table;
	
	
	public static JComboBox getComboBox() {
		return comboBox;
	}

	private  static JTextField textField_5;
    private static JComboBox comboBox;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    JScrollPane scrollPane;
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
   public void suppFichePatient() {
	  
	  
	   PreparedStatement pss = null;
		try {
			 rs.close();
			   ps.close();
			cn=connection.cnx();
			String sqll="delete from fichePatient where codeConsultation  = ?";
			 pss=cn.prepareStatement(sqll);
			pss.setString(1, comboBox.getSelectedItem().toString());				
			int result = pss.executeUpdate();
			if(result != 0) {
				JOptionPane.showMessageDialog(null, "Consultation supprimée...");
				dispose();
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 
			}finally {
				try {
					pss.close();
					
				}catch(Exception exx) {}
			}
    }
    public void modifierBilan() {
 		cn=connection.cnx();
			try {
				String sql="update analyses set results   = ? , contenuAnalyses  = ?  where codePatient  = ? and codeConsultation = ? ";
			ps=cn.prepareStatement(sql);				
			ps.setString(1, t1.getText());
			ps.setString(2, t2.getText()); 		
			ps.setString(3, textField_1.getText());
			ps.setString(4, comboBox.getSelectedItem().toString());
			int result = ps.executeUpdate();
			if(result != 0) {
				JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
				dispose();
			}
			
			}catch(Exception ex ) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				 
			}finally {
				try {
					ps.close();
				
				}catch(Exception exx) {}
			}
    }
    public void afficherBilan() {
		try {	
			cn=connection.cnx();
			String sql="select * from analyses where codeConsultation = ? and  codePatient= ?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, comboBox.getSelectedItem().toString());
			ps.setString(2, textField_1.getText());
			rs=ps.executeQuery();
			while(rs.next()) {
				t2.setText(rs.getString("contenuAnalyses"));
				t1.setText(rs.getString("results"));	
			}
			
		}catch(Exception ex) {
			
		}finally {
			try {
				rs.close();
				ps.close();
			}catch(Exception ex) {
				
			}
		} 
    }
    public void afficherAPCI() {
		try {	cn=connection.cnx();
		String sql="select * from apci where codeConsultation = ? and  codePatient= ?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, comboBox.getSelectedItem().toString());
		ps.setString(2, textField_1.getText());
		rs=ps.executeQuery();
		while(rs.next()) {
			t1.setText(rs.getString("numAPCI"));
			t2.setText(rs.getString("descriptionAPCI"));
			t3.setText(rs.getString("nomDocteur"));
			t4.setText(rs.getString("spécialiteDocteur"));
			t5.setText(rs.getString("adresseCabinet"));
			t6.setText(rs.getString("NumTelCabinet"));

		}
 
	
	}catch(Exception ex) {
		
	}finally {
		try {
			rs.close();
			ps.close();
		}catch(Exception ex) {
			
		}
	}
    }
    public void afficherCertificat() {
    	try {	cn=connection.cnx();
		String sql="select * from certificat where codeConsultation= ? and codePatient= ?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, comboBox.getSelectedItem().toString());
		ps.setString(2, textField_1.getText());
		rs=ps.executeQuery();
		while(rs.next()) {
			t2.setText(rs.getString("contenuCertificat"));
		}
		
	}catch(Exception ex) {
		
	}finally {
		try {
			rs.close();
			ps.close();
		}catch(Exception ex) {
			
		}
	}
    }
    public void afficherOrdonnance() throws Exception {  
    	cn=connection.cnx();
		String sql="select * from ordonnance where codeConsultation = ? and  codePatient= ?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, (comboBox.getSelectedItem()).toString());
		ps.setString(2, textField_1.getText());
		rs=ps.executeQuery();
		while(rs.next()) {
			t1.setText(rs.getString("codeOrdonnance"));
			t2.setText(rs.getString("contenuOrdonnance"));	}
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultation frame = new Consultation();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}



	public static JTextField getTextField_1() {
		return textField_1;
	}

	public static JTextField getTextField_2() {
		return textField_2;
	}

	public static JTextField getTextField_3() {
		return textField_3;
	}

	public static JTextField getTextField_4() {
		return textField_4;
	}

	public static JTextField getTextField_5() {
		return textField_5;
	}

	/**
	 * Create the frame.
	 */
	public void clear() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		bbt.setVisible(false);
		bbbt.setVisible(false);
		table.setVisible(false);
		scrollPane.setVisible(false);
		
	}
	public void cacher(JLabel l1,JLabel l2,JLabel l3,JLabel l4,JLabel l5,JLabel l6,JLabel pres) {
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		t5.setVisible(false);
		t6.setVisible(false);
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		l6.setVisible(false);
		pres.setVisible(false);
	}
	public Consultation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consultation.class.getResource("/Images/images (7).jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1171, 789);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLhistoriqueDesConsultations = new JLabel("L'historique des consultations");
		lblLhistoriqueDesConsultations.setForeground(SystemColor.textHighlight);
		lblLhistoriqueDesConsultations.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblLhistoriqueDesConsultations.setBounds(10, 22, 394, 52);
		contentPane.add(lblLhistoriqueDesConsultations);
		
		JLabel label_1 = new JLabel("Code consultation");
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_1.setBounds(28, 113, 110, 21);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(172, 173, 267, 43);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("CIN patient");
		label_2.setForeground(SystemColor.textHighlight);
		label_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_2.setBounds(28, 187, 110, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Date consultation");
		label_3.setForeground(SystemColor.textHighlight);
		label_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_3.setBounds(28, 272, 110, 21);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.window);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(172, 338, 267, 43);
		contentPane.add(textField_2);
		
		JLabel label_4 = new JLabel("Commentaire");
		label_4.setForeground(SystemColor.textHighlight);
		label_4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_4.setBounds(28, 352, 110, 21);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.window);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(172, 420, 267, 43);
		contentPane.add(textField_3);
		
		JLabel label_5 = new JLabel("Montant pay\u00E9");
		label_5.setForeground(SystemColor.textHighlight);
		label_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_5.setBounds(28, 434, 110, 21);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.window);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(172, 503, 267, 43);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("Cause consultation");
		label_6.setForeground(SystemColor.textHighlight);
		label_6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_6.setBounds(28, 517, 110, 21);
		contentPane.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.window);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(172, 256, 267, 43);
		contentPane.add(textField_5);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(100);

		comboBox.setBackground(SystemColor.window);
		comboBox.setForeground(SystemColor.textHighlight);
		comboBox.setBounds(182, 114, 104, 20);
		contentPane.add(comboBox);
		
		JButton btnOrdonnances = new JButton("Ordonnances");
	
		btnOrdonnances.setForeground(SystemColor.textHighlight);
		btnOrdonnances.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnOrdonnances.setBounds(473, 40, 119, 38);
		contentPane.add(btnOrdonnances);
		
		JButton btnCertificats = new JButton("Certificats");

		btnCertificats.setForeground(SystemColor.textHighlight);
		btnCertificats.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnCertificats.setBounds(473, 93, 119, 38);
		contentPane.add(btnCertificats);
		
		JButton btnApcis = new JButton("APCIs");
	
		btnApcis.setForeground(SystemColor.textHighlight);
		btnApcis.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnApcis.setBounds(473, 142, 119, 38);
		contentPane.add(btnApcis);
		
		JButton btnAnalyses = new JButton("Analyses");
	
		btnAnalyses.setForeground(SystemColor.textHighlight);
		btnAnalyses.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnAnalyses.setBounds(473, 191, 119, 38);
		contentPane.add(btnAnalyses);
		
		t1 = new JTextField();
		t1.setBackground(SystemColor.window);
		t1.setEditable(false);
		t1.setVisible(false);
		t1.setColumns(10);
		t1.setBounds(831, 51, 267, 43);
		contentPane.add(t1);
		
		JLabel l1 = new JLabel("Code");
		l1.setVisible(false);
		l1.setForeground(SystemColor.textHighlight);
		l1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l1.setBounds(619, 65, 178, 21);
		contentPane.add(l1);
		
		t2 = new JTextField();
		t2.setBackground(SystemColor.window);
		t2.setEditable(false);
		t2.setForeground(SystemColor.textText);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		t2.setVisible(false);
		t2.setColumns(10);
		t2.setBounds(831, 113, 267, 43);
		contentPane.add(t2);
		
		JLabel l2 = new JLabel("Contenu");
		l2.setVisible(false);
		l2.setForeground(SystemColor.textHighlight);
		l2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l2.setBounds(619, 129, 178, 21);
		contentPane.add(l2);
		
		t3 = new JTextField();
		t3.setBackground(SystemColor.window);
		t3.setEditable(false);
		t3.setVisible(false);
		t3.setColumns(10);
		t3.setBounds(831, 293, 267, 43);
		contentPane.add(t3);
		
		JLabel l3 = new JLabel("R\u00E9sultat");
		l3.setVisible(false);
		l3.setForeground(SystemColor.textHighlight);
		l3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l3.setBounds(619, 307, 178, 21);
		contentPane.add(l3);
		
		t4 = new JTextField();
		t4.setBackground(SystemColor.window);
		t4.setEditable(false);
		t4.setVisible(false);
		t4.setColumns(10);
		t4.setBounds(831, 347, 267, 43);
		contentPane.add(t4);
		
		JLabel l4 = new JLabel("Sp\u00E9cialit\u00E9 du m\u00E9decin");
		l4.setVisible(false);
		l4.setForeground(SystemColor.textHighlight);
		l4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l4.setBounds(619, 361, 178, 21);
		contentPane.add(l4);
		
		t5 = new JTextField();
		t5.setBackground(SystemColor.window);
		t5.setEditable(false);
		t5.setVisible(false);
		t5.setColumns(10);
		t5.setBounds(831, 401, 267, 43);
		contentPane.add(t5);
		
		JLabel l5 = new JLabel("Adresse cabinet");
		l5.setVisible(false);
		l5.setForeground(SystemColor.textHighlight);
		l5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l5.setBounds(619, 415, 178, 21);
		contentPane.add(l5);
		
		 bbt = new JButton("Modifier");
		 bbt.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		t1.setEditable(true);
		 		t2.setEditable(true);
		 		bbbt.setEnabled(true);
		 	}
		 });
		bbt.setVisible(false);
		bbt.setForeground(SystemColor.textHighlight);
		bbt.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		bbt.setBounds(916, 517, 104, 38);
		contentPane.add(bbt);
		
		 bbbt = new JLabel("Mettre \u00E0 jour>>");
		 bbbt.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
	modifierBilan();
		 	}
		 });
		bbbt.setVisible(false);
		bbbt.setForeground(Color.RED);
		bbbt.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		bbbt.setEnabled(false);
		bbbt.setBounds(916, 554, 104, 24);
		contentPane.add(bbbt);
		
		t6 = new JTextField();
		t6.setBackground(SystemColor.window);
		t6.setEditable(false);
		t6.setVisible(false);
		t6.setVerifyInputWhenFocusTarget(false);
		t6.setColumns(10);
		t6.setBounds(831, 455, 267, 43);
		contentPane.add(t6);
		
		JLabel l6 = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone du cabinet");
		l6.setVisible(false);
		l6.setVerifyInputWhenFocusTarget(false);
		l6.setForeground(SystemColor.textHighlight);
		l6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l6.setBounds(619, 469, 178, 21);
		contentPane.add(l6);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(533, 240, 10, 345);
		contentPane.add(separator);
		
		 scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(643, 374, 429, 221);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setVisible(false);
		scrollPane.setViewportView(table);
		
		JLabel pres = new JLabel("Prescription");
		pres.setVisible(false);
		pres.setForeground(SystemColor.textHighlight);
		pres.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		pres.setBounds(792, 338, 110, 21);
		contentPane.add(pres);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(287, 616, 521, 2);
		contentPane.add(separator_1);
		
		 progressBar = new JProgressBar();
		 progressBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		progressBar.setValue(1);
		progressBar.setMaximum(1825);
		progressBar.setForeground(SystemColor.textHighlight);
		progressBar.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(354, 651, 380, 14);
		contentPane.add(progressBar);
		
		JLabel label_7 = new JLabel("Les ann\u00E9es d'absence du patient");
		label_7.setForeground(SystemColor.textHighlight);
		label_7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		label_7.setBounds(442, 619, 203, 21);
		contentPane.add(label_7);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {   //suppresion de la consultation affichée
					cn=connection.cnx();
					String sql="delete from consultation where codePatient = ? and codeConsultation = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField_1.getText());
					ps.setString(2, comboBox.getSelectedItem().toString());				
					ps.executeUpdate();															
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {						
						ps.close();
						cn.close();
				suppFichePatient();
				      dispose(); 
					}catch(Exception ex) {}
				}
			}
		});
		btnSupprimer.setForeground(SystemColor.textHighlight);
		btnSupprimer.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnSupprimer.setBounds(148, 580, 119, 38);
		contentPane.add(btnSupprimer);
		
		JLabel lblAns = new JLabel("<html> '                                                             \r\n5 ans </html>");
		lblAns.setForeground(SystemColor.textHighlight);
		lblAns.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAns.setBounds(733, 664, 24, 52);
		contentPane.add(lblAns);
		
		JLabel lblAns_1 = new JLabel("<html> '                                                             \r\n0 ans </html>");
		lblAns_1.setForeground(SystemColor.textHighlight);
		lblAns_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblAns_1.setBounds(354, 664, 24, 52);
		contentPane.add(lblAns_1);
		
		JLabel label = new JLabel("'\r\n");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		label.setBounds(533, 659, 10, 43);
		contentPane.add(label);

		btnCertificats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cacher(l1,l2,l3,l4,l5,l6,pres);
			     clear();
				t2.setVisible(true);
				l2.setText("Contenu");
				t2.setBounds(831, 113, 267, 400);
				l2.setVisible(true);
				t2.setEditable(false);
				btnCertificats.setEnabled(false);

		afficherCertificat();
			}
		});
		btnApcis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cacher(l1,l2,l3,l4,l5,l6,pres);
				clear();
				l1.setText("Numéro APCI");
				l1.setVisible(true);
				t1.setVisible(true);
				l2.setText("Description");
				t2.setVisible(true);
				l2.setVisible(true);
				l3.setText("Nom du médecin");
				l4.setText("Spécialité du médecin");
				l5.setText("Adresse cabinet");
				l6.setText("Numéro téléphone du cabinet");
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				t6.setVisible(true);
				t1.setEditable(false);
				t2.setEditable(false); 
				t3.setEditable(false);
				t4.setEditable(false);
				t5.setEditable(false);
				t6.setEditable(false);
				t2.setBounds(831, 113, 267, 100);
				btnApcis.setEnabled(false);
afficherAPCI();
			}
		});
		btnAnalyses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cacher(l1,l2,l3,l4,l5,l6,pres);
				clear();
				l2.setText("Les analyses demandées");
				l1.setText("Les résultats");
				t1.setVisible(true);
				t2.setVisible(true);
			    t2.setBounds(831, 113, 267, 400);
				l1.setVisible(true);
				l2.setVisible(true);
				t1.setEditable(false);
				t2.setEditable(false);
				bbt.setVisible(true);
				bbbt.setVisible(true);
				btnAnalyses.setEnabled(false);
				
afficherBilan();
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOrdonnances.setEnabled(true);
				btnCertificats.setEnabled(true);
				btnApcis.setEnabled(true);
				btnAnalyses.setEnabled(true);
				cn= connection.cnx();
				try {    //afficher les infos de la consultation à partir du code selcetionné
					String sql="select * from consultation where codeconsultation = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, comboBox.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next()) {
						textField_1.setText(rs.getString("codePatient"));
						textField_5.setText(rs.getString("dateConsultationt"));
						textField_2.setText(rs.getString("commentaire"));
						textField_3.setText(rs.getString("montantPaye"));
						textField_4.setText(rs.getString("causeConsultation"));						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				finally {
					try {
						rs.close();
						ps.close();
					}catch(Exception ex) {
						
						
					}
				}			cn= connection.cnx();
				try {
					String sql="select * from consultation where codeconsultation = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, comboBox.getSelectedItem().toString());
					rs=ps.executeQuery();
					while(rs.next()) {
						textField_1.setText(rs.getString("codePatient"));
						textField_5.setText(rs.getString("dateConsultationt"));
						textField_2.setText(rs.getString("commentaire"));
						textField_3.setText(rs.getString("montantPaye"));
						textField_4.setText(rs.getString("causeConsultation"));						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				finally {
					try {
						rs.close();
						ps.close();
					}catch(Exception ex) {
						
						
					}
				}
			}
		});
		btnOrdonnances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				cacher(l1,l2,l3,l4,l5,l6,pres);				
				table.setVisible(true);
				scrollPane.setVisible(true);
				pres.setVisible(true);
				table.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		        Object[] columns= {"Nom du médicament","Quantité","Nombre de fois"};
		        DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(columns);
		        table.setModel(model);
		        table.setBackground(SystemColor.textHighlight);
		        table.setForeground(Color.WHITE);
		        table.setRowHeight(30);
				l2.setText("Contenu");
				l1.setText("Code");
				t1.setVisible(true);
				t2.setVisible(true);
			t2.setBounds(831, 113, 267, 200);
				l1.setVisible(true);
				l2.setVisible(true);
				t1.setEditable(false);
				t2.setEditable(false);
				btnOrdonnances.setEnabled(false);
				
			try {	afficherOrdonnance();
				
				
			}catch(Exception ex) {
				
			}finally {
				try {
					rs.close();
					ps.close();
					
					try {   //affchage de la prescription de l'ordonnance
						cn=connection.cnx();
						String sql="select * from prescription where codeOrdonnance = ?  ";
						PreparedStatement pps=cn.prepareStatement(sql);
						pps.setString(1, t1.getText());
						ResultSet rss= pps.executeQuery();
						Object[] row= new Object[3];
						while (rss.next()) {
						
						row[0]= rss.getString("nommedicament");
						row[1]=rss.getString("qtemedicament");
						row[2]= rss.getString("nbrfois");
						model.addRow(row);
						}
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						try {
							rs.close();
							ps.close();
						
						}catch(Exception ex) {}
					}
				}catch(Exception ex) {
					
				}
			}
				
			}
		});
	}
}
