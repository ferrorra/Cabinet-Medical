
import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.common.MouseButtons;
import com.mindfusion.common.ChangeListener;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.drawing.Colors;
import com.mindfusion.drawing.awt.AwtImage;
import com.mindfusion.scheduling.*;
import com.mindfusion.drawing.Color;
import com.mindfusion.scheduling.awt.AwtCalendar;
import com.mindfusion.scheduling.model.*;
import com.mindfusion.scheduling.model.ItemEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;
public class Calendrier extends JFrame {

    private JCheckBox simpleConsultation;
    private JCheckBox consultationUrgente;
    private JCheckBox maladieGrave;
    private JCheckBox traitementHebdomadaire;
    private Choice traitement;
    private AwtCalendar calendar;
    ArrayList<Contact> contactsList;
	static Connection cn=null;
	static ResultSet rs=null;
	static PreparedStatement ps=null;
public void ecrireNotes(ItemEvent e) {
	try {
        Appointment item = (Appointment)e.getItem();
if(traitement.getSelectedItem() != null) {
        String nomTraitement = traitement.getSelectedItem();
        for(Contact c:calendar.getSchedule().getContacts()) {
            if (c.getName().equals(nomTraitement)) {
                item.getContacts().add(calendar.getContacts().get(c.getId()));

            }
        }
        item.setHeaderText(nomTraitement);
}else 
	JOptionPane.showMessageDialog(null, "Vous n'avez pas selectionné un code patient ...");
for(Contact c:calendar.getSchedule().getContacts()) {
    if (c.getName().equals("")) {
        item.getContacts().add(calendar.getContacts().get(c.getId()));

    }
}
item.setHeaderText(""); //si auccune cin n'a été selectionnée, la tete de l'elt crée reste vide
    	}catch(Exception ex) {
    		
    	}
}
    public Calendrier() {
    	

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Mon calendrier dynamique pour les notes");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/Images/images (7).jpg")));
        setMinimumSize(new Dimension(800, 600));

        contactsList = new ArrayList<Contact>();

        Container container = this.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        container.setLayout(springLayout);

        traitement = new Choice();
        container.add(traitement);

        simpleConsultation = new JCheckBox("simple Consultation");
        simpleConsultation.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        simpleConsultation.setForeground(SystemColor.textHighlight);
        simpleConsultation.setSelected(false);

        simpleConsultation.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });
        container.add(simpleConsultation);

        traitementHebdomadaire = new JCheckBox("traitement Hebdomadaire");
        traitementHebdomadaire.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        traitementHebdomadaire.setForeground(SystemColor.textHighlight);

        traitementHebdomadaire.setSelected(false);
        traitementHebdomadaire.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(traitementHebdomadaire);

        maladieGrave = new JCheckBox("maladie Grave");
        maladieGrave.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        maladieGrave.setForeground(SystemColor.textHighlight);
        maladieGrave.setSelected(false);
        maladieGrave.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(maladieGrave);

        consultationUrgente = new JCheckBox("consultation Urgente");
        consultationUrgente.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        consultationUrgente.setForeground(SystemColor.textHighlight);

        consultationUrgente.setSelected(false);
        consultationUrgente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent e) {
                checkBoxChanged(e);
            }
        });

        container.add(consultationUrgente);

        springLayout.putConstraint(SpringLayout.SOUTH, consultationUrgente, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, consultationUrgente, 5, SpringLayout.EAST, simpleConsultation);

        springLayout.putConstraint(SpringLayout.SOUTH, traitementHebdomadaire, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, traitementHebdomadaire, 5, SpringLayout.EAST, consultationUrgente);

        springLayout.putConstraint(SpringLayout.SOUTH, maladieGrave, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, maladieGrave, 5, SpringLayout.EAST, traitementHebdomadaire);

        JLabel lblSelectionnerUnPatient = new JLabel("Selectionner un patient :");
        springLayout.putConstraint(SpringLayout.EAST, traitement, 91, SpringLayout.EAST, lblSelectionnerUnPatient);
        lblSelectionnerUnPatient.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        lblSelectionnerUnPatient.setForeground(SystemColor.textHighlight);
        container.add(lblSelectionnerUnPatient);

        calendar = new AwtCalendar();
  
        calendar.setHiddenItemsCursor(10);
        calendar.setItemVResizeCursor(10);
        calendar.setItemDragCursor(10);
        calendar.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
        calendar.beginInit();
        calendar.setCurrentView(CalendarView.Timetable);
        calendar.setTheme(ThemeType.Standard); // le thème du calendrier  
        calendar.setCustomDraw(CustomDrawElements.TimetableItem);
        calendar.setGroupType(10);
        calendar.getTimetableSettings().getCellStyle().setBorderBottomColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderBottomWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderLeftColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderLeftWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderRightColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderRightWidth(1);
        calendar.getTimetableSettings().getCellStyle().setBorderTopColor(new Color(169, 169, 169));
        calendar.getTimetableSettings().getCellStyle().setBorderTopWidth(1);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowOffset(0);
        calendar.getTimetableSettings().getCellStyle().setHeaderTextShadowStyle(ShadowStyle.Fading);
        calendar.getTimetableSettings().getDates().clear();

        for (int i = 0; i < 7; i++)
            calendar.getTimetableSettings().getDates().add(DateTime.today().addDays(i - 1));

        calendar.getTimetableSettings().setItemOffset(30);
        calendar.getTimetableSettings().setShowItemSpans(false);
        calendar.getTimetableSettings().setSnapInterval(Duration.fromMinutes(1));
        calendar.getTimetableSettings().setVisibleColumns(7);
        calendar.endInit();

        springLayout.putConstraint(SpringLayout.EAST, calendar, 0, SpringLayout.EAST, container);
        springLayout.putConstraint(SpringLayout.NORTH, calendar, 0, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, calendar, 0, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, calendar, -35, SpringLayout.NORTH, simpleConsultation);

        springLayout.putConstraint(SpringLayout.WEST, traitement, 5, SpringLayout.EAST, lblSelectionnerUnPatient);
        springLayout.putConstraint(SpringLayout.SOUTH, traitement, -5, SpringLayout.NORTH, simpleConsultation);

        springLayout.putConstraint(SpringLayout.WEST, lblSelectionnerUnPatient, 5, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.SOUTH, lblSelectionnerUnPatient, -5, SpringLayout.NORTH, simpleConsultation);

        springLayout.putConstraint(SpringLayout.SOUTH, simpleConsultation, -5, SpringLayout.SOUTH, container);
        springLayout.putConstraint(SpringLayout.WEST, simpleConsultation, 5, SpringLayout.WEST, container);

       calendar.setEnableDragCreate(true);

        calendar.addCalendarListener(new CalendarAdapter() {
        	
    
            public void itemCreated(ItemEvent e) {
                onItemCreated(e);
            }

            public void itemCreating(ItemConfirmEvent e) {
                onCalendarItemCreating(e);
            }

        });

        initializeContacts();

        container.add(calendar);
        simpleConsultation.setSelected(false);;
  	  consultationUrgente.setSelected(false);
  	     maladieGrave.setSelected(false);
  	    traitementHebdomadaire.setSelected(false);
  	    
  	    JButton btnNewButton = new JButton("Clear");
  	    btnNewButton.addMouseListener(new MouseAdapter() {
  	    	@Override
  	    	public void mouseClicked(MouseEvent arg0) {
  	    		
  	    		calendar.getSchedule().getItems().clear();
  	    		
  	    	}
  	    });
  	    btnNewButton.setForeground(SystemColor.textHighlight);
  	    btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
  	    springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, simpleConsultation);
  	    springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, getContentPane());
  	    getContentPane().add(btnNewButton);
  	  simpleConsultation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {   //garder que les simples consultations dns le JComboBox, toutes les autres méthodes font le tri selon le type de consultation 
				if (simpleConsultation.isSelected()) {
					traitement.removeAll();
					traitementHebdomadaire.setSelected(false);
					maladieGrave.setSelected(false);
					consultationUrgente.setSelected(false);
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day') and probleme = ?";
					try {
					ps=cn.prepareStatement(sql);
					ps.setString(1,"simpleConsultation");
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					  
  	    JButton button = new JButton("Clear");
  	    button.setForeground(SystemColor.textHighlight);
  	    button.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
  	    getContentPane().add(button);
  	        contact.setId(rs.getString("probleme"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
				}else {
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day')";
					try {
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					      contact.setId(rs.getString("probleme"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
				}
			}
		});
  	consultationUrgente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (consultationUrgente.isSelected()) {
					simpleConsultation.setSelected(false);
					maladieGrave.setSelected(false);
					traitementHebdomadaire.setSelected(false);
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day') and probleme = ?";
					try {
					ps=cn.prepareStatement(sql);
					ps.setString(1,"consultationUrgente");
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
				}else {
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day')";
					try {
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					      contact.setId(rs.getString("probleme"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
				}
			}
		});
  	maladieGrave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (maladieGrave.isSelected()) {
					simpleConsultation.setSelected(false);
					consultationUrgente.setSelected(false);
					traitementHebdomadaire.setSelected(false);
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day') and probleme = ?";
					try {
					ps=cn.prepareStatement(sql);
					ps.setString(1,"maladieGrave");
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
				}else {
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day')";
					try {
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
				}
			}
		});
  	traitementHebdomadaire.addMouseListener(new MouseAdapter() {
  		
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (traitementHebdomadaire.isSelected()) {
					simpleConsultation.setSelected(false);
					consultationUrgente.setSelected(false);
					maladieGrave.setSelected(false);
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day') and probleme = ?";
					try {
					ps=cn.prepareStatement(sql);
					ps.setString(1,"traitementHebdomadaire");
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
					
				}else {
					traitement.removeAll();
				 	cn=connection.cnx();
					String sql="select codePatient, probleme from RDV where dateRDV  BETWEEN date('now') AND date('now','+7 day')";
					try {
					ps=cn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						  Contact contact = new Contact();
					      
					        contact.setName(rs.getString("codePatient"));
					        traitement.add(contact.getName());
					        calendar.getContacts().add(contact);
					        contactsList.add(contact);
					        rs.close();
					        ps.close();
					}
					}catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						
					}
				}
			}
		});
  	    
    }

    /** Listens to the check boxes. */
    private void checkBoxChanged(java.awt.event.ItemEvent e) {
        boolean addItems = true;
        Object source = e.getItemSelectable();

        if (source == simpleConsultation) {

            for (Contact c : contactsList) {
                if (c.getId().equals("simpleConsultation")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        traitement.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        traitement.remove(c.getName());
                    }
                }
            }
        } else if (source == traitementHebdomadaire) {
            for (Contact c : contactsList) {
                if (c.getId().equals("traitementHebdomadaire")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        traitement.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        traitement.remove(c.getName());
                    }
                }
            }
        } else if (source == maladieGrave) {
            for (Contact c : contactsList) {
                if (c.getId().equals("maladieGrave")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        traitement.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        traitement.remove(c.getName());
                    }

                }
            }
        }
        else if (source == consultationUrgente) {
            for (Contact c : contactsList) {
                if (c.getId().startsWith("consultationUrgente")) {

                    if (addItems) {
                        calendar.getContacts().add(c);
                        traitement.add(c.getName());
                    } else {
                        calendar.getContacts().remove(c);
                        traitement.remove(c.getName());
                    }
                }
            }

        }
    }


    private void initializeContacts() {
    	cn=connection.cnx();
		String sql="select codePatient, probleme from RDV ";
		try {
		ps=cn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			  Contact contact = new Contact();
		      
		        contact.setName(rs.getString("codePatient"));
		      contact.setId(rs.getString("probleme"));
		        traitement.add(contact.getName());
		        calendar.getContacts().add(contact);
		        contactsList.add(contact);
		      
		}
		  rs.close();
	        ps.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}

    }

    protected void onItemCreated(ItemEvent e) {
ecrireNotes(e);

    }

    protected void onCalendarItemCreating(ItemConfirmEvent e)   //limiter l'écriture des notes aux jours de travail = tous les jour sauf le vendredi
    {
        DateTime start = e.getItem().getStartTime();
        DateTime end = e.getItem().getEndTime();


        if(start.getDayOfWeek() == 5 || end.getDayOfWeek() == 5)
        {
            JOptionPane.showMessageDialog(this, "Pas de travail les vendredis ! ");
            e.setConfirm(false);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calendrier window = null;
                try {
                    window = new Calendrier();
                    window.setVisible(true);
                }
                catch (Exception exp) {
                }
            }
        });
    }
}
