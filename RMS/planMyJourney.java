package RMS;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class planMyJourney
{
    JFrame f = new JFrame("BOOK");
    JDateChooser dc;
    JButton b2,b3;
    JLabel l1,l2,l3,l4,l5;
    JComboBox cb1,cb2,cb3,cb4;
    String[] classes = {"All Classes", "AC First Class 1A", "AC 2 Tier", "AC 3 Tier", "AC Chair car(CC)", "AC 3 Economy", "Sleeper(SL)", "First Class(2S)", "Second Sitting(2S)"};
    String[] quotas = {"General","Ladies","Tatkal","Lower Berth/Sr.Citizen","Premium Tatkal","Divyaang"};
    public planMyJourney(int id, String str)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        dc = new JDateChooser();
        dc.setBounds(250,230,150,20);
        f.add(dc);
        l1 = new JLabel("FROM");
        l1.setBounds(100, 90, 150, 40);
        f.add(l1);
        String[] from = {"FROM","Coimbatore","Calicut"};
        cb1 = new JComboBox(from);

        cb1.setBounds(150, 100, 170, 20);

        f.add(cb1);

        l2 = new JLabel("TO");
        l2.setBounds(370, 90, 80, 40);
        f.add(l2);
        String[] to = {"TO","Coimbatore","Tuticorn"};
        cb2 = new JComboBox(to);
        cb2.setBounds(400, 100, 170, 20);
        f.add(cb2);
        l3 = new JLabel("CLASSES");
        l3.setBounds(100,350,150,40);
        f.add(l3);
        cb3 = new JComboBox(classes);
        cb3.setBounds(170, 360, 170, 20);
        f.add(cb3);
        l4 = new JLabel("QUOTA");
        l4.setBounds(370, 350, 80, 40);
        f.add(l4);
        cb4 = new JComboBox(quotas);
        cb4.setBounds(425, 360, 170, 20);
        f.add(cb4);
        l5 = new JLabel("SELECT THE DATE");
        l5.setBounds(100,225,150,30);
        f.add(l5);
        b3 = new JButton("Back");
        b3.setBounds(400,600,100,30);
        f.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id == 0)
                {
                    new beforeLogin(0,str);
                    f.dispose();
                }
                else if(id==1)
                {
                    new afterLogin(str);
                    f.dispose();
                }
            }
        });
        b2 = new JButton("Search");
        b2.setBounds(130,600,100,30);
        f.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id == 0)
                {
                    new login_page();
                    f.dispose();
                }
                else
                {
                    try
                    {
                        String s1 = cb1.getSelectedItem().toString();
                        String s2 = cb2.getSelectedItem().toString();
                        String s3 = cb3.getSelectedItem().toString();
                        String s = dc.getDate().toString();


                        String[] values = s.split(" ");

                        String month = null;
                        if(values[1].equals("Jan"))
                            month = "01";
                        else if(values[1].equals("Feb"))
                            month = "02";
                        else if(values[1].equals("Mar"))
                            month = "03";
                        else if(values[1].equals("Apr"))
                            month = "04";
                        else if(values[1].equals("May"))
                            month = "05";
                        else if(values[1].equals("Jun"))
                            month = "06";
                        else if(values[1].equals("Jul"))
                            month = "07";
                        else if(values[1].equals("Aug"))
                            month = "08";
                        else if(values[1].equals("Sep"))
                            month = "09";
                        else if(values[1].equals("Oct"))
                            month = "10";
                        else if(values[1].equals("Nov"))
                            month = "11";
                        else if(values[1].equals("Dec"))
                            month = "12";

                        Date d1 = new Date();
                        Date d2 = sdf.parse(values[2]+"-"+month+"-"+values[5]);
                        String date = values[2]+"-"+values[1]+"-"+values[5];

                        if(s1.equals(s2)||s1.equals("FROM")||s2.equals("TO"))
                        {
                            JOptionPane.showMessageDialog(null,"Select a valid From Place and Destination");
                        }
                        else if(d1.compareTo(d2)>0)
                        {
                            JOptionPane.showMessageDialog(null,"Select a valid Date");
                        }
                        else if(s3.equals("All Classes"))
                        {
                            JOptionPane.showMessageDialog(null,"Select a valid Class");
                        }
                        else
                        {
                            new book(s1,s2,str,date);
                            f.dispose();
                        }

                    }
                    catch (NullPointerException e2)
                    {
                        JOptionPane.showMessageDialog(null,"Select a valid Date");
                    }
                    catch (Exception e1)
                    {
                        e1.printStackTrace();
                    }


                }
            }
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setSize(700, 800);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}











