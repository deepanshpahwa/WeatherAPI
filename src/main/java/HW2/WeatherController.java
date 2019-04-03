package HW2;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {
    WeatherService service = new WeatherService();


    @GetMapping("/historical")
    public List<WeatherDateBean> getHistoricalWeatherData() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();


        List<WeatherDateBean> listOfDates = new ArrayList<>();
        for (WeatherBean _weather : weather){
            listOfDates.add(new WeatherDateBean(_weather.getDate()));
        }
//        System.out.println(":::::::::::::::"+listOfDates.get(1));

        String json = new Gson().toJson(listOfDates);
        return listOfDates;


    }



    @GetMapping("/historical/{date}")
    public WeatherBean getHistoricalWeatherDataFromDate(@PathVariable("date") String date) throws Exception {

        checkDateLength(date);

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                return _weather;
            }
        }

        return null;//TODO historical data not found

    }

    @PostMapping("/historical")
    public String postWeatherData(@RequestParam("date") String date, @RequestParam("max_temp") String max_temp, @RequestParam("min_temp") String min_temp) throws Exception {
        getPojoDataFromService();
        service.addWeatherData(date,max_temp,min_temp);

        return  new Gson().toJson(new WeatherDateBean(date));
    }

    @DeleteMapping("/historical/{date}")
    public void deleteWeatherData(@PathVariable("date") String date) throws Exception {
        checkDateLength(date);

        getPojoDataFromService();
        service.deleteWeatherEntry(date);
    }

    @GetMapping("/forecast/{date}")
    public List<WeatherBean> getForecast(@PathVariable("date") String date) throws Exception {

        checkDateLength(date);


        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDate().equals(date)){//todo check
                if (service.getWeeksWeather(weather.indexOf(_weather)) == null){
                    throw new ResourceNotFoundException();
                }
                else{
                    return service.getWeeksWeather(weather.indexOf(_weather));
                }
            }
        }

        return null;//TODO add check on UI
    }

    private void checkDateLength(@PathVariable("date") String date) {
        if (date.length()>8){
            throw new ResourceNotFoundException();
        }
    }


//    @GetMapping("/ponty")//todo delete
//    public String getPonty() throws Exception {
//
//        List<WeatherBean> weather;
//        weather = getPojoDataFromService();
//
//        for (WeatherBean _weather : weather){
//            return _weather.getMax_temperature();
//        }
//
//        return "ponty";
//    }

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
