package HW2;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.File;
import java.util.List;

public class WeatherReader {
    public static List<WeatherBean> readFile(File csvFile) throws Exception {
        MappingIterator<WeatherBean> weatherIterator = new CsvMapper().readerWithTypedSchemaFor(WeatherBean.class).readValues(csvFile);

        return weatherIterator.readAll();
    }

}
