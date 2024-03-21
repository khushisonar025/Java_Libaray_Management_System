import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class issuedbook extends JFrame implements ActionListener{
    JTextField bookid, userid,bookname,days;
    JDateChooser dateofissued,dateofreturn;
    JButton add,back;
    issuedbook(){
        getContentPane().setBackground(Color.GRAY);

        JLabel headding = new JLabel("Issued book");
        headding.setBounds(320,60,400,30);
        headding.setBackground(Color.LIGHT_GRAY);
        headding.setForeground(Color.WHITE);
        headding.setFont(new Font("Raleway",Font.BOLD,25));
        add(headding);

        JLabel book_Id=new JLabel(" Book Id");
        book_Id.setBounds(40,100,150,30);
        book_Id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(book_Id);

        bookid = new JTextField();
        bookid.setBounds(150,100,150,30);
        bookid.setBackground(new Color(177,252,197));
        add( bookid);

        JLabel user_id=new JLabel(" User Id");
        user_id.setBounds(350,100,150,30);
        user_id.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(user_id);

        userid = new JTextField();
        userid.setBounds(450,100,150,30);
        userid.setBackground(new Color(177,252,197));
        add(userid);


        JLabel issueddate=new JLabel("issued date");
        issueddate.setBounds(40,150,150,30);
        issueddate.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(issueddate);

        dateofissued= new JDateChooser();
        dateofissued.setBounds(150,150,150,30);
        dateofissued.setBackground(new Color(177,252,197));
        add(dateofissued);

        JLabel book_name=new JLabel("book name");
        book_name.setBounds(350,150,150,30);
        book_name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(book_name);

        bookname= new JTextField();
        bookname.setBounds(460,150,150,30);
        bookname.setBackground(new Color(177,252,197));
        add(bookname);

        JLabel ruturn_date=new JLabel("ruturn date");
        ruturn_date.setBounds(40,200,150,30);
        ruturn_date.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(ruturn_date);

        dateofreturn= new JDateChooser();
        dateofreturn.setBounds(150,200,150,30);
        dateofreturn.setBackground(new Color(177,252,197));
        add(dateofreturn);

        JLabel period=new JLabel("period");
        period.setBounds(350,200,150,30);
        period.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(period);

        days = new JTextField();
        days .setBounds(450,200,150,30);
        days .setBackground(new Color(177,252,197));
        add(days);

        add=new JButton("ADD");
        add.setBounds(150,350,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(350,350,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        



        setSize(900,500);
        setLayout(null);
        setVisible(true);
        setLocation(300, 50);


        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==add){
            String bid = bookid.getText();
            String uid = userid.getText();
            String doi = ((JTextField) dateofissued.getDateEditor().getUiComponent()).getText();
            String bname = bookname.getText();
            String rdate = ((JTextField) dateofreturn.getDateEditor().getUiComponent()).getText();
            String period = days.getText();
          

            try {
                conn c = new conn();
                String query = "insert into viewissuedbook values ('"+bid+"','"+uid+"','"+doi+"','"+bname+"','"+rdate+"','"+period+"');";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book issued successfuly");
                setVisible(false);
                new main_class();
                
                
            } catch (Exception E) {
                E.printStackTrace();
            }            

        }else{
            setVisible(false);
            new main_class();
        }

    }
    public static void main(String[] args) {
        new issuedbook();
    }

}
