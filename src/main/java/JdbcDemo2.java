import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String upassword = "Reena@123";
        ResultSet resultSet = null;
        Connection con = null;
        String query = "select * from employee";
        try {
            con = DriverManager.getConnection(url, uname, upassword);
            Statement st = con.createStatement();
            boolean execute= st.execute(query);
           if(execute){
               ResultSet resultSet1= st.getResultSet();
               resultSet1.next();
               System.out.println(resultSet1.getString(3));
           }
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }
    }
}
