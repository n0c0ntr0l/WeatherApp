/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class RSSReader {

    private URL feedUrl = null;
    private SyndFeedInput input = null;
    private SyndFeed feed = null;
    List<SyndEntryImpl> feedList = null;

    public RSSReader() {
        try {
            feedUrl = new URL("http://newsrss.bbc.co.uk/weather/forecast/8/Next3DaysRSS.xml");
            input = new SyndFeedInput();
            feed = input.build(new XmlReader(feedUrl));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
        }
    }

    public ForecastStack getFirstDay() {
        feedList = feed.getEntries();
        return new ForecastStack(feedList.get(0).getDescription().getValue());
    }
    
    public ForecastStack getNextDay(){
      return new ForecastStack(feedList.get(1).getDescription().getValue());
    }
    
    public ForecastStack getDayAfterTomorrow(){ // couldn't resist!
        return new ForecastStack(feedList.get(2).getDescription().getValue());
    }
    

}
