import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
   
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;
    login(){
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,600,300);
        add(imgg);





        JLabel Username = new JLabel("Username");
        Username.setBounds(40,20,100,30);
        imgg.add(Username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        imgg.add(tusername);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40,70,100,30);
        imgg.add(Password);

        
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        imgg.add(tpassword);


        login = new JButton("LOGIN");
        login.setBounds(150,140,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        imgg.add(login);

        back = new JButton("BACK");
        back.setBounds(300,140,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        imgg.add(back);
        
        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            try {
                 String username = tusername.getText();
                 String password = tpassword.getText();
    
                    conn conn = new conn();
                    String query = "select * from login where username = '"+ username +"' and password = '"+ password +"' ";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    if (resultSet.next()){
                        setVisible(false);
                        new main_class();
                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                
            } catch (Exception E) {
                E.printStackTrace();
            }

        }else{
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args) {
        new login();
    }

}
