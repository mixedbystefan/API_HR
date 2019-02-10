package apartmentservice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.image.IntPixelGetter;
import com.sun.jmx.snmp.SnmpUnknownSubSystemException;

import jdk.internal.dynalink.beans.StaticClass;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

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
	private JLabel lblId;
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
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLggTillHyresgst = new JLabel("Lägg till Hyresgäst");
		lblLggTillHyresgst.setFont(new Font("Courier New", Font.BOLD, 16));
		lblLggTillHyresgst.setBounds(251, 46, 200, 16);
		contentPane.add(lblLggTillHyresgst);
		
		textF_ID = new JTextField();
		textF_ID.setBounds(47, 100, 37, 26);
		contentPane.add(textF_ID);
		textF_ID.setColumns(10);
		
		TextF_ApNum = new JTextField();
		TextF_ApNum.setBounds(47, 150, 130, 26);
		contentPane.add(TextF_ApNum);
		TextF_ApNum.setColumns(10);
		
		TextF_FirstName = new JTextField();
		TextF_FirstName.setBounds(47, 200, 130, 26);
		contentPane.add(TextF_FirstName);
		TextF_FirstName.setColumns(10);
		
		TextF_LastName = new JTextField();
		TextF_LastName.setBounds(47, 250, 130, 26);
		contentPane.add(TextF_LastName);
		TextF_LastName.setColumns(10);
		
		textF_SSnum = new JTextField();
		textF_SSnum.setBounds(47, 300, 130, 26);
		contentPane.add(textF_SSnum);
		textF_SSnum.setColumns(10);
		
		textF_mobNum = new JTextField();
		textF_mobNum.setBounds(47, 350, 130, 26);
		contentPane.add(textF_mobNum);
		textF_mobNum.setColumns(10);
		
		textF_email = new JTextField();
		textF_email.setBounds(47, 400, 130, 26);
		contentPane.add(textF_email);
		textF_email.setColumns(10);
		
		textF_in_date = new JTextField();
		textF_in_date.setBounds(47, 450, 130, 26);
		contentPane.add(textF_in_date);
		textF_in_date.setColumns(10);
		
		textF_outDate = new JTextField();
		textF_outDate.setBounds(47, 500, 130, 26);
		contentPane.add(textF_outDate);
		textF_outDate.setColumns(10);
		
		textF_notes = new JTextField();
		textF_notes.setBounds(47, 550, 130, 26);
		contentPane.add(textF_notes);
		textF_notes.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblId.setBounds(47, 82, 61, 16);
		contentPane.add(lblId);
		
		lblLgenhetsnummer = new JLabel("Lägenhetsnummer");
		lblLgenhetsnummer.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblLgenhetsnummer.setBounds(47, 132, 127, 16);
		contentPane.add(lblLgenhetsnummer);
		
		lblFrnamn = new JLabel("Förnamn");
		lblFrnamn.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblFrnamn.setBounds(47, 182, 64, 16);
		contentPane.add(lblFrnamn);
		
		lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblEfternamn.setBounds(47, 232, 74, 16);
		contentPane.add(lblEfternamn);
		
		lblNewLabel = new JLabel("Personnummer");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblNewLabel.setBounds(47, 282, 103, 16);
		contentPane.add(lblNewLabel);
		
		lblMobilnummer = new JLabel("Mobilnummer");
		lblMobilnummer.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblMobilnummer.setBounds(47, 332, 100, 16);
		contentPane.add(lblMobilnummer);
		
		lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(47, 382, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		lblInflyttnigsdatum = new JLabel("Inflyttnigsdatum");
		lblInflyttnigsdatum.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblInflyttnigsdatum.setBounds(47, 432, 130, 16);
		contentPane.add(lblInflyttnigsdatum);
		
		lblUtflyttningsdatum = new JLabel("Utflyttningsdatum");
		lblUtflyttningsdatum.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblUtflyttningsdatum.setBounds(47, 482, 153, 16);
		contentPane.add(lblUtflyttningsdatum);
		
		lblAnteckningar = new JLabel("Anteckningar");
		lblAnteckningar.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblAnteckningar.setBounds(47, 532, 100, 16);
		contentPane.add(lblAnteckningar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(230, 144, 348, 456);
		contentPane.add(textArea);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String id = textF_ID.getText();
				String apartmentNumber = TextF_ApNum.getText();
				String firstName = TextF_FirstName.getText();
				String lastName = TextF_LastName.getText();
				String ss_number = textF_SSnum.getText();
				String mobile = textF_mobNum.getText();
				String email = textF_email.getText();
				String _until = textF_outDate.getText();
				String _from= textF_in_date.getText();
				String notes = textF_notes.getText();
				
				clientService.addTenant(apartmentNumber, firstName, lastName, ss_number, mobile, email, _from, _until, notes); 
				
			    
				
			}
		});
		btnSpara.setBounds(47, 605, 117, 29);
		contentPane.add(btnSpara);
		
		btnHmtaHyresgstid = new JButton("Hämta Hyresgäst (ID)");
		btnHmtaHyresgstid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("I GUIKLASSEN");
				textArea.setText("");
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
				} catch (Exception e1) {
					textArea.setText("Det går inte att hitta en hyresgäst med ID " + ID);
					clearInput();
					
					
				}
				
				
				
				
				
				
				
				
			}
		});
		btnHmtaHyresgstid.setBounds(189, 100, 167, 29);
		contentPane.add(btnHmtaHyresgstid);
		
		JButton btnUppdatera = new JButton("Uppdatera");
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
				
				clientService.updateTenant(id, apartmentNumber, firstName, lastName, ss_number, mobile, email, _from, _until, notes);
				
			}
		});
		btnUppdatera.setBounds(358, 100, 117, 29);
		contentPane.add(btnUppdatera);
		
		btnTaBort = new JButton("Ta bort");
		btnTaBort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textF_ID.getText();
				
				
				textArea.setText(clientService.deleteTenant(id));
					
					
			}
		});
		btnTaBort.setBounds(477, 100, 117, 29);
		contentPane.add(btnTaBort);
		
		
		
		JButton btnSkrivUtHyresgster = new JButton("Skriv ut hyresgäster");
		btnSkrivUtHyresgster.setBounds(320, 605, 200, 29);
		contentPane.add(btnSkrivUtHyresgster);
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
}
