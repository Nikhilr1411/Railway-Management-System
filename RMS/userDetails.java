package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class userDetails{
    JFrame f = new JFrame("User Details");
    JPanel tp,bp;
    JButton b1;
    public userDetails(String str)
    {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM USER;";
            ResultSet rs = stmt.executeQuery(query);

            int row = 0,ro = 0;
            String[] c = {"User Id","Name","Gender","Age","Email","Aadhar No","Mobile No","City"};

            while(rs.next())
                row++;
            String [][] r = new String[row][11];

            rs = stmt.executeQuery(query);

            while(rs.next())
            {
                r[ro][0]=rs.getString("userid");
                r[ro][1]=rs.getString("firstname")+" "+rs.getString("lastname");
                r[ro][2]=rs.getString("gender");
                r[ro][3]=rs.getString("age");
                r[ro][4]=rs.getString("email_id");
                r[ro][5]=rs.getString("aadhar_no");
                r[ro][6]=rs.getString("mobine_number");
                r[ro][7]=rs.getString("city");
                ro++;
            }

            JTable jt = new JTable(r,c);
            jt.setVisible(true);
            JScrollPane sp = new JScrollPane(jt);
            tp = new JPanel();
            tp.setLayout(new BorderLayout());
            tp.add(sp,BorderLayout.CENTER);
            f.getContentPane().add(tp,BorderLayout.PAGE_START);
            b1 = new JButton("Back");
            bp = new JPanel();
            bp.add(b1);
            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    new admin(str);
                    f.dispose();
                }
            });
            f.getContentPane().add(bp,BorderLayout.LINE_END);

        }catch(Exception e1)
        {
            e1.printStackTrace();
        }
        f.setVisible(true);
        f.setSize(850,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
