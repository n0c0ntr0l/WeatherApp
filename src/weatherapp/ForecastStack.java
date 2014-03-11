/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

/**
 *
 * @author Jason
 */
public class ForecastStack {

    private int maxTemp, minTemp, windSpeed, pressure, humidity;
    private String visibility, windDirection;

    public ForecastStack(String stack) {
        String[] splitByCommas = stack.split(",");
        setMaxTemp(splitByCommas[0]);
        setMinTemp(splitByCommas[1]);
        setWindDirection(splitByCommas[2]);
        setWindSpeed(splitByCommas[3]);
        setVisibility(splitByCommas[4]);
        setPressure(splitByCommas[5]);
        setHumidity(splitByCommas[6]);
        

    }

    private void setMaxTemp(String parseThis) {
        String firstChar = "";
        String secondChar = "";
        String thirdChar = "";
        firstChar = Character.toString(parseThis.charAt(10));
        if (parseThis.charAt(11) != '°') {
            secondChar = Character.toString(parseThis.charAt(11));
            if (parseThis.charAt(12) != '°') {
                thirdChar = Character.toString(parseThis.charAt(12));
            }
        }

        maxTemp = Integer.parseInt(firstChar + secondChar + thirdChar);

    }
    
    private void setMinTemp(String parseThis){
        String firstChar = "";
        String secondChar = "";
        String thirdChar = "";
        firstChar = Character.toString(parseThis.charAt(11));
        if (parseThis.charAt(12) != '°') {
            secondChar = Character.toString(parseThis.charAt(12));
            if (parseThis.charAt(13) != '°') {
                thirdChar = Character.toString(parseThis.charAt(13));
            }
        }

        minTemp = Integer.parseInt(firstChar + secondChar + thirdChar);
    }
    
    private void setWindDirection(String parseThis){
        windDirection = parseThis.replace(" Wind Direction: ", "");
        
    }
    private void setWindSpeed(String parseThis){
        parseThis = parseThis.replace(" Wind Speed: ", "");
        parseThis = parseThis.replace("mph","");
        windSpeed = Integer.parseInt(parseThis);
    }
    
    private void setVisibility(String parseThis){
        visibility = parseThis.replace(" Visibility: ", "");
    }
    
    private void setPressure(String parseThis){
        parseThis = parseThis.replace(" Pressure: ", "");
        parseThis = parseThis.replace("mb", "");
        pressure = Integer.parseInt(parseThis);
    }
    
    private void setHumidity(String parseThis){
        parseThis = parseThis.replace(" Humidity: ", "");
        parseThis = parseThis.replace("%", "");
        humidity = Integer.parseInt(parseThis);
    }

    /**
     * @return the maxTemp
     */
    public int getMaxTemp() {
        return maxTemp;
    }

    /**
     * @return the minTemp
     */
    public int getMinTemp() {
        return minTemp;
    }

    /**
     * @return the windSpeed
     */
    public int getWindSpeed() {
        return windSpeed;
    }

    /**
     * @return the pressure
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * @return the humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * @return the visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * @return the windDirection
     */
    public String getWindDirection() {
        return windDirection;
    }
}
