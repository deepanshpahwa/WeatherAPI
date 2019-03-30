package HW2;

import java.io.File;
import java.util.List;

public class Service{
    private boolean pojosCreated = false;
    List<WeatherBean> weather;

    public List<WeatherBean> loadPojos() throws Exception {

        File testFile = new File("dailyweather.csv");
        weather = WeatherReader.readFile(testFile);

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
}
