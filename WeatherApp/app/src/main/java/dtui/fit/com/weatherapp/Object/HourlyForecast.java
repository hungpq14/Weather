package dtui.fit.com.weatherapp.Object;

/**
 * Created by phamh_000 on 15/11/2016.
 */
public class HourlyForecast {
    private String icon, time, temperature;
    private int precipitationPercent;

    public HourlyForecast(String icon, String time, String temperature) {
        this.icon = icon;
        this.time = time;
        this.temperature = temperature;
    }

    public HourlyForecast(String icon, String time, int precipitationPercent){
        this.icon = icon;
        this.time = time;
        this.precipitationPercent = precipitationPercent;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitationPercent() {
        return precipitationPercent;
    }

    public void setPrecipitationPercent(int precipitationPercent) {
        this.precipitationPercent = precipitationPercent;
    }
}
