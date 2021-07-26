package RMS;

import javax.swing.*;
import java.awt.event.*;


public class beforeLogin
{
    JFrame f = new JFrame("RMS CONNECT");
    JButton logb,b3,b4,mybook,b6;
    JLabel l,l2,l3,l4,img;
    ImageIcon icon;
    public beforeLogin(int id,String str)
    {
        logb = new JButton("LOGIN");
        logb.setBounds(100,120,80,30);
        f.add(logb);
        logb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login_page();
                f.dispose();
            }
        });
        b3 = new JButton("Upcoming Journey");
        b3.setBounds(400,120,170,30);
        f.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=1)
                {
                    new login_page();
                    f.dispose();
                }
            }
        });
        b4 = new JButton("Plan My Journey");
        b4.setBounds(50,350,170,30);
        f.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(id!=1)
                {
                    new login_page();
                    f.dispose();
                }
            }
        });
        mybook = new JButton("My Bookings");
        mybook.setBounds(270,350,150,30);
        f.add(mybook);
        mybook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id!=1)
                {
                    new login_page();
                    f.dispose();
                }

            }
        });

        b6 = new JButton("PNR Enquiry");
        b6.setBounds(470,350,150,30);
        f.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PNR(id,str);
                f.dispose();
            }
        });
        l = new JLabel("PREMIUM PARTNERS");
        l.setBounds(270,450,150,30);
        f.add(l);
        l2 = new JLabel("ConfirmTkt");
        l2.setBounds(50,640,150,30);
        f.add(l2);
        l3 = new JLabel("ixigo");
        l3.setBounds(320,640,100,30);
        f.add(l3);
        l4 = new JLabel("MakeMyTrip");
        l4.setBounds(530,640,170,30);
        f.add(l4);

        icon = new ImageIcon(getClass().getResource("plan.png"));
        img = new JLabel(icon);
        img.setBounds(60,200,120,120);
        f.add(img);
        icon = new ImageIcon(getClass().getResource("book.png"));
        img = new JLabel(icon);
        img.setBounds(280,200,120,120);
        f.add(img);
        icon = new ImageIcon(getClass().getResource("pnr.png"));
        img = new JLabel(icon);
        img.setBounds(490,200,120,120);
        f.add(img);
        icon = new ImageIcon(getClass().getResource("confirmTkt.png"));
        img = new JLabel(icon);
        img.setBounds(30,500,120,120);
        f.add(img);
        icon = new ImageIcon(getClass().getResource("ixigo.png"));
        img = new JLabel(icon);
        img.setBounds(270,500,120,120);
        f.add(img);
        icon = new ImageIcon(getClass().getResource("MakeMyTrip.png"));
        img = new JLabel(icon);
        img.setBounds(500,500,120,120);
        f.add(img);



        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
