import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Medicament  extends JPanel {
	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;
	public static  JPanel panel_18;
	public static JPanel getPanel_18() {
		return panel_18;
	}
	public static void afficherMedicaments()
	{
		try {
			File med = new File("medicaments.xlsx");    //ouverture d'une bd de médicament dans un fichier excel
			if(med.exists()) {
				if(Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(med);
				}else {
					JOptionPane.showMessageDialog(null, "Ce type de fichier n'est pas supportable dans votre PC");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Le fichier des médicaments est perdu");
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public Medicament() {
		panel_18 = new JPanel();
		panel_18.setBackground(SystemColor.window);
		
		panel_18.setLayout(null);		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBounds(10, 41, 1014, 723);
		panel_18.add(layeredPane_4);
		layeredPane_4.setLayout(new CardLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		layeredPane_4.add(panel_12, "name_16901111294700");
		panel_12.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion des m\u00E9dicaments");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(10, -12, 346, 74);
		panel_12.add(lblNewLabel);
		
		JButton btnVoirListe = new JButton("Voir liste");
		btnVoirListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			   afficherMedicaments();
			}
		});
		btnVoirListe.setForeground(SystemColor.textHighlight);
		btnVoirListe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnVoirListe.setBounds(761, 349, 183, 44);
		panel_12.add(btnVoirListe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Medicament.class.getResource("/Images/depositphotos_3699318-stock-illustration-medicament.jpg")));
		lblNewLabel_1.setBounds(20, 96, 960, 605);
		panel_12.add(lblNewLabel_1);
		
	    JPanel panel_20 = new JPanel();
	    panel_20.setBackground(SystemColor.window);
		layeredPane_4.add(panel_20, "name_16905501297800");
		panel_20.setLayout(null);
		
		JLabel lblRechercherUnMdicament = new JLabel("Rechercher un m\u00E9dicament dans la liste");
		lblRechercherUnMdicament.setForeground(SystemColor.textHighlight);
		lblRechercherUnMdicament.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblRechercherUnMdicament.setBounds(10, 11, 535, 74);
		panel_20.add(lblRechercherUnMdicament);
	}
}
