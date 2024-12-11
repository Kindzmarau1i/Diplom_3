import api.StellarBurgerApiClient;
import api.requests.CreateCustomerRequestDTO;
import api.requests.LoginCustomerRequestDTO;
import api.responses.CreateCustomerResponseDTO;
import api.responses.LoginCustomerResponseDTO;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Базовый класс для работы с тестами
 */
public abstract class BaseTest {
    protected WebDriver driver;
    private final StellarBurgerApiClient stellarBurgerApiClient = new StellarBurgerApiClient();

    private static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String CHROME = "Chrome";
    public static final String YANDEX = "Yandex";

    public WebDriver initDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                return new ChromeDriver();
            case "Yandex":
                return startYandex();
        }
        return null;
    }

    public WebDriver startYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/nail_/chromedriver-win64/chromedriver.exe");
        ChromeOptions opts = new ChromeOptions();
        opts.setBinary("C:/Users/nail_/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        return new ChromeDriver(opts);
    }

    @Before
    public void open() {
        driver = initDriver(CHROME);
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Step("Создать пользователя")
    public CreateCustomerResponseDTO prepareCustomer(String email, String password, String name) {
        return stellarBurgerApiClient.createCustomer(CreateCustomerRequestDTO.builder()
                .email(email)
                .password(password)
                .name(name)
                .build());
    }

    @Step("Залогинить пользователя")
    public LoginCustomerResponseDTO loginCustomer(String email, String password) {
        return stellarBurgerApiClient.loginCustomer(LoginCustomerRequestDTO.builder()
                .email(email)
                .password(password)
                .build());
    }

    @Step("Удалить пользователя")
    public void deleteCustomer(String accessToken) {
        stellarBurgerApiClient.deleteCustomer(accessToken);
    }
}
