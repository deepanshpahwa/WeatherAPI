package HW2;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "DATE", "TMAX", "TMIN" })

public class WeatherBean {

    private String date;
    private String max_temperature;
    private String min_temperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(String max_temperature) {
        this.max_temperature = max_temperature;
    }

    public String getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(String min_temperature) {
        this.min_temperature = min_temperature;
    }

}
