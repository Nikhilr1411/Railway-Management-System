package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class myBookings
{
    JFrame f = new JFrame("My Bookings");
    JPanel tp,bp;
    JButton b1;
    public myBookings(String str)
    {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM USER,BOOKS,TICKET,PASSENGER WHERE user.userid = books.user_id and ticket.id = books.id and passenger.ticket_id = ticket.id and user.email_id = '"+str+"';";

            ResultSet rs = stmt.executeQuery(query);

            String[] c = {"Date","From","To","Passengers","Status","Seat Number"};
            int row = 0;
            while(rs.next())
            {
                row++;
            }
            rs = stmt.executeQuery(query);
            String [][] r = new String[row][6];
            int ro = 0;
            while(rs.next())
            {
                r[ro][0]=rs.getString("date");
                r[ro][1]=rs.getString("fro");
                r[ro][2]=rs.getString("dest");
                r[ro][3]=rs.getString("number_of_passengers");
                r[ro][4]=rs.getString("reservation_status");
                r[ro][5]=rs.getString("seat_no");
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
                    new afterLogin(str);
                    f.dispose();
                }
            });
            f.getContentPane().add(bp,BorderLayout.LINE_END);
            f.setVisible(true);
            f.setSize(500,500);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }catch(Exception e1)
        {
            e1.printStackTrace();
        }
    }
}
