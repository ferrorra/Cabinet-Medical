import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Paperasse extends JFrame {

	private static JPanel contentPane;
	private static JLabel lblLpat;
	private static JLabel lblNDePermis;
	private static JLabel lblSignature;
	private static JLabel lblNomDuMdecin;
	private static JLabel lblLddn;
	private  static JLabel lblLadr;
	private static JLabel lblLddj;
	private static JLabel lblNm;
	private static JLabel lblNper;
	private static JLabel lblCommentaire;
	private static JLabel lblDateDuJour;
	private static JLabel lblAdresse ;
	private static JLabel ll;
	private static JLabel lblPatientM;
	private static JLabel lblp;
	private static JTextArea textArea ;
	private static JPanel panel;
	public static JPanel getPanel() {
		return panel;
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	public static JLabel getLblp() {
		return lblp;
	}

	private static JLabel lblCoordonnesDeLa;
	private static JLabel lblNewLabel;
	private JScrollPane scrollPane;

	public static JLabel getLblLpat() {
		return lblLpat;
	}

	public static JLabel getLblNDePermis() {
		return lblNDePermis;
	}

	public static JLabel getLblSignature() {
		return lblSignature;
	}

	public static JLabel getLblNomDuMdecin() {
		return lblNomDuMdecin;
	}

	public static JLabel getLblLddn() {
		return lblLddn;
	}

	public static JLabel getLblLadr() {
		return lblLadr;
	}

	public static JLabel getLblLddj() {
		return lblLddj;
	}

	public static JLabel getLblNm() {
		return lblNm;
	}

	public static JLabel getLblNper() {
		return lblNper;
	}

	public static JLabel getLblCommentaire() {
		return lblCommentaire;
	}

	public static JLabel getLblDateDuJour() {
		return lblDateDuJour;
	}

	public static JLabel getLblAdresse() {
		return lblAdresse;
	}

	public static JLabel getLblDdn() {
		return ll;
	}

	public static JLabel getLblPatientM() {
		return lblPatientM;
	}

	public static JLabel getLblCoordonnesDeLa() {
		return lblCoordonnesDeLa;
	}

	public static JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paperasse frame = new Paperasse();
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
	public Paperasse() {
		setBounds(new Rectangle(3, 3, 3, 3));
		setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		setType(Type.POPUP);
		setTitle("Apper\u00E7u ");
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setForeground(SystemColor.activeCaptionText);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Paperasse.class.getResource("/Images/images (7).jpg")));
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 795);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 680, 756);
		contentPane.add(scrollPane);
		
		 panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(SystemColor.window);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("Nom de la clinique");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(170, 11, 483, 41);
		panel.add(lblNewLabel);
		
		 lblCoordonnesDeLa = new JLabel("Coordonn\u00E9es de la clinique");
		lblCoordonnesDeLa.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblCoordonnesDeLa.setBounds(170, 71, 483, 28);
		panel.add(lblCoordonnesDeLa);
		
		 lblPatientM = new JLabel("Patient :      M ou Mme");
		lblPatientM.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPatientM.setBounds(23, 115, 122, 28);
		panel.add(lblPatientM);
		
		 ll = new JLabel("DDN :");
		ll.setFont(new Font("Arial", Font.PLAIN, 12));
		ll.setBounds(23, 145, 33, 41);
		panel.add(ll);
		
		 lblAdresse = new JLabel("Adresse  :");
		lblAdresse.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAdresse.setBounds(23, 178, 55, 41);
		panel.add(lblAdresse);
		
		 lblDateDuJour = new JLabel("Date du jour  :");
		lblDateDuJour.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDateDuJour.setBounds(139, 219, 76, 28);
		panel.add(lblDateDuJour);
		
		 lblNomDuMdecin = new JLabel("Nom du m\u00E9decin");
		lblNomDuMdecin.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNomDuMdecin.setBounds(23, 637, 122, 41);
		panel.add(lblNomDuMdecin);
		
		 lblSignature = new JLabel("Signature");
		lblSignature.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblSignature.setBounds(23, 704, 76, 41);
		panel.add(lblSignature);
		
		 lblNDePermis = new JLabel("N\u00B0 de permis d'exercice");
		lblNDePermis.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNDePermis.setBounds(398, 637, 163, 41);
		panel.add(lblNDePermis);
		
		 lblLpat = new JLabel("Lpat");
		lblLpat.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLpat.setBounds(155, 116, 116, 28);
		panel.add(lblLpat);
		
		 lblLddn = new JLabel("Lddn");
		lblLddn.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLddn.setBounds(66, 151, 433, 28);
		panel.add(lblLddn);
		
		 lblLadr = new JLabel("Ladr");
		lblLadr.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLadr.setBounds(88, 182, 433, 33);
		panel.add(lblLadr);
		
		 lblLddj = new JLabel("Lddj");
		lblLddj.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLddj.setBounds(225, 219, 296, 28);
		panel.add(lblLddj);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 245, 457, 13);
		panel.add(separator);
		
		 lblNm = new JLabel("nm");
		lblNm.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNm.setBounds(155, 637, 271, 41);
		panel.add(lblNm);
		
		 lblNper = new JLabel("Nper");
		lblNper.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNper.setBounds(398, 692, 163, 41);
		panel.add(lblNper);
		
		 lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblCommentaire.setBounds(88, 254, 483, 62);
		panel.add(lblCommentaire);
		
		 lblp = new JLabel("Lpat");
		lblp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblp.setBounds(281, 116, 116, 28);
		panel.add(lblp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 315, 478, 311);
		panel.add(scrollPane_1);
		
		 textArea = new JTextArea();
		 textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
	}
}
