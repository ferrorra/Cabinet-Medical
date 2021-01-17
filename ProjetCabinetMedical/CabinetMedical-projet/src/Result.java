import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Result extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextField pw;
	private Connection cn=null;
	private ResultSet rs=null;
	private PreparedStatement ps=null;
	private JTextField pww;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Result dialog = new Result();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	}

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public void changerPwLogin() throws Exception {
		cn=connection.cnx();
		String sqlll="update registration set motDePasse  = ? where nomUtilisateur = ?";
		PreparedStatement psss= cn.prepareStatement(sqlll);
	
	psss.setString(1, pww.getText());
	psss.setString(2, Medecin.getComboBox().getSelectedItem().toString());									
	int result = psss.executeUpdate();
	if(result != 0) {
		JOptionPane.showMessageDialog(null, "Mot de passe changé ! ");
		dispose();
	}
	}
	public Result() {
		setUndecorated(true);
		setBounds(100, 100, 414, 234);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Veuillez confirmer votre ancien mot de passe pour pouvoir le changer");
			lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 12));
			lblNewLabel.setForeground(new Color(0, 120, 215));
			lblNewLabel.setBounds(10, 26, 394, 53);
			contentPanel.add(lblNewLabel);
		}
		
		pw = new JTextField();
		pw.setBackground(Color.WHITE);
		pw.setForeground(SystemColor.textHighlight);
		pw.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
		pw.setBounds(69, 69, 279, 37);
		contentPanel.add(pw);
		pw.setColumns(10);
		{
			JLabel lblSaisirNouveauMot = new JLabel("Saisir nouveau mot de passe :\r\n");
			lblSaisirNouveauMot.setForeground(SystemColor.textHighlight);
			lblSaisirNouveauMot.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 12));
			lblSaisirNouveauMot.setBounds(10, 104, 173, 44);
			contentPanel.add(lblSaisirNouveauMot);
		}
		{
			pww = new JTextField();
			pww.setForeground(SystemColor.textHighlight);
			pww.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
			pww.setColumns(10);
			pww.setBackground(Color.WHITE);
			pww.setBounds(69, 153, 279, 37);
			contentPanel.add(pww);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.textHighlight);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
			{
				JButton okButton = new JButton("Confirmer");
				contentPanel.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent event) {
						if(event.getKeyCode()==KeyEvent.VK_ENTER) {
							okButton.doClick();
						}
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean t= false;
						try {
							cn=connection.cnx();							
	
							String sql="select motDePasse from registration where nomUtilisateur = ? " ;
							ps=cn.prepareStatement(sql);
							ps.setString(1, Medecin.getComboBox().getSelectedItem().toString());
							rs=ps.executeQuery();
							if(rs.next())
							{ t= rs.getString("motDePasse").equals(pw.getText());
						 if (! t) {
								JOptionPane.showMessageDialog(null, "Vous avez saisit un mot de passe incorrect !");
						 }
							
							}
						dispose();
					
							
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage());
						
						}finally {
							try {
								rs.close();
								ps.close();
							
								if(t==true) {
									
									try {
									changerPwLogin();
									
									}catch(Exception ex ) {
										JOptionPane.showMessageDialog(null, ex.getMessage());
										
									}finally {
										try {
											
											ps.close();
										}catch(Exception ex) {
											
										}
									}
								}
								
							
							}catch(Exception ex) {}
						}
					}
				});
				okButton.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
				okButton.setForeground(SystemColor.textHighlight);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setForeground(SystemColor.textHighlight);
				cancelButton.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
	
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public static JTextField getPw() {
		return pw;
	}

	
}
