package geo;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    @ValueSource (strings = {"127.0.0.1", "172.0.32.11", "96.44.183.149"})
    public void byIpTest(String argument) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location;
        switch (argument) {
            case "172.0.32.11":
                location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
                Assertions.assertEquals(location.toString(), geoService.byIp(argument).toString());
                break;
            case "96.44.183.149":
                location = new Location("New York", Country.USA, " 10th Avenue", 32);
                Assertions.assertEquals(location.toString(), geoService.byIp(argument).toString());
                break;
            default:
                location = new Location(null, null, null, 0);
                Assertions.assertEquals(location.toString(), geoService.byIp(argument).toString());
                break;
        }
    }
}
