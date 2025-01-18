import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcDemo {
    public static void main(String[] args)throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");

       String url="jdbc:mysql://localhost:3306/mydb";
       String uname= "root";
       String  upassword="Reena@123";
       Connection con= DriverManager.getConnection(url,uname,upassword);
       Statement st= con.createStatement();
       ResultSet resultSet= st.executeQuery("select * from employee");
       while (resultSet.next()){
           System.out.println("Employee id is:" +resultSet.getInt(1));
           System.out.println("Employee name is:"+resultSet.getString(2));
           System.out.println("Employee address is:"+resultSet.getString(3));
       }

    }
}
