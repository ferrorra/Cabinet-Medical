import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;

public class ConsultationInfo extends JFrame {

	private JPanel contentPane;
	private static JLabel i2;
	private static JLabel i3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationInfo frame = new ConsultationInfo();
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
	public ConsultationInfo() {
		setType(Type.POPUP);
		setBackground(SystemColor.textHighlight);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 197);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informations :");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 103, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblCause = new JLabel("Cause :");
		lblCause.setForeground(Color.WHITE);
		
		lblCause.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblCause.setBounds(10, 43, 42, 21);
		contentPane.add(lblCause);
		
		JLabel lblCommentaire = new JLabel("Commentaire :");
		lblCommentaire.setForeground(Color.WHITE);
		lblCommentaire.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		lblCommentaire.setBounds(10, 120, 103, 21);
		contentPane.add(lblCommentaire);
		
		 i3 = new JLabel("");
		i3.setForeground(Color.WHITE);
		i3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		i3.setBounds(94, 109, 234, 42);
		contentPane.add(i3);
		
		 i2 = new JLabel("");
		i2.setForeground(Color.WHITE);
		i2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		i2.setBounds(56, 43, 272, 21);
		contentPane.add(i2);
	}


	public static JLabel getI2() {
		return i2;
	}

	public static JLabel getI3() {
		return i3;
	}

}
