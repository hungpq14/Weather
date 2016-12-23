package dtui.fit.com.weatherapp.Constant;

import java.util.ArrayList;
import java.util.List;

import dtui.fit.com.weatherapp.Adapter.TemperatureAdapter;
import dtui.fit.com.weatherapp.Adapter.WindSpeedAdapter;
import dtui.fit.com.weatherapp.Object.HourlyForecast;

/**
 * Created by phamh_000 on 17/11/2016.
 */
public class HourlyForecastSeeder {
    public static List<HourlyForecast> temperatureList = new ArrayList<>();
    public static List<HourlyForecast> precipitationList = new ArrayList<>();
    public static List<HourlyForecast> windSpeedList = new ArrayList<>();
    public static List<HourlyForecast> humidityList = new ArrayList<>();

    public static List<HourlyForecast> getSampleListTemperature() {
        temperatureList.clear();
        temperatureList.add(new HourlyForecast("a", "NOW", "29°"));
        return temperatureList;
    }

    public static void initListTemperature(TemperatureAdapter adapter) {
        temperatureList.add(new HourlyForecast("a", "10 AM", "27°"));
        temperatureList.add(new HourlyForecast("a", "11 AM", "9°"));
        temperatureList.add(new HourlyForecast("a", "12 AM", "2°"));
        temperatureList.add(new HourlyForecast("a", "1 PM", "8°"));
        temperatureList.add(new HourlyForecast("a", "2 PM", "6°"));
        temperatureList.add(new HourlyForecast("a", "3 PM", "3°"));
        temperatureList.add(new HourlyForecast("a", "4 PM", "5°"));
        temperatureList.add(new HourlyForecast("a", "5 PM", "14°"));
        temperatureList.add(new HourlyForecast("a", "6 PM", "26°"));
        temperatureList.add(new HourlyForecast("a", "7 PM", "29°"));
        temperatureList.add(new HourlyForecast("a", "8 PM", "30°"));
        adapter.notifyItemRangeInserted(1, 12);
    }

    public static List<HourlyForecast> getPrecipitationList() {
        precipitationList.clear();
        precipitationList.add(new HourlyForecast("a", "NOW", 30));
        precipitationList.add(new HourlyForecast("a", "10 AM", 40));
        precipitationList.add(new HourlyForecast("a", "11 AM", 50));
        precipitationList.add(new HourlyForecast("a", "12 AM", 0));
        precipitationList.add(new HourlyForecast("a", "1 PM", 10));
        precipitationList.add(new HourlyForecast("a", "2 PM", 18));
        precipitationList.add(new HourlyForecast("a", "3 PM", 60));
        precipitationList.add(new HourlyForecast("a", "4 PM", 9));
        precipitationList.add(new HourlyForecast("a", "5 PM", 8));
        precipitationList.add(new HourlyForecast("a", "6 PM", 22));
        precipitationList.add(new HourlyForecast("a", "7 PM", 44));
        precipitationList.add(new HourlyForecast("a", "8 PM", 52));
        return precipitationList;
    }

    public static List<HourlyForecast> getWindSpeedList() {
        windSpeedList.clear();
        windSpeedList.add(new HourlyForecast("a", "NOW", "6 KM/H"));
        return windSpeedList;
    }

    public static void initListWindSpeed(WindSpeedAdapter adapter) {
        windSpeedList.add(new HourlyForecast("a", "10 AM", "3 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "11 AM", "2 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "12 AM", "4 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "1 PM", "5 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "2 PM", "9 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "3 PM", "10 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "4 PM", "2 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "5 PM", "3 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "6 PM", "3 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "7 PM", "4 KM/H"));
        windSpeedList.add(new HourlyForecast("a", "8 PM", "8 KM/H"));
        adapter.notifyItemRangeInserted(1,12);
    }

    public static List<HourlyForecast> getHumidityList() {
        humidityList.clear();
        humidityList.add(new HourlyForecast("a", "NOW", 50));
        humidityList.add(new HourlyForecast("a", "10 AM", 60));
        humidityList.add(new HourlyForecast("a", "11 AM", 20));
        humidityList.add(new HourlyForecast("a", "12 AM", 40));
        humidityList.add(new HourlyForecast("a", "1 PM", 30));
        humidityList.add(new HourlyForecast("a", "2 PM", 80));
        humidityList.add(new HourlyForecast("a", "3 PM", 89));
        humidityList.add(new HourlyForecast("a", "4 PM", 90));
        humidityList.add(new HourlyForecast("a", "5 PM", 70));
        humidityList.add(new HourlyForecast("a", "6 PM", 60));
        humidityList.add(new HourlyForecast("a", "7 PM", 20));
        humidityList.add(new HourlyForecast("a", "8 PM", 10));
        return humidityList;
    }
}
