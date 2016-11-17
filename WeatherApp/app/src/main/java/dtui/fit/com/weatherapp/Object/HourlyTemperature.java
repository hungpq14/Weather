package dtui.fit.com.weatherapp.Object;

/**
 * Created by phamh_000 on 15/11/2016.
 */
public class HourlyTemperature {
    private String icon, time, temperature;

    public HourlyTemperature(String icon, String time, String temperature) {
        this.icon = icon;
        this.time = time;
        this.temperature = temperature;
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
}
