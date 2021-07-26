package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class trainDetails {
    JFrame f = new JFrame("Train Details");
    JPanel tp,bp;
    JButton b1;
    public trainDetails(String str)
    {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM train;";
            ResultSet rs = stmt.executeQuery(query);

            int row = 0,ro = 0;
            String[] c = {"Train No","Train Name","Availability","Destination","Start"};

            while(rs.next())
                row++;
            String [][] r = new String[row][5];

            rs = stmt.executeQuery(query);

            while(rs.next())
            {
                r[ro][0]=rs.getString("train_number");
                r[ro][1]=rs.getString("train_name");
                r[ro][2]=rs.getString("availability_of_seats");
                r[ro][3]=rs.getString("dest1");
                r[ro][4]=rs.getString("fro1");
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
