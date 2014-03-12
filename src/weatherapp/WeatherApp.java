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
        this.setSize(600, 300);
        GridBagLayout myLayout = new GridBagLayout();
        JPanel mainFrame = new JPanel(myLayout);
        rss = new RSSReader();
        GridBagConstraints c = new GridBagConstraints();


        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 10;
        c.gridheight = 10;

        jDayOfTheWeek = new JLabel("lelel");
        jDayOfTheWeek.setText(this.getDayOfTheWeek());
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;
        c.gridheight = 4;

        c.weightx = 1;
        c.weighty = 1;


        mainFrame.add(jDayOfTheWeek, c);



        jWindDirectionToday = new JLabel(rss.getFirstDay().getWindDirection());
        c.gridx = 2;
        c.gridy = 2;
         c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        mainFrame.add(jWindDirectionToday, c);


        jWindSpeed1 = new JLabel(Integer.toString(rss.getFirstDay().getWindSpeed()) + "mph");
        c.gridx = 3;
        c.gridy = 3;
         c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jWindSpeed1, c);


        jMaxTemp1 = new JLabel(Integer.toString(rss.getFirstDay().getMaxTemp()) + "C");
        c.gridx = 4;
        c.gridy = 4;
         c.weightx = 1;
        c.weighty = 1;
        mainFrame.add(jMaxTemp1, c);



        this.add(mainFrame);



    }

    public String getDayOfTheWeek() {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());

        Date currentDate = c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);



    }

    public static void main(String[] args) {
        WeatherApp myapp = new WeatherApp();
        myapp.setVisible(true);

    }
}
