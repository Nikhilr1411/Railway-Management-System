package RMS;

import javax.swing.*;
import java.awt.event.*;

public class admin
{
    JFrame f = new JFrame("ADMIN");
    JButton b1;
    ImageIcon icon;
    JLabel img;
    public admin(String str)
    {
        b1= new JButton("User Details");
        b1.setBounds(60,150,120,30);
        f.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new userDetails(str);
                f.dispose();
            }
        });

        b1= new JButton("View Trains");
        b1.setBounds(200,150,120,30);
        f.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new trainDetails(str);
                f.dispose();
            }
        });

        b1= new JButton("Add Trains");
        b1.setBounds(340,150,120,30);
        f.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addTrains(str);
                f.dispose();
            }
        });

        b1= new JButton("Back");
        b1.setBounds(200,200,120,30);
        f.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                f.dispose();
            }
        });

        icon = new ImageIcon(getClass().getResource("user.png"));
        img = new JLabel(icon);
        img.setBounds(60,20,120,120);
        f.add(img);

        icon = new ImageIcon(getClass().getResource("view.png"));
        img = new JLabel(icon);
        img.setBounds(200,20,120,120);
        f.add(img);

        icon = new ImageIcon(getClass().getResource("add.png"));
        img = new JLabel(icon);
        img.setBounds(340,20,120,120);
        f.add(img);

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
