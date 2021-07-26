package RMS;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class registration
{
    public boolean phoneNumberValidation(String s)
    {
        int i,a,c=0;
        a = s.length();
        if(a==10&&(s.charAt(0)=='6'||s.charAt(0)=='7'||s.charAt(0)=='8'||s.charAt(0)=='9'))
        {
            for(i=0;i<a;i++)
            {
                if(Character.isDigit(s.charAt(i)))
                {
                    c++;
                }
            }
        }
        if(c==10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean emailVerification(String s)
    {
        String id = "",mid = "",last = "";
        int d=0;
        int m;
        int length;
        length = s.length();
        for(int i =0;i<length;i++)
        {

            if(s.charAt(i)=='@')
            {
                break;
            }
            else
            {
                d++;
                id = id+s.charAt(i);
            }
        }
        m=d;
        for(int i=d+1;i<length;i++)
        {
            if(s.charAt(i)=='.')
            {
                break;
            }
            else
            {
                m++;
                mid=mid+s.charAt(i);
            }
        }
        m++;
        for(int i = m+1;i<length;i++)
        {
            last = last+s.charAt(i);
        }
        int idl=0;

        if(((id.charAt(id.length()-1))!='-'||(id.charAt(id.length()-1))!='_'||(id.charAt(id.length()-1))!='.')&&
                ((id.charAt(0))!='-'||(id.charAt(0))!='_'||(id.charAt(0))!='.'));
        {
            for(int i=0;i<id.length();i++)
            {
                if(Character.isDigit(id.charAt(i))||id.charAt(i)=='.'||id.charAt(i)=='-'||id.charAt(i)=='_'||(id.toLowerCase().charAt(i)>='a'&&id.toLowerCase().charAt(i)<='z'))
                {
                    idl++;
                }
            }
        }
        if(idl==id.length()&&(mid.equals("gmail")||mid.equals("yahoo"))&&(last.equals("com")||last.equals("in")))
        {
            return true;
        }
        else
            return false;
    }
    JFrame f = new JFrame("NEW LOGIN");
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JButton b,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JPasswordField value1;
    JRadioButton rb1,rb2;
    public registration()
    {
        l1 = new JLabel("First Name");
        l1.setBounds(100,60,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,70,180,20);
        f.add(tf1);
        l7 = new JLabel("Last Name");
        l7.setBounds(100,110,150,40);
        f.add(l7);
        tf6 = new JTextField();
        tf6.setBounds(200,120,180,20);
        f.add(tf6);

        l2 = new JLabel("Age");
        l2.setBounds(100,160,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,170,180,20);
        f.add(tf2);
        l3 = new JLabel("Sex");
        l3.setBounds(100,210,150,40);
        f.add(l3);
        ButtonGroup bg = new ButtonGroup();
        rb1 = new JRadioButton("Male");
        rb1.setBounds(200,210,80,40);
        bg.add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(300,210,80,40);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        l3 = new JLabel("Adhaar Number");
        l3.setBounds(100,260,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,270,180,20);
        f.add(tf3);
        l6 = new JLabel("Phone");
        l6.setBounds(100,310,150,40);
        f.add(l6);
        tf4 = new JTextField("+91");
        tf4.setBounds(200,320,30,20);
        f.add(tf4);
        tf5 = new JTextField();
        tf5.setBounds(240,320,180,20);
        f.add(tf5);
        l4 = new JLabel("Password");
        l4.setBounds(100,360,150,40);
        f.add(l4);
        value1= new JPasswordField();
        value1.setBounds(200,370,180,20);
        f.add(value1);
        l5 = new JLabel("Email Id");
        l5.setBounds(100,410,150,40);
        f.add(l5);
        tf7 = new JTextField();
        tf7.setBounds(200,420,180,20);
        f.add(tf7);
        l8 = new JLabel("City");
        l8.setBounds(100,460,150,40);
        f.add(l8);
        tf8 = new JTextField();
        tf8.setBounds(200,470,180,20);
        f.add(tf8);
        l9 = new JLabel("State");
        l9.setBounds(100,510,150,40);
        f.add(l9);
        tf9 = new JTextField();
        tf9.setBounds(200,520,180,20);
        f.add(tf9);
        l10 = new JLabel("Pincode");
        l10.setBounds(100,560,150,40);
        f.add(l10);
        tf10 = new JTextField();
        tf10.setBounds(200,570,180,20);
        f.add(tf10);

        b = new JButton("Create");
        b.setBounds(100,670,80,30);
        f.add(b);
        b2 = new JButton("Back");
        b2.setBounds(300,670,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(tf1.getText().equals("") || tf2.getText().equals("") || tf5.getText().equals("") || tf3.getText().equals("") || String.valueOf(value1.getPassword()).equals("") ||
                        tf4.getText().equals("") || tf6.getText().equals("") || tf7.getText().equals("") || tf8.getText().equals("") || tf9.getText().equals("") || tf10.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter all details !!!");
                }
                else
                {
                    if(phoneNumberValidation(tf5.getText()))
                    {
                        if(emailVerification(tf7.getText()))
                        {
                            try
                            {
                                int userid = -1;
                                int flag = 0;
                                String line;
                                String driverName = "com.mysql.cj.jdbc.Driver";
                                Class.forName(driverName);

                                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
                                Statement stmt = con.createStatement();
                                String gender = null;

                                if(rb1.isSelected())
                                {
                                    gender = "M";
                                }
                                else if(rb2.isSelected())
                                {
                                    gender = "F";
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Select a valid Gender");
                                }

                                String firt = tf1.getText();
                                String last = tf6.getText();
                                String age = tf2.getText();
                                String email = tf7.getText();
                                String adhaar = tf3.getText();
                                String mobile = tf5.getText();
                                String city = tf8.getText();
                                String state = tf9.getText();
                                String pin = tf10.getText();
                                String password = String.valueOf(value1.getPassword());
                                String query = "INSERT INTO USER(firstname,lastname,gender,age,email_id,aadhar_no,mobine_number,city,state,pincode,password) VALUES('"+firt+"','"+last+"','"+gender+"','"+age+"','"+email+"','"+adhaar+"','"+mobile+"','"+city+"','"+state+"','"+pin+"','"+password+"');";
                                stmt.executeUpdate(query);
                                JOptionPane.showMessageDialog(null,"Successfully regsitered");
                                new beforeLogin(0,null);
                                f.dispose();
                            }
                            catch (SQLException e11)
                            {
                                e11.printStackTrace();
                            }
                            catch (Exception e2)
                            {
                                e2.printStackTrace();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Invalid Email id !!!");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Mobile Number !!!");
                    }
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login_page();
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(550,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
