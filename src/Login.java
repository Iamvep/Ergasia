import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;






public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passField;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(137, 35, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				String user = textField.getText();
				String strpass = String.valueOf(passField.getPassword());				
				
				try {						//eyresi user

					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991"); //Syndesh me vash dedomenwn
					PreparedStatement st = con.prepareStatement("select Password from login Where Username='"+user+"'");
					ResultSet rs = st.executeQuery();

					if(rs.next()) // gia na mpeis me stoixeia admin dineis username:admin kai password:1111
					
					{
						
						String dbpass = rs.getString(1);
						if(dbpass.equals(strpass)){					//elegxos password
							JOptionPane.showMessageDialog(null,"Login Successful! ","Success",JOptionPane.PLAIN_MESSAGE);
						
						if(user.equals("admin")){				//an admin tote adminform
								
								Admin form = new Admin();
								form.setVisible(true);
							}
							else{									// alliws phgaine sth selIda aksiologhshs
								Selida_aksiologhshs aksiologhsh = new Selida_aksiologhshs();
								aksiologhsh.setVisible(true);
								
								
														
								
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Login Unsuccessful!","Error",1);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Username not found","Error",1);
					}
					
				} catch (SQLException ex) {
					
				}

			}
		});
		btnNewButton.setBounds(270, 51, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(33, 38, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel pass = new JLabel("Password:");
		pass.setBounds(33, 78, 86, 14);
		contentPane.add(pass);
		
		passField = new JPasswordField();
		passField.setBounds(137, 66, 86, 20);
		contentPane.add(passField);
		
		JButton button = new JButton("Δημιουργία Λογαριασμού");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				Enter_RersonalData form1 = new Enter_RersonalData();
				form1.setVisible(true);
				
			
			
			}});
		
		
		
		button.setBounds(75, 137, 184, 23);
		contentPane.add(button);
			}
			
		}


