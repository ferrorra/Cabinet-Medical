import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
public class Medecin extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField textField;
	private static JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextArea textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextArea textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_10;
	private static Connection cn=null;
	private static ResultSet rs=null;
	private static PreparedStatement ps=null;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_177;
	private JTextArea textField_18;
	private JTextArea textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextArea textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_44;
	private JTextArea textField_45;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextArea textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private static JButton btnPatient;
	private static JButton btnMonCabinet;
	private static JButton btnMdicament;
	private static JTextField role;
	private JTable tbl;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField textField_57;
	private JTextField textField_56;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextArea textField_61;
	private static JComboBox comboBox;
	private JTextField txtHttpgooglecom;
	private JLabel Label1;
	private JComboBox jj = new JComboBox();
	private JComboBox mm = new JComboBox();
	private JComboBox aa = new JComboBox();
	private JComboBox j = new JComboBox();
	private JComboBox m = new JComboBox();
	private JComboBox a = new JComboBox();
	private JRadioButton f = new JRadioButton("Femme");
	private JRadioButton h = new JRadioButton("Homme");
	private JComboBox comboBox_9 = new JComboBox();
	private JComboBox comboBox_8 = new JComboBox();
	private JComboBox comboBox_7 = new JComboBox();
	JLabel ll;
	JLabel llll;
	JLabel lll;
	
	public String getCurrentDate() {  //Méthode pour avoir la date du jour
		Calendar cal= new GregorianCalendar();
		int day= cal.get(Calendar.DAY_OF_MONTH);
		int month= (cal.get(Calendar.MONTH))+1;
		int year= cal.get(Calendar.YEAR);
		
		return year+"-"+month+"-"+ day;
	}
	public void chercherPatient() {
		try {
			cn=connection.cnx();
			String sql="select * from patient where codePatient =?" ;
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField_1.getText());
			rs=ps.executeQuery();
			if(rs.next())
			{
				ll.setVisible(true);
				lll.setVisible(true);
				llll.setVisible(true);
			}else {
				ll.setVisible(false);
				lll.setVisible(false);
				llll.setVisible(false);
			}
		
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			 
		}finally {
			try {
				rs.close();
				ps.close();
			
					}catch(Exception ex) {}
	}
	}
	public void ajouterConsultation() {  //Méthode pour enregister une consulation
		cn=connection.cnx();
		
		String sql="insert into consultation (codeConsultation , codePatient , dateConsultationt , commentaire , montantPaye, causeConsultation) values (?,?, ?, ?, ?, ?)";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField_4.getText());
			ps.setString(2, textField_5.getText());
			ps.setString(3, comboBox_9.getSelectedItem().toString() +"-" +comboBox_8.getSelectedItem().toString() +"-"+ comboBox_7.getSelectedItem().toString()); //Pour avoir la date de la consultation sous format AAAA-MM-JJ
			ps.setString(4,textField_12.getText());
		    ps.setString(5,textField_13.getText());
			ps.setString(6, textField_14.getText());
			
			int result =	ps.executeUpdate();	
			if(result ==0) {
			
				JOptionPane.showMessageDialog(null, "Il y a un problème...");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 
		}finally{
			try {
				ps.close();
			}catch(Exception e) {
				
			}
		}
	
	}
	public void modifierInfosLogin() {     //Modifier les information d'un utilisateur
		PreparedStatement psss= null;
		try {
			cn=connection.cnx();
			String sqlll="update registration set sexe   = ?, role = ?, email  = ?, numTel = ?, adresse = ? where nomUtilisateur = ?";
			 psss= cn.prepareStatement(sqlll);
		
      psss.setString(1, textField_56.getText());
      psss.setString(2, textField_58.getText());
      psss.setString(3, textField_59.getText());
      psss.setString(4, textField_60.getText());
      psss.setString(5, textField_61.getText());
	  psss.setString(6, Medecin.getComboBox().getSelectedItem().toString());									
		int result = psss.executeUpdate();
		if(result != 0) {
			JOptionPane.showMessageDialog(null, "Modification réussie !");					
		}
		
		}catch(Exception ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			 
		}finally {
			try {	
				psss.close();
			}catch(Exception ex) {
				
			}
		}
	}
	public void calculerRevenus(JPanel panel_17) {   //Calculer les revenus à partir de la somme des monants payés lors de chaque consultation de la semaine
		String query="select dateConsultationt, SUM(montantPaye) from consultation where dateConsultationt BETWEEN date('now','-7 day') AND date('now') GROUP BY dateConsultationt";	
		JDBCCategoryDataset dataset;
		try {
			dataset = new JDBCCategoryDataset(connection.cnx(), query);
			JFreeChart chart= ChartFactory.createLineChart("Revenus ", "Date", "montant Acquis", dataset, PlotOrientation.VERTICAL , false, true, true);
			chart.setBorderPaint(SystemColor.textHighlight);
			chart.getTitle().setPaint(SystemColor.textHighlight);
			
			BarRenderer renderer = null;
			CategoryPlot plot= null;
			renderer = new BarRenderer();
			ChartPanel cp = new ChartPanel(chart);
			
			panel_17.add(cp, BorderLayout.CENTER);
			 cp.setPreferredSize(new java.awt.Dimension(panel_17.getWidth(), panel_17.getHeight()));
		        cp.setSize(new java.awt.Dimension(panel_17.getWidth(), panel_17.getHeight()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 
		}
	}
	public void calculerBenefices(JPanel panel_21) { //Calculer les bénéfices à partir de la somme des consultation - les factures établies par l'utilisateur principal
		String query="select consultation.dateConsultationt, SUM(consultation.montantPaye)-SUM(chargesCabinet.loyer)-SUM(chargesCabinet.factInter)-SUM(chargesCabinet.factTel)-SUM(chargesCabinet.factGaz)-SUM(chargesCabinet.factEau)-SUM(chargesCabinet.factElec)  from consultation, chargesCabinet where chargesCabinet.datej = consultation.dateConsultationt and consultation.dateConsultationt BETWEEN date('now','-7 day') AND date('now') GROUP BY consultation.dateConsultationt";		
		JDBCCategoryDataset dataset;
		try {
			dataset = new JDBCCategoryDataset(connection.cnx(), query);
			JFreeChart chart= ChartFactory.createLineChart("Bénéfices ", "Date", "montant Payé", dataset, PlotOrientation.VERTICAL , false, true, true);
			chart.setBorderPaint(SystemColor.textHighlight);
			chart.getTitle().setPaint(SystemColor.textHighlight);
			
			BarRenderer renderer = null;
			CategoryPlot plot= null;
			renderer = new BarRenderer();
			ChartPanel cp = new ChartPanel(chart);
			
			panel_21.add(cp, BorderLayout.CENTER);
			 cp.setPreferredSize(new java.awt.Dimension(panel_21.getWidth(), panel_21.getHeight()));
		        cp.setSize(new java.awt.Dimension(panel_21.getWidth(), panel_21.getHeight()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 
		}
	}
	public void clearTable(JTable table )  //Fonction pour vider une table
	{
	    DefaultTableModel dm = (DefaultTableModel) table.getModel(); //Récuper le modele {colonnes}
	    dm.getDataVector().removeAllElements();   //enlever les elts
	    revalidate();
	}
	public void attribuerCode(JTextField textField_4) {  //attribuer un code constitué de: la date + l'heure exacte
		Calendar cal= new GregorianCalendar();
		int day= cal.get(Calendar.DAY_OF_MONTH);
		int month= (cal.get(Calendar.MONTH))+1;
		int year= cal.get(Calendar.YEAR);				
		int hour= cal.get(Calendar.HOUR_OF_DAY);
		int minute= cal.get(Calendar.MINUTE);
		int second= cal.get(Calendar.SECOND);
		
		textField_4.setText(String.valueOf(day) + String.valueOf(month) + String.valueOf(year) + String.valueOf(hour) + String.valueOf(minute) + String.valueOf(second));
		
	}
	public void voirStatTension() {    // Voir l'évolution de la tension d'un patient depuis son inscription
		try {
			String query="select dateConsultationt, tension   from fichePatient where codePatient = "+ textField_10.getText()+" order by dateConsultationt";	//la requette sql
			JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection.cnx(), query);   // execution
			JFreeChart chart= ChartFactory.createLineChart("Tension du patient ", "Date", "Tension", dataset, PlotOrientation.VERTICAL , false, true, true); //préparation jfreechat : titre et axes..
			chart.setBorderPaint(SystemColor.textHighlight);
			chart.getTitle().setPaint(SystemColor.textHighlight);
			BarRenderer renderer = null;
			CategoryPlot plot= null;
			renderer = new BarRenderer();
			ChartFrame frame = new ChartFrame("Charte des statistiques de tension", chart);
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
			frame.setVisible(true); 
			frame.setSize(1200, 650);
			frame.setResizable(true);
			
			}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		 
		}
	}
	public static JComboBox getComboBox() {
		return comboBox;
	}
	public static JTextField getRole() {
		return role;
	}
	public void deleteInfosPatient() {    //supprimer un patient selectionné de la table
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		cn=connection.cnx();
		String sql="delete from patient where codePatient = ? ";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();
		} catch (SQLException e) {
		
			 
		}
			
	}
	public void viderPostes(JComboBox comboBox) {    //vider un jcomboBox
		if(comboBox.getItemCount() > 1 )
		{
			int itemCount = comboBox.getItemCount()-1;

		    for(int i=itemCount;i>0;i--){
		        comboBox.removeItemAt(i);
		     }
			//comboBox.removeAllItems();
		}
	}
	public void ajouterOrdonnance() {    //enregistrement d'une ordonnance
		try {	
			cn=connection.cnx();
		String sql="insert into ordonnance (codeOrdonnance, codeConsultation, codePatient, contenuOrdonnance ) values (?,?, ?,?)";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_15.getText());
		ps.setString(2, textField_16.getText());
		ps.setString(3, textField_177.getText());
		ps.setString(4, textField_18.getText());			
		int result =	ps.executeUpdate();	
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
			
		}else {
			JOptionPane.showMessageDialog(null, "Il y a un problème...");	
		}				
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
		 
	}
	finally {
		try {
			rs.close();
			ps.close();
		}catch(Exception ex) {}
	}
	}
	public void MontrerDossierPatient() {     //afficher le dossier d'un patient dans un autre JFrame
		 new FichePatient().setVisible(true);
			
			try {
				cn=connection.cnx();
				int row=1;
				 row=table.getSelectedRow();
				String cin= (table.getModel().getValueAt(row, 0)).toString();
				String sql="select * from patient where codePatient = ? " ;
				ps=cn.prepareStatement(sql);
				ps.setString(1, cin);
				rs=ps.executeQuery();
				while(rs.next())
				{
					FichePatient.getTextField().setText(rs.getString("codepatient"));
					FichePatient.getTextField_1().setText(rs.getString("nompatient"));
					FichePatient.getTextField_2().setText(rs.getString("prenompatient"));
					FichePatient.getTextField_3().setText(rs.getString("dateNaissance"));
					FichePatient.getTextField_4().setText(rs.getString("sexePatient"));
					FichePatient.getTextField_5().setText(rs.getString("numTel"));
					FichePatient.getTextField_6().setText(rs.getString("profession"));
					FichePatient.getTextField_7().setText(rs.getString("adressePatient"));
					FichePatient.getTextField_8().setText(rs.getString("emailPatient"));
					FichePatient.getTextField_9().setText(rs.getString("dateInscription"));
					FichePatient.getTextField_10().setText(rs.getString("matriculeAss"));
				}
			
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				 
			}finally {
				try {
					rs.close();
					ps.close();
				
				}catch(Exception ex) {}
			}
	}
	public void ajouterFacture() { //ajouter une facture à la bd, util pour calculer les bénéfices
		try {	
			cn=connection.cnx();
			String sql="insert into chargesCabinet (datej , loyer , factElec , factEau , factGaz , factTel  , factInter , fraisSup) values (?,?, ?, ?, ?, ?, ?, ?)";
			ps=cn.prepareStatement(sql);
			ps.setString(1, txtAaaammjj.getText());
			ps.setString(2, textField_22.getText());
			ps.setString(3, textField_33.getText());
			ps.setString(4, textField_42.getText());		
			ps.setString(5, textField_62.getText());
			ps.setString(6, textField_47.getText());
			ps.setString(7,textField_46.getText());
			ps.setString(8, textField_43.getText());
			int result =	ps.executeUpdate();	
			if(result !=0) {
				JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
				
			}else {
				JOptionPane.showMessageDialog(null, "Il y a un problème...");	
			}				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			 
		}
		finally {
			try {
				rs.close();
				ps.close();
				
			}catch(Exception e) {}
		}
	}
	public void printIt(JPanel panel, double i, double j) {    //Impression de tous les composants d'un JPanel avec des paramétres de la taille voulue 
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setJobName("Impression");
		
		printerJob.setPrintable(new Printable() {
		//	@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				if(pageIndex > 0) {
					return Printable.NO_SUCH_PAGE;    // si l'index de la page n'est pas valide
				}
				Graphics2D graphics2D = (Graphics2D) graphics;
				graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
				graphics2D.scale(i, j);
				panel.paint(graphics2D); // transformation du contenu de la JPanel en graphismes 2D imprimables
				return Printable.PAGE_EXISTS;
			}
		});
		boolean ReturningResults = printerJob.printDialog();
		if(ReturningResults) {
			try {
				printerJob.print();  //Impression
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	
	}
	public void etablirDossierMedical() {    //Etablir une fiche pour la consultation
		try {	
			cn=connection.cnx();
		
		String sql="insert into fichePatient(codeConsultation, codepatient, codeAntecedants,  glycemie, tension, poids , taille, groupeSanguin, dateConsultationt) values (?,?,?,?,?,?,?,?,?)";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_4.getText());	
		ps.setString(2, textField_5.getText());
		ps.setString(3,textField_25.getText());
		ps.setString(4,textField_30.getText());
	    ps.setString(5,textField_29.getText());
		ps.setString(6, textField_28.getText());
		ps.setString(7, textField_27.getText());
		ps.setString(8, textField_26.getText());
		ps.setString(9, comboBox_9.getSelectedItem().toString() +"-" +comboBox_8.getSelectedItem().toString() +"-"+ comboBox_7.getSelectedItem().toString());

		int result = ps.executeUpdate();	
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
			
		}else {
			JOptionPane.showMessageDialog(null, "Il y a un problème...");	
		}	
		
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
		 
	}
	finally {
		try {
			ps.close();
			rs.close();
			
		}catch(Exception exx) {}
	}
	}
	public void ajouterCertificat() { //enregistrement d'un certificat
		try {	cn=connection.cnx();
		String sql="insert into certificat (codePatient, codeConsultation , contenuCertificat) values (?,?, ?)";
		ps=cn.prepareStatement(sql);
		ps.setString(1, textField_21.getText());
		ps.setString(2, textField_20.getText());
		ps.setString(3, textField_19.getText());

		int result =	ps.executeUpdate();	
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
			
		}else {
			JOptionPane.showMessageDialog(null, "Il y a un problème...");	
		}				
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
		 
	}
	finally {
		try {
			rs.close();
			ps.close();
		
		}catch(Exception ex) {}
	}
	}
