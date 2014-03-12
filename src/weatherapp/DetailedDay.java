/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jason
 */
public class DetailedDay extends JFrame {

    private JLabel jDayOfTheWeek;
    RSSReader rssI = null;
    ForecastStack rss = null;
    private JLabel jWindDirectionToday;
    private JLabel jWindDirection2;
    private JLabel jWindDirection3;
    private JLabel jWindSpeed1;
    private JLabel jMaxTemp1;
    private JLabel jMinTemp1;
    private JLabel jVisibility1;
    private JLabel jPressure1;
    private JLabel jHumidity1;

    public DetailedDay(int day) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Detailed weather");
        this.setSize(320, 480);
        GridBagLayout myLayout = new GridBagLayout();
        JPanel mainFrame = new JPanel(myLayout);
        rssI = new RSSReader();
        if (day == 1) {
            rss = rssI.getFirstDay();
        } else if (day == 2) {
            rss = rssI.getNextDay();
        } else if (day == 3) {
            rss = rssI.getDayAfterTomorrow();
        }



        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        JLabel jDay = new JLabel("Day");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;

        mainFrame.add(jDay, c);

        JLabel jWindD = new JLabel("Wind\n Direction");
        c.gridy = 1;
        mainFrame.add(jWindD, c);

        JLabel jWindS = new JLabel("Wind Speed");
        c.gridy = 2;
        mainFrame.add(jWindS, c);

        JLabel jMaxT = new JLabel("Max Temp");
        c.gridy = 3;
        mainFrame.add(jMaxT, c);

        JLabel jMinT = new JLabel("Min Temp");
        c.gridy = 4;
        mainFrame.add(jMinT, c);

        JLabel jPress = new JLabel("Pressure");
        c.gridy = 5;
        mainFrame.add(jPress, c);

        JLabel jHumid = new JLabel("Humididty");
        c.gridy = 6;
        mainFrame.add(jHumid, c);

        JLabel jVis = new JLabel("Visibility");
        c.gridy = 7;
        mainFrame.add(jVis, c);


        jDayOfTheWeek = new JLabel("lelel");
        jDayOfTheWeek.setText(this.getNextDayOfTheWeek(day - 1).substring(0, 3));
        c.gridx = 1;
        c.gridy = 0;




        mainFrame.add(jDayOfTheWeek, c);



        jWindDirectionToday = new JLabel(rss.getWindDirection());

        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindDirectionToday, c);


        jWindSpeed1 = new JLabel(Integer.toString(rss.getWindSpeed()) + "mph");
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindSpeed1, c);


        jMaxTemp1 = new JLabel(Integer.toString(rss.getMaxTemp()) + "C");
        c.gridy = 3;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jMaxTemp1, c);

        jMinTemp1 = new JLabel(Integer.toString(rss.getMinTemp()) + "C");
        c.gridy = 4;
        mainFrame.add(jMinTemp1, c);

        jPressure1 = new JLabel(Integer.toString(rss.getPressure()));
        c.gridy = 5;
        mainFrame.add(jPressure1, c);

        jHumidity1 = new JLabel(Integer.toString(rss.getHumidity()) + "%");
        c.gridy = 6;
        mainFrame.add(jHumidity1, c);

        jVisibility1 = new JLabel(rss.getVisibility());
        c.gridy = 7;
        mainFrame.add(jVisibility1, c);


        this.add(mainFrame);

    }

    public static void main(String[] args) {
        DetailedDay myapp = new DetailedDay(2);
        myapp.setVisible(true);
    }

    public String getDayOfTheWeek() {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());

        Date currentDate = c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);



    }

    public String getNextDayOfTheWeek(int increment) {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        c.add(Calendar.DATE, increment);
        Date currentDate = c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);
    }
}
