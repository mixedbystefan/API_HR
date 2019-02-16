package apartmentservice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;

import com.sun.javafx.image.IntPixelGetter;
import com.sun.jmx.snmp.SnmpUnknownSubSystemException;
import com.sun.xml.internal.bind.v2.model.core.ID;

import jdk.internal.dynalink.beans.StaticClass;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.enterprise.inject.New;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class GUI_Client extends JFrame {

	private JPanel contentPane;
	private static JTextField textF_ID;
	private static JTextField TextF_ApNum;
	private static JTextField TextF_FirstName;
	private static JTextField TextF_LastName;
	private static JTextField textF_SSnum;
	private static JTextField textF_mobNum;
	private static JTextField textF_email;
	private static JTextField textF_in_date;
	private static JTextField textF_outDate;
	private static JTextField textF_notes;
	private JLabel lblLgenhetsnummer;
	private JLabel lblFrnamn;
	private JLabel lblEfternamn;
	private JLabel lblNewLabel;
	private JLabel lblMobilnummer;
	private JLabel lblNewLabel_1;
	private JLabel lblInflyttnigsdatum;
	private JLabel lblUtflyttningsdatum;
	private JLabel lblAnteckningar;
	ClientService clientService = new ClientService();
	private JButton btnHmtaHyresgstid;
	private JButton btnTaBort;
	private JButton btnRensa;
	private JLabel lblId;
	private final Action action = new SwingAction();
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Client frame = new GUI_Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textF_ID = new JTextField();
		textF_ID.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textF_ID.setBounds(340, 120, 25, 20);
		contentPane.add(textF_ID);
		textF_ID.setColumns(10);
		
		TextF_ApNum = new JTextField();
		
		TextF_ApNum.setBounds(46, 247, 153, 26);
		contentPane.add(TextF_ApNum);
		TextF_ApNum.setColumns(10);
		
		TextF_FirstName = new JTextField();
		
		TextF_FirstName.setBounds(46, 297, 153, 26);
		contentPane.add(TextF_FirstName);
		TextF_FirstName.setColumns(10);
		
		TextF_LastName = new JTextField();
		
		TextF_LastName.setBounds(46, 347, 153, 26);
		contentPane.add(TextF_LastName);
		TextF_LastName.setColumns(10);
		
		textF_SSnum = new JTextField();
		
		textF_SSnum.setBounds(46, 397, 153, 26);
		contentPane.add(textF_SSnum);
		textF_SSnum.setColumns(10);
		
		textF_mobNum = new JTextField();
		
		textF_mobNum.setBounds(46, 447, 153, 26);
		contentPane.add(textF_mobNum);
		textF_mobNum.setColumns(10);
		
		textF_email = new JTextField();
		
		textF_email.setBounds(46, 497, 153, 26);
		contentPane.add(textF_email);
		textF_email.setColumns(10);
		
		textF_in_date = new JTextField();
		
		textF_in_date.setBounds(46, 547, 153, 26);
		contentPane.add(textF_in_date);
		textF_in_date.setColumns(10);
		
		textF_outDate = new JTextField();
		
		textF_outDate.setBounds(46, 597, 153, 26);
		contentPane.add(textF_outDate);
		textF_outDate.setColumns(10);
		
		textF_notes = new JTextField();
		
		textF_notes.setBounds(46, 647, 153, 26);
		contentPane.add(textF_notes);
		textF_notes.setColumns(10);
		
		textFMode(false);
		
		lblLgenhetsnummer = new JLabel("Lägenhetsnummer");
		lblLgenhetsnummer.setBounds(46, 229, 153, 16);
		lblLgenhetsnummer.setFont(new Font("Courier New", Font.BOLD, 15));
		contentPane.add(lblLgenhetsnummer);
		
		lblFrnamn = new JLabel("Förnamn");
		lblFrnamn.setBounds(46, 279, 64, 16);
		lblFrnamn.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblFrnamn);
		
		lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setBounds(46, 329, 74, 16);
		lblEfternamn.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblEfternamn);
		
		lblNewLabel = new JLabel("Personnummer");
		lblNewLabel.setBounds(46, 379, 103, 16);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblNewLabel);
		
		lblMobilnummer = new JLabel("Mobilnummer");
		lblMobilnummer.setBounds(46, 429, 100, 16);
		lblMobilnummer.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblMobilnummer);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(46, 479, 61, 16);
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		lblInflyttnigsdatum = new JLabel("Inflyttnigsdatum");
		lblInflyttnigsdatum.setBounds(46, 529, 130, 16);
		lblInflyttnigsdatum.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblInflyttnigsdatum);
		
		lblUtflyttningsdatum = new JLabel("Utflyttningsdatum");
		lblUtflyttningsdatum.setBounds(46, 579, 153, 16);
		lblUtflyttningsdatum.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblUtflyttningsdatum);
		
		lblAnteckningar = new JLabel("Anteckningar");
		lblAnteckningar.setBounds(46, 629, 100, 16);
		lblAnteckningar.setFont(new Font("Courier New", Font.BOLD, 13));
		contentPane.add(lblAnteckningar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(-44, -13, 351, 556);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(279, 230, 340, 540);
		 
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setForeground(Color.WHITE);
		lblId_1.setBounds(367, 121, 61, 16);
		contentPane.add(lblId_1); 
		contentPane.add(scrollPane);
		
		
		
		JButton btnNyHyresgst = new JButton("Ny Hyresgäst");
		btnNyHyresgst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LocalDateTime date = LocalDateTime.now();
				String _today = date.toString();
				String today = _today.substring(0, 10);
				textFMode(true);
				clearInput();
				textF_ID.setText("");
				textF_in_date.setText(today);
				textArea.setText("Fyll i formuläret och klicka på Spara");
				
				
			}
		});
		btnNyHyresgst.setForeground(Color.WHITE);
		btnNyHyresgst.setBounds(80, 116, 146, 29);
		btnNyHyresgst.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNyHyresgst.setForeground(Color.LIGHT_GRAY);
		contentPane.add(btnNyHyresgst);
		btnNyHyresgst.setOpaque(false);
		btnNyHyresgst.setContentAreaFilled(false);
		btnNyHyresgst.setBorderPainted(false);
		
		btnNyHyresgst.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnNyHyresgst.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNyHyresgst.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		btnHmtaHyresgstid = new JButton("Hämta");
		btnHmtaHyresgstid.setBounds(257, 116, 92, 29);
		btnHmtaHyresgstid.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		btnHmtaHyresgstid.setOpaque(true);
		btnHmtaHyresgstid.setContentAreaFilled(false);
		btnHmtaHyresgstid.setBorderPainted(false);
		btnHmtaHyresgstid.setForeground(Color.LIGHT_GRAY);
		
		btnHmtaHyresgstid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("I GUIKLASSEN");
				textFMode(true);
				textArea.setText("");
				int _id;
				
				String ID = textF_ID.getText();
				Tenant tempTenant;
				try {
					
					
					tempTenant = clientService.getTenant(ID);
					String ApNumber = Integer.toString(tempTenant.getApartmentNumber());
					TextF_ApNum.setText(ApNumber);
					TextF_FirstName.setText(tempTenant.getFirstName());
					TextF_LastName.setText(tempTenant.getLastName());
					textF_SSnum.setText(tempTenant.getSs_number());
					textF_mobNum.setText(tempTenant.getMobile());
					textF_email.setText(tempTenant.getEmail());
					textF_in_date.setText(tempTenant.get_from());
					textF_outDate.setText(tempTenant.get_until());
					textF_notes.setText(tempTenant.getNotes());
					
					_id = Integer.parseInt(ID);
					ArrayList<Tenant> result = (ArrayList<Tenant>) clientService.getAllTenants();
					System.out.println("Skrivs ut i GUI" + result);
					if (result.size()<1) {textArea.setText("Sökningen gav inga resultat");}
					
					else {
					for (Tenant ten : result) 
					{
						if (_id == ten.id) {textArea.append(ten + "\n" );
						
						
					}}
					
					textArea.setCaretPosition(0);
					
					
					}
					
					
					
					
					
					
				} catch (Exception e1) {
					if (ID !="") {textArea.setText("Det går inte att hitta en hyresgäst med ID " + ID);
					textFMode(false);}
					
					
					else textArea.setText("Ett ID måste anges för att hämta data");
					clearInput(); textFMode(false);
					
					
				}
				
				
				
				
				
				
				
				
			}
		}); 
		contentPane.add(btnHmtaHyresgstid);
		
		JButton btnUppdatera = new JButton("Spara");
		btnUppdatera.setBounds(522, 118, 117, 26);
		btnUppdatera.setForeground(Color.LIGHT_GRAY);
		btnUppdatera.setFont(new Font("Lucida Grande", Font.PLAIN, 13)); 
		
		btnUppdatera.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnUppdatera.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnUppdatera.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		
		
		btnHmtaHyresgstid.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnHmtaHyresgstid.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnHmtaHyresgstid.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		btnUppdatera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textF_ID.getText();
				String apartmentNumber = TextF_ApNum.getText();
				String firstName = TextF_FirstName.getText();
				String lastName = TextF_LastName.getText();
				String ss_number = textF_SSnum.getText();
				String mobile = textF_mobNum.getText();
				String email = textF_email.getText();
				String _until = textF_outDate.getText();
				String _from= textF_in_date.getText();
				String notes = textF_notes.getText();
				System.out.println("nu är id =: " + id);
				
				if (textF_ID.getText().length()<1){clientService.addTenant(apartmentNumber, firstName, lastName, ss_number, mobile, email, _from, _until, notes);
				clearInput(); textArea.setText("Ny Hyresgäst Sparad!");}
				else clientService.updateTenant(id, apartmentNumber, firstName, lastName, ss_number, mobile, email, _from, _until, notes);
				textFMode(false);
				
				
				
				 
				
			}
		});
		btnUppdatera.setOpaque(false);
		btnUppdatera.setContentAreaFilled(false);
		btnUppdatera.setBorderPainted(false);
		contentPane.add(btnUppdatera);
		
		btnTaBort = new JButton("Ta Bort");
		btnTaBort.setBounds(377, 118, 105, 26);
		btnTaBort.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnTaBort.setForeground(Color.LIGHT_GRAY);
		btnTaBort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textF_ID.getText();
				Tenant tempTenant;
				if (textF_ID.getText().length()<1) {textArea.setText("Du måste ange ID för hyresgästen du vill ta bort!");}
				else {
					try 
					{
					
					tempTenant = clientService.getTenant(id);
					
					if (tempTenant.getFirstName()==null);
					
					else {
						
						textArea.setText(clientService.deleteTenant(id));
						clearInput();
						textF_ID.setText("");}
				
					} 
					
					catch (Exception e1) {textArea.setText("Det finns ingen hyresgäst med ID " + id);}
					
					
				}
					
					
				
				
				
				
					
					
			}
		});
		btnTaBort.setOpaque(false);
		btnTaBort.setContentAreaFilled(false);
		btnTaBort.setBorderPainted(false);
		contentPane.add(btnTaBort);
		
		btnTaBort.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btnTaBort.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnTaBort.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		JButton btnSkrivUtHyresgster = new JButton("Skriv ut hyresgäster");
		btnSkrivUtHyresgster.setBounds(453, 792, 172, 29);
		btnSkrivUtHyresgster.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textArea.setText("");
				ArrayList<Tenant> result = (ArrayList<Tenant>) clientService.getAllTenants();
				System.out.println("Skrivs ut i GUI" + result);
				if (result.size()<1) {textArea.setText("Sökningen gav inga resultat");}
				
				else {
				for (Tenant ten : result) 
				{
					textArea.append(ten + "\n" + "\n" +"___________________________________________" + "\n"+ "\n");
					
				}
				
				textArea.setCaretPosition(0);
				
				
				}
			}});
		contentPane.add(btnSkrivUtHyresgster);
		
		btnRensa = new JButton("Rensa");
		btnRensa.setBounds(47, 740, 117, 29);
		btnRensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
				textF_ID.setText("");
			}
		});
		contentPane.add(btnRensa);
		
		JLabel BackgroundImage = new JLabel("New label");
		BackgroundImage.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		BackgroundImage.setBounds(-25, -1, 725, 853);
		BackgroundImage.setIcon(new ImageIcon("/Users/mixedbystefan/Desktop/BakgrundAPI_new6.jpg"));
		contentPane.add(BackgroundImage);
		
		
		
		
		
		
		
		
		
		
		}
	
	private static void clearInput() {
		TextF_ApNum.setText("");
		TextF_FirstName.setText("");
		TextF_LastName.setText("");
		textF_SSnum.setText("");
		textF_mobNum.setText("");
		textF_email.setText("");
		textF_in_date.setText("");
		textF_outDate.setText("");
		textF_notes.setText("");
		
	}
	
	private static void textFMode(boolean mode) {
		
		TextF_ApNum.setEnabled(mode);
		TextF_FirstName.setEnabled(mode);
		TextF_LastName.setEnabled(mode);
		textF_SSnum.setEnabled(mode);
		textF_mobNum.setEnabled(mode);
		textF_email.setEnabled(mode);
		textF_in_date.setEnabled(mode);
		textF_outDate.setEnabled(mode);
		textF_notes.setEnabled(mode);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
