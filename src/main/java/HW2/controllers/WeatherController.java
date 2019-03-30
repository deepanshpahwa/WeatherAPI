package HW2.controllers;

import HW2.WeatherBean;
import HW2.WeatherReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class WeatherController {

    @GetMapping("/historical/{date}")
    public String getHistoricalWeatherData(@PathVariable("date") int date) throws Exception {

        File testFile = new File("dailyweather.csv");
        List<WeatherBean> weather = WeatherReader.readFile(testFile);

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return _weather.getMax_temperature();
            }
        }

        return"ponty";

    }

    @GetMapping("/forecast/{date}")
    public String getForecast(@PathVariable("date") int date) throws Exception {

        File testFile = new File("dailyweather.csv");
        List<WeatherBean> weather = WeatherReader.readFile(testFile);

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return _weather.getMax_temperature();
            }
        }

        return "ponty";
    }

    @GetMapping("/ponty")
    public String getPonty() throws Exception {

        File testFile = new File("C:\\Users\\deepa\\OneDrive\\Documents\\19SS\\CLOUD COMPUTING\\dailyweather.csv");
        List<WeatherBean> weather = WeatherReader.readFile(testFile);

        for (WeatherBean _weather : weather){
            return _weather.getMax_temperature();
        }

        return "ponty";
    }



}
