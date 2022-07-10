package GeoServiceImplTest;

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
        if (GeoServiceImpl.LOCALHOST.equals(argument)) {
            Location location = new Location(null, null, null, 0);
            GeoServiceImpl geoService = new GeoServiceImpl();
            assertThat(location.getCity(), equalTo(geoService.byIp(argument).getCity()));
            assertThat(location.getCountry(), equalTo(geoService.byIp(argument).getCountry()));
            assertThat(location.getStreet(), equalTo(geoService.byIp(argument).getStreet()));
            assertThat(location.getBuiling(), equalTo(geoService.byIp(argument).getBuiling()));
            /*
            Assertions.assertEquals(geoService.byIp(argument).getCity(), location.getCity());
            Assertions.assertEquals(geoService.byIp(argument).getCountry(), location.getCountry());
            Assertions.assertEquals(geoService.byIp(argument).getStreet(), location.getStreet());
            Assertions.assertEquals(geoService.byIp(argument).getBuiling(), location.getBuiling());
            */
        } else if (GeoServiceImpl.MOSCOW_IP.equals(argument)) {
            Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
            GeoServiceImpl geoService = new GeoServiceImpl();
            assertThat(location.getCity(), equalTo(geoService.byIp(argument).getCity()));
            assertThat(location.getCountry(), equalTo(geoService.byIp(argument).getCountry()));
            assertThat(location.getStreet(), equalTo(geoService.byIp(argument).getStreet()));
            assertThat(location.getBuiling(), equalTo(geoService.byIp(argument).getBuiling()));
        } else if (GeoServiceImpl.NEW_YORK_IP.equals(argument)) {
            Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
            GeoServiceImpl geoService = new GeoServiceImpl();
            assertThat(location.getCity(), equalTo(geoService.byIp(argument).getCity()));
            assertThat(location.getCountry(), equalTo(geoService.byIp(argument).getCountry()));
            assertThat(location.getStreet(), equalTo(geoService.byIp(argument).getStreet()));
            assertThat(location.getBuiling(), equalTo(geoService.byIp(argument).getBuiling()));
        } else if (argument.startsWith("172.")) {
            Location location = new Location("Moscow", Country.RUSSIA, null, 0);
            GeoServiceImpl geoService = new GeoServiceImpl();
            assertThat(location.getCity(), equalTo(geoService.byIp(argument).getCity()));
            assertThat(location.getCountry(), equalTo(geoService.byIp(argument).getCountry()));
            assertThat(location.getStreet(), equalTo(geoService.byIp(argument).getStreet()));
            assertThat(location.getBuiling(), equalTo(geoService.byIp(argument).getBuiling()));
        }  else if (argument.startsWith("96.")) {
            Location location = new Location("New York", Country.USA, null,  0);
            GeoServiceImpl geoService = new GeoServiceImpl();
            assertThat(location.getCity(), equalTo(geoService.byIp(argument).getCity()));
            assertThat(location.getCountry(), equalTo(geoService.byIp(argument).getCountry()));
            assertThat(location.getStreet(), equalTo(geoService.byIp(argument).getStreet()));
            assertThat(location.getBuiling(), equalTo(geoService.byIp(argument).getBuiling()));
        }
    }
}
