
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JSpinner;

import java.sql.PreparedStatement;
import javax.swing.SpinnerNumberModel;


public class Selida_aksiologhshs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	private JTextField totalScore;
	private JTextField Aprice;
	private JTextField Aenergy;
	private JTextField Aservice;
	private JTextField Aolhelp;
	private JTextField Aaksiop;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selida_aksiologhshs frame = new Selida_aksiologhshs();
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

	public Selida_aksiologhshs() {
		setTitle("Selida_aksiologhshs");


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 47, 153, 20);
		
		final JSpinner TimhSpinner= new JSpinner();
		TimhSpinner.setBounds(57, 114, 29, 20);
		TimhSpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		final JSpinner EnergySpinner = new JSpinner();
		EnergySpinner.setBounds(237, 114, 29, 20);
		EnergySpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		final JSpinner ServiceSpinner = new JSpinner();
		ServiceSpinner.setBounds(57, 156, 29, 20);
		ServiceSpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		
		final JSpinner aksiopistiaSpinner = new JSpinner();
		aksiopistiaSpinner.setBounds(237, 194, 29, 20);
		aksiopistiaSpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		final JSpinner helpSpinner = new JSpinner();
		helpSpinner.setBounds(237, 156, 29, 20);
		helpSpinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 233, 106, 39);
		final JButton btnAddButton = new JButton("Add");
		btnAddButton.setBounds(126, 275, 89, 23);
		
		final JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(443, 275, 106, 52);
		
		//epilogh proiontwn pros aksiologhsh
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991"); //Syndesh me vash dedomenwn
			
			String sql="select *from products";
			PreparedStatement st = con.prepareStatement(sql);		
			ResultSet rs = st.executeQuery();

			while(rs.next())			//oso yparxoyn dedomena
			{	
				comboBox.addItem(rs.getString(1));	//prosthese ta sto comboBox
			}
		
		
		}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
		
	
		// mexri na epilegei proion h aksiologhsh einai anenergh
		
		editorPane.setEnabled(false);	 
		TimhSpinner.setEnabled(false);		
		ServiceSpinner.setEnabled(false);	
		EnergySpinner.setEnabled(false);	
		aksiopistiaSpinner.setEnabled(false);	 
		helpSpinner.setEnabled(false);	 
	
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(202, 46, 98, 23);
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//molis epilegei proion energopoiountai ta pedia aksiologhshs
				
				TimhSpinner.setEnabled(true);
				ServiceSpinner.setEnabled(true);	
				EnergySpinner.setEnabled(true);	
				editorPane.setEnabled(true);
				aksiopistiaSpinner.setEnabled(true);	 
				helpSpinner.setEnabled(true);	  	
				btnAddButton.setEnabled(true);
				
				
	// emfanish prohgoumenwn aksiologhsewn 		
	//syndesh me th vash kai emfanish apotelesmatwn sta antistoixa textfild			
				
		try{     
							
							
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
							
							
							PreparedStatement st = conn.prepareStatement("Select price from products where proionta='"+comboBox.getSelectedItem()+"'");	
							ResultSet rs = st.executeQuery();
							
							
							while(rs.next())			
							{	
								Aprice.setText(rs.getString(1));
								Aenergy.setText(rs.getString(1));
							}
							
			}catch(Exception e3){
				JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
				}
		
		
		try{     
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
			
			
			PreparedStatement st = conn.prepareStatement("Select energy from products where proionta='"+comboBox.getSelectedItem()+"'");		//tis ores apo tin tainia poy exei epilegei sto combobox
			ResultSet rs= st.executeQuery();
			
						while(rs.next())		
						{	
							Aenergy.setText(rs.getString(1));
							
						}
						
			}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
		try{     
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
			
			
			PreparedStatement st = conn.prepareStatement("Select service from products where proionta='"+comboBox.getSelectedItem()+"'");		//tis ores apo tin tainia poy exei epilegei sto combobox
			ResultSet rs = st.executeQuery();
			
			
						while(rs.next())			
						{	
							Aservice.setText(rs.getString(1));
							
						}
			
			}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
		
		try{     
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
			
			
			PreparedStatement st = conn.prepareStatement("Select aksiopistia from products where proionta='"+comboBox.getSelectedItem()+"'");		//tis ores apo tin tainia poy exei epilegei sto combobox
			ResultSet rs = st.executeQuery();
			
			
					while(rs.next())			//oso yparxoyn dedomena
					{	
						Aaksiop.setText(rs.getString(1));
						
					}
			
			}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
						
		try{     
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
			
			
			PreparedStatement st = conn.prepareStatement("Select help from products where proionta='"+comboBox.getSelectedItem()+"'");		//tis ores apo tin tainia poy exei epilegei sto combobox
			ResultSet rs = st.executeQuery();
			
			
					while(rs.next())			//oso yparxoyn dedomena
					{	
						Aolhelp.setText(rs.getString(1));
						
					}
			
			}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
						
		
		try{     
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
			
			
			PreparedStatement st = conn.prepareStatement("Select sxolia from products where proionta='"+comboBox.getSelectedItem()+"'");		//tis ores apo tin tainia poy exei epilegei sto combobox
			ResultSet rs = st.executeQuery();
			
			
						while(rs.next())			//oso yparxoyn dedomena
						{	
							editorPane_1.setText(rs.getString(1));
							
						}
			
						
						
						
			}catch(Exception e3){
			JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
		}
		
		
		
	
			}
			
			
			
			
		});
			
				
		JLabel timh1 = new JLabel("Τιμή");
		timh1.setBounds(20, 117, 46, 14);
		
		JLabel energy1 = new JLabel("Κατανάλωση Ενέργειας");
		energy1.setBounds(129, 116, 88, 17);
		
		JLabel service1 = new JLabel("Service");
		service1.setBounds(20, 159, 46, 14);
		
			
		JLabel label = new JLabel("ΣΧΟΛΙΑ");
		label.setBounds(10, 197, 46, 14);
		
		JLabel check = new JLabel("Επιλέξτε προϊόν προς αξιολόγηση");
		check.setBounds(20, 11, 167, 14);
		///////////////////////////////////////////
		btnAddButton.setEnabled(false);
		
		
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {     //gia prosthiki vathmologiwn sth vash kai ypologismos telikis vathmologias
				
			
				
				
				
				int price = (Integer) TimhSpinner.getValue();
				int energy= (Integer) EnergySpinner.getValue();
				int service=(Integer) ServiceSpinner.getValue();	
				int aksiopistia=(Integer)aksiopistiaSpinner.getValue();
				int help=(Integer)helpSpinner.getValue();
				String sxolia=editorPane.getText();
				
				
				try{
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn		
				
	//perasma parametrwn (vathmologiwn sth vash)
				String sql="update products set price='"+price+"'where proionta='"+comboBox.getSelectedItem()+"'";
				String sql1="update products set energy='"+energy+"'where proionta='"+comboBox.getSelectedItem()+"'";
				String sql2="update products set service='"+service+"'where proionta='"+comboBox.getSelectedItem()+"'";
				String sql3="update products set aksiopistia='"+aksiopistia+"'where proionta='"+comboBox.getSelectedItem()+"'";
				String sql4="update products set help='"+help+"'where proionta='"+comboBox.getSelectedItem()+"'";
				String sql6="update products set sxolia='"+sxolia+"'where proionta='"+comboBox.getSelectedItem()+"'";
				
				
		//ypologismos mesou oroy ths dothisas vathmologias		
				int synVath=((price+energy+service+aksiopistia+help)/5);
				String sql5="update products set vathmologia='"+ synVath+"'where proionta='"+comboBox.getSelectedItem()+"'";
				
				

				
					PreparedStatement st = con.prepareStatement(sql);
					st.execute();
				
					PreparedStatement st1 = con.prepareStatement(sql1);
					st1.execute();
					
					PreparedStatement st2 = con.prepareStatement(sql2);
					st2.execute();
					
					PreparedStatement st3 = con.prepareStatement(sql3);
					st3.execute();
					
					PreparedStatement st4 = con.prepareStatement(sql4);
					st4.execute();
					
					PreparedStatement st6 = con.prepareStatement(sql6);
					st6.execute();
					
					PreparedStatement st5 = con.prepareStatement(sql5);
					st5.execute();
					
					

					totalScore.setText(Integer.toString(synVath));	//emfanisi telikis vathmologias
					
				}catch(Exception e3){
						JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
					}
					
				
			
			
				
			}

			
			
		});
		
		
		
		
		totalScore = new JTextField();
		totalScore.setBounds(232, 225, 21, 20);
		totalScore.setColumns(10);
		
		JLabel result = new JLabel("Τελικη Βαθμολογια");
		result.setBounds(126, 233, 103, 14);
		
		JLabel reliability = new JLabel("Αξιοπιστια");
		reliability.setBounds(129, 197, 75, 14);
		
		
		
		JLabel lblOnline = new JLabel("On-line Βοήθεια");
		lblOnline.setBounds(129, 159, 75, 14);
		
		JLabel label_1 = new JLabel("Προηγουμενη αξιολογηση");
		label_1.setBounds(396, 50, 153, 14);
		
		Aprice = new JTextField();
		Aprice.setBounds(509, 93, 21, 20);
		Aprice.setColumns(10);
		
		Aenergy = new JTextField();
		Aenergy.setBounds(509, 133, 21, 20);
		Aenergy.setColumns(10);
		
		Aservice = new JTextField();
		Aservice.setBounds(509, 164, 21, 20);
		Aservice.setColumns(10);
		
		Aolhelp = new JTextField();
		Aolhelp.setBounds(509, 194, 21, 20);
		Aolhelp.setColumns(10);
		
		Aaksiop = new JTextField();
		Aaksiop.setBounds(504, 230, 21, 20);
		Aaksiop.setColumns(10);
		
		
		
		JLabel lblT = new JLabel("Tιμή");
		lblT.setBounds(433, 96, 46, 14);
		
		JLabel label_2 = new JLabel("καταναλωση ενεργειας");
		label_2.setBounds(396, 136, 111, 14);
		
		JLabel lblService = new JLabel("Service");
		lblService.setBounds(433, 170, 46, 14);
		
		JLabel lblOnline_1 = new JLabel("On-line help");
		lblOnline_1.setBounds(406, 197, 98, 14);
		
		JLabel label_3 = new JLabel("αξιοπιστια");
		label_3.setBounds(416, 233, 78, 14);
		
		JLabel label_4 = new JLabel("σχολια");
		label_4.setBounds(396, 275, 46, 14);
		contentPane.setLayout(null);
		contentPane.add(comboBox);
		contentPane.add(TimhSpinner);
		contentPane.add(EnergySpinner);
		contentPane.add(ServiceSpinner);
		contentPane.add(aksiopistiaSpinner);
		contentPane.add(helpSpinner);
		contentPane.add(editorPane);
		contentPane.add(editorPane_1);
		contentPane.add(btnOk);
		contentPane.add(timh1);
		contentPane.add(energy1);
		contentPane.add(service1);
		contentPane.add(label);
		contentPane.add(check);
		contentPane.add(btnAddButton);
		contentPane.add(totalScore);
		contentPane.add(result);
		contentPane.add(reliability);
		contentPane.add(lblOnline);
		contentPane.add(label_1);
		contentPane.add(Aprice);
		contentPane.add(Aenergy);
		contentPane.add(Aservice);
		contentPane.add(Aolhelp);
		contentPane.add(Aaksiop);
		contentPane.add(lblT);
		contentPane.add(label_2);
		contentPane.add(lblService);
		contentPane.add(lblOnline_1);
		contentPane.add(label_3);
		contentPane.add(label_4);
		
		JButton button = new JButton("ΑΠΟΣΥΝΔΕΣΗ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.exit(0);
				
				
				
			}
		});
		button.setBounds(232, 315, 115, 23);
		contentPane.add(button);
		
		



	}
}

