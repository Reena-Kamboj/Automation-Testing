import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String upassword = "Reena@123";
        ResultSet resultSet = null;
        Connection con = null;
        String query = "select * from employee";
        String insertQuery = "insert into employee values('3','Anu','Harrow')";
        try {
            con = DriverManager.getConnection(url, uname, upassword);
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQuery);
            System.out.println("Numbers of row affected : " + count);
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }
    }
}
