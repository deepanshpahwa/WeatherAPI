package HW2.controllers;

import HW2.Service;
import HW2.WeatherBean;
import HW2.WeatherReader;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
public class WeatherController {
    Service service;

    @GetMapping("/historical")
    public List<WeatherBean> getHistoricalWeatherData() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();


//        File testFile = new File("dailyweather.csv");
//        List<WeatherBean> weather = WeatherReader.readFile(testFile);

//        for (WeatherBean _weather : weather){
//            if (_weather.getDate().equals(date)){//todo check
//                return _weather.getMax_temperature();
//            }
//        }

        return ;

    }

    private List<WeatherBean> getPojoDataFromService() throws Exception {
        List<WeatherBean> weather;
        if (!service.hasPOJOsLoaded()) {
            weather = service.loadPojos();
        }else{
            weather = service.getPojos();
        }
        return weather;
    }

    @GetMapping("/historical/{date}")
    public String getHistoricalWeatherDataFromDate(@PathVariable("date") String date) throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return _weather.getMax_temperature();
            }
        }

        return"ponty";

    }

    @PostMapping("/historical")
    public List<WeatherBean> postWeatherData() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();



//        for (WeatherBean _weather : weather){
//            if (_weather.getDate().equals(date)){//todo check
//                return _weather.getMax_temperature();
//            }
//        }

        return weather;

    }

    @DeleteMapping("/historical/{date}")
    public void deleteWeatherData(@PathVariable("date") int date) throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();



//        for (WeatherBean _weather : weather){
//            if (_weather.getDate().equals(date)){//todo check
//                return _weather.getMax_temperature();
//            }
//        }

//        return weather;

    }

    @GetMapping("/forecast/{date}")
    public String getForecast(@PathVariable("date") int date) throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();



        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return _weather.getMax_temperature();
            }
        }

        return "ponty";
    }


    @GetMapping("/ponty")//todo delete
    public String getPonty() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            return _weather.getMax_temperature();
        }

        return "ponty";
    }







}