public String[] takeImage() {    //fonction qui prend toutes les photos d'un packages et retournes les noms sous forme d'un tableau, utile pour l'affichage de ses photos
	
	File f;
	try {
		f = new File(getClass().getResource("/imagePath").toURI().getPath().toString());
		if(f.exists()) {
			String [] ig = f.list();
		
			return ig;
			}
			else {
					JOptionPane.showMessageDialog(null, "Le fichier des logos est perdu...");
			   }
				} catch (Exception  e) {
					// TODO Auto-generated catch block
					 
				} 
				return null;

}
private int position = 0;   // variable utilisée pour garder la psition de l'image affichée
private JTextField textentete;
private JTextField fm;
private JTextField fne;
private JTextField fnc;
private JTextField fcc;
private JTextField textField_34;
private JTextField textField_35;
private JTextField textField_36;
private JTextField textField_37;
private JTextField textField_38;
private JTextField textField_39;
private JTextField textField_40;
private JTextField textField_41;
private JTextField txtAaaammjj;
private JTextField textField_32;
private JTextField textField_33;
private JTextField textField_42;
private JTextField textField_43;
private JTextField textField_46;
private JTextField textField_47;
private JTextField textField_62;

public void show(int indexxx) {   //affichage des photos prise par la méthode takeImage, le parametre indexxx sert à désigner la position de l'image à afficher dans la package
	String [] images= takeImage();
   String im = images[indexxx];
	ImageIcon icon= new ImageIcon(getClass().getResource("/imagePath/"+im));
  Image ima = icon.getImage().getScaledInstance(Label1.getWidth(), Label1.getHeight(), Image.SCALE_SMOOTH);
  Label1.setIcon(new ImageIcon(ima));
}
public long diffrenece(Date one, Date two) { //Méthode qui calcule la différence entre deux dates
	long diff= (one.getTime()- two.getTime())/86400000;
	return Math.abs(diff);
}
public void voirStatGlycemie() {  // Voir l'évolution de la glycémie d'un patient depuis son inscription
	try {
		String query="select dateConsultationt, glycemie  from fichePatient where codePatient = "+ textField_10.getText() +" order by dateConsultationt";	
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection.cnx(), query);
		JFreeChart chart= ChartFactory.createLineChart("Glycémie du patient ", "Date", "Glycémie", dataset, PlotOrientation.VERTICAL , false, true, true);
		chart.setBorderPaint(SystemColor.textHighlight);
		chart.getTitle().setPaint(SystemColor.textHighlight);
		BarRenderer renderer = null;
		CategoryPlot plot= null;
		renderer = new BarRenderer();
		renderer.setFillPaint(SystemColor.textHighlight);
		ChartFrame frame = new ChartFrame("Charte des statistiques de glycémie", chart);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
		frame.setVisible(true); 
		frame.setSize(1200, 650);
		}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
	 
	}
}

public void demanderBilan() {     //Enregister des analyses d'un patient
	try {	cn=connection.cnx();
	String sql="insert into analyses(codeConsultation,codePatient, contenuAnalyses) values (?,?, ?)";
	ps=cn.prepareStatement(sql);
	ps.setString(1, textField_48.getText());
	ps.setString(2, textField_49.getText());
	ps.setString(3, textField_50.getText());
	int result =ps.executeUpdate();	
	if(result !=0) {
		JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
		
	}else {
		JOptionPane.showMessageDialog(null, "Il y a un problème...");	
	}				
}catch (Exception ex) {
	JOptionPane.showMessageDialog(null, ex.getMessage());
	 
}
finally {
	try {
		rs.close();
		ps.close();
	}catch(Exception ex) {}
}
}
public void voirStatPoids() {  // Voir l'évolution du poids d'un patient depuis son inscription
	try {
		String query="select dateConsultationt , poids  from fichePatient where codePatient = "+ textField_10.getText()+" order by dateConsultationt";	
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection.cnx(), query);
		JFreeChart chart= ChartFactory.createLineChart("Poids du patient ", "Date", "Poids", dataset, PlotOrientation.VERTICAL , false, true, true);
		chart.setBorderPaint(SystemColor.textHighlight);
		chart.getTitle().setPaint(SystemColor.textHighlight);
		BarRenderer renderer = null;
		CategoryPlot plot= null;
		renderer = new BarRenderer();
		ChartFrame frame = new ChartFrame("Charte des statistiques de poids", chart);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
		frame.setVisible(true); 
		frame.setSize(1200, 650);
		
		}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
	 
	}
}
public void voirStatTaille() {  // Voir l'évolution de la taille d'un patient depuis son inscription
	try {
		String query="select dateConsultationt, taille from fichePatient where codePatient = "+ textField_10.getText()+" order by dateConsultationt";	
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(connection.cnx(), query);
		JFreeChart chart= ChartFactory.createLineChart("Taille du patient ", "Date", "Taille ", dataset, PlotOrientation.VERTICAL , false, true, true);
		chart.setBorderPaint(SystemColor.textHighlight);
		chart.getTitle().setPaint(SystemColor.textHighlight);				
		BarRenderer renderer = null;
		CategoryPlot plot= null;
		renderer = new BarRenderer();
		ChartFrame frame = new ChartFrame("Charte des statistiques de taille", chart);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
		frame.setVisible(true); 
		frame.setSize(1200, 650);
		
		}catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
	 
	}
}

