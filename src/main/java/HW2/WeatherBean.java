package HW2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({ "DATE", "TMIN", "TMAX" })

public  class WeatherBean implements Serializable {
    @JsonProperty
    private String DATE;

    @JsonProperty
    private Double max_temperature;

    @JsonProperty
    private Double min_temperature;

    WeatherBean(){}

    WeatherBean(String date, Double max_temp, Double min_temp) {
        this.DATE = date;
        this.max_temperature = max_temp;
        this.min_temperature = min_temp;
    }
    @JsonProperty("DATE")
    public String getDATE() {
        return DATE;
    }
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    @JsonProperty("TMAX")
    public Double getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(Double max_temperature) {
        this.max_temperature = max_temperature;
    }

    @JsonProperty("TMIN")
    public Double getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(Double min_temperature) {
        this.min_temperature = min_temperature;
    }

}
