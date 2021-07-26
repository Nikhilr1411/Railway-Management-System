package RMS;

import java.lang.String;
import java.sql.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

public class login_page {

    public String captche()
    {
        Random rand = new Random();
        String res = "",str[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
        int i;

        for(int j = 0; j <= 4; j++)
        {
            i = rand.nextInt(str.length);
            res += str[i];
        }
        return res;
    }

    JFrame f = new JFrame("RAILWAY MANAGEMENT SYSTEM");
    JTextField tf1,tf2;
    JButton b,b2,b3;
    JLabel l1,l2,l3,l4;
    JPasswordField value;
    String str = null, captcha = null;
    public login_page()
    {
        l1 = new JLabel("Email");
        l1.setBounds(100,50,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(220,60,180,20);
        f.add(tf1);

        l2 = new JLabel("Password");
        l2.setBounds(100,110,120,40);
        f.add(l2);
        value= new JPasswordField();
        value.setBounds(220,120,180,20);
        f.add(value);

        l4 = new JLabel("Enter the captcha");
        l4.setBounds(100,170,150,40);
        f.add(l4);
        captcha = captche();
        l3 = new JLabel(captcha);
        l3.setBounds(270,210,150,40);
        f.add(l3);
        tf2 = new JTextField();
        tf2.setBounds(220,180,180,20);
        f.add(tf2);

        b = new JButton("Login");
        b.setBounds(100,270,80,30);
        f.add(b);
        b2 = new JButton("Signup");
        b2.setBounds(200,270,80,30);
        f.add(b2);
        b3 = new JButton("Back");
        b3.setBounds(300,270,80,30);
        f.add(b3);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int flag = 0;
                String user = tf1.getText();
                String pass = String.valueOf(value.getPassword());
                String cap = tf2.getText();

                try {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
                    Statement stmt = con.createStatement();
                    String query = "SELECT email_id,password FROM USER;";
                    ResultSet rs = stmt.executeQuery(query);
                    String a=null;
                    String b=null;
                    while(rs.next())
                    {
                        a = rs.getString("email_id");
                        b = rs.getString("password");

                        if(!captcha.equals(cap))
                        {
                            flag = 2;
                            break;
                        }

                        if(a.equals(user)&&b.equals(pass))
                        {
                            flag = 1;
                            break;
                        }
                    }

                    if(flag == 2)
                    {
                        JOptionPane.showMessageDialog(null,"Captcha Miss Match !!!");
                    }
                    else if(flag == 0)
                    {
                        JOptionPane.showMessageDialog(null,"Invalid User Id or Password !!!");
                    }
                    else if(flag == 1)
                    {
                        new details(user);
                        f.dispose();
                    }

                }catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new beforeLogin(0,str);
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new registration();
                f.dispose();
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(550,350);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
