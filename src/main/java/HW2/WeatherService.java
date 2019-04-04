package HW2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    private boolean pojosCreated = false;
    List<WeatherBean> weather;

    public List<WeatherBean> loadPojos() throws Exception {
        weather = new ArrayList<>();

        File testFile = new File("dailyweather.csv");
        weather = CSVtoPOJO.readFile(testFile);

        if(weather.size()!=0){
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

    public void addWeatherData(String date, Double max_temp, Double min_temp) {
        WeatherBean weatherBean = new WeatherBean(date, max_temp, min_temp);
        weather.add(weatherBean);
    }

    public void deleteWeatherEntry(String date) {
        int index = -1;
        for (WeatherBean _weather: weather){
            if (_weather.getDATE().equals(date)){
                index = weather.indexOf(_weather);
            }
        }
        if (index!=-1) {
            weather.remove(index);
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
