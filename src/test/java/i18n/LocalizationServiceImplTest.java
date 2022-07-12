package i18n;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"Добро пожаловать", "Welcome"})
    public void localeTest(String argument) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        switch (argument) {
            case "Welcome":
                assertThat(localizationService.locale(Country.USA), equalTo(argument));
                break;
            default:
                assertThat(localizationService.locale(Country.RUSSIA), equalTo(argument));
                break;

        }
    }
}
