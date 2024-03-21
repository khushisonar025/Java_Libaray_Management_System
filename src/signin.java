import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class signin extends JFrame implements ActionListener{

    JTextField tusername , tpassword;
    JButton sigin,back;
    signin(){
        getContentPane().setBackground(Color.GRAY);
        JLabel headding = new JLabel("Create New User");
        headding.setBounds(350,40,400,20);
        headding.setFont(new Font("RalWay",Font.BOLD,20));
        add(headding);




        JLabel Username = new JLabel("Username");
        Username.setBounds(350,100,100,30);
        Username.setFont(new Font("RalWay",Font.BOLD,20));
        add(Username);

        tusername = new JTextField();
        tusername.setBounds(450,100,150,30);
        add(tusername);

        JLabel Password = new JLabel("Password");
        Password.setBounds(350,150,100,30);
        Password.setFont(new Font("RalWay",Font.BOLD,20));
        add(Password);

        
        tpassword = new JTextField();
        tpassword.setBounds(450,150,150,30);
        add(tpassword);

        sigin = new JButton("signin");
        sigin.setBounds(350,250,100,30);
        sigin.setBackground(Color.BLACK);
        sigin.setForeground(Color.WHITE);
        sigin.addActionListener(this);
        add(sigin);

        back = new JButton("back");
        back.setBounds(500,250,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,900,500);
        add(imgg);








        setSize(900,500);
        setLocation(250,100);
        setTitle("Create User");
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sigin){
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn c = new conn();
                String query = "insert into login values('"+username+"', '"+password+"');";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "sign in successfully");
                setVisible(false);
                new login();





            } catch (Exception E) {
                E.printStackTrace();
            }
          

        }else{
            setVisible(false);
            new main_class();
        }

    }






    public static void main(String[] args) {
        new signin();
    }

}
