package HW2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({ "DATE", "TMAX", "TMIN" })

public class WeatherBean implements Serializable {
    @JsonProperty
    private String date;

    @JsonProperty
    private String max_temperature;

    @JsonProperty
    private String min_temperature;

    public WeatherBean(String date, String max_temp, String min_temp) {
        this.date = date;
        this.max_temperature = max_temp;
        this.min_temperature = min_temp;
    }

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
