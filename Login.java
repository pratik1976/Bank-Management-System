package bank.management.system1;
import javax.swing.*;  //there is no image class in swing
import java.awt.*;     //to get image class we import awt
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login,signup, clear;  // button defined globally
    JTextField cardTextField;
    JPasswordField pinTextField;
    

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null); //it will use our custom layout and not swing default layout
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  //class to set image. getSystemResource is static method
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  //created object of class imageicon and pass i2 in constructor. thus image i2 is converted to imageicon
        JLabel label = new JLabel(i3); //to set icon on the frame
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM"); //to set welcome to atm
        text.setFont(new Font("Osward",Font.BOLD,38));       
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno = new JLabel("Card No.:"); 
        cardno.setFont(new Font("Raleway",Font.BOLD,28));       
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField(); //JTextField is a class. It is removed because declared globally
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        
        JLabel pin = new JLabel("PIN:"); 
        pin.setFont(new Font("Raleway",Font.BOLD,28));       
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField = new JPasswordField(); //JTextField is a class. Removed because declared globally
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);   //this will tell that button has been clicked
        add(login);
        
        clear = new JButton("CLEAR"); // JButton clear = new JButton("CLEAR"); JButton removed because it is already defined globally
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);  //to set white color
        
        setSize(800,480); //size of frame length 800 and breadth 480
        setVisible(true);  //to make it visible set it true. by default it is false
        setLocation(350,200); //Location in main window
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            cons conn = new cons();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();  //mark on getText because pinnumer is not textfield. It is password field. And getText function cannot be used in password field
            String query = "select * from login where cardnumber = '"+ cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                
            }
        }else if (ae.getSource() == signup){
            setVisible(false); //to open signup form after clicking on signup
            new SignupOne().setVisible(true);
            
        }
        
    }
    public static void main(String args[]) {
        new Login(); //object of class
        
        
        
    }
}
