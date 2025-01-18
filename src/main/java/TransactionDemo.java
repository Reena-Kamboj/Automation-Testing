import java.sql.*;
import java.util.Scanner;

public class TransactionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydb";
        String uname = "root";
        String upassword = "Reena@123";
        Connection con = DriverManager.getConnection(url, uname, upassword);
        Statement st = con.createStatement();
        System.out.println("Data before transaction");
        ResultSet rs= st.executeQuery("Select * from account");
        while(rs.next()){
            System.out.println(rs.getString(1)+"__"+rs.getInt(2));
        }
        System.out.println("Transaction begins");
        con.setAutoCommit(false);
        st.executeUpdate("update account set amount=amount-2000 where name='A' ");
        st.executeUpdate("update account set amount=amount+2000 where name='B' ");
        System.out.println("can you please confirm this transaction of 2000 [yes|no]");
        Scanner s= new Scanner(System.in);
       String option= s.next();
       if(option.equalsIgnoreCase("yes")){
           con.commit();
           System.out.println("Transaction commited");
       }
       else {
           con.rollback();
           System.out.println("Transaction rollback");
       }
        System.out.println("Data After transaction");
        ResultSet rs1= st.executeQuery("Select * from account");
        while(rs1.next()){
            System.out.println(rs1.getString(1)+"__"+rs1.getInt(2));
        }


    }
}
