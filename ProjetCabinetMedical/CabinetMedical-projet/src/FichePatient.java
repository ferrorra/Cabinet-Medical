import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FichePatient extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextArea textField_7;
	private static  JTextField textField_8;
	private  static JTextField textField_9;
	private static  JTextField textField_10;
	private Assurance assurance;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public static JTextField getTextField() {
		return textField;
	}



	public  static JTextField getTextField_1() {
		return textField_1;
	}



	public  static JTextField getTextField_2() {
		return textField_2;
	}



	public  static JTextField getTextField_3() {
		return textField_3;
	}



	public  static JTextField getTextField_4() {
		return textField_4;
	}



	public static  JTextField getTextField_5() {
		return textField_5;
	}



	public static  JTextField getTextField_6() {
		return textField_6;
	}



	public  static JTextArea getTextField_7() {
		return textField_7;
	}



	public  static JTextField getTextField_8() {
		return textField_8;
	}
	
	
	
	public  static JTextField getTextField_9() {
		return textField_9;
	}



	public  static JTextField getTextField_10() {
		return textField_10;
	}

	/**
	 * Launch the application.
	 */
	public void modifierInfoPatient() {    //modifier les informations du dossier du patient
		cn=connection.cnx();
		try {
			String sql="update patient set nomPatient = ?, prenomPatient = ?, dateNaissance = ?, sexePatient = ?, numTel = ?, profession = ?, adressePatient = ?, emailPatient = ?, dateInscription = ?, matriculeAss = ? where codePatient = ?";
		ps=cn.prepareStatement(sql);
		
		ps.setString(1, textField_1.getText());
		ps.setString(2, textField_2.getText()); 
		ps.setString(3, textField_3.getText());
		ps.setString(4, textField_4.getText());
		ps.setString(5, textField_5.getText());
		ps.setString(6, textField_6.getText());
		ps.setString(7, textField_7.getText());
		ps.setString(8, textField_8.getText());
		ps.setString(9, textField_9.getText());
		ps.setString(10, textField_10.getText());
		ps.setString(11, textField.getText());
		int result = ps.executeUpdate();
		if(result != 0) {
			JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
			dispose();
		}
		
		}catch(Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			
		}finally {
			try {
				Medecin.MontrerInfosPatient();
				ps.close();
			}catch(Exception ex) {
				
			}
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichePatient frame = new FichePatient();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}

	public FichePatient() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 607);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(845, 11, 17, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Les informations du patient");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(24, 22, 326, 49);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.window);
		textField.setEditable(false);
		textField.setBounds(186, 115, 219, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setForeground(SystemColor.textHighlight);
		lblCin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblCin.setBounds(10, 117, 152, 38);
		contentPane.add(lblCin);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(186, 178, 219, 38);
		contentPane.add(textField_1);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(SystemColor.textHighlight);
		lblNom.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblNom.setBounds(10, 180, 152, 38);
		contentPane.add(lblNom);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.window);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(186, 249, 219, 38);
		contentPane.add(textField_2);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setForeground(SystemColor.textHighlight);
		lblPrnom.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblPrnom.setBounds(10, 251, 152, 38);
		contentPane.add(lblPrnom);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.window);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(186, 317, 219, 38);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.window);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(186, 392, 219, 38);
		contentPane.add(textField_4);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setForeground(SystemColor.textHighlight);
		lblDateDeNaissance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblDateDeNaissance.setBounds(10, 319, 152, 38);
		contentPane.add(lblDateDeNaissance);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.window);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(186, 468, 219, 38);
		contentPane.add(textField_5);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setForeground(SystemColor.textHighlight);
		lblSexe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblSexe.setBounds(10, 395, 152, 38);
		contentPane.add(lblSexe);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.window);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(616, 121, 219, 38);
		contentPane.add(textField_6);
		
		JLabel lblNumroDeTlphone = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblNumroDeTlphone.setForeground(SystemColor.textHighlight);
		lblNumroDeTlphone.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblNumroDeTlphone.setBounds(10, 468, 178, 38);
		contentPane.add(lblNumroDeTlphone);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(616, 184, 219, 38);
		contentPane.add(scrollPane);
		
		textField_7 = new JTextArea();
		textField_7.setBackground(SystemColor.window);
		scrollPane.setViewportView(textField_7);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JLabel lblProfession = new JLabel("Profession");
		lblProfession.setForeground(SystemColor.textHighlight);
		lblProfession.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblProfession.setBounds(448, 117, 158, 38);
		contentPane.add(lblProfession);
		
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.window);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(616, 255, 219, 38);
		contentPane.add(textField_8);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(SystemColor.textHighlight);
		lblAdresse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblAdresse.setBounds(448, 188, 158, 38);
		contentPane.add(lblAdresse);
		
		textField_9 = new JTextField();
		textField_9.setBackground(SystemColor.window);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(616, 321, 219, 38);
		contentPane.add(textField_9);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblEmail.setBounds(448, 254, 158, 38);
		contentPane.add(lblEmail);
		
		textField_10 = new JTextField();
		textField_10.setBackground(SystemColor.window);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(616, 396, 219, 38);
		contentPane.add(textField_10);
		
		JLabel lblMatriculeAssurance = new JLabel("Matricule Assurance");
		lblMatriculeAssurance.setForeground(SystemColor.textHighlight);
		lblMatriculeAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblMatriculeAssurance.setBounds(448, 390, 158, 38);
		contentPane.add(lblMatriculeAssurance);
		
		JButton m = new JButton("Mofidier");
	
		m.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		m.setForeground(SystemColor.textHighlight);
		m.setBounds(521, 485, 104, 38);
		contentPane.add(m);
		
		JLabel maj = new JLabel("Mettre \u00E0 jour>>");
		maj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
            modifierInfoPatient();
			}
		});
		maj.setEnabled(false);
		maj.setForeground(Color.RED);
		maj.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		maj.setBounds(521, 522, 104, 24);
		contentPane.add(maj);
		
		JLabel label = new JLabel(">>");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				assurance = new Assurance();
				assurance.setVisible(true);
				assurance.setInsc(false);   // l'assurance est appellé lors de l'affichage
				
				try {
					cn=connection.cnx();		
					String sql="select * from assurance where codePatient = ? " ;   //afficher les infos de l'assurance du patient
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField.getText());
					rs=ps.executeQuery();
					
					while(rs.next())
					{
						assurance.getTextField().setText(rs.getString("matriculeAss"));
						assurance.getTextField_1().setText(rs.getString("typeAss"));
						assurance.getTextField_2().setText(rs.getString("validiteAss"));
						textField.setEditable(false);
						
					}
					
				
					rs.close();
					ps.close();		
					cn.close();
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					
				}finally {
					try {
						
					}catch(Exception ex) {}
				}
				
			}
		});
		label.setForeground(Color.RED);
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		label.setBounds(839, 394, 33, 38);
		contentPane.add(label);
		
		JLabel lblDateInscription = new JLabel("Date inscription");
		lblDateInscription.setForeground(SystemColor.textHighlight);
		lblDateInscription.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblDateInscription.setBounds(448, 317, 158, 38);
		contentPane.add(lblDateInscription);
		m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maj.setEnabled(true);   // rendre possible la modification des champs
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_8.setEditable(true);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
			}
		});
	}
}
