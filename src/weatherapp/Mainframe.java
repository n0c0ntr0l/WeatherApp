
package weatherapp;

/**
 *
 * @author william
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;



public class Mainframe {
    boolean running = true;
    JLabel timeNow = new JLabel();
    int hour = 0;
    
    JFrame window;
    JPanel panel;
    JButton alarm, size;
    JLabel weatherTitle, warningLevel;
    JLabel oneHour, twoHour, threeHour, fourHour, fiveHour;
    JLabel trafficUpdate1, trafficUpdate2, trafficUpdate3, trafficUpdate4;
    Random rand = new Random(); 
    int value = 0;
    boolean initialSize = true;
    GridBagConstraints gbc = new GridBagConstraints();
    
    
    ImageIcon sunny = new ImageIcon(getClass().getResource("sunny.png"));
    ImageIcon cloud = new ImageIcon(getClass().getResource("cloud.png"));
    ImageIcon dayStorm = new ImageIcon(getClass().getResource("dayStorm.png"));
    ImageIcon sunnyCloud = new ImageIcon(getClass().getResource("sunnyCloud.png"));
    ImageIcon storm = new ImageIcon(getClass().getResource("storm.png"));
    
    

    
    public Mainframe(){
      new Thread(){
        public void run(){
            while (running){
                Calendar cal = new GregorianCalendar();
                String minute = "";
                hour = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);
                minute = String.valueOf(min);
                if (min<10){
                    minute = "0"+min;
                }
                String time = hour + ":" +minute;
                timeNow.setText(time);
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){ System.out.println("Clock Thread Sleep Error");}
            }
          }
        }.start();
    }

    public void Mainframe(){
        
         
        makeFrame();
        addPanel();
        addSize();
        addAlarmGps();
        addClock();
        addTitle();
        addForecast();
        addWarning();
        addTrafficUpdate();
        addFrame();
    }
    
    public void makeFrame(){
        window = new JFrame("Alpha");
        window.setSize(320, 480);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addPanel(){
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(new GridBagLayout());
        window.add(panel);
    }
    
    public void addSize(){   
        size = new JButton("+");
        
        size.setBackground(Color.white);
        size.setFont(new Font("Arial", Font.PLAIN , 8));
        //size.setPreferredSize(new Dimension(60, 60));
        
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        
        panel.add(size, gbc);
        size.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (initialSize){ maximise(); initialSize = false;}
                else if(!initialSize){ minimise(); initialSize = true;}
            }  
        });    
    }
    
    public void addAlarmGps(){
        alarm = new JButton("Alarm");
        alarm.setBackground(Color.white);
        alarm.setFont(new Font("Arial", Font.BOLD, 9));
        alarm.setHorizontalAlignment(SwingConstants.LEFT);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weighty =1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
       
        
        panel.add(alarm, gbc);
        gbc.insets = new Insets(0,0,0,0);
        
    }
    
    
    
    
    public void addClock(){
        
        timeNow.setFont(new Font("Arial",Font.PLAIN,30));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        timeNow.setHorizontalAlignment(JLabel.CENTER);
        timeNow.setBorder(border);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        
        panel.add(timeNow, gbc);
    }
    
    public void addTitle(){
        weatherTitle = new JLabel("Weather Forecast");
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        weatherTitle.setBorder(border);
        weatherTitle.setHorizontalAlignment(JLabel.CENTER);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 0.25;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.PAGE_START;
        
        panel.add(weatherTitle, gbc);
    }
    
    public void addForecast(){  
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        oneHour = new JLabel(String.valueOf(hour)+":00", JLabel.CENTER);
        returnImage(1);
   
        oneHour.setBorder(border);
        oneHour.setHorizontalTextPosition(SwingConstants.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(oneHour, gbc);
        
        twoHour = new JLabel(String.valueOf(correctHour(hour+1))+":00", JLabel.CENTER);
        returnImage(2);
       
        twoHour.setBorder(border);
        twoHour.setHorizontalTextPosition(SwingConstants.CENTER);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(twoHour, gbc);
        
        threeHour = new JLabel(String.valueOf(correctHour(hour+2))+":00", JLabel.CENTER);
        returnImage(3);
        
        threeHour.setBorder(border);
        threeHour.setHorizontalTextPosition(SwingConstants.CENTER);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(threeHour, gbc);
        
        fourHour = new JLabel(String.valueOf(correctHour(hour+3))+":00", JLabel.CENTER);
        returnImage(4);
        
        fourHour.setBorder(border);
        fourHour.setHorizontalTextPosition(SwingConstants.CENTER);
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(fourHour, gbc);
        
        fiveHour = new JLabel(String.valueOf(correctHour(hour+4))+":00", JLabel.CENTER);
        returnImage(5);
        
        fiveHour.setBorder(border);
        fiveHour.setHorizontalTextPosition(SwingConstants.CENTER);
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,0,50);
        panel.add(fiveHour, gbc);  
        
        
    }
    
    public void addWarning(){
        warningLevel = new JLabel("Warning Level");
        setWarningLevel();
        warningLevel.setOpaque(true);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        warningLevel.setBorder(border);
        warningLevel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weighty = 0.25;
        gbc.weightx = 1;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        panel.add(warningLevel, gbc);
    }
    
    public void addTrafficUpdate(){
    
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        trafficUpdate1 = new JLabel("update 1");
        
        trafficUpdate1.setBorder(border);
        trafficUpdate1.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 31;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.PAGE_START;
        
        panel.add(trafficUpdate1, gbc);
        
        System.out.println("added update 1");
        
        trafficUpdate2 = new JLabel("update 2");
        
        trafficUpdate2.setBorder(border);
        trafficUpdate2.setHorizontalAlignment(JLabel.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weighty = 0.5;
        gbc.gridwidth = 5;
        panel.add(trafficUpdate2,gbc);
        System.out.println("added update 2");
        
        trafficUpdate3 = new JLabel("update 3");
        
        trafficUpdate3.setBorder(border);
        trafficUpdate3.setHorizontalAlignment(JLabel.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 0.5;
        gbc.gridwidth = 5;
        panel.add(trafficUpdate3, gbc);
        System.out.println("added update 3");
        
        trafficUpdate4 = new JLabel("update 4");
        
        trafficUpdate4.setBorder(border);
        trafficUpdate4.setHorizontalAlignment(JLabel.CENTER);
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 0.5;
        gbc.gridwidth = 5;
        panel.add(trafficUpdate4, gbc);
        System.out.println("added update 4");
    }
    
    public void setWarningLevel(){
        int chance =  rand.nextInt(3)+1;
        if(chance == 1){
            warningLevel.setBackground(Color.RED);
        }
        if(chance == 2){
            warningLevel.setBackground(Color.ORANGE);
        }
        if(chance == 3){
            warningLevel.setBackground(Color.BLUE);
        }
        if(chance == 4){
            warningLevel.setBackground(Color.GREEN);
        }
    }
    
    public void returnImage(int nHour){
    
    value = rand.nextInt(5)+1;
   //System.out.println("The value hour " + nHour +" go is " + value);
        if (nHour ==1){
            if (value == 1){oneHour.setIcon(sunny);}
            else if (value == 2){oneHour.setIcon(cloud);}
            else if (value == 3){oneHour.setIcon(sunnyCloud);}
            else if (value == 4){oneHour.setIcon(dayStorm);}
            else if (value == 5){oneHour.setIcon(storm);}    
        }
        
        if (nHour ==2){
            if (value == 1){twoHour.setIcon(sunny);}
            else if (value == 2){twoHour.setIcon(cloud);}
            else if (value == 3){twoHour.setIcon(sunnyCloud);}
            else if (value == 4){twoHour.setIcon(dayStorm);}
            else if (value == 5){twoHour.setIcon(storm);}    
        }
        
        if (nHour ==3){
            if (value == 1){threeHour.setIcon(sunny);}
            else if (value == 2){threeHour.setIcon(cloud);}
            else if (value == 3){threeHour.setIcon(sunnyCloud);}
            else if (value == 4){threeHour.setIcon(dayStorm);}
            else if (value == 5){threeHour.setIcon(storm);}    
        }
        if (nHour ==4){
            if (value == 1){fourHour.setIcon(sunny);}
            else if (value == 2){fourHour.setIcon(cloud);}
            else if (value == 3){fourHour.setIcon(sunnyCloud);}
            else if (value == 4){fourHour.setIcon(dayStorm);}
            else if (value == 5){fourHour.setIcon(storm);}    
        }
        
        if (nHour ==5){
            if (value == 1){fiveHour.setIcon(sunny);}
            else if (value == 2){fiveHour.setIcon(cloud);}
            else if (value == 3){fiveHour.setIcon(sunnyCloud);}
            else if (value == 4){fiveHour.setIcon(dayStorm);}
            else if (value == 5){fiveHour.setIcon(storm);}    
        }
    }
    
    public int correctHour(int hour){
        int newHour = hour;
        if(hour > 23){
         newHour = Math.abs((24-hour));
        }
        return newHour;
    }
    
    public void maximise() {
        window.setSize(520, 680);
        
        gbc.gridx = 0;gbc.gridy = 0;gbc.gridwidth= 1;gbc.weightx=1;gbc.weighty=1;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(size, gbc);
        gbc.gridx = 1;gbc.gridy = 1;gbc.weighty =1;gbc.weightx = 0.5;gbc.gridwidth = 2;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(alarm, gbc);
        gbc.gridx = 3;gbc.gridy = 1;gbc.gridwidth = 3;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(timeNow, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;gbc.gridx = 2;gbc.gridy = 2;gbc.weighty = 0.25;gbc.gridwidth = 3;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(weatherTitle, gbc);
        gbc.gridx = 1;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(oneHour, gbc);
        gbc.gridx = 2;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(twoHour, gbc);
        gbc.gridx = 3;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(threeHour, gbc);
        gbc.gridx = 4;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(fourHour, gbc);
        gbc.gridx = 5;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(fiveHour, gbc);
        gbc.gridx = 1;gbc.gridy = 2;gbc.weighty = 0.25;gbc.weightx = 1;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.LAST_LINE_START;panel.add(warningLevel, gbc);
        gbc.gridx = 1;gbc.gridy = 3;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_END;panel.add(trafficUpdate1, gbc);
        gbc.gridx = 1;gbc.gridy = 3;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(trafficUpdate2, gbc);
        gbc.gridx = 1;gbc.gridy = 4;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_END;panel.add(trafficUpdate1, gbc);
        gbc.gridx = 1;gbc.gridy = 4;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(trafficUpdate2, gbc);
        
        
        size.setText("-");
        size.setFont(new Font("Arial", Font.BOLD, 19));  
    }
    
    public void minimise() {
        window.setSize(320, 480);
        gbc.gridx = 0;gbc.gridy = 0;gbc.gridwidth= 1;gbc.weightx=1;gbc.weighty=1;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(size, gbc);
        gbc.gridx = 1;gbc.gridy = 1;gbc.weighty =1;gbc.weightx = 0.5;gbc.gridwidth = 2;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(alarm, gbc);
        gbc.gridx = 3;gbc.gridy = 1;gbc.gridwidth = 3;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(timeNow, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;gbc.gridx = 2;gbc.gridy = 2;gbc.weighty = 0.25;gbc.gridwidth = 3;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(weatherTitle, gbc);
        gbc.gridx = 1;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(oneHour, gbc);
        gbc.gridx = 2;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(twoHour, gbc);
        gbc.gridx = 3;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(threeHour, gbc);
        gbc.gridx = 4;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(fourHour, gbc);
        gbc.gridx = 5;gbc.gridy = 2;gbc.weighty = 0.5;gbc.weightx = 1;gbc.gridwidth = 1;gbc.anchor = GridBagConstraints.LINE_START;panel.add(fiveHour, gbc);
        gbc.gridx = 1;gbc.gridy = 2;gbc.weighty = 0.25;gbc.weightx = 1;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.LAST_LINE_START;panel.add(warningLevel, gbc);
        gbc.gridx = 1;gbc.gridy = 3;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_END;panel.add(trafficUpdate1, gbc);
        gbc.gridx = 1;gbc.gridy = 3;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(trafficUpdate2, gbc);
        gbc.gridx = 1;gbc.gridy = 4;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_END;panel.add(trafficUpdate1, gbc);
        gbc.gridx = 1;gbc.gridy = 4;gbc.ipady = 31;gbc.weightx = 1;gbc.weighty = 0.5;gbc.gridwidth = 5;gbc.anchor = GridBagConstraints.PAGE_START;panel.add(trafficUpdate2, gbc);
        size.setText("+");
        size.setFont(new Font("Arial", Font.PLAIN, 10));  
    }
    
    public void addFrame(){
        window.setVisible(true);
    
    }
}


