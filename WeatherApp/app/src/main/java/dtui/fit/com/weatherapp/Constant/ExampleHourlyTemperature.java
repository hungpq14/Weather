package dtui.fit.com.weatherapp.Constant;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Object.HourlyTemperature;

/**
 * Created by phamh_000 on 17/11/2016.
 */
public class ExampleHourlyTemperature {
    public static List<HourlyTemperature> temperatureList = new ArrayList<>();

    public static List<HourlyTemperature> getSampleListTemperature(){
        temperatureList.add(new HourlyTemperature("a","NOW","29°"));
        temperatureList.add(new HourlyTemperature("a","10 AM","29°"));
        temperatureList.add(new HourlyTemperature("a","11 AM","29°"));
        temperatureList.add(new HourlyTemperature("a","12 AM","29°"));
        temperatureList.add(new HourlyTemperature("a","1 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","2 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","3 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","4 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","5 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","6 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","7 PM","29°"));
        temperatureList.add(new HourlyTemperature("a","8 PM","29°"));
        return temperatureList;
    }
}
