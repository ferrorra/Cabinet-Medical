import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textField_3;
	private Connection cn=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	private JPasswordField m1;
	private JPasswordField m2;
	private JComboBox comboBox ;
	JRadioButton H ;


	public void inscription() {
		
		if((new String(m1.getPassword()).equals(new String(m2.getPassword()))))
		{
			//si les deux champs du mdps sont égaux, le patient sera enregistré
		 cn=connection.cnx();
		 String sql="insert into registration (nomUtilisateur, motDePasse, numTel, email, adresse , sexe, role) values(?, ?,?, ?, ?, ?,?)";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField.getText().toString());
			ps.setString(2, m1.getText());
			ps.setString(3, textField_1.getText().toString());
			ps.setString(4, textField_2.getText().toString());
			ps.setString(5, textField_3.getText().toString());
			if(H.isSelected())
			{
			ps.setString(6, "Homme");
			
			}
		else
		{
			ps.setString(6, "Femme");
		}
			ps.setString(7, comboBox.getSelectedItem().toString());					
		int result = ps.executeUpdate();	
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Inscription avec succès !");	
				dispose();
				new Login().setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Il y a un problème...");	
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Un problème est survenu..." +  e.getMessage());
		
		}
		finally {
			
			try {
				
				ps.close();
				cn.close();
			}catch(Exception e) {
			}
		}
		
		
		}else {
			JOptionPane.showMessageDialog(null, "Erreur du mot de passe");
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
				
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
		setTitle("Inscription Cabinet M\u00E9dical");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 504);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(812, 143, 188, 26);
		contentPane.add(scrollPane);
		
		textField_3 = new JTextArea();
		scrollPane.setViewportView(textField_3);
		textField_3.setBackground(Color.WHITE);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registration.class.getResource("/Images/ILLUST~1.JPG")));
		lblNewLabel.setBounds(-41, 0, 599, 469);   
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(812, 49, 188, 2);
		contentPane.add(separator);
		
		textField = new JTextField();

		textField.setBounds(812, 23, 188, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(812, 88, 188, 2);
		contentPane.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(812, 62, 188, 26);
		contentPane.add(textField_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(812, 127, 188, 2);
		contentPane.add(separator_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(812, 101, 188, 26);
		contentPane.add(textField_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(812, 169, 188, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(812, 248, 188, 2);
		contentPane.add(separator_5);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(SystemColor.textHighlight);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M\u00E9decin", "Assistant(e)"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(846, 330, 123, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("S'inscrire");
	
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		btnNewButton.setBounds(632, 395, 147, 43);
		contentPane.add(btnNewButton);		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(632, 29, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNumroDeTlphone = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblNumroDeTlphone.setForeground(SystemColor.textHighlight);
		lblNumroDeTlphone.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNumroDeTlphone.setBounds(632, 68, 147, 14);
		contentPane.add(lblNumroDeTlphone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblEmail.setBounds(632, 106, 147, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(SystemColor.textHighlight);
		lblAdresse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblAdresse.setBounds(632, 149, 147, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setForeground(SystemColor.textHighlight);
		lblSexe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblSexe.setBounds(632, 189, 147, 14);
		contentPane.add(lblSexe);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(SystemColor.textHighlight);
		lblMotDePasse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblMotDePasse.setBounds(632, 228, 147, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConfirmerMotDe = new JLabel("Confirmer mot de passe");
		lblConfirmerMotDe.setForeground(SystemColor.textHighlight);
		lblConfirmerMotDe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblConfirmerMotDe.setBounds(632, 276, 147, 14);
		contentPane.add(lblConfirmerMotDe);
		
		JLabel lblVousEtes = new JLabel("Division");
		lblVousEtes.setForeground(new Color(0, 120, 215));
		lblVousEtes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblVousEtes.setBounds(846, 305, 119, 14);
		contentPane.add(lblVousEtes);
		
		 H = new JRadioButton("Homme");

		H.setBackground(Color.WHITE);
		H.setForeground(SystemColor.textHighlight);
		H.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		H.setBounds(810, 186, 79, 23);
		contentPane.add(H);
		
		JRadioButton F = new JRadioButton("Femme");
		F.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(F.isSelected()) {
					H.setSelected(false);
				}
			}
		});
		F.setBackground(Color.WHITE);
		F.setForeground(SystemColor.textHighlight);
		F.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		F.setBounds(921, 186, 79, 23);
		contentPane.add(F);
		H.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(H.isSelected()) {
					F.setSelected(false);
				}
			}
		});
		JLabel lblSeConnecter = new JLabel("Se connecter>>");
		lblSeConnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new Login().setVisible(true);
			}
		});
		lblSeConnecter.setForeground(Color.RED);
		lblSeConnecter.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblSeConnecter.setBounds(795, 413, 102, 14);
		contentPane.add(lblSeConnecter);
		
		m1 = new JPasswordField();
		m1.setBounds(812, 221, 188, 30);
		contentPane.add(m1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(812, 288, 188, 2);
		contentPane.add(separator_4);
		
		m2 = new JPasswordField();
		m2.setBounds(812, 261, 188, 30);
		contentPane.add(m2);
		
		JLabel lblCeNomExiste = new JLabel("Ce nom existe d\u00E9ja");
		lblCeNomExiste.setVisible(false);
		lblCeNomExiste.setForeground(Color.RED);
		lblCeNomExiste.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		lblCeNomExiste.setBounds(1010, 29, 102, 14);
		contentPane.add(lblCeNomExiste);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inscription();
			}
		});
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					cn= connection.cnx();
					String sql="select * from registration where nomUtilisateur = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField.getText());
					rs= ps.executeQuery();
					if(rs.next()) 
						lblCeNomExiste.setVisible(true);   // si le souscripteur saisit un nom déjà existant, le systéme le lui dira car le nom d'utiisateur doit etre unique
					else
						lblCeNomExiste.setVisible(false);
							
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Une erreur s'est produite");
				}
			}
		});
	}
}
