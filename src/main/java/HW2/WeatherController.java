package HW2;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class WeatherController {
    WeatherService service = new WeatherService();


    @GetMapping("weather/historical")
    public List<WeatherDateBean> getHistoricalWeatherData() throws Exception {

        List<WeatherBean> weather;
        weather = getPojoDataFromService();


        List<WeatherDateBean> listOfDates = new ArrayList<>();
        for (WeatherBean _weather : weather){
            listOfDates.add(new WeatherDateBean(_weather.getDATE()));
        }
//        System.out.println(":::::::::::::::"+listOfDates.get(1));

        String json = new Gson().toJson(listOfDates);
        return listOfDates;


    }



    @GetMapping("weather/historical/{DATE}")
    public WeatherBean getHistoricalWeatherDataFromDate(@PathVariable("DATE") String date) throws Exception {

        checkDateLength(date);

        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDATE().equals(date)){//todo check
                return _weather;
            }
        }
        throw new ResourceNotFoundException();

//        return null;//TODO historical data not found

    }

    @PostMapping(path = "weather/historical", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
//    @RequestMapping(path = "/historical", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String postWeatherData(@RequestBody WeatherBean weatherBean) throws Exception {
//    public String postWeatherData(@RequestBody WeatherBean weatherBean) throws Exception {
        getPojoDataFromService();
//        service.addWeatherData(weatherBean.getDATE(),weatherBean.getMax_temperature(),weatherBean.getMin_temperature());
        service.deleteWeatherEntry(weatherBean.getDATE());
        service.addWeatherData(weatherBean.getDATE(), weatherBean.getMax_temperature(), weatherBean.getMin_temperature());

//        return new ResponseEntity("Entry Created", HttpStatus.CREATED);//TODO this one

//        return new TwoOhOne();

//        throw new TwoOhOne();
//        return Response

        return  new Gson().toJson(new WeatherDateBean(weatherBean.getDATE()));
//        return null;
    }

    @DeleteMapping("weather/historical/{DATE}")
    public void deleteWeatherData(@PathVariable("DATE") String date) throws Exception {
        checkDateLength(date);

        getPojoDataFromService();
        service.deleteWeatherEntry(date);
    }

    @GetMapping("weather/forecast/{DATE}")
    public List<WeatherBean> getForecast(@PathVariable("DATE") String date) throws Exception {

        checkDateLength(date);


        List<WeatherBean> weather;
        weather = getPojoDataFromService();

        for (WeatherBean _weather : weather){
            if (_weather.getDATE().equals(date)){//todo check
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

    private void checkDateLength(@PathVariable("DATE") String date) {
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
