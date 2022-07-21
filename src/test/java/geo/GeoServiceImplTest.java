package geo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @Test
    public void byCoordinatesTest() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertThrows(RuntimeException.class, () -> {
            geoService.byCoordinates(1, 1);
            }, "Not implemented");
    }

    /*======Можно было бы для удобства в классе Location переопределеить equal======*/
    @ParameterizedTest
    @CsvSource({"172.0.32.11, RUSSIA", "96.44.183.149, USA"})
    public void byIpTest(String argument, String expected) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Assertions.assertEquals(expected, geoService.byIp(argument).getCountry().toString());
    }
}