public void supprimerPoste() throws Exception {   //Supprimer un utilisateur de la liste
	cn=connection.cnx();
	cn=connection.cnx();
	String sql="delete from registration where nomUtilisateur = ? ";
	ps=cn.prepareStatement(sql);
	ps.setString(1, comboBox.getSelectedItem().toString());				
	int result = ps.executeUpdate();	
	if(result != 0) {
		JOptionPane.showMessageDialog(null, "Le poste à été supprimé");
	}
}
	public void deleteCertificats(JTable table) {     //Supprimer tous les certificats d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from certificat where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteFichePatient(JTable table) { //Supprimer la fiche d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from fichePatient where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteRDV(JTable table) {  //Supprimer tous les RDVs d'un patient
		cn=connection.cnx();
		int row=1;  //initialisation de la ligne
		 row=table.getSelectedRow(); //récuperer l'indice 
		String cin= (table.getModel().getValueAt(row, 0)).toString();     // récuperer le codePatient de la ligne séléctionnée et la olonne 0 qui contient la cin 
		
		
		try {
			cn=connection.cnx();
			String sql="delete from RDV  where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();   //recharger les nouvelles infos dans la table
			}catch(Exception ex) {}
		}
	}
	public void deleteAntecedants(JTable table) {     //Supprimer tous les antecedants d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from antecedant where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteApcis(JTable table) { //Supprimer toutes les APCIs d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from apci where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteAnalyses(JTable table) { //Supprimer tous les bilans d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from analyses where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteOrdonnances(JTable table) { //Supprimer toutes les ordonnances d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from ordonnance where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	public void deleteConsultations(JTable table) { //Supprimer toutes les consultations d'un patient
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from consultation where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();
			}catch(Exception ex) {}
		}
	}
	
	
	
	public void chargerCombo() {   //charger tous les codes de consultation d'un patient dans le JComboBox d'un autre jframe
		
		try {
			cn=connection.cnx();
			int row=table.getSelectedRow();
			String cin= (table.getModel().getValueAt(row, 0)).toString();
			String sql="select * from consultation where codePatient = ?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Consultation.getComboBox().addItem(rs.getString("codeConsultation"));
		
			}

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			 
		}finally {
			try {
				rs.close();
				ps.close();
			
			}catch(Exception e) {}
		}
	}
	public static void MontrerInfosPatient() {		//chargement des infos des patients dans une table
		cn=connection.cnx();
		try {
			String sql="select codepatient, nompatient, prenompatient,matriculeAss from patient ";
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));  //Model de table disponible dans le jar rs2xml
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}finally {
			try {
				rs.close();
				ps.close();
			
			}catch(Exception e) {}
	}
}
	public static void main(String[] args) {   //main pour affciher le frame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medecin frame = new Medecin();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}
	public void switchpanels(JLayeredPane panlay, JPanel panel)     // changer de panel
	{
		panlay.removeAll();
		panlay.add(panel);
		panlay.repaint();
		panlay.revalidate();
	}
	public void clock(JLabel label_30) {        //afficher l'heure dynamiquement
		
		Thread cl = new Thread() {
		public void run() {
			try {
				for(;;) {
				Calendar cal= new GregorianCalendar();
				int day= cal.get(Calendar.DAY_OF_MONTH);
				int month= (cal.get(Calendar.MONTH))+1;
				int year= cal.get(Calendar.YEAR);				
				int hour= cal.get(Calendar.HOUR_OF_DAY);
				int minute= cal.get(Calendar.MINUTE);
				int second= cal.get(Calendar.SECOND);
				label_30.setText("Time :" + hour + ":" + minute + ":" +second +"\n Date :" +year+"-"+month +"-"+ day);
				sleep(1000);
				}
				
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
			}finally {
				try {
					rs.close();
					ps.close();				
				}catch(Exception e) {}
			}		
		}
		};
		
		cl.start();
	} 
	public void ajouterAPCI() {    //enregister un APCI
		try {	cn=connection.cnx();
		String sql="insert into apci (codeConsultation, codePatient, numAPCI ,nomDocteur, spécialiteDocteur , adresseCabinet, NumTelCabinet ,descriptionAPCI) values (?,?, ?,?,?,?,?,?)";
		ps=cn.prepareStatement(sql);
		ps.setString(8, textField_22.getText());
		ps.setString(7, textField_55.getText());
		ps.setString(6, textField_54.getText());
		ps.setString(5, textField_53.getText());
		ps.setString(4, textField_51.getText());
		ps.setString(3, textField_52.getText());
		ps.setString(2, textField_24.getText());
		ps.setString(1, textField_23.getText());
		int result =	ps.executeUpdate();	
		if(result !=0) {
			JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
			
		}else {
			JOptionPane.showMessageDialog(null, "Il y a un problème...");	
		}				
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage());
		 
	}
	finally {
		try {
			rs.close();
			ps.close();
			
		}catch(Exception ex) {}
	}
	}
	public void ajouterPatient() {   //enregister un patient
		if(textField_1.getText().equalsIgnoreCase("") || textField_1.getText().equalsIgnoreCase(" ")) {
			JOptionPane.showMessageDialog(null, "La cin est un champs obligatoire !");
			
		}else {
		try {	
			cn=connection.cnx();
			String sql="insert into patient (codePatient, nomPatient, prenomPatient, dateNaissance, sexePatient, numTel , profession, adressePatient,  emailPatient, dateInscription, matriculeAss) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps=cn.prepareStatement(sql);
			ps.setString(1, textField_1.getText());
			ps.setString(2, textField_2.getText());
			ps.setString(3, textField_3.getText());
			ps.setString(4,a.getSelectedItem().toString() +"-"+m.getSelectedItem().toString()+"-"+j.getSelectedItem().toString());   //la date
			if(h.isSelected()) {
				ps.setString(5, "Homme");
			} //selectionner un seul sexe
			else {
				ps.setString(5, "Femme");

			}
			ps.setString(6, textField_6.getText());
			ps.setString(7, textField_7.getText());
			ps.setString(8, textField_8.getText());
			ps.setString(9, textField_9.getText());
			ps.setString(10, aa.getSelectedItem().toString() +"-"+mm.getSelectedItem().toString()+"-"+jj.getSelectedItem().toString());
			ps.setString(11, textField_11.getText());
			int result =	ps.executeUpdate();	
			if(result !=0) {
				JOptionPane.showMessageDialog(null, "Enregistrement avec succès !");	
				
			}else {
				JOptionPane.showMessageDialog(null, "Il y a eu un problème...");	
			}				
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			 
		}
		finally {
			try {
				rs.close();
				ps.close();
			
			}catch(Exception e) {}
		}
		}
	}
	public void deleteAssurance(JTable table) {    //Suppresssion de l'assurance du patient 
		cn=connection.cnx();
		int row=1;
		 row=table.getSelectedRow();
		String cin= (table.getModel().getValueAt(row, 0)).toString();
		
		
		try {
			cn=connection.cnx();
			String sql="delete from assurance where codePatient = ? ";
			ps=cn.prepareStatement(sql);
			ps.setString(1, cin);				
			ps.executeUpdate();															
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}finally {
			try {						
				ps.close();
				MontrerInfosPatient();    //rechargement de la table
			}catch(Exception ex) {}
		}
	}

	public Medecin() {
		setTitle("Cabinet M\u00E9dical");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Medecin.class.getResource("/Images/images (7).jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1164, 727);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new MatteBorder(5, 1, 5, 5, (Color) new Color(0, 120, 215)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(SystemColor.textHighlight);
		separator_5.setBounds(119, 11, 1, 788);
		contentPane.add(separator_5);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(120, 11, 1034, 677);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		layeredPane.add(panel, "name_12707987276200");
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("DECONNEXION"); 
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().setVisible(true);  //Se déconnecter du poste actuel et se reconnecter avec le poste voulu
			}
		});
		
		JLabel label_30 = new JLabel("");
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		label_30.setBounds(29, 397, 603, 70);
		panel.add(label_30);		
	     clock(label_30);		
		JButton btnCommencer = new JButton("COMMENCER");
	
		btnCommencer.setForeground(Color.RED);
		btnCommencer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnCommencer.setBounds(119, 525, 179, 87);
		panel.add(btnCommencer);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(119, 617, 179, 56);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Bienvenue au cabinet m\u00E9dical !");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 75));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(45, 43, 918, 183);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(245, 224, 531, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(245, 347, 531, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Projet r\u00E9alis\u00E9 par : Bourouina Rania et Merabtenne Nasreddine");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		lblNewLabel_1.setBounds(119, 237, 787, 70);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Medecin.class.getResource("/Images/medical.jpg")));
		lblNewLabel_2.setBounds(0, 371, 1034, 325);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		layeredPane.add(panel_1, "name_12720029533500");
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		panel_1.setLayout(null);
		
		JLayeredPane panel_5 = new JLayeredPane();
		panel_5.setBackground(SystemColor.window);
		panel_5.setBounds(10, 41, 1014, 625);
		panel_1.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.window);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.textHighlight);
		scrollPane.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBounds(216, 121, 541, 418);
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		table.setForeground(Color.WHITE);
		table.setBackground(SystemColor.textHighlight);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					//deleteConsultations(table);
					int row=table.getSelectedRow();
					String cin= (table.getModel().getValueAt(row, 0)).toString();
					String sql="select * from fichePatient where codePatient = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, cin);
					new DossierMedical().setVisible(true);
					rs=ps.executeQuery();
					DossierMedical.getTextField_1().setText(cin);
					while(rs.next())
					{
						DossierMedical.getComboBox().addItem(rs.getString("codeConsultation"));				
					}

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
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
				
			}
		});
 
		textField.setBounds(371, 48, 246, 39);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Filtre de recherche ");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(817, 25, 118, 21);
		panel_6.add(lblNewLabel_3);
		
		JComboBox cb = new JComboBox();
		cb.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		cb.setForeground(SystemColor.textHighlight);
		cb.setModel(new DefaultComboBoxModel(new String[] {"codePatient ", "nomPatient ", "prenomPatient ", "dateNaissance", "sexePatient ", "numTel ", "profession ", "adressePatient ", "emailPatient ", "dateInscription ", "matriculeAss"}));
		cb.setBounds(817, 57, 118, 20);
		panel_6.add(cb);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					cn=connection.cnx();
					String sql="select codepatient, nompatient, prenompatient from patient where "+ cb.getSelectedItem().toString() + " = ? " ;
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField.getText().toString());
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}finally {
					try {
					
						rs.close();
						ps.close();
						if(textField.getText().equals("")) {
							MontrerInfosPatient();
						}
					
						textField_57.setText(String.valueOf(table.getRowCount()));
						
						
					}catch(Exception e) {}
				}
			}
		});
		
		JButton btnFichePatient_1 = new JButton("Dossier complet");
		btnFichePatient_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MontrerDossierPatient();
				
			}
		});
		btnFichePatient_1.setForeground(SystemColor.textHighlight);
		btnFichePatient_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnFichePatient_1.setBounds(49, 162, 157, 75);
		panel_6.add(btnFichePatient_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
				deleteInfosPatient();														
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {						
						ps.close();
						deleteFichePatient(table);
						deleteAntecedants(table);
						deleteOrdonnances(table) ;
						deleteAnalyses(table);
						deleteCertificats(table);
						deleteConsultations(table);
						deleteRDV(table);
						deleteAssurance(table);
						MontrerInfosPatient();
						textField_57.setText(String.valueOf(table.getRowCount()));
					}catch(Exception ex) {}
				}

			}
		});
		btnSupprimer.setForeground(SystemColor.textHighlight);
		btnSupprimer.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnSupprimer.setBounds(401, 550, 157, 39);
		panel_6.add(btnSupprimer);
		
		JButton btnConsultation = new JButton("Consultations");
		btnConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Consultation().setVisible(true);			
				chargerCombo();// changer le comboBox avec les codes de consultation ordonnés du plus ancien au plus récent
				
				try {   //calculer le temps d'abscence du patient
					cn=connection.cnx();
					//String lastConsultation="2021-02-dd";
					String sqll = "SELECT dateConsultationt  FROM consultation  WHERE codePatient = ? and dateConsultationt  IN (SELECT max(dateConsultationt ) FROM consultation WHERE codePatient = ?)  "; //qquery pour avoir la date de la visite la plus récente du patient
					ps=cn.prepareStatement(sqll);
					ps.setString(1, Consultation.getTextField_1().getText());
					ps.setString(2, Consultation.getTextField_1().getText());
					rs=ps.executeQuery();
					if(rs.next()) {
						String lastConsultation =rs.getString("dateConsultationt");	
							Date today= new Date();
							Calendar myNextCalendar = Calendar.getInstance(); 
							String year = String.valueOf(lastConsultation.toCharArray(), 0, 4); 
							String month = String.valueOf(lastConsultation.toCharArray(),5 , 2);							
							String day = String.valueOf(lastConsultation.toCharArray(), 8, 2);

							myNextCalendar.set(Integer.parseInt(year) ,Integer.parseInt(month),Integer.parseInt(day));// conversion de la date pour calculer la difference
							
							Date nyd = myNextCalendar.getTime();
							Consultation.getProgressBar().setValue((int) diffrenece(today,nyd));
					}
					
				
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					 
				}finally {
					try {
						rs.close();
						ps.close();
					}catch(Exception ex) {
						
					}
				}
			}
			});
		btnConsultation.setForeground(SystemColor.textHighlight);
		btnConsultation.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnConsultation.setBounds(767, 162, 157, 75);
		panel_6.add(btnConsultation);
		
		JLabel lblRechercher = new JLabel("Rechercher");
		lblRechercher.setForeground(SystemColor.textHighlight);
		lblRechercher.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblRechercher.setBounds(449, 25, 72, 21);
		panel_6.add(lblRechercher);
		
		textField_57 = new JTextField();
		textField_57.setForeground(SystemColor.textHighlight);
		textField_57.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		textField_57.setColumns(10);
		textField_57.setBounds(907, 551, 73, 44);
		panel_6.add(textField_57);
		
		JLabel label_10 = new JLabel("Le nombre total est");
		label_10.setForeground(SystemColor.textHighlight);
		label_10.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		label_10.setBounds(779, 550, 118, 44);
		panel_6.add(label_10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.textHighlightText);
		panel_5.add(panel_7, "name_14150069128300");
		panel_7.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.window);

		textField_1.setBounds(197, 79, 266, 39);
		panel_7.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.window);
		textField_2.setColumns(10);
		textField_2.setBounds(197, 129, 266, 39);
		panel_7.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.window);
		textField_3.setColumns(10);
		textField_3.setBounds(197, 179, 266, 39);
		panel_7.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.window);
		textField_6.setColumns(10);
		textField_6.setBounds(197, 364, 266, 39);
		panel_7.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(SystemColor.window);
		textField_7.setColumns(10);
		textField_7.setBounds(197, 414, 266, 39);
		panel_7.add(textField_7);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(715, 79, 266, 39);
		panel_7.add(scrollPane_4);
		
		textField_8 = new JTextArea();
		textField_8.setBackground(SystemColor.window);
		scrollPane_4.setViewportView(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CIN");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(59, 84, 81, 26);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNom = new JLabel("Nom ");
		lblNom.setForeground(SystemColor.textHighlight);
		lblNom.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNom.setBounds(59, 141, 81, 26);
		panel_7.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(SystemColor.textHighlight);
		lblPrenom.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblPrenom.setBounds(59, 191, 81, 26);
		panel_7.add(lblPrenom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setForeground(SystemColor.textHighlight);
		lblDateDeNaissance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblDateDeNaissance.setBounds(59, 261, 128, 26);
		panel_7.add(lblDateDeNaissance);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setForeground(SystemColor.textHighlight);
		lblSexe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblSexe.setBounds(59, 327, 81, 26);
		panel_7.add(lblSexe);
		
		JLabel lblNumroTlphone = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone");
		lblNumroTlphone.setForeground(SystemColor.textHighlight);
		lblNumroTlphone.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNumroTlphone.setBounds(59, 376, 112, 26);
		panel_7.add(lblNumroTlphone);
		
		JLabel lblProfession = new JLabel("Profession");
		lblProfession.setForeground(SystemColor.textHighlight);
		lblProfession.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblProfession.setBounds(59, 426, 81, 26);
		panel_7.add(lblProfession);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(SystemColor.textHighlight);
		lblAdresse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblAdresse.setBounds(552, 91, 141, 26);
		panel_7.add(lblAdresse);
		
		textField_9 = new JTextField();
		textField_9.setBackground(SystemColor.window);
		textField_9.setColumns(10);
		textField_9.setBounds(715, 129, 266, 39);
		panel_7.add(textField_9);
		
		JLabel lblEmail = new JLabel("Date inscription");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblEmail.setBounds(552, 185, 141, 26);
		panel_7.add(lblEmail);
		
		JLabel label = new JLabel("Email");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		label.setBounds(552, 134, 141, 26);
		panel_7.add(label);
		
		JLabel lblMatriculeAssurance = new JLabel("Matricule assurance");
		lblMatriculeAssurance.setForeground(SystemColor.textHighlight);
		lblMatriculeAssurance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblMatriculeAssurance.setBounds(552, 260, 141, 26);
		panel_7.add(lblMatriculeAssurance);
		
		textField_11 = new JTextField();
	
		textField_11.setBackground(SystemColor.window);
		textField_11.setColumns(10);
		textField_11.setBounds(715, 248, 266, 39);
		panel_7.add(textField_11);
		
		JButton btnEnregistrerPatient = new JButton("Enregistrer patient");

		btnEnregistrerPatient.setForeground(SystemColor.textHighlight);
		btnEnregistrerPatient.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnEnregistrerPatient.setBounds(295, 493, 168, 75);
		panel_7.add(btnEnregistrerPatient);
		
		
		j.setForeground(SystemColor.textHighlight);
		j.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		j.setSelectedIndex(0);
		j.setBounds(201, 249, 57, 20);
		panel_7.add(j);
		
		
		m.setForeground(SystemColor.textHighlight);
		m.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		m.setSelectedIndex(0);
		m.setBounds(279, 249, 66, 20);
		panel_7.add(m);
		
		
		a.setForeground(SystemColor.textHighlight);
		a.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		a.setSelectedIndex(0);
		a.setBounds(355, 249, 108, 20);
		panel_7.add(a);
		
		JLabel lblJour = new JLabel("Jour");
		lblJour.setForeground(SystemColor.textHighlight);
		lblJour.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblJour.setBounds(212, 229, 46, 20);
		panel_7.add(lblJour);
		
		JLabel lblMois = new JLabel("Mois");
		lblMois.setForeground(SystemColor.textHighlight);
		lblMois.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblMois.setBounds(295, 229, 46, 20);
		panel_7.add(lblMois);
		
		JLabel lblAnne = new JLabel("Ann\u00E9e");
		lblAnne.setForeground(SystemColor.textHighlight);
		lblAnne.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblAnne.setBounds(378, 229, 46, 20);
		panel_7.add(lblAnne);
		
		
		aa.setForeground(SystemColor.textHighlight);
		aa.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100"}));
		aa.setSelectedIndex(0);
		aa.setBounds(869, 199, 108, 20);
		panel_7.add(aa);
		
		JLabel label_1 = new JLabel("Ann\u00E9e");
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		label_1.setBounds(892, 179, 46, 20);
		panel_7.add(label_1);
		
		
		mm.setForeground(SystemColor.textHighlight);
		mm.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		mm.setSelectedIndex(0);
		mm.setBounds(793, 199, 66, 20);
		panel_7.add(mm);
		
		JLabel label_2 = new JLabel("Mois");
		label_2.setForeground(SystemColor.textHighlight);
		label_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		label_2.setBounds(809, 179, 46, 20);
		panel_7.add(label_2);
		
		
		jj.setForeground(SystemColor.textHighlight);
		jj.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jj.setSelectedIndex(0);
		jj.setBounds(715, 199, 57, 20);
		panel_7.add(jj);
		
		JLabel label_3 = new JLabel("Jour");
		label_3.setForeground(SystemColor.textHighlight);
		label_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		label_3.setBounds(726, 179, 46, 20);
		panel_7.add(label_3);
		
		

		h.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		h.setForeground(SystemColor.textHighlight);
		h.setBackground(SystemColor.textHighlightText);
		h.setBounds(194, 298, 109, 23);
		panel_7.add(h);
		
		
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(f.isSelected()) {
					h.setSelected(false);
				}
			}
		});
		f.setForeground(SystemColor.textHighlight);
		f.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		f.setBackground(Color.WHITE);
		f.setBounds(194, 330, 109, 23);
		panel_7.add(f);
		h.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (h.isSelected())
				{
					f.setSelected(false);
				}
			}
		});
		JLabel lblNouveauPatient = new JLabel("Nouveau patient");
		lblNouveauPatient.setForeground(SystemColor.textHighlight);
		lblNouveauPatient.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 45));
		lblNouveauPatient.setBounds(59, 11, 393, 57);
		panel_7.add(lblNouveauPatient);
		
		JLabel label_9 = new JLabel(">>");

		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		label_9.setBounds(981, 248, 33, 38);
		panel_7.add(label_9);
		
		 lll = new JLabel("Ce patient est d\u00E9ja inscrit");
		lll.setVisible(false);
		lll.setForeground(Color.RED);
		lll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 48));
		lll.setBounds(529, 483, 475, 85);
		panel_7.add(lll);
		
		 llll = new JLabel("Vous pourrez aller directement ajouter une consultation");
		llll.setVisible(false);
		llll.setForeground(Color.GRAY);
		llll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		llll.setBounds(618, 562, 320, 26);
		panel_7.add(llll);	
		JLabel assu = new JLabel("Cette assurance n'appatient pas \u00E0 ce patient");
		assu.setVisible(false);
		assu.setForeground(Color.RED);
		assu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		assu.setBounds(719, 286, 262, 20);
		panel_7.add(assu);
	
		
		 ll = new JLabel("");
		ll.setVisible(false);
		ll.setIcon(new ImageIcon(Medecin.class.getResource("/Images/warning.png")));
		ll.setBounds(639, 307, 254, 202);
		panel_7.add(ll);
	
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.textHighlightText);
		panel_5.add(panel_8, "name_14151899652100");
		panel_8.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
		});
		textField_4.setBounds(193, 90, 267, 43);
		panel_8.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Code consultation");
		lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setBounds(49, 104, 110, 21);
		panel_8.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
	

	
		textField_5.setColumns(10);
		textField_5.setBounds(193, 164, 267, 43);
		panel_8.add(textField_5);
		
		JLabel lblCinPatinet = new JLabel("CIN patient");
		lblCinPatinet.setForeground(SystemColor.textHighlight);
		lblCinPatinet.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblCinPatinet.setBounds(49, 178, 110, 21);
		panel_8.add(lblCinPatinet);
		
		JLabel lblDateConsultation = new JLabel("Date consultation");
		lblDateConsultation.setForeground(SystemColor.textHighlight);
		lblDateConsultation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblDateConsultation.setBounds(49, 263, 110, 21);
		panel_8.add(lblDateConsultation);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(193, 329, 267, 43);
		panel_8.add(scrollPane_5);
		
		textField_12 = new JTextArea();
		scrollPane_5.setViewportView(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblCommentaire = new JLabel("Commentaire");
		lblCommentaire.setForeground(SystemColor.textHighlight);
		lblCommentaire.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblCommentaire.setBounds(49, 343, 110, 21);
		panel_8.add(lblCommentaire);
		
		JLabel lblMontantPay = new JLabel("Montant pay\u00E9");
		lblMontantPay.setForeground(SystemColor.textHighlight);
		lblMontantPay.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblMontantPay.setBounds(49, 425, 110, 21);
		panel_8.add(lblMontantPay);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(193, 411, 267, 43);
		panel_8.add(textField_13);
		
		JLabel lblCauseConsultation = new JLabel("Cause consultation");
		lblCauseConsultation.setForeground(SystemColor.textHighlight);
		lblCauseConsultation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lblCauseConsultation.setBounds(49, 517, 110, 21);
		panel_8.add(lblCauseConsultation);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(193, 503, 267, 43);
		panel_8.add(textField_14);
		
		JButton b = new JButton("Enregistrer consultation");
		b.setVisible(false);

		b.setForeground(SystemColor.textHighlight);
		b.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		b.setBounds(673, 533, 203, 75);
		panel_8.add(b);
		
		
		comboBox_7.setForeground(SystemColor.textHighlight);
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_7.setBounds(193, 264, 61, 20);
		panel_8.add(comboBox_7);
		
		
		comboBox_8.setForeground(SystemColor.textHighlight);
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_8.setBounds(279, 264, 61, 20);
		panel_8.add(comboBox_8);
		
		
		comboBox_9.setForeground(SystemColor.textHighlight);
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100"}));
		comboBox_9.setBounds(350, 264, 110, 20);
		panel_8.add(comboBox_9);
		
		JLabel lb = new JLabel("Jour");
		lb.setForeground(SystemColor.textHighlight);
		lb.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lb.setBounds(207, 242, 34, 21);
		panel_8.add(lb);
		
		JLabel lbb = new JLabel("Ann\u00E9e");
		lbb.setForeground(SystemColor.textHighlight);
		lbb.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lbb.setBounds(375, 242, 70, 21);
		panel_8.add(lbb);
		
		JLabel lbbb = new JLabel("Mois");
		lbbb.setForeground(SystemColor.textHighlight);
		lbbb.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		lbbb.setBounds(292, 242, 34, 21);
		panel_8.add(lbbb);
		
		JLabel lblNouvelleConsultation = new JLabel("Nouvelle consultation");
		lblNouvelleConsultation.setForeground(SystemColor.textHighlight);
		lblNouvelleConsultation.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 45));
		lblNouvelleConsultation.setBounds(49, 11, 421, 50);
		panel_8.add(lblNouvelleConsultation);
		
		JButton btnEtablirUneFiche = new JButton("Etablir/mettre \u00E0 jour  la fiche patient>>");

		btnEtablirUneFiche.setForeground(Color.RED);
		btnEtablirUneFiche.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnEtablirUneFiche.setBounds(130, 583, 318, 25);
		panel_8.add(btnEtablirUneFiche);
		
		textField_25 = new JTextField();
		textField_25.setVisible(false);
		textField_25.setColumns(10);
		textField_25.setBounds(700, 82, 267, 43);
		panel_8.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setVisible(false);
		textField_26.setColumns(10);
		textField_26.setBounds(700, 136, 267, 43);
		panel_8.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setVisible(false);
		textField_27.setColumns(10);
		textField_27.setBounds(700, 190, 267, 43);
		panel_8.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setVisible(false);
		textField_28.setColumns(10);
		textField_28.setBounds(700, 247, 267, 43);
		panel_8.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setVisible(false);
		textField_29.setColumns(10);
		textField_29.setBounds(700, 301, 267, 43);
		panel_8.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setVisible(false);
		textField_30.setColumns(10);
		textField_30.setBounds(700, 360, 267, 43);
		panel_8.add(textField_30);
		
		JLabel l1 = new JLabel("Code ant\u00E9c\u00E9dants");
		l1.setVisible(false);
		l1.setForeground(SystemColor.textHighlight);
		l1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l1.setBounds(563, 100, 110, 21);
		panel_8.add(l1);
		
		JLabel l2 = new JLabel("Groupe sanguin");
		l2.setVisible(false);
		l2.setForeground(SystemColor.textHighlight);
		l2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l2.setBounds(563, 150, 110, 21);
		panel_8.add(l2);
		
		JLabel l3 = new JLabel("Taille");
		l3.setVisible(false);
		l3.setForeground(SystemColor.textHighlight);
		l3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l3.setBounds(563, 204, 110, 21);
		panel_8.add(l3);
		
		JLabel l6 = new JLabel("Glyc\u00E9mie");
		l6.setVisible(false);
		l6.setForeground(SystemColor.textHighlight);
		l6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l6.setBounds(563, 370, 110, 21);
		panel_8.add(l6);
		
		JLabel l5 = new JLabel("Tension");
		l5.setVisible(false);
		l5.setForeground(SystemColor.textHighlight);
		l5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l5.setBounds(563, 315, 110, 21);
		panel_8.add(l5);
		
		JLabel l4 = new JLabel("Poids");
		l4.setVisible(false);
		l4.setForeground(SystemColor.textHighlight);
		l4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		l4.setBounds(563, 263, 110, 21);
		panel_8.add(l4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.textHighlight);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(506, 90, 7, 510);
		panel_8.add(separator_2);
		
		JLabel l7 = new JLabel(">>");
		l7.setVisible(false);
		l7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Antecedants().setVisible(true);	
				try{
					cn=connection.cnx();
				String sql=" select descriptionAntecedants from antecedant where codePatient = ? and codeAntecedant = ?";
				ps=cn.prepareStatement(sql);
					ps.setString(1, textField_5.getText());
					ps.setString(2, textField_25.getText());
					Antecedants.getTextField().setText(textField_5.getText());
					Antecedants.getTextField_1().setText(textField_25.getText());
					rs=ps.executeQuery();
				
				if(rs.next()) {
					
					Antecedants.getTextField_2().setText(rs.getString("descriptionAntecedants"));
				}
				else {
					
					Antecedants.getTextField().setEditable(true);
					Antecedants.getTextField_1().setEditable(true);
					Antecedants.getTextField_2().setEditable(true);
				}
				}catch (Exception ex) {
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
		l7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		l7.setForeground(Color.RED);
		l7.setBounds(971, 85, 42, 35);
		panel_8.add(l7);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon(Medecin.class.getResource("/Images/warning.png")));
		lbl.setVisible(false);
		lbl.setBounds(633, 137, 254, 202);
		panel_8.add(lbl);
		
		JLabel lbll = new JLabel("Ce patient n'est pas inscrit");
		lbll.setVisible(false);
		lbll.setForeground(Color.RED);
		lbll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 48));
		lbll.setBounds(513, 329, 500, 121);
		panel_8.add(lbll);
		
		JLabel lblll = new JLabel("Vous devez aller ajouter le patient avant");
		lblll.setVisible(false);
		lblll.setForeground(Color.GRAY);
		lblll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblll.setBounds(647, 422, 320, 26);
		panel_8.add(lblll);
		
		JLabel label_31 = new JLabel("*");
		label_31.setForeground(Color.RED);
		label_31.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		label_31.setBounds(462, 164, 34, 21);
		panel_8.add(label_31);
		
		JLabel label_32 = new JLabel("*");
		label_32.setForeground(Color.RED);
		label_32.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		label_32.setBounds(970, 190, 34, 21);
		panel_8.add(label_32);
		
		JLabel label_33 = new JLabel("*");
		label_33.setForeground(Color.RED);
		label_33.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		label_33.setBounds(970, 246, 34, 21);
		panel_8.add(label_33);
		
		JLabel label_34 = new JLabel("*");
		label_34.setForeground(Color.RED);
		label_34.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		label_34.setBounds(970, 301, 34, 21);
		panel_8.add(label_34);
		
		JLabel label_35 = new JLabel("*");
		label_35.setForeground(Color.RED);
		label_35.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		label_35.setBounds(979, 369, 34, 21);
		panel_8.add(label_35);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.textHighlightText);
		panel_5.add(panel_9, "name_14153284734700");
		panel_9.setLayout(null);
		
		JButton btnLaTension = new JButton("La tension");
		btnLaTension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		voirStatTension();
			}
		});
		btnLaTension.setForeground(SystemColor.textHighlight);
		btnLaTension.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLaTension.setBounds(785, 306, 176, 41);
		panel_9.add(btnLaTension);
		
		JButton btnLePoids = new JButton("Le poids");
		btnLePoids.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	voirStatPoids();
			}
		});
		btnLePoids.setForeground(SystemColor.textHighlight);
		btnLePoids.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLePoids.setBounds(785, 396, 176, 41);
		panel_9.add(btnLePoids);
		
		JButton btnLaTaille = new JButton("La taille");
		btnLaTaille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			voirStatTaille();
			}
		});
		btnLaTaille.setForeground(SystemColor.textHighlight);
		btnLaTaille.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLaTaille.setBounds(785, 489, 176, 41);
		panel_9.add(btnLaTaille);
		
		JButton btnLaGlycmie = new JButton("La glyc\u00E9mie");
		btnLaGlycmie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	voirStatGlycemie();
			}
		});
		btnLaGlycmie.setForeground(SystemColor.textHighlight);
		btnLaGlycmie.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLaGlycmie.setBounds(785, 219, 176, 41);
		panel_9.add(btnLaGlycmie);
		
		JLabel lblNewLabel_6 = new JLabel("L'\u00E9tat de sant\u00E9 des patients");
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 45));
		lblNewLabel_6.setBounds(23, 11, 516, 79);
		panel_9.add(lblNewLabel_6);
		
		textField_10 = new JTextField();
		textField_10.setBounds(355, 101, 272, 48);
		panel_9.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblSaisirCin = new JLabel("Saisir CIN");
		lblSaisirCin.setForeground(SystemColor.textHighlight);
		lblSaisirCin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 26));
		lblSaisirCin.setBounds(221, 96, 113, 48);
		panel_9.add(lblSaisirCin);
		
		JLabel lblChoisirConstantes = new JLabel("Choisir constante");
		lblChoisirConstantes.setForeground(SystemColor.textHighlight);
		lblChoisirConstantes.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 26));
		lblChoisirConstantes.setBounds(412, 160, 168, 48);
		panel_9.add(lblChoisirConstantes);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Medecin.class.getResource("/Images/l-analyse-de-statistique-48670555.jpg")));
		lblNewLabel_8.setBounds(10, 219, 1004, 506);
		panel_9.add(lblNewLabel_8);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_5.add(panel_19, "name_15622645361400");
		panel_19.setLayout(null);
		
		JLayeredPane layeredPane_5 = new JLayeredPane();
		layeredPane_5.setBounds(10, 54, 994, 571);
		panel_19.add(layeredPane_5);
		layeredPane_5.setLayout(new CardLayout(0, 0));
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		layeredPane_5.add(panel_22, "name_24479071800200");
		panel_22.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Ajouter une nouvelle ordonnance");
		lblNewLabel_7.setBounds(10, 11, 468, 69);
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		panel_22.add(lblNewLabel_7);
		
		textField_15 = new JTextField();
		textField_15.setBounds(143, 91, 274, 37);
		panel_22.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setBounds(143, 139, 274, 37);
		textField_16.setColumns(10);
		panel_22.add(textField_16);
		
		textField_177 = new JTextField();
		textField_177.setBounds(143, 187, 274, 37);
		textField_177.setColumns(10);
		panel_22.add(textField_177);
		
		JLabel lblCodeOrdonnance = new JLabel("Code ordonnance");
		lblCodeOrdonnance.setBounds(10, 91, 222, 37);
		lblCodeOrdonnance.setForeground(SystemColor.textHighlight);
		lblCodeOrdonnance.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		panel_22.add(lblCodeOrdonnance);
		
		JLabel lblCodeConsultation = new JLabel("Code consultation");
		lblCodeConsultation.setBounds(10, 138, 200, 37);
		lblCodeConsultation.setForeground(SystemColor.textHighlight);
		lblCodeConsultation.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		panel_22.add(lblCodeConsultation);
		
		JLabel lblCinPatient = new JLabel("CIN patient");
		lblCinPatient.setBounds(10, 186, 222, 37);
		lblCinPatient.setForeground(SystemColor.textHighlight);
		lblCinPatient.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		panel_22.add(lblCinPatient);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(488, 70, 496, 62);
		panel_22.add(scrollPane_6);
		
		textField_18 = new JTextArea();
		scrollPane_6.setViewportView(textField_18);
		textField_18.setColumns(10);
		
		JLabel lblPrescription = new JLabel("Commentaire");
		lblPrescription.setBounds(670, 22, 97, 41);
		lblPrescription.setForeground(SystemColor.textHighlight);
		lblPrescription.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		panel_22.add(lblPrescription);
		
		JButton btnSupprimer_1 = new JButton("Supprimer m\u00E9dicament");

		btnSupprimer_1.setBounds(652, 517, 200, 31);
		btnSupprimer_1.setForeground(SystemColor.textHighlight);
		btnSupprimer_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		panel_22.add(btnSupprimer_1);
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setBounds(28, 512, 176, 41);
		btnSauvegarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		ajouterOrdonnance();
			}
		});
		btnSauvegarder.setForeground(SystemColor.textHighlight);
		btnSauvegarder.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		panel_22.add(btnSauvegarder);
		
		JButton btnImprimer = new JButton("Imprimer");

		btnImprimer.setBounds(214, 512, 176, 41);
		btnImprimer.setForeground(SystemColor.textHighlight);
		btnImprimer.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		panel_22.add(btnImprimer);
		
		JLabel label_17 = new JLabel("Prescription");
		label_17.setBounds(691, 283, 85, 37);
		label_17.setForeground(SystemColor.textHighlight);
		label_17.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		panel_22.add(label_17);
		
		JButton btnAjouter = new JButton("Ajouter");
	
		btnAjouter.setBounds(875, 139, 93, 41);
		btnAjouter.setForeground(SystemColor.textHighlight);
		btnAjouter.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		panel_22.add(btnAjouter);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(SystemColor.window);
		scrollPane_3.setBounds(488, 313, 496, 188);
		panel_22.add(scrollPane_3);
		
		tbl = new JTable();
		tbl.setGridColor(SystemColor.controlText);
		
		tbl.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
        Object[] columns= {"Nom du médicament","Quantité","Nombre de fois"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tbl.setModel(model);
        tbl.setBackground(SystemColor.textHighlight);
        tbl.setForeground(Color.WHITE);
        tbl.setRowHeight(30);
		scrollPane_3.setViewportView(tbl);
		
		p1 = new JTextField();
		p1.setColumns(10);
		p1.setBounds(666, 142, 199, 37);
		panel_22.add(p1);
		
		p2 = new JTextField();
		p2.setColumns(10);
		p2.setBounds(666, 186, 199, 37);
		panel_22.add(p2);
		
		p3 = new JTextField();
		p3.setColumns(10);
		p3.setBounds(666, 234, 199, 37);
		panel_22.add(p3);
		
		JLabel lblNomDeLa = new JLabel("Nom du m\u00E9dicament");
		lblNomDeLa.setForeground(SystemColor.textHighlight);
		lblNomDeLa.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblNomDeLa.setBounds(484, 148, 172, 37);
		panel_22.add(lblNomDeLa);
		
		JLabel lblNomDuMdicament = new JLabel("Quantit\u00E9");
		lblNomDuMdicament.setForeground(SystemColor.textHighlight);
		lblNomDuMdicament.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblNomDuMdicament.setBounds(484, 190, 172, 37);
		panel_22.add(lblNomDuMdicament);
		
		JLabel lblDosage = new JLabel("Nombre de fois");
		lblDosage.setForeground(SystemColor.textHighlight);
		lblDosage.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblDosage.setBounds(484, 234, 172, 37);
		panel_22.add(lblDosage);
		
		fm = new JTextField();
		fm.setColumns(10);
		fm.setBounds(208, 296, 267, 31);
		panel_22.add(fm);
		JTextField fmm = new JTextField();
		
	
		
		JLabel label_13 = new JLabel("Nom du m\u00E9decin");
		label_13.setForeground(SystemColor.textHighlight);
		label_13.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_13.setBounds(10, 295, 188, 31);
		panel_22.add(label_13);
		
	
		
		
		fne = new JTextField();
		fne.setColumns(10);
		fne.setBounds(208, 348, 267, 31);
		panel_22.add(fne);
		
		JLabel label_14 = new JLabel("N\u00B0 permis d'exercice");
		label_14.setForeground(SystemColor.textHighlight);
		label_14.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_14.setBounds(10, 348, 188, 31);
		panel_22.add(label_14);
		
		fnc = new JTextField();
		fnc.setColumns(10);
		fnc.setBounds(208, 401, 267, 31);
		panel_22.add(fnc);
		
		JLabel label_15 = new JLabel("Nom de la clinique");
		label_15.setForeground(SystemColor.textHighlight);
		label_15.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_15.setBounds(10, 401, 188, 31);
		panel_22.add(label_15);
		
		fcc = new JTextField();
		fcc.setColumns(10);
		fcc.setBounds(208, 452, 267, 49);
		panel_22.add(fcc);
		
		JLabel label_16 = new JLabel("Coordonn\u00E9es de la clinique");
		label_16.setForeground(SystemColor.textHighlight);
		label_16.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_16.setBounds(10, 454, 188, 31);
		panel_22.add(label_16);
		
		JLabel lblNewLabel_14 = new JLabel("Impression");
		lblNewLabel_14.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.infoText, new Color(153, 180, 209), new Color(105, 105, 105), SystemColor.activeCaption));
		lblNewLabel_14.setForeground(SystemColor.textHighlight);
		lblNewLabel_14.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_14.setBounds(208, 235, 79, 31);
		panel_22.add(lblNewLabel_14);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(297, 253, 172, 9);
		panel_22.add(separator_4);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 253, 188, 9);
		panel_22.add(separator_6);
		
		//JPanel panel_20= new JPanel();
		JPanel panel_23= new JPanel();;
		panel_23.setLayout(null);
		
		panel_23.setBackground(SystemColor.textHighlightText);
		layeredPane_5.add(panel_23, "Certificat");
		panel_23.setLayout(null);
		
		JLabel lblU = new JLabel("Ajouter un nouveau certificat");
		lblU.setForeground(SystemColor.textHighlight);
		lblU.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblU.setBounds(10, 11, 406, 69);
		panel_23.add(lblU);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(488, 98, 496, 406);
		panel_23.add(scrollPane_7);
		
		textField_19 = new JTextArea();
		scrollPane_7.setViewportView(textField_19);
		textField_19.setColumns(10);
		
		JLabel lblContenu = new JLabel("Contenu");
		lblContenu.setForeground(SystemColor.textHighlight);
		lblContenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblContenu.setBounds(697, 64, 85, 37);
		panel_23.add(lblContenu);
		
		JButton button_2 = new JButton("Sauvegarder");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
