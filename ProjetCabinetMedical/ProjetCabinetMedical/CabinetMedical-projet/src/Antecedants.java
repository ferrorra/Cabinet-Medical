import java.awt.BorderLayout;
import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Antecedants extends JFrame {
	Connection cn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	private JPanel contentPane;
	private static JTextField textField;
	private  static JTextField textField_1;
	private static  JTextArea textField_2;


	public static JTextField getTextField() {
		return textField;
	}

	public static JTextField getTextField_1() {
		return textField_1;
	}

	public static JTextArea getTextField_2() {
		return textField_2;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Antecedants frame = new Antecedants();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void updateAntecedants() {    //modifier les informations des antecedants du patient
		cn=connection.cnx();
		try {
			String sql="update antecedant set descriptionAntecedants = ? where codePatient = ? ";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_2.getText());
		ps.setString(2, textField.getText());
	//	ps.setString(3, textField_1.getText());		
		int result = ps.executeUpdate();
		if(result != 0) {
			JOptionPane.showMessageDialog(null, "Mise à jour avec succès");
			dispose();
		}
		
		}catch(Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			
		}finally {
			try {
				Medecin.MontrerInfosPatient();   //rechargement de la table
				ps.close();
				dispose();
			}catch(Exception ex) {
				
			}
		}
	}
	public void enregisterAntecedants() {
		 try {
				cn=connection.cnx();	
				String sql="insert into antecedant (codePatient, codeAntecedant, descriptionAntecedants) values(?, ?, ?)" ;
				ps=cn.prepareStatement(sql);
				ps.setString(1, textField.getText());
				ps.setString(2,textField_1.getText() );
				ps.setString(3, textField_2.getText());						
				int result = ps.executeUpdate();
			if(result !=0)
			{
				JOptionPane.showMessageDialog(null, "Antécédants sauvegardées !");
				dispose();
			}
				
				ps.close();
				cn.close();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				
			}
	}
	public void supprimerAntecedants() {
		try {
			cn=connection.cnx();
			String sql="delete from antecedant where codePatient = ? and codeAntecedant = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField.getText());	
			ps.setString(2, textField_1.getText());
			int result = ps.executeUpdate();	
			if(result != 0) {
				JOptionPane.showMessageDialog(null, "Antécédants suprimés");
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
	public Antecedants() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Antecedants.class.getResource("/Images/images (7).jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 560);
		contentPane = new JPanel();

		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.textHighlight));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Les ant\u00E9c\u00E9dants du patient");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(26, 22, 345, 48);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.window);
		textField.setEditable(false);
		textField.setBounds(206, 100, 248, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(206, 168, 248, 36);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 249, 248, 156);
		contentPane.add(scrollPane);
		
		textField_2 = new JTextArea();
		textField_2.setBackground(SystemColor.window);
		scrollPane.setViewportView(textField_2);

		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel lblCin = new JLabel("CIN");
		lblCin.setForeground(SystemColor.textHighlight);
		lblCin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblCin.setBounds(26, 105, 39, 24);
		contentPane.add(lblCin);
		
		JLabel lblCodeAntcdants = new JLabel("Code ant\u00E9c\u00E9dants");
		lblCodeAntcdants.setForeground(SystemColor.textHighlight);
		lblCodeAntcdants.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblCodeAntcdants.setBounds(26, 179, 132, 24);
		contentPane.add(lblCodeAntcdants);
		
		JLabel lblDescriptionAntcdants = new JLabel("Description ant\u00E9c\u00E9dants");
		lblDescriptionAntcdants.setForeground(SystemColor.textHighlight);
		lblDescriptionAntcdants.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblDescriptionAntcdants.setBounds(26, 255, 170, 24);
		contentPane.add(lblDescriptionAntcdants);
		
		JButton button = new JButton("Supprimer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	supprimerAntecedants();
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button.setBounds(346, 436, 104, 38);
		contentPane.add(button);
	
		
		JLabel label = new JLabel("Mettre \u00E0 jour>>");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
	            updateAntecedants();
			}
		});
		label.setForeground(Color.RED);
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 14));
		label.setEnabled(false);
		label.setBounds(201, 486, 104, 24);
		contentPane.add(label);
		 
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			enregisterAntecedants();
			}
		});
		btnEnregistrer.setForeground(SystemColor.textHighlight);
		btnEnregistrer.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnEnregistrer.setBounds(52, 436, 104, 38);
		contentPane.add(btnEnregistrer);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				 try {
						cn=connection.cnx();	
						String sql="select * from  antecedant where codePatient = ?" ;
						ps=cn.prepareStatement(sql);
					
						ps.setString(1,textField.getText() );
										
						rs = ps.executeQuery();
					if(rs.next())
					{
						btnEnregistrer.setEnabled(false);
						textField_2.setEditable(true);
						label.setEnabled(true);
					}else {
						label.setEnabled(false);
						button.setEnabled(false);
												
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
