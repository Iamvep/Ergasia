
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Admin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Admin Form");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 309);
		getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(24, 42, 127, 20);
		getContentPane().add(comboBox);
		
		//fortwnei sto comboBox to perioxomeno ths bashs
		
		try{
			
			
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
		
		
		
		
		
		

		
		JButton btnNewButton = new JButton("Add product");
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				String proion = textField.getText();
				
			try{
				
				
				if(textField.getText().equals("") ){		//an yparxei keno pedio error
					JOptionPane.showMessageDialog(null,"Please fill fields","Error",1);
				}
				
				else{   // prosthiki proiontwn sth vash apo ton admin
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn
					
					
					String sql="Insert into products(proionta) values('"+(proion)+"')";
					PreparedStatement st = con.prepareStatement(sql);
					st.execute();
				
					JOptionPane.showMessageDialog(null,"Products added Succesfully! ","Success",JOptionPane.PLAIN_MESSAGE);
					textField.setText(null);
				
				
				}				
				
			}catch(Exception e3){
				JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
				}
			
			
		
			
				
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aksiologisi","root","25021991");  //Syndesh me vash dedomenwn
				PreparedStatement st = con.prepareStatement("select proionta from products where proionta='"+(proion)+"'");		
				ResultSet rs = st.executeQuery();

				while(rs.next())			//oso yparxoyn dedomena
				{	
					comboBox.addItem(rs.getString(1));	//prosthese ta sto comboBox
				}
			
			
			
			
			
			
			}catch(Exception e3){
				JOptionPane.showMessageDialog(null,"Connection Error","Error",1);
			}
				
					
				
				
				
			}
		});
		btnNewButton.setBounds(282, 127, 89, 23);
		getContentPane().add(btnNewButton);
		
	
		
		textField = new JTextField();
		textField.setBounds(242, 73, 150, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Εισαγετε προϊον για αξιολόγηση");
		label.setBounds(246, 45, 162, 14);
		getContentPane().add(label);
		
	}
}
