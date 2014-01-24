
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Enter_RersonalData extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter_RersonalData frame = new Enter_RersonalData();
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
	public Enter_RersonalData() {
		setTitle("Enter_RersonalData");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Εισάγεται όνομα χρήστη");
		label.setBounds(10, 51, 122, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(156, 48, 108, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel insertCode = new JLabel("Εισάγεται κωδικό χρήστη");
		insertCode.setBounds(10, 103, 122, 14);
		contentPane.add(insertCode);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 100, 108, 20);
		contentPane.add(passwordField);
		
		JButton save = new JButton("Αποθήκευση Δεδομένων");
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){   //eisagwgh stoixeiwn gia eggrafh xrhsth 
		
				String username = textField.getText();
				String password = String.valueOf(passwordField.getPassword());	
				
				try{
					
					
					if(textField.getText().equals("")||passwordField.getPassword().equals("") ){		//an yparxei keno pedio error
						JOptionPane.showMessageDialog(null,"Please fill fields","Error",1);
					}
				
					else{
						
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991"); //Syndesh me vash dedomenwn
						String sql1="Insert into login(username,password) values('"+(username)+"','"+(password)+"')";
						
										
						
						PreparedStatement st1 = con.prepareStatement(sql1);
						st1.execute();
					
						JOptionPane.showMessageDialog(null,"Username and Password added Succesfully! ","Success",JOptionPane.PLAIN_MESSAGE);
					
					
					}
		
		
		
				
					
		
				} catch (Exception e3) {
				}
		
		
				
				
		
		
		
		
			}});
		save.setBounds(128, 178, 171, 23);
		contentPane.add(save);
	}
}
