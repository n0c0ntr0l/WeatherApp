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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author Jason
 */
public class WeatherApp extends JFrame {

    private JLabel jDayOfTheWeek;
    RSSReader rss = null;
    private JLabel jWindDirectionToday;
    private JLabel jWindDirection2;
    private JLabel jWindDirection3;
    private JLabel jWindSpeed1;
    private JLabel jMaxTemp1;
    private JLabel jMinTemp1;
    private JLabel jVisibility1;
    private JLabel jPressure1;
    private JLabel jHumidity1;
    private JLabel jWindSpeed2;
    private JLabel jMaxTemp2;
    private JLabel jMinTemp2;
    private JLabel jVisibility2;
    private JLabel jPressure2;
    private JLabel jHumidity2;
    private JLabel jWindSpeed3;
    private JLabel jMaxTemp3;
    private JLabel jMinTemp3;
    private JLabel jVisibility3;
    private JLabel jPressure3;
    private JLabel jHumidity3;

    public WeatherApp() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Detailed weather");
        this.setSize(320, 480);
        GridBagLayout myLayout = new GridBagLayout();
        JPanel mainFrame = new JPanel(myLayout);
        rss = new RSSReader();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        JLabel jDay = new JLabel("Day");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        
        mainFrame.add(jDay,c);
        
        JLabel jWindD = new JLabel("Wind\n Direction"); 
        c.gridx = 1;
        mainFrame.add(jWindD, c);
        
        JLabel jWindS = new JLabel("Wind Speed");
        c.gridx = 2;
        mainFrame.add(jWindS, c);
        
        JLabel jMaxT = new JLabel("Max Temp");
        c.gridx = 3;
        mainFrame.add(jMaxT,c);
        
        JLabel jMinT = new JLabel("Min Temp");
        c.gridx = 4;
        mainFrame.add(jMinT, c);

        JLabel jPress = new JLabel("Pressure");
        c.gridx = 5;
        mainFrame.add(jPress, c);
        
        JLabel jHumid = new JLabel("Humididty");
        c.gridx = 6;
        mainFrame.add(jHumid, c);
        
        JLabel jVis = new JLabel("Visibility");
        c.gridx = 7;
        mainFrame.add(jVis, c);
        
        
        jDayOfTheWeek = new JLabel("lelel");
        jDayOfTheWeek.setText(this.getDayOfTheWeek().substring(0, 3));
        c.gridx = 0;
        c.gridy = 1;




        mainFrame.add(jDayOfTheWeek, c);



        jWindDirectionToday = new JLabel(rss.getFirstDay().getWindDirection());

        c.gridx = 1;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindDirectionToday, c);


        jWindSpeed1 = new JLabel(Integer.toString(rss.getFirstDay().getWindSpeed()) + "mph");
        c.gridx = 2;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindSpeed1, c);


        jMaxTemp1 = new JLabel(Integer.toString(rss.getFirstDay().getMaxTemp()) + "C");
        c.gridx = 3;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jMaxTemp1, c);

        jMinTemp1 = new JLabel(Integer.toString(rss.getFirstDay().getMinTemp()) + "C");
        c.gridx = 4;
        mainFrame.add(jMinTemp1, c);

        jPressure1 = new JLabel(Integer.toString(rss.getFirstDay().getPressure()));
        c.gridx = 5;
        mainFrame.add(jPressure1, c);

        jHumidity1 = new JLabel(Integer.toString(rss.getFirstDay().getHumidity()));
        c.gridx = 6;
        mainFrame.add(jHumidity1, c);

        jVisibility1 = new JLabel(rss.getFirstDay().getVisibility());
        c.gridx = 7;
        mainFrame.add(jVisibility1, c);
        
        
        
        JLabel jNextDayOfTheWeek = new JLabel(this.getNextDayofTheWeek(1).substring(0, 3));
        c.gridx = 0;
        c.gridy = 2;

        mainFrame.add(jNextDayOfTheWeek, c);



        jWindDirection2 = new JLabel(rss.getNextDay().getWindDirection());

        c.gridx = 1;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindDirection2, c);


        jWindSpeed2 = new JLabel(Integer.toString(rss.getNextDay().getWindSpeed()) + "mph");
        c.gridx = 2;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindSpeed2, c);


        jMaxTemp2 = new JLabel(Integer.toString(rss.getNextDay().getMaxTemp()) + "C");
        c.gridx = 3;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jMaxTemp2, c);

        jMinTemp2 = new JLabel(Integer.toString(rss.getNextDay().getMinTemp()) + "C");
        c.gridx = 4;
        mainFrame.add(jMinTemp2, c);

        jPressure2 = new JLabel(Integer.toString(rss.getNextDay().getPressure()));
        c.gridx = 5;
        mainFrame.add(jPressure2, c);

        jHumidity2 = new JLabel(Integer.toString(rss.getNextDay().getHumidity()));
        c.gridx = 6;
        mainFrame.add(jHumidity2, c);

        jVisibility2 = new JLabel(rss.getNextDay().getVisibility());
        c.gridx = 7;
        mainFrame.add(jVisibility2, c);
        
        JLabel jNextDayOfTheWeek1 = new JLabel(this.getNextDayofTheWeek(2).substring(0, 3));
        c.gridx = 0;
        c.gridy = 3;

        mainFrame.add(jNextDayOfTheWeek1, c);



        jWindDirection3 = new JLabel(rss.getDayAfterTomorrow().getWindDirection());

        c.gridx = 1;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindDirection3, c);


        jWindSpeed3 = new JLabel(Integer.toString(rss.getDayAfterTomorrow().getWindSpeed()) + "mph");
        c.gridx = 2;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindSpeed3, c);


        jMaxTemp3 = new JLabel(Integer.toString(rss.getDayAfterTomorrow().getMaxTemp()) + "C");
        c.gridx = 3;
        c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jMaxTemp3, c);

        jMinTemp3 = new JLabel(Integer.toString(rss.getDayAfterTomorrow().getMinTemp()) + "C");
        c.gridx = 4;
        mainFrame.add(jMinTemp3, c);

        jPressure3 = new JLabel(Integer.toString(rss.getDayAfterTomorrow().getPressure()));
        c.gridx = 5;
        mainFrame.add(jPressure3, c);

        jHumidity3 = new JLabel(Integer.toString(rss.getDayAfterTomorrow().getHumidity()));
        c.gridx = 6;
        mainFrame.add(jHumidity3, c);

        jVisibility3 = new JLabel(rss.getDayAfterTomorrow().getVisibility());
        c.gridx = 7;
        mainFrame.add(jVisibility3, c);

        this.add(mainFrame);



    }

    public String getDayOfTheWeek() {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());

        Date currentDate = c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);



    }

    public String getNextDayofTheWeek(int increment) {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        c.add(Calendar.DATE, increment);
        Date currentDate = c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);
    }
    
    

    public static void main(String[] args) {
        WeatherApp myapp = new WeatherApp();
        myapp.setVisible(true);

    }
}
