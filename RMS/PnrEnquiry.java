package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PnrEnquiry
{
    JFrame f = new JFrame("Pnr Enquiry");
    JPanel tp,bp;
    JButton b1;
    public PnrEnquiry(String pnr,String str)
    {
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM USER,BOOKS,TICKET,PASSENGER WHERE user.userid = books.user_id and ticket.id = books.id and passenger.pnr_no = ticket.pnr and ticket.pnr = '"+pnr+"';";

            ResultSet rs = stmt.executeQuery(query);

            int row = 0,ro = 0;
            String[] c = {"PNR","Train No.","Date","From","To","Passenger Name","Gender","Age","Status","Seat Number"};

            while(rs.next())
            {
                row++;
            }
            String [][] r = new String[row][10];
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                r[ro][0]=rs.getString("pnr");
                r[ro][1]=rs.getString("train_no");
                r[ro][2]=rs.getString("date");
                r[ro][3]=rs.getString("fro");
                r[ro][4]=rs.getString("dest");
                r[ro][5]=rs.getString("name");
                r[ro][6]=rs.getString("gender");
                r[ro][7]=rs.getString("age");
                r[ro][8]=rs.getString("status");
                r[ro][9]=rs.getString("seat_no");
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
                    new PNR(1,str);
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
