package RMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    JFrame f = new JFrame("LOGIN PAGE");
    JButton b,b2;
    String str = null;
    public login()
    {
        b = new JButton("ADMIN");
        b.setBounds(150,120,80,30);
        f.add(b);
        b2 = new JButton("USER");
        b2.setBounds(250,120,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new admin(str);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new beforeLogin(0,str);
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
