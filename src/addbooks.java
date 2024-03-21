import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class addbooks extends JFrame implements ActionListener {
    Random ran= new Random();
    int Number=ran.nextInt(999999);



    JTextField bookname,authorname,bookprice,username,userid,userphone,useraddress;
    JLabel bookid;
    JDateChooser dateofissued;
    JComboBox bookfiled;
    JButton add,back;
    addbooks(){
        getContentPane().setBackground(Color.CYAN);

        JLabel heading=new JLabel("Add Book Detalis");
        heading.setBounds(320,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel book_name=new JLabel(" Book Name");
        book_name.setBounds(50,150,150,30);
        book_name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(book_name);

        bookname = new JTextField();
        bookname.setBounds(200,150,150,30);
        bookname.setBackground(new Color(177,252,197));
        add(bookname);

        JLabel author_name=new JLabel("Author Name");
        author_name.setBounds(400,150,150,30);
        author_name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add( author_name);

        authorname = new JTextField();
        authorname.setBounds(600,150,150,30);
        authorname.setBackground(new Color(177,252,197));
        add(authorname);

        JLabel date_of_issued=new JLabel("Date Of Issued");
        date_of_issued.setBounds(50,200,150,30);
        date_of_issued.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(date_of_issued);

        dateofissued= new JDateChooser();
        dateofissued.setBounds(200,200,150,30);
        dateofissued.setBackground(new Color(177,252,197));
        add( dateofissued);

        JLabel labeleducation=new JLabel("Book Filed");
        labeleducation.setBounds(50,250,150,30);
        labeleducation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(labeleducation);

        String items[]={"Fiction","Novel","Narrative","Mystery","Non-Fiction","Historical","Thriller","Romance","Fantasy"};
        bookfiled= new JComboBox<>(items);
        bookfiled.setBounds(200,250,150,30);
        bookfiled.setBackground(new Color(177,252,197));
        add(bookfiled);


        JLabel book_id=new JLabel("Book Id");
        book_id.setBounds(400,200,150,30);
        book_id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(book_id);

        bookid=new JLabel("" +Number);
        bookid.setBounds(600,200,150,30);
        bookid.setBackground(new Color(177,252,197));
        bookid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        bookid.setForeground(Color.RED);
        add(bookid);


        JLabel price=new JLabel("Price of Book");
        price.setBounds(400,250,150,30);
        price.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(price);

        bookprice = new JTextField();
        bookprice.setBounds(600,250,150,30);
        bookprice.setBackground(new Color(177,252,197));
        add(bookprice);

       

        JLabel heading2=new JLabel("Add user Detalis");
        heading2.setBounds(320,300,500,50);
        heading2.setFont(new Font("serif",Font.BOLD,25));
        add(heading2);

        JLabel name=new JLabel("User Name");
        name.setBounds(50,350,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        username = new JTextField();
        username.setBounds(200,350,150,30);
        username.setBackground(new Color(177,252,197));
        add( username);

        JLabel id=new JLabel("User Id");
        id.setBounds(400,350,150,30);
        id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(id);

        userid = new JTextField();
        userid.setBounds(600,350,150,30);
        userid.setBackground(new Color(177,252,197));
        add(userid);

        JLabel phone=new JLabel("Phone");
        phone.setBounds(50,400,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        userphone = new JTextField();
        userphone.setBounds(200,400,150,30);
        userphone.setBackground(new Color(177,252,197));
        add(userphone);

        JLabel address=new JLabel("User Address");
        address.setBounds(400,400,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        useraddress = new JTextField();
        useraddress.setBounds(600,400,150,30);
        useraddress.setBackground(new Color(177,252,197));
        add(useraddress);



        


       

        add=new JButton("ADD");
        add.setBounds(200,550,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(400,550,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
             {
            String bname = bookname.getText();
            String aname= authorname.getText();
            String doi = ((JTextField) dateofissued.getDateEditor().getUiComponent()).getText();
            String bid= bookid.getText();
            String bfiled =(String) bookfiled.getSelectedItem();
            String price = bookprice.getText();
            String uname = username.getText();
            String uid = userid.getText();
            String uphone = userphone.getText();
            String uaddress = useraddress.getText();
            try {
                conn c = new conn();
                String query = "insert into addbook values('"+bname+"', '"+aname+"', '"+doi+"','"+bid+"','"+bfiled+"','"+price+"','"+uname+"','"+uid+"','"+uphone+"','"+uaddress+"');";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new main_class();
                
            } catch (Exception E) {
                E.printStackTrace();
            }
         } 
        }else{
            setVisible(false);
            new splash();
        }
    }

     public static void main(String[] args) {
        new addbooks();
     }
    
}