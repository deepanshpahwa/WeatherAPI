package HW2;

import HW2.WeatherService;
import HW2.WeatherBean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {
    WeatherService service;

    @GetMapping("/historical")
    public List<String> getHistoricalWeatherData() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();


        List<String> listOfDates = new ArrayList<>();
        for (WeatherBean _weather : weather){
            listOfDates.add(_weather.getDate());
        }

        return listOfDates;

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

        return "Error";//TODO

    }

    @PostMapping("/historical")
    public void postWeatherData(@RequestBody String date, @RequestBody String max_temp, @RequestBody String min_temp){
        service.addWeatherData(date,max_temp,min_temp);
    }

    @DeleteMapping("/historical/{date}")
    public void deleteWeatherData(@PathVariable("date") String date){
        service.deleteWeatherEntry(date);
    }

    @GetMapping("/forecast/{date}")
    public List<WeatherBean> getForecast(@PathVariable("date") String date) throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return service.getWeeksWeather(weather.indexOf(_weather));
            }
        }

        return null;//TODO add check on UI
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

    private List<WeatherBean> getPojoDataFromService() throws Exception {
        List<WeatherBean> weather;
        if (!service.hasPOJOsLoaded()) {
            weather = service.loadPojos();
        }else{
            weather = service.getPojos();
        }
        return weather;
    }





}
