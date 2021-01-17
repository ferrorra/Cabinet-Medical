

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Window.Type;
import java.awt.event.MouseMotionAdapter;

public class DossierMedical extends JFrame {

	private JPanel contentPane;
	private static JTextField textField_8;
	private static JTextField textField_7;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JComboBox comboBox;
	private static DossierMedical frame= new DossierMedical();
	 private Antecedants antecedants;
	public static JComboBox getComboBox() {
		return comboBox;
	}

	private Connection cn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private ConsultationInfo ci = new ConsultationInfo();
public void afficherDossierMedical() {
	try {
		cn= connection.cnx();
		String sql="select * from fichePatient where codePatient = ? and codeconsultation = ?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_1.getText());
		ps.setString(2, comboBox.getSelectedItem().toString());
		rs=ps.executeQuery();
		while(rs.next()) {					
			
			textField_3.setText(rs.getString("codeAntecedants"));
			textField_4.setText(rs.getString("glycemie"));
			textField_5.setText(rs.getString("tension"));
			textField_6.setText(rs.getString("poids"));	
			textField_7.setText(rs.getString("taille"));
			textField_8.setText(rs.getString("groupeSanguin"));						
		}
		
	}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
	}
	finally {
		try {
			rs.close();
			ps.close();
			cn= connection.cnx();
			String sql="select * from consultation  where codePatient = ? and codeconsultation = ?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField_1.getText());
			ps.setString(2, comboBox.getSelectedItem().toString());
			rs=ps.executeQuery();
			while(rs.next()) {					
				textField_2.setText(rs.getString("dateConsultationt"));
				}						
		}catch(Exception ex) {	
		}finally {
			try {
				rs.close();
				ps.close();													
			}catch(Exception ex) {}
		}
	}
}
private int mousepX;
private int mousepY;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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

	public static JTextField getTextField_6() {
		return textField_6;
	}

	public static JTextField getTextField_7() {
		return textField_7;
	}

	public static JTextField getTextField_8() {
		return textField_8;
	}
private int xOffset, yOffset;
	/**
	 * Create the frame.
	 */
	public DossierMedical() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
			frame.setLocation(event.getXOnScreen()-xOffset, event.getYOnScreen()-yOffset);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOffset = e.getX();
				yOffset = e.getY();
			}
		});
		
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 712);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		label.setBounds(547, 11, 17, 24);
		contentPane.add(label);
		
		JLabel lblLeDossierMdical = new JLabel("Les dossiers m\u00E9dicaux du patient");

		lblLeDossierMdical.setForeground(SystemColor.textHighlight);
		lblLeDossierMdical.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblLeDossierMdical.setBounds(10, 22, 527, 52);
		contentPane.add(lblLeDossierMdical);
		
		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.window);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(226, 636, 219, 38);
		contentPane.add(textField_8);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe sanguin");
		lblGroupeSanguin.setForeground(SystemColor.textHighlight);
		lblGroupeSanguin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblGroupeSanguin.setBounds(22, 642, 158, 38);
		contentPane.add(lblGroupeSanguin);
		
		textField_7 = new JTextField();
		textField_7.setBackground(SystemColor.window);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(226, 573, 219, 38);
		contentPane.add(textField_7);
		
		JLabel lblTaille = new JLabel("Taille");
		lblTaille.setForeground(SystemColor.textHighlight);
		lblTaille.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblTaille.setBounds(22, 571, 158, 38);
		contentPane.add(lblTaille);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(226, 152, 219, 38);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.window);
		textField_2.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				ci.setVisible(true);
				cn= connection.cnx();
				try {
					String sql="select * from consultation where dateConsultationt = ? and codePatient = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField_2.getText());
					ps.setString(2, textField_1.getText());
					rs=ps.executeQuery();
					while(rs.next()) {
						ci.getI3().setText(rs.getString("commentaire"));						
						ci.getI2().setText(rs.getString("causeConsultation"));						
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
			@Override
			public void mouseExited(MouseEvent e) {
				ci.setVisible(false);
			}
		});
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(226, 215, 219, 38);
		contentPane.add(textField_2);
		
		JLabel label_6 = new JLabel("CIN");
		label_6.setForeground(SystemColor.textHighlight);
		label_6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		label_6.setBounds(22, 152, 152, 38);
		contentPane.add(label_6);
		
		JLabel lblDernireConsultation = new JLabel("Date consultation");
		lblDernireConsultation.setForeground(SystemColor.textHighlight);
		lblDernireConsultation.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblDernireConsultation.setBounds(22, 215, 194, 38);
		contentPane.add(lblDernireConsultation);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.window);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(226, 286, 219, 38);
		contentPane.add(textField_3);
		
		JLabel lblAntcdants = new JLabel("Ant\u00E9c\u00E9dants");
		lblAntcdants.setForeground(SystemColor.textHighlight);
		lblAntcdants.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblAntcdants.setBounds(22, 286, 152, 38);
		contentPane.add(lblAntcdants);
		
		textField_4 = new JTextField();
		textField_4.setBackground(SystemColor.window);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(226, 354, 219, 38);
		contentPane.add(textField_4);
		
		JLabel lblGlycmie = new JLabel("Glyc\u00E9mie ");
		lblGlycmie.setForeground(SystemColor.textHighlight);
		lblGlycmie.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblGlycmie.setBounds(22, 354, 152, 38);
		contentPane.add(lblGlycmie);
		
		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.window);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(226, 429, 219, 38);
		contentPane.add(textField_5);
		
		JLabel lblTension = new JLabel("Tension");
		lblTension.setForeground(SystemColor.textHighlight);
		lblTension.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblTension.setBounds(22, 430, 152, 38);
		contentPane.add(lblTension);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.window);
		textField_6.setEditable(false);
		textField_6.setColumns(10); 
		textField_6.setBounds(226, 505, 219, 38);
		contentPane.add(textField_6);
		
		JLabel lblPoids = new JLabel("Poids");
		lblPoids.setForeground(SystemColor.textHighlight);
		lblPoids.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblPoids.setBounds(22, 503, 178, 38);
		contentPane.add(lblPoids);
		
		JLabel lblVoirEnDtail = new JLabel(" >>");
		lblVoirEnDtail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				antecedants = new Antecedants();
				antecedants.setVisible(true);
					cn=connection.cnx();
				
					try {
						String sqll = "select * from  antecedant  where codePatient = ?";
						ps=cn.prepareStatement(sqll);
						ps.setString(1, textField_1.getText());
						//ps.setString(2, textField_3.getText());
					
						rs=ps.executeQuery();
						if(rs.next()) {
							
							antecedants.getTextField_2().setText(rs.getString("descriptionAntecedants"));
							antecedants.getTextField().setText(textField_1.getText());
							antecedants.getTextField_1().setText(textField_3.getText());
						}
						Antecedants.getTextField_2().setEditable(false);
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						try {
							rs.close();
							ps.close();
						
						}catch(Exception ex) {}
				}
			}
		});
		lblVoirEnDtail.setForeground(Color.RED);
		lblVoirEnDtail.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblVoirEnDtail.setBounds(455, 291, 41, 24);
		contentPane.add(lblVoirEnDtail);
	
		 comboBox = new JComboBox();
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
	    	afficherDossierMedical();
		 	}
		 });
		comboBox.setBounds(226, 85, 121, 20);
		contentPane.add(comboBox);
		
		JLabel lblConsultation = new JLabel(" consultation");
		lblConsultation.setForeground(SystemColor.textHighlight);
		lblConsultation.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		lblConsultation.setBounds(110, 74, 106, 38);
		contentPane.add(lblConsultation);
	}
}
