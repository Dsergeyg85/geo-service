package LocalizationServiceImplTest;

import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LocalizationServiceImplTest {
    @Test
    public void localeTest() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        assertThat(localizationService.locale(Country.RUSSIA), equalTo("Добро пожаловать"));
        assertThat(localizationService.locale(Country.USA), equalTo("Welcome"));
    }
}
