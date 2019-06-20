package JM;

import java.awt.Font;
//import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class UserInterface extends JFrame{
	JTabbedPane tabbedPane;
	public void loginFrame() {
		JFrame frame=new JFrame();
		frame.setTitle("ÏµÍ³µÇÂ¼");
		frame.setSize(380,300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel L1=new JLabel("ÕËºÅ:");
		JTextField te1=new JTextField(25);
		JLabel L2=new JLabel("ÃÜÂë:");
		JPasswordField te2=new JPasswordField(25);
		te2.setEchoChar('*');
		L1.setFont(new Font("ºÚÌå",Font.PLAIN,18));
		L1.setSize(50,30);
		L1.setBounds(5+30,50,50,30);
		te1.setFont(new Font("ºÚÌå",Font.PLAIN,18));
		te1.setSize(250,30);
		te1.setBounds(5+80,50,250,30);
		L2.setFont(new Font("ºÚÌå",Font.PLAIN,18));
		L2.setSize(50,30);
		L2.setBounds(5+30,100,50,30);
		te2.setFont(new Font("ºÚÌå",Font.PLAIN,18));
		te2.setSize(250,30);
		te2.setBounds(5+80,100,250,30);
		frame.add(L1);
		frame.add(te1);
		frame.add(L2);
		frame.add(te2);
		JButton B1=new JButton("µÇÂ¼");
		JButton B2=new JButton("ÍË³ö");
		B1.setSize(100,50);
		B1.setBounds((380-100-5)/2-60,(300-50-30)/2+50,100,50);
		B2.setSize(100,50);
		B2.setBounds((380-100-5)/2+60,(300-50-30)/2+50,100,50);
		frame.add(B1);
		frame.add(B2);
		frame.setVisible(true);
	}
}
	

