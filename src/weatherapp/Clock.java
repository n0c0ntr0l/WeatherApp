
package weatherapp;

/**
 *
 * @author daniel
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.* ;
import java.net.*;
import sun.audio.*;

public class Clock extends Frame {

   int hour=0;
   int mins=0;
   JLabel timer;
   JLabel timer2;
   JFrame jframe ;
   Boolean timeofday = false;
   JButton button1;
   JButton button2;
   JButton button3;
   JButton button4;
   JButton button5;
   JButton button6;
   JButton button7;
   JButton button8;
   Panel p;
   AudioClip aClip;
   boolean size = true;
   
   
    public Clock(){

        try{
            aClip = Applet.newAudioClip(new URL("file:C:\\Users\\drd30\\Desktop\\beep-07.wav"));
        }
        catch(MalformedURLException e){
            
        }
        jframe = new JFrame("test");
       
        jframe.setSize(320,480);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p =new Panel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.black);
        jframe.add(p);
        
        GridBagConstraints c = new GridBagConstraints();
        
        
        timer = new JLabel(); timer2= new JLabel();
        
        timer.setForeground(Color.red); timer2.setForeground(Color.red);timer.setFont(new Font("Arial",Font.BOLD,35));
        timer.setText("0" + hour); timer2.setText("0" + mins);timer2.setFont(new Font("Arial",Font.BOLD,35));
        c.gridx=0;c.gridy=1;c.insets = new Insets(10,10,0,0);p.add(timer,c);
        c.gridx=1;c.gridy=1;c.insets = new Insets(10,10,0,0);p.add(timer2,c);

        button1 = new JButton("^");
        button1.setFont(new Font("Arial",Font.BOLD,45));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.red);
        button1.setBorderPainted(false);
        button1.setBorder(null);
        c.gridx=0;
        c.gridy=0;
        c.insets = new Insets(10,10,0,0);
        p.add(button1,c);  
        button1.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 String hr ="";
                  if(hour==23){
                     hour=0;
                  }
                  else{
                      hour++;
                  }
                  if(hour <10){ 
                    hr = "0" + hour;
                 }
                  else { 
                    hr = Integer.toString(hour);
                  }
                  timer.setText(hr);
             }  
            });
 
       
        
        button2 = new JButton("^");
        button2.setFont(new Font("Arial",Font.BOLD,45));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.red);
        button2.setBorderPainted(false);
        button2.setBorder(null);
        c.gridx=1;
        c.gridy=0;
        c.insets = new Insets(10,10,0,0);
        p.add(button2,c);  
        button2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                 String min ="";
                 
                  if(mins==59){
                     mins=0;
                  }
                  else{
                      mins++;
                  }
                  if(mins <10){ 
                    min = "0" + mins;
                 }
                  else { 
                    min = Integer.toString(mins);
                  }
                  timer2.setText(min);
             }
             
            });
             
                
        
        
        button3 = new JButton("v");
        button3.setFont(new Font("Arial",Font.BOLD,35));
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.red);
        button3.setBorderPainted(false);
        button3.setBorder(null);
        c.gridx=0;
        c.gridy=2;
        p.add(button3,c);  
        button3.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent eb){
                 String hr ="";
                 
                  if(hour==0){
                     hour=23;
                  }
                  else{
                      hour--;
                  }
                  
                  if(hour <10){ 
                    hr = "0" + hour;
                 }
                  else { 
                    hr = Integer.toString(hour);
                  }
                  timer.setText(hr);
             }
             
            });
                
                
        
        button4 = new JButton("v");
        button4.setFont(new Font("Arial",Font.BOLD,35));
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.red);
        button4.setBorderPainted(false);
        button4.setBorder(null);
        c.gridx=1;
        c.gridy=2;
        c.insets = new Insets(10,10,0,0);
        p.add(button4,c);  
        
        button4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                 String min ="";
                 
                  if(mins==0){
                     mins=59;
                  }
                  else{
                      mins--;
                  }
                  if(mins <10){ 
                    min = "0" + mins;
                 }
                  else { 
                    min = Integer.toString(mins);
                  }
                  timer2.setText(min);
             }
             
            });
        
        
        
        
        button5 = new JButton("cancel");
        button5.setFont(new Font("Arial",Font.BOLD,35));
        button5.setForeground(Color.red);
        button5.setBackground(Color.BLACK);
        button5.setBorderPainted(false);
        button5.setBorder(null);
        c.gridx=1;
        c.gridy=3;
        c.insets = new Insets(10,10,0,0);
        p.add(button5,c);  
         button5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                 aClip.play();
                 jframe.dispose();
             }
             
            });
        
        
        button6 = new JButton("ok");
        button6.setFont(new Font("Arial",Font.BOLD,35));
        button6.setForeground(Color.red);
        button6.setBackground(Color.BLACK);
        button6.setBorderPainted(false);
        button6.setBorder(null);
        c.gridx=0;
        c.gridy=3;
        c.insets = new Insets(10,10,0,0);
        p.add(button6,c);  
         button6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                 aClip.play();
                 jframe.dispose();

             }
             
            });
         
         
         button7 = new JButton("LIGHTMODEPOWERRANGERSMEGASWORD");
         c.gridx=1;
         c.gridy=5;
         c.insets = new Insets(10,10,0,0);
          button7.setForeground(Color.red);
        button7.setBackground(Color.BLACK);
        button7.setBorderPainted(false);
        button7.setBorder(null);
         p.add(button7,c);  
         button7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                aClip.play();
                 if(timeofday){
                     
                     timeofday=false;
                     changeNight();
                    
                                
                 }
                 else{
                     
                     timeofday=true;
                      changeDay();
                 }

             }
             
            });
         
        button8 = new JButton("_");
        button8.setFont(new Font("Arial",Font.BOLD,10));
        button8.setForeground(Color.PINK);
        button8.setBackground(Color.PINK);
        button8.setBorderPainted(false);
        button8.setBorder(null);
        c.gridx=0;
        c.gridy=10;
        c.anchor = GridBagConstraints.FIRST_LINE_START;   
        p.add(button8,c);
        button7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent ea){
                if(size){
                    size=false;
                    changeSizeMin();
                }
                else { 
                    size=true;
                    changeSizeMax();
                    
                }
             }
             
            });
        
        
        jframe.setVisible(true);
        
        
        
    }
    public static void main(String[] args) {
       Clock app=new Clock();
    }

    public int getHour(){
        return hour;
    }
    
    public int getMins(){
        return mins;
    }

    public void changeNight(){
         p.setBackground(Color.black);
                p.setForeground(Color.red);
                
                timer.setForeground(Color.red);
                timer.setBackground(Color.black);
        
                timer2.setForeground(Color.red);
                timer2.setBackground(Color.black);
            
                button1.setBackground(Color.black);
                button2.setBackground(Color.black);
                button3.setBackground(Color.black);
                button4.setBackground(Color.black);
                button5.setBackground(Color.black);
                button6.setBackground(Color.black);
                button7.setBackground(Color.black);
                
                button1.setForeground(Color.red);
                button2.setForeground(Color.red);
                button3.setForeground(Color.red);
                button4.setForeground(Color.red);
                button5.setForeground(Color.red);
                button6.setForeground(Color.red);
                button7.setForeground(Color.red);
    }
    
    public void changeDay(){
        p.setBackground(Color.white);
                    p.setForeground(Color.BLACK);

                    timer.setForeground(Color.black);
                    timer.setBackground(Color.white);

                    timer2.setForeground(Color.black);
                    timer2.setBackground(Color.white);

                    button1.setBackground(Color.white);
                    button2.setBackground(Color.white);
                    button3.setBackground(Color.white);
                    button4.setBackground(Color.white);
                    button5.setBackground(Color.white);
                    button6.setBackground(Color.white);
                    button7.setBackground(Color.white);

                    button1.setForeground(Color.black);
                    button2.setForeground(Color.black);
                    button3.setForeground(Color.black);
                    button4.setForeground(Color.black);
                    button5.setForeground(Color.black);
                    button6.setForeground(Color.black);
                    button7.setForeground(Color.black);
    }
    
    public void changeSizeMin(){
        jframe.setSize(520,680);
    }

    public void changeSizeMax(){
        jframe.setSize(320,480);
    }
}

