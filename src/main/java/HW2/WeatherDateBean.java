package HW2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDateBean {
    public WeatherDateBean(String date) {
        this.DATE = date;
    }
    @JsonProperty("DATE")
    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }
    @JsonProperty
    String DATE;
}
