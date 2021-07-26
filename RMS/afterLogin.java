package RMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afterLogin
{
    public afterLogin(String str)
    {
        beforeLogin a = new beforeLogin(1,str);
        a.logb.setVisible(false);
        a.b3.setBounds(250,120,170,30);
        a.mybook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new myBookings(str);
                a.f.dispose();
            }
        });
        a.b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new upcomingJourney(str);
                a.f.dispose();
            }
        });
        a.b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new planMyJourney(1,str);
                a.f.dispose();
            }
        });
    }

}
