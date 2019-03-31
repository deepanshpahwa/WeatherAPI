package HW2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    private boolean pojosCreated = false;
    List<WeatherBean> weather;

    public List<WeatherBean> loadPojos() throws Exception {

        File testFile = new File("dailyweather.csv");
        weather = CSVtoPOJO.readFile(testFile);

        if(weather!=null){
            pojosCreated = true;
        }

        return weather;

    }

    public List<WeatherBean> getPojos(){
        return weather;
    }


    public boolean hasPOJOsLoaded(){
        return pojosCreated;
    }

    public void addWeatherData(String date, String max_temp, String min_temp) {
        WeatherBean weatherBean = new WeatherBean(date, max_temp, min_temp);
        weather.add(weatherBean);
    }

    public void deleteWeatherEntry(String date) {
        for (WeatherBean _weather: weather){
            if (_weather.getDate().equals(date)){
                weather.remove(_weather);
            }
        }
    }

    public List<WeatherBean> getWeeksWeather(int index) {
        List<WeatherBean> weeksForecast = new ArrayList<>();

        if (!(index+7>weather.size()-1)){
            for (int i=0; i<7; i++){
                weeksForecast.add(weather.get(index+i));
            }
        } else {
            //Don't have data for the next 7 days
            return null;
        }

        return weeksForecast;
    }
}