ajouterCertificat();
			}
		});
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button_2.setBounds(10, 506, 176, 41);
		panel_23.add(button_2);
		
		JButton button_3 = new JButton("Imprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {   //impression du certificat, meme chose que l'ordonnance
				Connection conn= null; 
				PreparedStatement p= null;
				ResultSet r= null;
				
				try {
					conn= connection.cnx();
					String querry="SELECT * FROM patient where codepatient = " +textField_21.getText() ;
					p= conn.prepareStatement(querry);
				//	p.setString(1,textField_177.getText());
				
					new	Paperasse().setVisible(true);
					
					r=p.executeQuery();
					while(r.next()) {
					
					Paperasse.getLblLpat().setText(r.getString("nomPatient"));
					Paperasse.getLblp().setText(r.getString("prenomPatient"));
					Paperasse.getLblLddn().setText(r.getString("dateNaissance"));
					Paperasse.getLblLadr().setText(r.getString("adressePatient"));;
					Paperasse.getLblNm().setText("<html> "+textField_34.getText()+ " </html>");
					Paperasse.getLblNper().setText(textField_35.getText()+ " </html>");
					Paperasse.getLblNewLabel().setText("<html> "+textField_36.getText()+ " </html>");
					Paperasse.getLblCoordonnesDeLa().setText("<html> "+textField_37.getText()+ " </html>");
					Paperasse.getLblCommentaire().setText("");			
					Paperasse.getTextArea().setText("<html> "+textField_19.getText()+ " </html>");
					Paperasse.getLblLddj().setText(getCurrentDate());
				printIt(Paperasse.getPanel(),1,1.1);
					}

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					 
				}finally {
					try {
						r.close();
						p.close();
						
					}catch(Exception ex) {}
				}
			}
		});
		button_3.setForeground(SystemColor.textHighlight);
		button_3.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button_3.setBounds(268, 506, 176, 41);
		panel_23.add(button_3);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(143, 113, 274, 37);
		panel_23.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(143, 161, 274, 37);
		panel_23.add(textField_21);
		
		JLabel label_5 = new JLabel("CIN patient");
		label_5.setForeground(SystemColor.textHighlight);
		label_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_5.setBounds(10, 160, 222, 37);
		panel_23.add(label_5);
		
		JLabel label_6 = new JLabel("Code consultation");
		label_6.setForeground(SystemColor.textHighlight);
		label_6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_6.setBounds(10, 112, 200, 37);
		panel_23.add(label_6);
		
		JLabel label_18 = new JLabel("Impression");
		label_18.setForeground(SystemColor.textHighlight);
		label_18.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_18.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.infoText, new Color(153, 180, 209), new Color(105, 105, 105), SystemColor.activeCaption));
		label_18.setBounds(208, 209, 79, 31);
		panel_23.add(label_18);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(208, 270, 267, 31);
		panel_23.add(textField_34);
		
		JLabel label_21 = new JLabel("Nom du m\u00E9decin");
		label_21.setForeground(SystemColor.textHighlight);
		label_21.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_21.setBounds(10, 269, 188, 31);
		panel_23.add(label_21);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(208, 322, 267, 31);
		panel_23.add(textField_35);
		
		JLabel label_22 = new JLabel("N\u00B0 permis d'exercice");
		label_22.setForeground(SystemColor.textHighlight);
		label_22.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_22.setBounds(10, 322, 188, 31);
		panel_23.add(label_22);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(208, 375, 267, 31);
		panel_23.add(textField_36);
		
		JLabel label_23 = new JLabel("Nom de la clinique");
		label_23.setForeground(SystemColor.textHighlight);
		label_23.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_23.setBounds(10, 375, 188, 31);
		panel_23.add(label_23);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(208, 426, 267, 49);
		panel_23.add(textField_37);
		
		JLabel label_24 = new JLabel("Coordonn\u00E9es de la clinique");
		label_24.setForeground(SystemColor.textHighlight);
		label_24.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_24.setBounds(10, 428, 188, 31);
		panel_23.add(label_24);
		
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(297, 226, 176, 2);
		panel_23.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 226, 176, 2);
		panel_23.add(separator_8);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		layeredPane_5.add(panel_24, "name_24485857126200");
		panel_24.setLayout(null);
		
		JLabel lblAjouterUneNouvelle = new JLabel("Ajouter une nouvelle APCI");
		lblAjouterUneNouvelle.setForeground(SystemColor.textHighlight);
		lblAjouterUneNouvelle.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblAjouterUneNouvelle.setBounds(10, 11, 468, 69);
		panel_24.add(lblAjouterUneNouvelle);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(488, 101, 496, 416);
		panel_24.add(scrollPane_8);
		
		textField_22 = new JTextArea();
		scrollPane_8.setViewportView(textField_22);
		textField_22.setColumns(10);
		
		JLabel label_4 = new JLabel("Contenu");
		label_4.setForeground(SystemColor.textHighlight);
		label_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_4.setBounds(697, 64, 85, 37);
		panel_24.add(label_4);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(204, 81, 274, 37);
		panel_24.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(204, 129, 274, 37);
		panel_24.add(textField_24);
		
		JLabel label_7 = new JLabel("CIN patient");
		label_7.setForeground(SystemColor.textHighlight);
		label_7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_7.setBounds(10, 128, 222, 37);
		panel_24.add(label_7);
		
		JLabel label_8 = new JLabel("Code consultation");
		label_8.setForeground(SystemColor.textHighlight);
		label_8.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD, 15));
		label_8.setBounds(10, 80, 200, 37);
		panel_24.add(label_8);
		
		JButton button = new JButton("Sauvegarder");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                 ajouterAPCI();
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button.setBounds(288, 498, 176, 41);
		panel_24.add(button);
		
		JButton button_1 = new JButton("Imprimer");
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button_1.setBounds(10, 498, 176, 41);
		panel_24.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {   //imprssion de l'APCI, meme chose que l'ordonnance
				Connection conn= null; 
				PreparedStatement p= null;
				ResultSet r= null;
				
				try {
					conn= connection.cnx();
					String querry="SELECT * FROM patient where codepatient = " +textField_24.getText() ;
					p= conn.prepareStatement(querry);
				//	p.setString(1,textField_177.getText());
					
					new	Paperasse().setVisible(true);
		
					r=p.executeQuery();
					while(r.next()) {
					
					Paperasse.getLblLpat().setText(r.getString("nomPatient"));
					Paperasse.getLblp().setText(r.getString("prenomPatient"));
					Paperasse.getLblLddn().setText(r.getString("dateNaissance"));
					Paperasse.getLblLadr().setText(r.getString("adressePatient"));;
					Paperasse.getLblNDePermis().setText("");
					Paperasse.getLblNm().setText("<html> "+textField_51.getText()+ " </html>");
					Paperasse.getLblNper().setText(textField_52.getText());
					Paperasse.getLblNewLabel().setText("<html> "+textField_53.getText()+ " </html>");
					Paperasse.getLblCoordonnesDeLa().setText("<html> "+textField_54.getText() +" "+ textField_55.getText()+ " </html>");					
					Paperasse.getTextArea().setText("<html> "+textField_22.getText()+ " </html>");;						
					Paperasse.getLblLddj().setText(getCurrentDate());
				    printIt(Paperasse.getPanel(),1,1.1);
					}

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					 
				}finally {
					try {
						r.close();
						p.close();
						
					}catch(Exception ex) {}
				}
				
				
			}});
		
		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(204, 230, 274, 37);
		panel_24.add(textField_51);
		
		JLabel lblNomMdecin = new JLabel("Nom m\u00E9decin");
		lblNomMdecin.setForeground(SystemColor.textHighlight);
		lblNomMdecin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblNomMdecin.setBounds(10, 229, 222, 37);
		panel_24.add(lblNomMdecin);
		
		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(204, 182, 274, 37);
		panel_24.add(textField_52);
		
		JLabel lblNumroApci = new JLabel("Num\u00E9ro APCI");
		lblNumroApci.setForeground(SystemColor.textHighlight);
		lblNumroApci.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblNumroApci.setBounds(10, 181, 200, 37);
		panel_24.add(lblNumroApci);
		
		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(204, 279, 274, 37);
		panel_24.add(textField_53);
		
		JLabel lblSpcialitMdecin = new JLabel("Sp\u00E9cialit\u00E9 m\u00E9decin");
		lblSpcialitMdecin.setForeground(SystemColor.textHighlight);
		lblSpcialitMdecin.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblSpcialitMdecin.setBounds(10, 278, 222, 37);
		panel_24.add(lblSpcialitMdecin);
		
		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(204, 335, 274, 37);
		panel_24.add(textField_54);
		
		JLabel lblNumroTlphoneDu = new JLabel("Num\u00E9ro t\u00E9l\u00E9phone du cabinet");
		lblNumroTlphoneDu.setForeground(SystemColor.textHighlight);
		lblNumroTlphoneDu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblNumroTlphoneDu.setBounds(10, 334, 222, 37);
		panel_24.add(lblNumroTlphoneDu);
		
		textField_55 = new JTextField();
		textField_55.setColumns(10);
		textField_55.setBounds(204, 394, 274, 37);
		panel_24.add(textField_55);
		
		JLabel lblAdresseCabinet_1 = new JLabel("Adresse cabinet");
		lblAdresseCabinet_1.setForeground(SystemColor.textHighlight);
		lblAdresseCabinet_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblAdresseCabinet_1.setBounds(10, 393, 222, 37);
		panel_24.add(lblAdresseCabinet_1);
		
		JPanel panel_25 = new JPanel();
		panel_25.setLayout(null);
		panel_25.setBackground(Color.WHITE);
		layeredPane_5.add(panel_25, "name_168949296733400");
		
		JLabel lblDemanderUnBilan = new JLabel("Demander un bilan");
		lblDemanderUnBilan.setForeground(SystemColor.textHighlight);
		lblDemanderUnBilan.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 29));
		lblDemanderUnBilan.setBounds(10, 11, 258, 69);
		panel_25.add(lblDemanderUnBilan);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(133, 92, 274, 37);
		panel_25.add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setColumns(10);
		textField_49.setBounds(133, 140, 274, 37);
		panel_25.add(textField_49);
		
		JLabel label_19 = new JLabel("Code consultation");
		label_19.setForeground(SystemColor.textHighlight);
		label_19.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_19.setBounds(0, 91, 200, 37);
		panel_25.add(label_19);
		
		JLabel label_20 = new JLabel("CIN patient");
		label_20.setForeground(SystemColor.textHighlight);
		label_20.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		label_20.setBounds(0, 139, 222, 37);
		panel_25.add(label_20);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(485, 97, 496, 423);
		panel_25.add(scrollPane_9);
		
		textField_50 = new JTextArea();
		scrollPane_9.setViewportView(textField_50);
		textField_50.setColumns(10);
		
		JLabel lblContenuDesAnalayse = new JLabel("Contenu des analayse");
		lblContenuDesAnalayse.setForeground(SystemColor.textHighlight);
		lblContenuDesAnalayse.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		lblContenuDesAnalayse.setBounds(659, 52, 152, 37);
		panel_25.add(lblContenuDesAnalayse);
		
		JButton button_6 = new JButton("Sauvegarder");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	demanderBilan();
			}
		});
		button_6.setForeground(SystemColor.textHighlight);
		button_6.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button_6.setBounds(24, 488, 176, 41);
		panel_25.add(button_6);
		
		JButton button_7 = new JButton("Imprimer");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//impression des analyses, meme chose que l'ordonnance
				Connection conn= null; 
				PreparedStatement p= null;
				ResultSet r= null;
				
				try {
					conn= connection.cnx();
					String querry="SELECT * FROM patient where codepatient = " +textField_49.getText() ;
					p= conn.prepareStatement(querry);
				//	p.setString(1,textField_177.getText());
				
					new	Paperasse().setVisible(true);
					
					r=p.executeQuery();
					while(r.next()) {
					
					Paperasse.getLblLpat().setText(r.getString("nomPatient"));
					Paperasse.getLblp().setText(r.getString("prenomPatient"));
					Paperasse.getLblLddn().setText(r.getString("dateNaissance"));
					Paperasse.getLblLadr().setText(r.getString("adressePatient"));;
					Paperasse.getLblNm().setText("<html> "+textField_38.getText()+" <html>");
					Paperasse.getLblNper().setText(textField_39.getText());
					Paperasse.getLblNewLabel().setText("<html> "+textField_40.getText()+" <html>");
					Paperasse.getLblCoordonnesDeLa().setText("<html> "+textField_41.getText()+" <html>");
					Paperasse.getLblCommentaire().setText("");			
					Paperasse.getTextArea().setText("<html> "+textField_50.getText()+" <html>");
					Paperasse.getLblLddj().setText(getCurrentDate());
				printIt(Paperasse.getPanel(),1,1.1);
					}

				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					 
				}finally {
					try {
						r.close();
						p.close();
						
					}catch(Exception ex) {}
				}
			}
		});
		button_7.setForeground(SystemColor.textHighlight);
		button_7.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		button_7.setBounds(288, 488, 176, 41);
		panel_25.add(button_7);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(208, 249, 267, 31);
		panel_25.add(textField_38);
		
		JLabel label_25 = new JLabel("Impression");
		label_25.setForeground(SystemColor.textHighlight);
		label_25.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_25.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.infoText, new Color(153, 180, 209), new Color(105, 105, 105), SystemColor.activeCaption));
		label_25.setBounds(208, 188, 79, 31);
		panel_25.add(label_25);
		
		JLabel label_26 = new JLabel("Nom du m\u00E9decin");
		label_26.setForeground(SystemColor.textHighlight);
		label_26.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_26.setBounds(10, 248, 188, 31);
		panel_25.add(label_26);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(208, 301, 267, 31);
		panel_25.add(textField_39);
		
		JLabel label_27 = new JLabel("N\u00B0 permis d'exercice");
		label_27.setForeground(SystemColor.textHighlight);
		label_27.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_27.setBounds(10, 301, 188, 31);
		panel_25.add(label_27);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(208, 354, 267, 31);
		panel_25.add(textField_40);
		
		JLabel label_28 = new JLabel("Nom de la clinique");
		label_28.setForeground(SystemColor.textHighlight);
		label_28.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_28.setBounds(10, 354, 188, 31);
		panel_25.add(label_28);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(208, 405, 267, 49);
		panel_25.add(textField_41);
		
		JLabel label_29 = new JLabel("Coordonn\u00E9es de la clinique");
		label_29.setForeground(SystemColor.textHighlight);
		label_29.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		label_29.setBounds(10, 407, 188, 31);
		panel_25.add(label_29);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(297, 200, 176, 2);
		panel_25.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(24, 200, 176, 2);
		panel_25.add(separator_10);
		
		JButton btnOrdonnance = new JButton("Ordonnance");
		btnOrdonnance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_5, panel_22);
				textField_15.setText("");
				textField_16.setText("");
				textField_177.setText("");
				textField_18.setText("");
				p1.setText("");
				p2.setText("");
				p3.setText("");
				clearTable(tbl);
				fm.setText("");
				fne.setText("");
				fnc.setText("");
				fcc.setText("");
				attribuerCode(textField_15);
			}
		});
		btnOrdonnance.setForeground(SystemColor.textHighlight);
		btnOrdonnance.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnOrdonnance.setBounds(66, 11, 176, 41);
		panel_19.add(btnOrdonnance);
		
		JButton btnCertificat = new JButton("Certificat");
		btnCertificat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_5, panel_23);
				textField_19.setText("");
				textField_20.setText("");
				textField_21.setText("");
				textField_34.setText("");
				textField_35.setText("");
				textField_36.setText("");
				textField_37.setText("");
				
				
			}
		});
		btnCertificat.setForeground(SystemColor.textHighlight);
		btnCertificat.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnCertificat.setBounds(269, 11, 176, 41);
		panel_19.add(btnCertificat);
		
		JButton btnApci = new JButton("APCI");
		btnApci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_5, panel_24);
				textField_22.setText("");
				textField_23.setText("");
				textField_24.setText("");
				textField_51.setText("");
				textField_52.setText("");
				textField_53.setText("");
				textField_54.setText("");
				textField_55.setText("");
			}
		});
		btnApci.setForeground(SystemColor.textHighlight);
		btnApci.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnApci.setBounds(466, 11, 176, 41);
		panel_19.add(btnApci);
		
		JButton btnAnalyses = new JButton("Analyses");
		btnAnalyses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchpanels(layeredPane_5, panel_25);
				textField_48.setText("");
				textField_49.setText("");
				textField_50.setText("");
				textField_38.setText("");
				textField_39.setText("");
				textField_40.setText("");
				textField_41.setText("");
			}
		});
		btnAnalyses.setForeground(SystemColor.textHighlight);
		btnAnalyses.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnAnalyses.setBounds(670, 11, 176, 41);
		panel_19.add(btnAnalyses);
		
		JButton btnNewButton_2 = new JButton("Informations patient");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(panel_5, panel_6);
				textField.setText("");
				cn=connection.cnx();
				try {
					String sql="select codepatient, nompatient, prenompatient, matriculeAss from patient ";
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}finally {
					try {
						rs.close();
						ps.close();
						int rowNum = table.getRowCount();
						textField_57.setText(String.valueOf(rowNum));
					}catch(Exception e) {}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(0, 0, 176, 41);
		panel_1.add(btnNewButton_2);
		
		JButton btnAjouterPatient = new JButton("Ajouter patient");
		btnAjouterPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(panel_5, panel_7);
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_11.setText("");
				ll.setVisible(false);
				lll.setVisible(false);
				llll.setVisible(false);
				
			}
		});
		btnAjouterPatient.setForeground(SystemColor.textHighlight);
		btnAjouterPatient.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnAjouterPatient.setBounds(173, 0, 176, 41);
		panel_1.add(btnAjouterPatient);
		
		JButton btnOrdonnancecertificat = new JButton("Paperasse");
		btnOrdonnancecertificat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(panel_5, panel_19);
				textField_15.setText("");
				textField_16.setText("");
				textField_177.setText("");
				textField_18.setText("");
				p1.setText("");
				p2.setText("");
				p3.setText("");
				clearTable(tbl);
				fm.setText("");
				fne.setText("");
				fnc.setText("");
				fcc.setText("");
				attribuerCode(textField_15);
