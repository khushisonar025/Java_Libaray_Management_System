import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class splash extends JFrame{

    splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i2=i1.getImage().getScaledInstance(1000, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1000,500);
        add(img);




        JLabel headding = new JLabel("Library Management");
        headding.setBounds(40,155,400,40);
        headding.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(headding);

        JLabel headding2 = new JLabel("System");
        headding2.setBounds(40,200,400,40);
        headding2.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(headding2);

        JButton login = new JButton("Log in");
        login.setBackground(Color.lightGray);
        login.setForeground(Color.WHITE);
        login.setBounds(40,300,100,20);
        login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    new login();
                    setVisible(false);
                 }
            });



        img.add(login);

        JButton signin = new JButton("Sign In");
        signin.setBackground(Color.lightGray);
        signin.setForeground(Color.WHITE);
        signin.setBounds(200,300,100,20);
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new signin();
                setVisible(false);
             }
        });
        img.add(signin);


        
        





        setSize(1000,500);
        setTitle("lab Management System");
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args)  {
        new splash();
    }
}
