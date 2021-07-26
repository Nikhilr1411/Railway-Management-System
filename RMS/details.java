package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class details
{
    JFrame f = new JFrame("WELCOME");
    JPanel tp,bp;
    JButton b1;
    public details(String user)
    {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM USER WHERE email_id = '"+user+"';";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String[] c = {"Attributes","Values"};
            String[][]r = {{"First Name",rs.getString("firstname")},{"Last Name",rs.getString("lastname")},{"Email",rs.getString("email_id")},{"Adhaar",rs.getString("aadhar_no")}};
            JTable jt = new JTable(r,c);
            jt.setVisible(true);
            JScrollPane sp = new JScrollPane(jt);
            tp = new JPanel();
            tp.setLayout(new BorderLayout());
            tp.add(sp,BorderLayout.CENTER);
            f.getContentPane().add(tp,BorderLayout.PAGE_START);
            b1 = new JButton("OK");
            bp = new JPanel();
            bp.add(b1);
            f.getContentPane().add(bp,BorderLayout.LINE_END);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new afterLogin(user);
                    f.dispose();
                }
            });

        }catch(Exception e1)
        {
            e1.printStackTrace();
        }
        f.setVisible(true);
        f.setSize(400,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