textField_19.setText("");
				textField_20.setText("");
				textField_21.setText("");
				textField_34.setText("");
				textField_35.setText("");
				textField_36.setText("");
				textField_37.setText("");
		textField_22.setText("");
				textField_23.setText("");
				textField_24.setText("");
				textField_51.setText("");
				textField_52.setText("");
				textField_53.setText("");
				textField_54.setText("");
				textField_55.setText("");
	textField_48.setText("");
				textField_49.setText("");
				textField_50.setText("");
				textField_38.setText("");
				textField_39.setText("");
				textField_40.setText("");
				textField_41.setText("");


             
			}
		});
		btnOrdonnancecertificat.setForeground(SystemColor.textHighlight);
		btnOrdonnancecertificat.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnOrdonnancecertificat.setBounds(690, 0, 167, 41);
		panel_1.add(btnOrdonnancecertificat);
		
		JButton btnAjouterConsultation = new JButton("Ajouter consultation");
		btnAjouterConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(panel_5, panel_8);
				textField_4.setText("");
				textField_5.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_25.setText("");
				textField_26.setText("");
				textField_27.setText("");
				textField_28.setText("");
				textField_29.setText("");
				textField_30.setText("");
				textField_25.setVisible(false);
				textField_26.setVisible(false);
				textField_27.setVisible(false);
				textField_28.setVisible(false);
				textField_29.setVisible(false);
				textField_30.setVisible(false);
				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(false);
				l5.setVisible(false);
				l6.setVisible(false);
				l7.setVisible(false);
				b.setVisible(false);			
				lbl.setVisible(false);
				lbll.setVisible(false);
				lblll.setVisible(false);
				attribuerCode(textField_4);
				label_32.setVisible(false);
				label_33.setVisible(false);
				label_34.setVisible(false);
				label_35.setVisible(false);

			}
		});
		btnAjouterConsultation.setForeground(SystemColor.textHighlight);
		btnAjouterConsultation.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnAjouterConsultation.setBounds(347, 0, 176, 41);
		panel_1.add(btnAjouterConsultation);
		
		JButton btnConstantes = new JButton("Constantes");
		btnConstantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(panel_5, panel_9);   //chager de panel 
				textField_10.setText("");    //vider le champs de la recherche
			}
		});
		btnConstantes.setForeground(SystemColor.textHighlight);
		btnConstantes.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnConstantes.setBounds(517, 0, 176, 41);
		panel_1.add(btnConstantes);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.window);
		panel_3.setLayout(null);
		layeredPane.add(panel_3, "name_14244015451300");
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(10, 41, 1014, 636);
		panel_3.add(layeredPane_2);
		layeredPane_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setForeground(SystemColor.textHighlight);
		panel_14.setBackground(SystemColor.text);
		layeredPane_2.add(panel_14, "name_14327658571000");
		panel_14.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.window);
		tabbedPane.setMinimumSize(new Dimension(10, 5));
		tabbedPane.setForeground(SystemColor.textHighlight);
		tabbedPane.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		tabbedPane.setBounds(10, 83, 1004, 653);
		panel_14.add(tabbedPane);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(SystemColor.window);
		tabbedPane.addTab("Les assistantes et les médecins", null, panel_13, null);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(430, 61, 147, 20);
		panel_13.add(scrollPane_2);
		
		 comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		 scrollPane_2.setViewportView(comboBox);
		 comboBox.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		 comboBox.setForeground(SystemColor.textHighlight);
		 comboBox.setMaximumRowCount(100);
		 comboBox.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	
		 		try {     //afficher les information de l'utilisateur selectionné dans le comboBox
		 			cn= connection.cnx();
		 			String sql="select * from registration where nomUtilisateur = ?";
		 			ps=cn.prepareStatement(sql);
		 			ps.setString(1, comboBox.getSelectedItem().toString());
		 			rs=ps.executeQuery();
		 			while(rs.next()) {
		 				textField_56.setText(rs.getString("sexe"));
		 				textField_58.setText(rs.getString("role"));
		 				textField_59.setText(rs.getString("email"));
		 				textField_60.setText(rs.getString("numTel"));
		 				textField_61.setText(rs.getString("adresse"));						
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
		
		textField_56 = new JTextField();
		textField_56.setBackground(SystemColor.window);
		textField_56.setEditable(false);
		textField_56.setBounds(191, 109, 205, 32);
		panel_13.add(textField_56);
		textField_56.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Sexe");
		lblNewLabel_9.setForeground(SystemColor.textHighlight);
		lblNewLabel_9.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_9.setBounds(43, 118, 138, 14);
		panel_13.add(lblNewLabel_9);
		
		textField_58 = new JTextField();
		textField_58.setBackground(SystemColor.window);
		textField_58.setEditable(false);
		textField_58.setColumns(10);
		textField_58.setBounds(191, 152, 205, 32);
		panel_13.add(textField_58);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(SystemColor.textHighlight);
		lblRole.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblRole.setBounds(43, 161, 138, 14);
		panel_13.add(lblRole);
		
		textField_59 = new JTextField();
		textField_59.setBackground(SystemColor.window);
		textField_59.setEditable(false);
		textField_59.setColumns(10);
		textField_59.setBounds(191, 199, 205, 32);
		panel_13.add(textField_59);
		
		JLabel lblEmail_2 = new JLabel("Email");
		lblEmail_2.setForeground(SystemColor.textHighlight);
		lblEmail_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblEmail_2.setBounds(43, 208, 138, 14);
		panel_13.add(lblEmail_2);
		
		textField_60 = new JTextField();
		textField_60.setBackground(SystemColor.window);
		textField_60.setEditable(false);
		textField_60.setColumns(10);
		textField_60.setBounds(191, 252, 205, 32);
		panel_13.add(textField_60);
		
		JLabel lblNumroDeTlphone_3 = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone");
		lblNumroDeTlphone_3.setForeground(SystemColor.textHighlight);
		lblNumroDeTlphone_3.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNumroDeTlphone_3.setBounds(43, 261, 138, 14);
		panel_13.add(lblNumroDeTlphone_3);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(191, 305, 205, 32);
		panel_13.add(scrollPane_10);
		
		textField_61 = new JTextArea();
		textField_61.setBackground(SystemColor.window);
		scrollPane_10.setViewportView(textField_61);
		textField_61.setEditable(false);
		textField_61.setColumns(10);
		
		JLabel lblAdresse_2 = new JLabel("Adresse");
		lblAdresse_2.setForeground(SystemColor.textHighlight);
		lblAdresse_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblAdresse_2.setBounds(43, 314, 138, 14);
		panel_13.add(lblAdresse_2);
		
		JButton btnChangerMotDe = new JButton("Changer mot de passe");
		btnChangerMotDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Result().setVisible(true);
			}
		});
		btnChangerMotDe.setForeground(SystemColor.textHighlight);
		btnChangerMotDe.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnChangerMotDe.setBounds(192, 366, 204, 41);
		panel_13.add(btnChangerMotDe);
		
		JButton btnModifierInformations = new JButton("Modifier informations");
	
		btnModifierInformations.setForeground(SystemColor.textHighlight);
		btnModifierInformations.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnModifierInformations.setBounds(191, 418, 204, 41);
		panel_13.add(btnModifierInformations);
		
		JButton btnSupprimerPoste = new JButton("Supprimer poste");
		btnSupprimerPoste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					supprimerPoste();
					viderPostes(comboBox);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {						
						ps.close();
						cn=connection.cnx();
						try {
							comboBox.removeAll();	
							textField_56.setText("");
							textField_58.setText("");
							textField_59.setText("");
							textField_60.setText("");
							textField_16.setText("");
							String sql="select nomUtilisateur  from registration";
							ps=cn.prepareStatement(sql);
							rs=ps.executeQuery();
							while(rs.next())
							{
								comboBox.addItem(rs.getString("nomUtilisateur"));
						
							}

						}catch(Exception e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
							 
						}finally {
							try {
								rs.close();
								ps.close();
							
							}catch(Exception e) {}
						}
						
					}catch(Exception ex) {}
				}
			}
		});
		btnSupprimerPoste.setForeground(SystemColor.textHighlight);
		btnSupprimerPoste.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnSupprimerPoste.setBounds(192, 478, 204, 41);
		panel_13.add(btnSupprimerPoste);
		
		JLabel lblMettreJour = new JLabel("Mettre \u00E0 jour >>");
		lblMettreJour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
