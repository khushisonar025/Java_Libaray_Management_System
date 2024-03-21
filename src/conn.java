
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.xdevapi.Statement;

public class conn {

    Connection connection;
    java.sql.Statement statement;
    public conn(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab","root","1234");
            statement =  connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    }


