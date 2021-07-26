package RMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class book
{
    public book(String str1,String str2,String str,String date)
    {
        JFrame f = new JFrame("BOOK");
        JPanel tp,bp,cp;
        JLabel label;
        JTextField tf;
        JButton b1,b3;

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM TRAIN WHERE train.fro1 = '"+str1+"' and train.dest1 = '"+str2+"';";
            ResultSet rs = stmt.executeQuery(query);
            int row =0;
            while (rs.next())
            {
                if(rs.getString("availability_of_seats").equals("A"))
                {
                    row++;
                }
            }

            String[][]r = new String[row][2];
            String[] c = {"Train No","Train name"};
            rs = stmt.executeQuery(query);
            int r1 = 0;
            while (rs.next())
            {
                if(rs.getString("availability_of_seats").equals("A"))
                {
                    r[r1][0] = rs.getString("train_number");
                    r[r1][1] = rs.getString("train_name");
                    r1++;
                }

            }

            JTable jt = new JTable(r,c);
            jt.setVisible(true);
            JScrollPane sp = new JScrollPane(jt);
            tp = new JPanel();
            tp.setLayout(new BorderLayout());
            tp.add(sp,BorderLayout.CENTER);
            f.getContentPane().add(tp,BorderLayout.PAGE_START);

            label = new JLabel("Enter the number of the train to be booked");
            tf = new JTextField(10);
            cp = new JPanel();
            cp.add(label);
            cp.add(tf);
            f.getContentPane().add(cp,BorderLayout.CENTER);
            bp = new JPanel();
            b1 = new JButton("OK");
            bp.add(b1);
            b3 = new JButton("Back");
            bp.add(b3);

            f.getContentPane().add(bp,BorderLayout.SOUTH);

            int finalRow = row;
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int flag = 0;
                    for(int i = 0; i< finalRow; i++)
                    {
                        if (r[i][0].equals(tf.getText()))
                        {
                            flag = 1;
                            break;
                        }
                    }
                    if(tf.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Enter the train number");
                    }
                    else if(flag!=1)
                    {
                        JOptionPane.showMessageDialog(null,"Enter the valid train number from the table");
                    }
                    else
                    {
                        new passengerDetails(str1, str2, str, tf.getText(),date);
                        f.dispose();
                    }

                }
            });
            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    new planMyJourney(1,str);
                }
            });

        }catch(Exception e1)
        {
            e1.printStackTrace();
        }
        f.setVisible(true);
        f.setSize(400,550);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
