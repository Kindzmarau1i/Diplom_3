import api.responses.CreateCustomerResponseDTO;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.RecoverPage;
import pages.RegistrationPage;

public class LoginCustomerTest extends BaseTest {

    @Description("Проверка входа в аккаунт по кнопке «Войти в аккаунт» на главной странице")
    @DisplayName("Залогиниться по кнопке «Войти в аккаунт» на главной странице")
    @Test
    public void loginCustomerInMainPage() {
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Подготовить клиента
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        CreateCustomerResponseDTO response = prepareCustomer(email, password, name);

        // Нажать на кнопку "Войти в аккаунт"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickLoginAccountButton();

        // Заполнить форму авторизации и нажать на кнопку "Войти"
        loginPage.waitForOpened();
        loginPage.fillLoginFields(email, password);
        loginPage.clickLoginButton();

        // Проверить, что отображается главная страница
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }

    @Description("Проверка входа в аккаунт через кнопку «Личный кабинет»")
    @DisplayName("Залогиниться через кнопку «Личный кабинет»")
    @Test
    public void loginCustomerFromPersonalAccount() {
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Подготовить клиента
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        CreateCustomerResponseDTO response = prepareCustomer(email, password, name);

        // Нажать на кнопку "Личный кабинет"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickPersonalAccountButton();

        // Заполнить форму авторизации и нажать на кнопку "Войти"
        loginPage.waitForOpened();
        loginPage.fillLoginFields(email, password);
        loginPage.clickLoginButton();

        // Проверить, что отображается главная страница
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }

    @Description("Проверка входа в аккаунт через кнопку в форме регистрации")
    @DisplayName("Залогиниться через кнопку в форме регистрации")
    @Test
    public void loginCustomerFromRegisterForm() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Подготовить клиента
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        CreateCustomerResponseDTO response = prepareCustomer(email, password, name);

        // Нажать на кнопку "Войти в аккаунт"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickLoginAccountButton();

        // Нажать на кнопку "Зарегистрироваться"
        loginPage.waitForOpened();
        loginPage.clickRegisterButton();

        // Нажать на кнопку "Войти"
        registrationPage.waitForOpened();
        registrationPage.clickLoginButton();

        // Заполнить форму авторизации и нажать на кнопку "Войти"
        loginPage.waitForOpened();
        loginPage.fillLoginFields(email, password);
        loginPage.clickLoginButton();

        // Проверить, что отображается главная страница
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }

    @Description("Проверка входа в аккаунт через кнопку в форме восстановления пароля")
    @DisplayName("Залогиниться через кнопку в форме восстановления пароля")
    @Test
    public void loginCustomerFromRecoverPassword() {
        RecoverPage recoverPage = new RecoverPage(driver);
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Подготовить клиента
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        CreateCustomerResponseDTO response = prepareCustomer(email, password, name);

        // Нажать на кнопку "Войти в аккаунт"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickLoginAccountButton();

        // Нажать на кнопку "Восстановить пароль"
        loginPage.waitForOpened();
        loginPage.clickRecoverPasswordButton();

        // Нажать на кнопку "Войти"
        recoverPage.waitForOpened();
        recoverPage.clickLoginButton();

        // Заполнить форму авторизации и нажать на кнопку "Войти"
        loginPage.waitForOpened();
        loginPage.fillLoginFields(email, password);
        loginPage.clickLoginButton();

        // Проверить, что отображается главная страница
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }
}
