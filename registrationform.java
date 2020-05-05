package registrationform;
  import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
  
public class registrationform implements ActionListener {
	static Connection con;
public 	JTextField jtf1,jtf2;
private Container c;
public JPasswordField jpf1;
	public void jf() {
		JFrame jframe=new JFrame("Registration form");
		  jframe.setBounds(300,90, 900, 600);
		jframe.setVisible(true);
	   //jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe.setBackground(Color.CYAN);
		JPanel jpanel=new JPanel();
		jpanel.setBackground(Color.CYAN);
//c=getContentPane();
		jpanel.setLayout(null);
		JLabel jl1=new JLabel("Name");
		jl1.setSize(100,20);
		  jl1.setLocation(100,100);
		 jtf1=new JTextField();
		  jtf1.setSize(190, 20); 
	        jtf1.setLocation(200, 100);
		JLabel jl2=new JLabel("password");
		jl2.setSize(100,20);
		jl2.setLocation(100,140);
		 jpf1=new JPasswordField(20);
		 jpf1.setSize(190,20);
		 jpf1.setLocation(200, 140);
		 JLabel jl3=new JLabel("E-mail");
		 jl3.setSize(100,20);
		 jl3.setLocation(100, 180);
		  jtf2=new JTextField();
		 jtf2.setSize(190, 20);
		 jtf2.setLocation(200, 180);
		 
		JButton jb1=new JButton("Register");
		jb1.setSize(150,30);
		jb1.setLocation(220,220);
		jpanel.add(jl1);
		jpanel.add(jtf1);
		
		jpanel.add(jl2);
		jpanel.add(jpf1);
		jpanel.add(jl3);
		jpanel.add(jtf2);
	
		jb1.addActionListener(this);
		jpanel.add(jb1);
		jframe.add(jpanel);
		
	}

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String uname="root";
		 String password="@Lenovo8";
		 String url="jdbc:mysql://localhost/final_try";
		
		 con=DriverManager.getConnection(url,uname,password);
	 
	     
	     
		
         registrationform rf=new registrationform();
         rf.jf();
	
	
         
	

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s1=jtf1.getText().toString();
		String s2=jtf2.getText().toString();
		String password=new String(jpf1.getPassword());
		
	//	char s2[]=jpf1.getPassword();
		if(s1.isEmpty() || s2.isEmpty()) {
			System.out.println("data is empty");
		
			JOptionPane.showMessageDialog(null, "name is empty");
		
		}
		
		//int m=1234;
		else {
	    String query="insert into k1648 values(default,?,?,?)";
	     try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, s1);
			pst.setString(2, password);
			pst.setString(3, s2);
		//	pst.setInt(2, m);
			pst.executeUpdate();
			
			System.out.println("data inserted");
			JFrame jframe2=new JFrame("welcome");
			JPanel jp1=new JPanel();
			jframe2.add(jp1);
			jframe2.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		}
	}

}