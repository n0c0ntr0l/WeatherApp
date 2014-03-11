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
import javax.swing.JWindow;

/**
 *
 * @author Jason
 */
public class WeatherApp extends JFrame{

    private JLabel jDayOfTheWeek;
    
    public WeatherApp(){
        
        
        JPanel mainFrame = new JPanel(new GridBagLayout());
 
        GridBagConstraints c = new GridBagConstraints();
        
        
        jDayOfTheWeek = new JLabel();
        jDayOfTheWeek.setText(this.getDayOfTheWeek());
        c.gridx = 0;
        c.gridy= 0;
        
         mainFrame.add(jDayOfTheWeek, c);
         this.add(mainFrame);
            
        
        
    }
    
    public String getDayOfTheWeek(){
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        
        Date currentDate =  c.getTime();
        return new SimpleDateFormat("EEEE").format(currentDate);
            
        
        
    }
    
    public static void main(String[] args) {
        WeatherApp myapp = new WeatherApp();
        myapp.setVisible(true);
        
    }
    
    
}
