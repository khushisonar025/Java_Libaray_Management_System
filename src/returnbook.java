import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class returnbook extends JFrame implements ActionListener {

    Choice choicebid;
    JTable table;
    JButton searchbtn, back, Return;
    returnbook(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel heading = new JLabel("search by Book Id ");
        heading.setBounds(20,20,250,20);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        choicebid = new Choice();
        choicebid.setBounds(20,60,150,20);
        add(choicebid);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from viewissuedbook");
            while (resultSet.next()){
                choicebid.add(resultSet.getString("bid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try {
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select*from viewissuedbook");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,500);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(200,60,80,20);
        searchbtn.setBackground(Color.BLACK);
        searchbtn.setForeground(Color.WHITE);
        searchbtn.addActionListener(this);
        add(searchbtn);

        back = new JButton("Back");
        back.setBounds(300,60,80,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        Return = new JButton("Return");
        Return.setBounds(400,60,80,20);
        Return.setBackground(Color.BLACK);
        Return.setForeground(Color.WHITE);
        Return.addActionListener(this);
        add(Return);

      









        setSize(900,500);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==searchbtn){
            String query ="select * from viewissuedbook where bid ='"+choicebid.getSelectedItem()+"'";
            try {
                conn c= new conn();
                ResultSet resultSet =  c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                
            } catch (Exception E) {
                E.printStackTrace();
            }

        }else if (e.getSource()==Return) {
            JOptionPane.showMessageDialog(null,"Book Return Successfully");
            setVisible(false);
            
        } else {
            setVisible(false);
            new main_class();
            
        }
        
        
        
        
    }


    public static void main(String[] args) {
        new returnbook();
    }

}
