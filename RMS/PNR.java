package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PNR
{
    JFrame f = new JFrame("PNR ENQUIRY");
    JButton b,b2;
    JTextField tf;
    JLabel l,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    public PNR(int id,String str)
    {
        tf = new JTextField();
        tf.setBounds(230,120,200,30);
        f.add(tf);

        b = new JButton("SEARCH");
        b.setBounds(280, 180, 100, 30);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    String pnr = tf.getText();

                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
                    Statement stmt = con.createStatement();


                    String query = "SELECT * FROM TICKET WHERE TICKET.pnr = '"+ pnr +"';";

                    ResultSet rs = stmt.executeQuery(query);

                    if(!rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Pnr No !!!");
                    }
                    else
                    {
                        new PnrEnquiry(pnr,str);
                        f.dispose();
                    }
                }catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        l = new JLabel("Note");
        l.setBounds(50,320,100,30);
        f.add(l);
        l2 = new JLabel();
        l2.setText("1. No refund shall be on the confirmed ticket after four hours before the scheduled departure of the train.");
        l2.setBounds(50,360,600,30);
        f.add(l2);
        l3 = new JLabel();
        l3.setText("2. No refund shall be granted on the RAC or Waitlisted ticket after thirty minutes before the scheduled ");
        l3.setBounds(50,400,600,30);
        f.add(l3);
        l4 = new JLabel();
        l4.setText("   departure of the train.");
        l4.setBounds(50,420,600,30);
        f.add(l4);
        l5 = new JLabel();
        l5.setText("3. In case, on a party e-ticket or a family e-ticket issued for travel of more than one passenger, some");
        l5.setBounds(50,460,600,30);
        f.add(l5);
        l6 = new JLabel();
        l6.setText("   passengers have confirmed reservation and others are on RAC or waiting list, full refund of fare, less");
        l6.setBounds(50,480,600,30);
        f.add(l6);
        l7 = new JLabel();
        l7.setText("   clerkage, shall be admissible for confirmed passengers also subject to the condition that the ticket shall");
        l7.setBounds(50,500,600,30);
        f.add(l7);
        l8 = new JLabel();
        l8.setText("   admissible for confirmed passengers also subject to the condition that the ticket shall be cancelled online");
        l8.setBounds(50,520,600,30);
        f.add(l8);
        l9 = new JLabel();
        l9.setText("   or online TDR shall be filed for all the passengers upto thirty minutes before the scheduled departure of train");
        l9.setBounds(50,540,650,30);
        f.add(l9);
        l10 = new JLabel();
        l10.setText("4. Before cancellation, please refer New Refund Rule 2015 w.e.f 12-Nov-2015");
        l10.setBounds(50,580,600,30);
        f.add(l10);
        b2 = new JButton("Back");
        b2.setBounds(480,650,100,30);
        f.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(id == 0)
                {
                    new beforeLogin(0,str);
                    f.dispose();
                }
                else if(id == 1)
                {
                    new afterLogin(str);
                    f.dispose();
                }
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
