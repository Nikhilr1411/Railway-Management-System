package RMS;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class addTrains {
    JFrame f = new JFrame("Add Train");
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5;
    JTextField tf1,tf2,tf3,tf4;
    JComboBox cb1;

    String[] availabe = {"Select","NA","A"};


    public addTrains(String str)
    {
        l1 = new JLabel("Train No");
        l1.setBounds(100,10,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(230,20,180,20);
        f.add(tf1);

        l2 = new JLabel("Train Name");
        l2.setBounds(100,60,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(230,70,180,20);
        f.add(tf2);

        l3 = new JLabel("Availability");
        l3.setBounds(100,110,150,40);
        f.add(l3);
        cb1 = new JComboBox(availabe);
        cb1.setBounds(230,120,180,20);
        f.add(cb1);

        l4 = new JLabel("From");
        l4.setBounds(100,165,150,30);
        f.add(l4);
        tf3 = new JTextField();
        tf3.setBounds(230,170,180,20);
        f.add(tf3);

        l5 = new JLabel("To");
        l5.setBounds(100,210,150,40);
        f.add(l5);
        tf4 = new JTextField();
        tf4.setBounds(230,220,180,20);
        f.add(tf4);


        b1 = new JButton("Add Train");
        b1.setBounds(100,280,100,30);
        f.add(b1);
        b2 = new JButton("Back");
        b2.setBounds(300,280,100,30);
        f.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s1 = tf1.getText();
                String s2 = tf2.getText();
                String s3 = cb1.getSelectedItem().toString();
                String s4 = tf3.getText();
                String s5 = tf4.getText();

                if(s4.equals(s5)||s4.equals("")||s5.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Select a valid From Place or Destination");
                }
                else if(s3.equals("Select"))
                {
                    JOptionPane.showMessageDialog(null,"Select a valid Availability field");
                }
                else if(s1.equals("") || s2.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter a valid Train name or Train No !!!");
                }
                else
                {
                    try {
                        String driverName = "com.mysql.cj.jdbc.Driver";
                        Class.forName(driverName);

                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
                        Statement stmt = con.createStatement();

                        String query = "INSERT INTO TRAIN VALUES("+ s1 +", '"+ s2 +"', '"+ s3 +"', '"+ s4 +"', '"+ s5 +"');";
                        stmt.executeUpdate(query);

                        JOptionPane.showMessageDialog(null,"Train Successfully Added !!!");
                        new admin(str);
                        f.dispose();
                    }
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new admin(str);
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
