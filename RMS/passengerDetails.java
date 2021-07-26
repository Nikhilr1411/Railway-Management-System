package RMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class passengerDetails
{
    public String createPnr()
    {
        Random rand = new Random();
        String res = "", str[] = {"1","2","3","4","5","6","7","8","9","0"};
        int i;

        for(int j = 0; j <= 4; j++)
        {
            i = rand.nextInt(str.length);
            res += str[i];
        }
        return res;
    }
    public String createSeatNo()
    {
        Random rand = new Random();
        int i = rand.nextInt(100);
        String res = "S1-"+Integer.toString(i);
        return res;
    }
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
    JFrame f = new JFrame("DETAILS");
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b,b2;
    JLabel l1,l2,l3,l6;
    JRadioButton rb1,rb2;
    public passengerDetails(String str1,String str2,String email, String train,String date)
    {
        l1 = new JLabel("Name");
        l1.setBounds(100,90,150,40);
        f.add(l1);
        tf1 = new JTextField();
        tf1.setBounds(200,100,180,20);
        f.add(tf1);

        l2 = new JLabel("Age");
        l2.setBounds(100,180,150,40);
        f.add(l2);
        tf2 = new JTextField();
        tf2.setBounds(200,190,180,20);
        f.add(tf2);
        l3 = new JLabel("Sex");
        l3.setBounds(100,280,150,40);
        f.add(l3);
        ButtonGroup bg = new ButtonGroup();
        rb1 = new JRadioButton("Male");
        rb1.setBounds(200,280,80,40);
        bg.add(rb1);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(300,280,80,40);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        l3 = new JLabel("Adhaar Number");
        l3.setBounds(100,360,150,40);
        f.add(l3);
        tf3 = new JTextField();
        tf3.setBounds(200,370,180,20);
        f.add(tf3);
        l6 = new JLabel("Phone");
        l6.setBounds(100,430,150,40);
        f.add(l6);
        tf4 = new JTextField("+91");
        tf4.setBounds(200,440,30,20);
        f.add(tf4);
        tf5 = new JTextField();
        tf5.setBounds(240,440,180,20);
        f.add(tf5);
        b = new JButton("Create");
        b.setBounds(100,640,80,30);
        f.add(b);
        b2 = new JButton("Back");
        b2.setBounds(300,640,80,30);
        f.add(b2);
        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String driverName = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driverName);

                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","root");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM USER WHERE email_id = '"+email+"';";

                    ResultSet rs = stmt.executeQuery(query);
                    rs.next();
                    String b = rs.getString("userid");

                    String pnr = createPnr();

                    String ticket = "INSERT INTO TICKET(user_id,status,number_of_passengers,train_no,pnr) VALUES("+b+",'C','1',"+train+","+pnr+");";
                    stmt.executeUpdate(ticket);
                    String ticket_query = "SELECT MAX(ID) as 'id' FROM TICKET";
                    ResultSet r = stmt.executeQuery(ticket_query);
                    r.next();
                    String id = r.getString("id");
                    System.out.println(date);
                    String books = "INSERT INTO BOOKS VALUES("+b+","+id+",'"+str1+"','"+str2+"','"+date+"');";
                    stmt.executeUpdate(books);
                    String age = tf2.getText();
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
                        JOptionPane.showMessageDialog(null,"Select a valid gender");
                    }
                    String name = tf1.getText();
                    String seat = createSeatNo();
                    String pass_query = "INSERT INTO PASSENGER(pnr_no,age,gender,user_id,reservation_status,seat_no,name,ticket_id) VALUES("+pnr+","+age+",'"+gender+"','"+b+"','C','"+seat+"','"+name+"','"+id+"');";
                    stmt.executeUpdate(pass_query);
                    JOptionPane.showMessageDialog(null,"Successfully registered");
                    new afterLogin(email);
                    f.dispose();
                }
                catch (Exception a)
                {
                    a.printStackTrace();
                }

            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new book(str1,str2,email,date);
                f.dispose();
            }
        });
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700,800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


