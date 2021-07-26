import java.sql.*;

public class connect {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            System.out.println("Success");
        }catch(ClassNotFoundException e)
        {
            System.out.println("Could not find database server");
        }catch(SQLException e){
            System.out.println("Could not connect to database");
        }
        try
        {

            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from user");

            while(rs.next()){
                int no=rs.getInt(1);
                String name=rs.getString(4).toString();
                System.out.println(""+name+" "+no);
            }

            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