modifierInfosLogin();
			}
		});
		lblMettreJour.setEnabled(false);
		lblMettreJour.setForeground(Color.RED);
		lblMettreJour.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblMettreJour.setBounds(239, 459, 114, 14);
		panel_13.add(lblMettreJour);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Medecin.class.getResource("/Images/depositphotos_211088816-stock-illustration-vector-graphic-illustration-vial-ampoule.jpg")));
		lblNewLabel_10.setBounds(463, 125, 500, 401);
		panel_13.add(lblNewLabel_10);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(SystemColor.window);
		panel_27.setForeground(SystemColor.textHighlight);
		tabbedPane.addTab("paramètres audio", null, panel_27, null);
		panel_27.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.WHITE);

		btnStart.setForeground(SystemColor.textHighlight);
		btnStart.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnStart.setBounds(398, 423, 204, 41);
		panel_27.add(btnStart);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Medecin.class.getResource("/Images/man-graphics-picture-headphones-wallpaper-preview.jpg")));
		lblNewLabel_11.setBounds(138, 71, 728, 420);
		panel_27.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setEnabled(false);
	
		lblNewLabel_12.setIcon(new ImageIcon(Medecin.class.getResource("/Images/ss.png")));
		lblNewLabel_12.setBounds(939, 11, 50, 50);
		panel_27.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Stop music");
		lblNewLabel_13.setEnabled(false);
		lblNewLabel_13.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		lblNewLabel_13.setForeground(SystemColor.textHighlight);
		lblNewLabel_13.setBounds(939, 59, 59, 14);
		panel_27.add(lblNewLabel_13);
		lblNewLabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				musicStuff.StopMusic();
				lblNewLabel_12.setEnabled(false);
				lblNewLabel_13.setEnabled(false);
			}
		});
		
		JLabel lblParamtresDuLogiciel = new JLabel("Param\u00E8tres du logiciel");
		lblParamtresDuLogiciel.setForeground(SystemColor.textHighlight);
		lblParamtresDuLogiciel.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		lblParamtresDuLogiciel.setBounds(10, 11, 478, 51);
		panel_14.add(lblParamtresDuLogiciel);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(SystemColor.window);
		layeredPane_2.add(panel_15, "name_14330361431300");
		panel_15.setLayout(null);
		
		JLabel lblLesInformationsDu = new JLabel("Personaliser ma carte visite");
		lblLesInformationsDu.setForeground(SystemColor.textHighlight);
		lblLesInformationsDu.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 31));
		lblLesInformationsDu.setBounds(10, 8, 445, 50);
		panel_15.add(lblLesInformationsDu);
		
		JLabel lblLesAssistantes = new JLabel("Choisir mon logo");
		lblLesAssistantes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblLesAssistantes.setForeground(SystemColor.textText);
		lblLesAssistantes.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
		lblLesAssistantes.setBounds(10, 69, 86, 25);
		panel_15.add(lblLesAssistantes);
		
		textField_44 = new JTextField();

		textField_44.setColumns(10);
		textField_44.setBounds(221, 349, 292, 37);
		panel_15.add(textField_44);
		
		JScrollPane scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(114, 397, 254, 37);
		panel_15.add(scrollPane_11);
		
		textField_45 = new JTextArea();
		textField_45.setFont(new Font("Monospaced", Font.PLAIN, 13));
	
		scrollPane_11.setViewportView(textField_45);
		textField_45.setColumns(10);
		
		JButton btnImprimerCarteVisite = new JButton("Imprimer carte Visite");
	
		btnImprimerCarteVisite.setForeground(Color.RED);
		btnImprimerCarteVisite.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnImprimerCarteVisite.setBounds(371, 397, 142, 41);
		panel_15.add(btnImprimerCarteVisite);
		
		JLabel lblVisionnerMonSite = new JLabel("Visionner mon site Web");
		lblVisionnerMonSite.setForeground(SystemColor.textHighlight);
		lblVisionnerMonSite.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 31));
		lblVisionnerMonSite.setBounds(654, 11, 276, 44);
		panel_15.add(lblVisionnerMonSite);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(SystemColor.textHighlight);
		separator_3.setBounds(535, 8, 2, 717);
		panel_15.add(separator_3);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(545, 178, 459, 451);
		panel_15.add(scrollPane_12);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html  \r\ntext/css  \r\ntext/javascript \r\ntext/php");
		
		editorPane.setEditable(false);
		scrollPane_12.setViewportView(editorPane);
		
		txtHttpgooglecom = new JTextField();
		txtHttpgooglecom.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		txtHttpgooglecom.setText("http://google.com");
		txtHttpgooglecom.setForeground(SystemColor.activeCaptionBorder);
		txtHttpgooglecom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHttpgooglecom.setText("");
				txtHttpgooglecom.setForeground(SystemColor.black);
			}
		});
		txtHttpgooglecom.setColumns(10);
		txtHttpgooglecom.setBounds(628, 121, 292, 37);
		panel_15.add(txtHttpgooglecom);
		
		JLabel lblUrl = new JLabel("URL :");
		lblUrl.setForeground(SystemColor.textHighlight);
		lblUrl.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblUrl.setBounds(570, 126, 48, 25);
		panel_15.add(lblUrl);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	SwingUtilities.invokeLater(null);
				String url = txtHttpgooglecom.getText();
				try {
					editorPane.setPage(url);
				} catch (IOException e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnGo.setForeground(SystemColor.textHighlight);
		btnGo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		btnGo.setBounds(930, 117, 84, 41);
		panel_15.add(btnGo);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblInformations.setForeground(SystemColor.controlText);
		lblInformations.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
		lblInformations.setBounds(10, 250, 73, 25);
		panel_15.add(lblInformations);
		
		 Label1 = new JLabel("");
	
		Label1.setBounds(159, 97, 153, 134);
		panel_15.add(Label1);
		
		JLabel next = new JLabel(">");
		next.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent arg0) {
				new Thread();
				try {
					Thread.sleep(300);
				} catch (Exception e) {
					Logger.getLogger(Medecin.class.getName()).log(Level.SEVERE, null, e);
					// 
				}
			
				
				position++;   //afficher l'image suivante
				if(position > takeImage().length-1) {
					position= 0;
				}
				show(position);
			}
		});
		next.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
		next.setForeground(SystemColor.textHighlight);
		next.setBounds(322, 135, 46, 37);
		panel_15.add(next);
		JLabel previous = new JLabel("<");
		previous.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent e) {
				new Thread();
				try {
					Thread.sleep(300);
				} catch (Exception ex) {
					Logger.getLogger(Medecin.class.getName()).log(Level.SEVERE, null, ex);
					// 
				}
				
				position--; //afficher l'image precedante
				if(position < 0) {
					position= takeImage().length-1;
				}
				show(position);
			}
		});
		previous.setForeground(SystemColor.textHighlight);
		previous.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
		previous.setBounds(111, 135, 46, 37);
		panel_15.add(previous);
		
		JLabel lblApperu = new JLabel("Apper\u00E7u");
		lblApperu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblApperu.setForeground(SystemColor.controlText);
		lblApperu.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 12));
		lblApperu.setBounds(10, 521, 48, 23);
		panel_15.add(lblApperu);
		
		JPanel editorPane_1 = new JPanel();
		editorPane_1.setBackground(SystemColor.window);
		editorPane_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.BLACK));
		editorPane_1.setBounds(78, 445, 416, 187);
		panel_15.add(editorPane_1);
		editorPane_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setForeground(SystemColor.textHighlight);
		logo.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
		logo.setBounds(10, 53, 104, 78);
		editorPane_1.add(logo);
		
		JLabel num = new JLabel("");
		num.setForeground(SystemColor.controlText);
		num.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		num.setBounds(20, 142, 220, 34);
		editorPane_1.add(num);
		
		JLabel adr = new JLabel("");
		adr.setForeground(SystemColor.controlText);
		adr.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		adr.setBounds(158, 66, 248, 78);
		editorPane_1.add(adr);
		
		JLabel entete = new JLabel("");
		entete.setForeground(SystemColor.controlText);
		entete.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		entete.setBounds(10, 0, 396, 42);
		editorPane_1.add(entete);
		
		JLabel label_11 = new JLabel("Num\u00E9ro de t\u00E9l\u00E9phone du cabinet ");
		label_11.setForeground(SystemColor.textHighlight);
		label_11.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		label_11.setBounds(0, 342, 220, 44);
		panel_15.add(label_11);
		
		JLabel label_12 = new JLabel("Adresse cabinet");
		label_12.setForeground(SystemColor.textHighlight);
		label_12.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		label_12.setBounds(0, 397, 106, 44);
		panel_15.add(label_12);
		
		textentete = new JTextField();
		textentete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				entete.setText("<html> " +textentete.getText() +" </html>");
			}
		});
		textentete.setColumns(10);
		textentete.setBounds(68, 293, 445, 37);
		panel_15.add(textentete);
		
		JLabel lblL = new JLabel("L'ent\u00EAte");
		lblL.setForeground(SystemColor.textHighlight);
		lblL.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
		lblL.setBounds(0, 286, 220, 44);
		panel_15.add(lblL);
		
		JButton btnStatistiques = new JButton("Param\u00E8tres");
		btnStatistiques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_2, panel_14);
				textField_56.setText("");
				textField_58.setText("");
				textField_59.setText("");
				textField_60.setText("");
				textField_61.setText("");
				
			}
		});
		btnStatistiques.setForeground(SystemColor.textHighlight);
		btnStatistiques.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnStatistiques.setBounds(10, 0, 204, 41);
		panel_3.add(btnStatistiques);
		
		JButton btnInformationsCabinet = new JButton("Marketing");
		btnInformationsCabinet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_2, panel_15);
				show(position);  //affchages des images
				txtHttpgooglecom.setText("http://google.com");
				txtHttpgooglecom.setForeground(Color.GRAY);
				textField_44.setText("");
				textField_45.setText("");
				textentete.setText("");
				editorPane.setText("");
				logo.setText("");
				num.setText("");
				adr.setText("");
				entete.setText("");
			}
		});
		
		btnInformationsCabinet.setForeground(SystemColor.textHighlight);
		btnInformationsCabinet.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnInformationsCabinet.setBounds(209, 0, 204, 41);
		panel_3.add(btnInformationsCabinet);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		layeredPane.add(panel_4, "name_14279662879200");
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBounds(10, 41, 1014, 636);
		panel_4.add(layeredPane_3);
		layeredPane_3.setLayout(new CardLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		layeredPane_3.add(panel_16, "name_14341945754100");
		panel_16.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Les charges du cabinet m\u00E9dical");
		lblNewLabel_15.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 45));
		lblNewLabel_15.setForeground(SystemColor.textHighlight);
		lblNewLabel_15.setBounds(10, 11, 594, 81);
		panel_16.add(lblNewLabel_15);
		
		txtAaaammjj = new JTextField();
		txtAaaammjj.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		txtAaaammjj.setText("AAAA-MM-JJ");
		txtAaaammjj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtAaaammjj.setText("");
				txtAaaammjj.setForeground(SystemColor.black);
			}
		});
		txtAaaammjj.setBounds(198, 138, 243, 42);
		panel_16.add(txtAaaammjj);
		txtAaaammjj.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_32.setText("");
				textField_32.setForeground(SystemColor.black);
			}
		});
		textField_32.setText("00.00");
		textField_32.setForeground(Color.GRAY);
		textField_32.setColumns(10);
		textField_32.setBounds(198, 228, 243, 42);
		panel_16.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_33.setText("");
				textField_33.setForeground(SystemColor.black);
			}
		});
		textField_33.setText("00.00");
		textField_33.setForeground(Color.GRAY);
		textField_33.setColumns(10);
		textField_33.setBounds(198, 326, 243, 42);
		panel_16.add(textField_33);
		
		textField_42 = new JTextField();
		textField_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_42.setText("");
				textField_42.setForeground(SystemColor.black);
			}
		});
		textField_42.setText("00.00");
		textField_42.setForeground(Color.GRAY);
		textField_42.setColumns(10);
		textField_42.setBounds(198, 424, 243, 42);
		panel_16.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_43.setText("");
				textField_43.setForeground(SystemColor.black);
			}
		});
		textField_43.setText("00.00");
		textField_43.setForeground(Color.GRAY);
		textField_43.setColumns(10);
		textField_43.setBounds(746, 424, 243, 42);
		panel_16.add(textField_43);
		
		textField_46 = new JTextField();
		textField_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_46.setText("");
				textField_46.setForeground(SystemColor.black);
			}
		});
		textField_46.setText("00.00");
		textField_46.setForeground(Color.GRAY);
		textField_46.setColumns(10);
		textField_46.setBounds(746, 326, 243, 42);
		panel_16.add(textField_46);
		
		textField_47 = new JTextField();
		textField_47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_47.setText("");
				textField_47.setForeground(SystemColor.black);
			}
		});
		textField_47.setText("00.00");
		textField_47.setForeground(Color.GRAY);
		textField_47.setColumns(10);
		textField_47.setBounds(746, 228, 243, 42);
		panel_16.add(textField_47);
		
		textField_62 = new JTextField();
		textField_62.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_62.setText("");
				textField_62.setForeground(SystemColor.black);
			}
		});
		textField_62.setText("00.00");
		textField_62.setForeground(Color.GRAY);
		textField_62.setColumns(10);
		textField_62.setBounds(746, 138, 243, 42);
		panel_16.add(textField_62);
		
		JLabel lblNewLabel_16 = new JLabel("Date");
		lblNewLabel_16.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblNewLabel_16.setForeground(SystemColor.textHighlight);
		lblNewLabel_16.setBounds(10, 145, 93, 28);
		panel_16.add(lblNewLabel_16);
		
		JLabel lblLoyer = new JLabel("Loyer");
		lblLoyer.setForeground(SystemColor.textHighlight);
		lblLoyer.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblLoyer.setBounds(10, 242, 93, 28);
		panel_16.add(lblLoyer);
		
		JLabel lblFactureDlctricit = new JLabel("Facture d'\u00E9l\u00E9ctricit\u00E9");
		lblFactureDlctricit.setForeground(SystemColor.textHighlight);
		lblFactureDlctricit.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFactureDlctricit.setBounds(10, 340, 178, 28);
		panel_16.add(lblFactureDlctricit);
		
		JLabel lblFactureDeau = new JLabel("Facture d'eau");
		lblFactureDeau.setForeground(SystemColor.textHighlight);
		lblFactureDeau.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFactureDeau.setBounds(10, 438, 158, 28);
		panel_16.add(lblFactureDeau);
		
		JLabel lblFraisSupplmentaires = new JLabel("Frais suppl\u00E9mentaires");
		lblFraisSupplmentaires.setForeground(SystemColor.textHighlight);
		lblFraisSupplmentaires.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFraisSupplmentaires.setBounds(536, 438, 200, 28);
		panel_16.add(lblFraisSupplmentaires);
		
		JLabel lblFactureDinternet = new JLabel("Facture d'internet");
		lblFactureDinternet.setForeground(SystemColor.textHighlight);
		lblFactureDinternet.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFactureDinternet.setBounds(536, 340, 158, 28);
		panel_16.add(lblFactureDinternet);
		
		JLabel lblFactureTlphone = new JLabel("Facture t\u00E9l\u00E9phone");
		lblFactureTlphone.setForeground(SystemColor.textHighlight);
		lblFactureTlphone.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFactureTlphone.setBounds(536, 242, 158, 28);
		panel_16.add(lblFactureTlphone);
		
		JLabel lblFactureDeGaz = new JLabel("Facture de gaz");
		lblFactureDeGaz.setForeground(SystemColor.textHighlight);
		lblFactureDeGaz.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblFactureDeGaz.setBounds(536, 152, 140, 28);
		panel_16.add(lblFactureDeGaz);
		
		JButton btnSauvegarderfacture = new JButton("Sauvegarder Facture");
		btnSauvegarderfacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterFacture();
			}
		});
		btnSauvegarderfacture.setForeground(SystemColor.textHighlight);
		btnSauvegarderfacture.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnSauvegarderfacture.setBounds(378, 532, 211, 44);
		panel_16.add(btnSauvegarderfacture);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		layeredPane_3.add(panel_17, "name_14346526904500");
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		layeredPane_3.add(panel_21, "name_16922156063200");
		panel_21.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("<html> Si le graphe est vide, sachez que vos b\u00E9n\u00E9fices sont exactement les m\u00EAmes que vos revenus \u00E9tant donn\u00E9 que vous n'avez \u00E9tabli aucune facture. </html> ");
		lblNewLabel_17.setForeground(Color.DARK_GRAY);
		lblNewLabel_17.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		lblNewLabel_17.setBounds(605, 11, 399, 26);
		panel_21.add(lblNewLabel_17);
		
		JButton btnNewButton_5 = new JButton("Ajouter facture");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_3, panel_16);
				txtAaaammjj.setText("AAAA-MM-JJ");	
				txtAaaammjj.setForeground(Color.GRAY);
				textField_32.setText("00.00");
				textField_32.setForeground(Color.GRAY);
				textField_33.setText("00.00");
				textField_33.setForeground(Color.GRAY);
				textField_42.setText("00.00");
				textField_42.setForeground(Color.GRAY);
				textField_62.setText("00.00");
				textField_62.setForeground(Color.GRAY);
				textField_47.setText("00.00");
				textField_47.setForeground(Color.GRAY);
				textField_46.setText("00.00");
				textField_46.setForeground(Color.GRAY);
				textField_43.setText("00.00");
				textField_43.setForeground(Color.GRAY);
			}
		});
		btnNewButton_5.setForeground(SystemColor.textHighlight);
		btnNewButton_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnNewButton_5.setBounds(10, 0, 211, 44);
		panel_4.add(btnNewButton_5);
		
		JButton btnListeDesMdicaments = new JButton("Revenus");
		btnListeDesMdicaments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_3, panel_17);
	calculerRevenus(panel_17);
			}
		});
		btnListeDesMdicaments.setForeground(SystemColor.textHighlight);
		btnListeDesMdicaments.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnListeDesMdicaments.setBounds(218, 0, 211, 44);
		panel_4.add(btnListeDesMdicaments);
		
		JButton btnBnfices = new JButton("B\u00E9n\u00E9fices");
		btnBnfices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane_3, panel_21);
				calculerBenefices(panel_21);
				Thread t = new Thread(new Runnable() {
					  public void run() {
					    while (true) {
					    	lblNewLabel_17.setVisible(!lblNewLabel_17.isVisible()); //faire clignoter le message

					      try {
					        Thread.sleep(500); 
					      } catch (InterruptedException e) { 
					    	  JOptionPane.showMessageDialog(null, e.getMessage());
					      }
					    }
					  }
					});

					t.start();
				
			}
		});
		btnBnfices.setForeground(SystemColor.textHighlight);
		btnBnfices.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnBnfices.setBounds(426, 0, 211, 44);
		panel_4.add(btnBnfices);

		JButton btnNewButton = new JButton("Acceuil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane, panel);
			}
		});
		btnEnregistrerPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ajouterPatient();				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBounds(0, 11, 110, 33);
		contentPane.add(btnNewButton);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.setEnabled(false);
		btnPatient.setIcon(new ImageIcon(Medecin.class.getResource("/Images/cc.png")));

		btnPatient.setForeground(SystemColor.textHighlight);
		btnPatient.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnPatient.setBounds(0, 77, 120, 75);
		contentPane.add(btnPatient);
		
		JButton btnRendezvous = new JButton("Rendez-vous");
		btnRendezvous.setEnabled(false);
		btnRendezvous.setIcon(new ImageIcon(Medecin.class.getResource("/Images/nurse_plan.png")));
		btnRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Secretaire();  // afficher l'espace de la secretaire
				layeredPane.add(Secretaire.getSecret(), "name_14231826055200");
				switchpanels(layeredPane, Secretaire.getSecret());
				Secretaire.getTextField_47().setText("");
				Secretaire.getTextField_32().setText("");
				Secretaire.getTextField_31().setText("");
				Secretaire.getTextField_33().setText("");
				Secretaire.getTxtAaaammjj().setText("AAAA-MM-JJ");
				Secretaire.getTxtAaaammjj().setForeground(Color.GRAY);
				
		
			}
		});
		btnRendezvous.setForeground(SystemColor.textHighlight);
		btnRendezvous.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnRendezvous.setBounds(0, 183, 120, 75);
		contentPane.add(btnRendezvous);
		
		JButton btnMonCabinet = new JButton("Mon cabinet");
		btnMonCabinet.setEnabled(false);
		btnMonCabinet.setIcon(new ImageIcon(Medecin.class.getResource("/Images/cabinetMedical.png")));
		btnMonCabinet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane, panel_3);
				cn=connection.cnx();
				textField_56.setText("");
				textField_58.setText("");
				textField_59.setText("");
				textField_60.setText("");
				textField_61.setText("");
				txtHttpgooglecom.setText("http://google.com");
				txtHttpgooglecom.setForeground(Color.GRAY);
				textField_44.setText("");
				textField_45.setText("");
				textentete.setText("");
				editorPane.setText("");
				logo.setText("");
				num.setText("");
				adr.setText("");
				entete.setText("");
				viderPostes(comboBox);    //vider le comBobox afin de pouvoir le recharger avec les postes actuels
				try {
					
					
					String sql="select *  from registration";
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next())
					{
						comboBox.addItem(rs.getString("nomUtilisateur"));
				
					}

				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					 
					
					  
				}finally {
					try {
						rs.close();
						ps.close();
					
					}catch(Exception e) {
						 

					}
				}
			}
		});
		btnMonCabinet.setForeground(SystemColor.textHighlight);
		btnMonCabinet.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnMonCabinet.setBounds(0, 293, 120, 75);
		contentPane.add(btnMonCabinet);
		
		JButton btnComptabilit = new JButton("Comptabilit\u00E9");
		btnComptabilit.setEnabled(false);
		btnComptabilit.setIcon(new ImageIcon(Medecin.class.getResource("/Images/money.png")));
		btnComptabilit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane, panel_4);
				txtAaaammjj.setText("AAAA-MM-JJ");	
				txtAaaammjj.setForeground(Color.GRAY);
				textField_32.setText("00.00");
				textField_32.setForeground(Color.GRAY);
				textField_33.setText("00.00");
				textField_33.setForeground(Color.GRAY);
				textField_42.setText("00.00");
				textField_42.setForeground(Color.GRAY);
				textField_62.setText("00.00");
				textField_62.setForeground(Color.GRAY);
				textField_47.setText("00.00");
				textField_47.setForeground(Color.GRAY);
				textField_46.setText("00.00");
				textField_46.setForeground(Color.GRAY);
				textField_43.setText("00.00");
				textField_43.setForeground(Color.GRAY);
			}
		});
		btnComptabilit.setForeground(SystemColor.textHighlight);
		btnComptabilit.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnComptabilit.setBounds(0, 406, 120, 75);
		contentPane.add(btnComptabilit);
		
		JButton btnMdicament = new JButton("M\u00E9dicament");
		btnMdicament.setEnabled(false);
		btnMdicament.setIcon(new ImageIcon(Medecin.class.getResource("/Images/img.png")));
		btnMdicament.setText("Médicaments");
		btnMdicament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        	new Medicament();
				layeredPane.add(Medicament.getPanel_18(), "name_14883667712300");
				switchpanels(layeredPane, Medicament.getPanel_18());
				
			}
		});
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanels(layeredPane, panel_1);
				cn=connection.cnx();
				textField.setText("");
				textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_6.setText("");
								textField_7.setText("");
								textField_8.setText("");
								textField_9.setText("");
								textField_11.setText("");
						     	textField_4.setText("");
								textField_5.setText("");
								textField_12.setText("");
								textField_13.setText("");
								textField_14.setText("");
								textField_25.setText("");
								textField_26.setText("");
								textField_27.setText("");
								textField_28.setText("");
								textField_29.setText("");
								textField_30.setText("");
								textField_25.setVisible(false);
								textField_26.setVisible(false);
								textField_27.setVisible(false);
								textField_28.setVisible(false);
								textField_29.setVisible(false);
								textField_30.setVisible(false);
								l1.setVisible(false);
								l2.setVisible(false);
								l3.setVisible(false);
								l4.setVisible(false);
								l5.setVisible(false);
								l6.setVisible(false);
								l7.setVisible(false);
								b.setVisible(false);			
								lbl.setVisible(false);
								lbll.setVisible(false);
								lblll.setVisible(false);
								attribuerCode(textField_4);
					textField_10.setText("");
						textField_15.setText("");
								textField_16.setText("");
								textField_177.setText("");
								textField_18.setText("");
								p1.setText("");
								p2.setText("");
								p3.setText("");
								clearTable(tbl);
								fm.setText("");
								fne.setText("");
								fnc.setText("");
								fcc.setText("");
								attribuerCode(textField_15);
		                   		textField_19.setText("");
								textField_20.setText("");
								textField_21.setText("");
								textField_34.setText("");
								textField_35.setText("");
								textField_36.setText("");
								textField_37.setText("");
					         	textField_22.setText("");
								textField_23.setText("");
								textField_24.setText("");
								textField_51.setText("");
								textField_52.setText("");
								textField_53.setText("");
								textField_54.setText("");
								textField_55.setText("");
				             	textField_48.setText("");
								textField_49.setText("");
								textField_50.setText("");
								textField_38.setText("");
								textField_39.setText("");
								textField_40.setText("");
								textField_41.setText("");
								ll.setVisible(false);
								lll.setVisible(false);
								llll.setVisible(false);
								label_32.setVisible(false);
								label_33.setVisible(false);
								label_34.setVisible(false);
								label_35.setVisible(false);


             
				try {
					String sql="select codepatient, nompatient, prenompatient,matriculeAss from patient ";
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}finally {
					try {
						rs.close();
						ps.close();
					textField_57.setText(String.valueOf(table.getRowCount()));
					}catch(Exception e) {}
				}	
				}
	
		});
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 new Assurance().setVisible(true);
			      Assurance.getTextField().setText(textField_11.getText());
			      Assurance.getTextField().setEditable(false);
			      Assurance.getTextField_2().setEditable(true);
			      Assurance.getTextField_1().setEditable(true);			 
			}
		});
		
		btnMdicament.setForeground(SystemColor.textHighlight);
		btnMdicament.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnMdicament.setBounds(0, 518, 120, 75);
		contentPane.add(btnMdicament);
		btnEtablirUneFiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbl.isVisible() || lbll.isVisible() || lblll.isVisible())    //Si le patient n'existe pas
				{
					JOptionPane.showMessageDialog(null, "Il faut allez inscrire le patient avant !");
				}else {   //sinon afficher les autres champs à remplir
				textField_25.setVisible(true);
				textField_26.setVisible(true);
				textField_27.setVisible(true);
				textField_28.setVisible(true);
				textField_29.setVisible(true);
				textField_30.setVisible(true);
				l1.setVisible(true);
				l2.setVisible(true);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				b.setVisible(true);
				attribuerCode(textField_25);
				label_32.setVisible(true);
				label_33.setVisible(true);
				label_34.setVisible(true);
				label_35.setVisible(true);
				
				try{
					cn=connection.cnx();
				String sql=" select codeAntecedant from antecedant where codePatient = ? ";
				ps=cn.prepareStatement(sql);
					ps.setString(1, textField_5.getText());
					rs=ps.executeQuery();
				
				if(rs.next()) {
					textField_25.setText(rs.getString("codeAntecedant"));
				}
				else {
					JOptionPane.showMessageDialog(null, "Ce patient n'a pas d'antecedants");
				}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				finally {
					try {
						rs.close();
						ps.close();						
							}catch(Exception ex) {}
						}
				}
			}
			
		});
		
		role = new JTextField();
		role.setBackground(SystemColor.window);
		role.setEditable(false);

		role.setForeground(SystemColor.textHighlight);
		role.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		role.setBounds(455, 11, 104, 38);
		panel.add(role);
		role.setColumns(10);
		
		JLabel lblVousEtesEn = new JLabel("Vous \u00EAtes en mode :");
		lblVousEtesEn.setForeground(new Color(0, 120, 215));
		lblVousEtesEn.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		lblVousEtesEn.setBounds(274, 0, 171, 56);
		panel.add(lblVousEtesEn);
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
		btnDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new Login().setVisible(true);
			}
		});
		btnDconnexion.setForeground(Color.RED);
		btnDconnexion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnDconnexion.setBounds(0, 766, 120, 33);
		contentPane.add(btnDconnexion);
		
		JButton btnProblme = new JButton("Probl\u00E8me");
		btnProblme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {  //signaler le problème et nous contacter sur google forms
					Desktop.getDesktop().browse(new URL("https://docs.google.com/forms/d/e/1FAIpQLSer5NzOotVKcTqbsj8IxLacT0j6RJ3csvn8Inhr-qx47CWEcw/viewform?usp=pp_url").toURI());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 
				}
			}
		});
		btnProblme.setForeground(SystemColor.textHighlight);
		btnProblme.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnProblme.setBounds(0, 625, 110, 33);
		contentPane.add(btnProblme);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_5.getText().equalsIgnoreCase("") || textField_27.getText().equalsIgnoreCase("") ||textField_28.getText().equalsIgnoreCase("") ||textField_29.getText().equalsIgnoreCase("") ||textField_30.getText().equalsIgnoreCase("") || textField_5.getText().equalsIgnoreCase(" ") || textField_27.getText().equalsIgnoreCase(" ") ||textField_28.getText().equalsIgnoreCase(" ") ||textField_29.getText().equalsIgnoreCase(" ") ||textField_30.getText().equalsIgnoreCase(" ")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir les champs obligatoires...");
				}else {
				try {	
		    ajouterConsultation();				
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				 
			}
			finally {
				try {
					ps.close();
					cn.close();
			    etablirDossierMedical();
				}catch(Exception exx) {}
			}
				}
			}
		});
		btnCommencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {   //définir les contraintesselon le role de l'utilisateur
					if (role.getText().toString().equals("Médecin")) {   //n'a pas de contraintes
				
					btnPatient.setEnabled(true);
					btnMdicament.setEnabled(true);
					btnMonCabinet.setEnabled(true);
					btnComptabilit.setEnabled(true);
					btnRendezvous.setEnabled(true);
				}
				else if (role.getText().toString().equals("Assistant(e)")){   //peut seuelement gerer les rdvs et consulter la partie "mon cabinet pour changer son mot de passe etc...
					btnComptabilit.setEnabled(false);
					btnRendezvous.setEnabled(true);
					btnPatient.setEnabled(false);
					btnMdicament.setEnabled(false);
					btnMonCabinet.setEnabled(true);
				}
			}catch(Exception ex) {
				 
			}
			}
		});
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {    //si le medecin essaye d'enregister un patient qui existe déja
				
			chercherPatient();
				}
		});
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {   // si le medecin essaye d'ajouter une consultation pour un patient qui n'existe pas
					cn=connection.cnx();
					String sql="select * from patient where codePatient = ?" ;
					ps=cn.prepareStatement(sql);
					ps.setString(1,(String) textField_5.getText().toString());
					rs=ps.executeQuery();
					if(! rs.next())
					{
						lbl.setVisible(true);
						lbll.setVisible(true);
						lblll.setVisible(true);
				
					}else {
						lbl.setVisible(false);
						lbll.setVisible(false);
						lblll.setVisible(false);
						
					}
				
					
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
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {    //ajouter un médicament dans la prescription
				Object[] row= new Object[3];
				row[0]= p1.getText();
				row[1]=p2.getText();
				row[2]= p3.getText();
				model.addRow(row);
				try {
					cn=connection.cnx();
					String sql="insert into  prescription(nommedicament , codeOrdonnance, qtemedicament, nbrfois) values(?,?,?,?)";
					ps=cn.prepareStatement(sql);
					ps.setString(2, textField_15.getText());
					ps.setString(1, p1.getText());
					ps.setString(3, p2.getText());
					ps.setString(4, p3.getText());
					ps.executeUpdate();
					
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {
						
						ps.close();
					}catch(Exception ex) {}
				}
			}
		});		btnSupprimer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //supprimer un médicament de la prescription
				model.removeRow(tbl.getSelectedRow());
				try {
					cn=connection.cnx();
					String sql="delete from prescription where codeOrdonnance = ? and nommedicament = ?";
					ps=cn.prepareStatement(sql);
					ps.setString(1, textField_15.getText());
					ps.setString(2, p1.getText());
				
					ps.executeUpdate();
					
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}finally {
					try {
						
						ps.close();
					}catch(Exception ex) {}
				}
				
			}
		});

		textField_45.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				adr.setText("<html> " +textField_45.getText()+" </html>");   // le champs d'adresse peut dépasser une ligne donc on rajouter <html>...
			}
		});
		btnModifierInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMettreJour.setEnabled(true);
				textField_56.setEditable(true);
				textField_58.setEditable(true);
				textField_59.setEditable(true);
				textField_60.setEditable(true);
				textField_61.setEditable(true);
			}
		});
		textField_44.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				num.setText("<html> " +textField_44.getText() +" </html>");
			}
		});
		 Label1.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent e) {
			 		logo.setText("");
			 		Image image = ((ImageIcon) Label1.getIcon()).getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
			 			
			 		 logo.setIcon(new ImageIcon(image));
			 	}
			 });
			btnImprimerCarteVisite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					printIt(editorPane_1,0.3,0.3);    //impression de la carte visite 
				}
			});
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String filePath="ChillingMusic.wav";
					musicStuff.playMusic(filePath);   // allumer la musique 
					lblNewLabel_12.setEnabled(true);
					lblNewLabel_13.setEnabled(true);
				}
			});
			btnImprimer.addActionListener(new ActionListener() {   //imprimer une ordonnance
				public void actionPerformed(ActionEvent e) {
					Connection conn= null; 
					PreparedStatement p= null;
					ResultSet r= null;
					
					try {
						conn= connection.cnx();
						String querry="SELECT * FROM patient where codepatient = " +textField_177.getText() ; //recuperer le infos du patient à partir de la cin pour ne pas les réecrire
						p= conn.prepareStatement(querry);
				
						DefaultTableModel m1 = (DefaultTableModel) tbl.getModel();
						int nRow=m1.getRowCount(), nCol=m1.getColumnCount();
						Object [][] tableData = new Object[nRow][nCol];
						new	Paperasse().setVisible(true);					//Apperçu de l'ordonnance imprimée
			
						r=p.executeQuery();
						while(r.next()) { //remplissage de l'ordonnance
						
						Paperasse.getLblLpat().setText(r.getString("nomPatient"));
						Paperasse.getLblp().setText(r.getString("prenomPatient"));
						Paperasse.getLblLddn().setText(r.getString("dateNaissance"));
						Paperasse.getLblLadr().setText(r.getString("adressePatient"));;
						Paperasse.getLblNm().setText("<html> "+ fm.getText() + " </html>");
						Paperasse.getLblNper().setText("<html> "+fne.getText()+ " </html>");
						Paperasse.getLblNewLabel().setText("<html> "+fnc.getText()+ " </html>");
						Paperasse.getLblCoordonnesDeLa().setText("<html> "+fcc.getText()+ " </html>");
						Paperasse.getLblCommentaire().setText("<html> "+textField_18.getText()+ " </html>");		
						Paperasse.getLblLddj().setText(getCurrentDate());
				for(int i=0; i<nRow;i++) { //remplissage de la textArea avec la table de la prescription établie
					for(int j=0; j<nCol;j++) {
						tableData [i][j] = m1.getValueAt(i, j);
						Paperasse.getTextArea().append((String) tableData [i][j] +"\t");
					}
					Paperasse.getTextArea().append("\n");
				}
					printIt(Paperasse.getPanel(),1,1.1);    //impression 
						}

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
			textField_11.addKeyListener(new KeyAdapter() { //vérifier si un autre patient s'est inscrit avec cette assurance
				@Override
				public void keyReleased(KeyEvent arg0) {
					//***********************************************************************************************
					try {
						cn=connection.cnx();
						String sql="select * from assurance where matriculeAss = ? ";
						ps=cn.prepareStatement(sql);
						ps.setString(1, textField_11.getText().toString());				
						rs =ps.executeQuery();	
						if(rs.next()) {     //si le matricule de l'assurance existe déjà
							assu.setVisible(true);
						}else {
							assu.setVisible(false);
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}finally {
						try {						
							ps.close();
							  
						}catch(Exception ex) {}
					}
				}
			});
	}
	public static JTextField getTextField_1() {
		// TODO Auto-generated method stub
		return textField_1;
	}
}
