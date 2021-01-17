import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Assurance extends JFrame {
	private static boolean insc = true;   //variable pour définir si le JFrame assurance a été appelé lors de l'inscription ou bien lors de l'affichage des infos du patient
	public boolean isInsc() {
		return insc;
	}

	public static void setInsc(boolean inc) {
		insc = inc;
	}
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
private static JButton btnEnregistrer_1;
	public static JButton getBtnEnregistrer_1() {
	return btnEnregistrer_1;
}

	public static JTextField getTextField() {
		return textField;
	} 

	public static void setTextField(JTextField textField) {
		Assurance.textField = textField;
	}

	public static JTextField getTextField_1() {
		return textField_1;
	}

	public static void setTextField_1(JTextField textField_1) {
		Assurance.textField_1 = textField_1;
	}

	public static JTextField getTextField_2() {
		return textField_2;
	}

	public static void setTextField_2(JTextField textField_2) {
		Assurance.textField_2 = textField_2;
	}

	public void MettreAjourAssurance() {    //modifier les infos d'une assurance 
		cn=connection.cnx();
		try {
			String sql="update assurance set typeAss  = ? , validiteAss = ?  where matriculeAss = ?";
		ps=cn.prepareStatement(sql);				
		ps.setString(1, textField_1.getText());
		ps.setString(2, textField_2.getText()); 		
		ps.setString(3, textField.getText());
		int result = ps.executeUpdate();
		if(result != 0) {
			JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
			dispose();
		}
		
		}catch(Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			
		}
	}
	public void EtablirAssurance(JTextField codePatient) {    //enregister une assurance
	     try {
						cn=connection.cnx();	
						String sql="insert into assurance (matriculeAss, typeAss, validiteAss, codePatient ) values(?, ?, ?, ?)" ;
						ps=cn.prepareStatement(sql);
						ps.setString(1, textField.getText());
						ps.setString(2,textField_1.getText());
						ps.setString(3, textField_2.getText());
						ps.setString(4, codePatient.getText());
					    ps.executeUpdate();
			
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
						
					}finally {
						try {  //on sauvegarde le matricule dans la table du patient
							cn=connection.cnx();	
							String sql="update patient set matriculeAss = ? where codePatient = ?" ;
							ps=cn.prepareStatement(sql);
							ps.setString(1, textField.getText());
							ps.setString(2,  codePatient.getText());
							int result = ps.executeUpdate();
							if(result !=0)
							{
								JOptionPane.showMessageDialog(null, "Assurance sauvegardée !");
								dispose();
							}
								
								ps.close();
								cn.close();
						}catch(Exception e) {
							
						}
					}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assurance frame = new Assurance();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}

	public void supprimerAssurance() {  //suppresion de l'assurance
		try {
			cn=connection.cnx();
			String sql="delete from assurance where matriculeAss  = ?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField.getText());	
			int result = ps.executeUpdate();	
			if(result != 0) {
				JOptionPane.showMessageDialog(null, "Assurance suprimée");
				dispose();
			}														
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				
			}catch(Exception ex) {}
		}
	}
	public Assurance() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Assurance.class.getResource("/Images/images (7).jpg")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
	
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 120, 215)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformationsAssurance = new JLabel("Informations Assurance");
		lblInformationsAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		lblInformationsAssurance.setForeground(SystemColor.textHighlight);
		lblInformationsAssurance.setBounds(10, 11, 217, 42);
		contentPane.add(lblInformationsAssurance);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.window);
		textField.setEditable(true);
		textField.setBounds(148, 64, 265, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(148, 117, 265, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.window);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(148, 177, 265, 36);
		contentPane.add(textField_2);
		
		JButton buttonSupp = new JButton("Supprimer");
		buttonSupp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supprimerAssurance();
			}
		});
		buttonSupp.setForeground(SystemColor.textHighlight);
		buttonSupp.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		buttonSupp.setBounds(290, 228, 104, 38);
		contentPane.add(buttonSupp);
	
		
		JButton btnEnregistrer_1 = new JButton("Enregistrer");
		btnEnregistrer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(insc==true) {
		EtablirAssurance(Medecin.getTextField_1());   // si assurance à été appelé lors de l'inscription
			}else {
				EtablirAssurance(FichePatient.getTextField());// si assurance à été appelé lors de l'affichage 
			}
			Medecin.MontrerInfosPatient();    //Recharger la table aprés ajout de l'assurance
			}
		});
		btnEnregistrer_1.setForeground(SystemColor.textHighlight);
		btnEnregistrer_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnEnregistrer_1.setBounds(20, 228, 104, 38);
		contentPane.add(btnEnregistrer_1);
		
		JLabel label = new JLabel("Mettre \u00E0 jour>>");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		MettreAjourAssurance();
			}
		});
		label.setForeground(Color.RED);
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		label.setEnabled(false);
		label.setBounds(148, 265, 104, 24);
		contentPane.add(label);
		
		JLabel lblMatriculeAssurance = new JLabel("Matricule Assurance");
		lblMatriculeAssurance.setForeground(SystemColor.textHighlight);
		lblMatriculeAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		lblMatriculeAssurance.setBounds(10, 69, 128, 31);
		contentPane.add(lblMatriculeAssurance);
		
		JLabel lblTypeAssurance = new JLabel("Type Assurance");
		lblTypeAssurance.setForeground(SystemColor.textHighlight);
		lblTypeAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		lblTypeAssurance.setBounds(10, 122, 128, 31);
		contentPane.add(lblTypeAssurance);
		
		JLabel lblValiditAssurance = new JLabel("Validit\u00E9 Assurance");
		lblValiditAssurance.setForeground(SystemColor.textHighlight);
		lblValiditAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		lblValiditAssurance.setBounds(10, 182, 128, 31);
		contentPane.add(lblValiditAssurance);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				label.setEnabled(true);
			}
		});
		btnModifier.setForeground(SystemColor.textHighlight);
		btnModifier.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnModifier.setBounds(148, 228, 104, 38);
		contentPane.add(btnModifier);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 try {
						cn=connection.cnx();	
						String sql="select * from  assurance where matriculeAss = ?" ; //verifier si le patient a déjà une assurance
						ps=cn.prepareStatement(sql);
					
						ps.setString(1,textField.getText() );
										
						rs = ps.executeQuery();
					if(rs.next())    //si le patient a une assurance
					{
						btnModifier.setEnabled(true);   //on peut modifier
						btnEnregistrer_1.setEnabled(false);   //on n'a rien à enregistrer 
						buttonSupp.setEnabled(true);   // on peut supprimer
						
						
					}else {   // si le patient n'a pas d'assurance
						btnModifier.setEnabled(false);
						buttonSupp.setEnabled(false);
						btnEnregistrer_1.setEnabled(true);  //on peut lui ajouter une assurance
						textField.setEditable(true);
						textField_1.setEditable(true);
						textField_2.setEditable(true);
												
					}						
						ps.close();
						cn.close();
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
						
					}
			}
		});
	}
}
