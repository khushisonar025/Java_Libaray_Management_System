import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main_class extends JFrame{
    main_class(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image i2=i1.getImage().getScaledInstance(1000, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1000,500);
        add(img);




        JLabel headding = new JLabel("Library Management");
        headding.setBounds(40,155,400,40);
        headding.setForeground(Color.WHITE);
        headding.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(headding);

        JLabel headding2 = new JLabel("System");
        headding2.setBounds(40,200,400,40);
        headding2.setForeground(Color.WHITE);
        headding2.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(headding2);

        JButton add = new JButton("Add Books");
        add.setBounds(550,150,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addbooks();
                setVisible(false);
            }
        }

        );
        img.add(add);

        JButton view = new JButton("view  Books");
        view.setBounds(600,200,150,40);
        view .setForeground(Color.WHITE);
        view .setBackground(Color.BLACK);
        view.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewbook();
                setVisible(false);
            }
        }

        );
        img.add(view);
        
       
        JButton issuedbooks = new JButton(" issued books");
        issuedbooks .setBounds(650,250,150,40);
        issuedbooks .setForeground(Color.white);
        issuedbooks .setBackground(Color.BLACK);
        issuedbooks.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new issuedbook();
                setVisible(false);
            }
        }

        );
        img.add(issuedbooks);


        JButton viewissuedbook = new JButton("view issued book");
        viewissuedbook .setBounds(700,300,150,40);
        viewissuedbook .setForeground(Color.white);
        viewissuedbook.setBackground(Color.BLACK);
        viewissuedbook.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewissuedbook();
                setVisible(false);
            }
        }

        );
        img.add(viewissuedbook);
        
        JButton returnbook = new JButton("Return book");
        returnbook .setBounds(750,350,150,40);
        returnbook .setForeground(Color.white);
        returnbook.setBackground(Color.BLACK);
        returnbook.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new returnbook();
                setVisible(false);
            }
        }

        );
        img.add(returnbook);
        
        
        
       





        setSize(1000,500);
        setTitle("Login Panel");
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new main_class();
    }

}
