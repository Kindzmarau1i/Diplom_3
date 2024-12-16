import api.responses.CreateCustomerResponseDTO;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.PersonalAccountPage;

public class EntryBetweenPersonalAccountAndMainPageTest extends BaseTest {

    @Description("Проверка перехода в контекст конструктора по клику на «Конструктор»")
    @DisplayName("Перейти в контекст конструктора по клику на «Конструктор»")
    @Test
    public void entryConstructorFromPersonalAccount() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
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

        // Нажать на кнопку "Личный кабинет"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickPersonalAccountButton();

        // Нажать на кнопку "Конструктор"
        personalAccountPage.waitForOpened();
        personalAccountPage.clickConstructorButton();

        // Проверить переход в контекст "Конструктор"
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }

    @Description("Проверка перехода в контекст конструктора по клику на логотип Stellar Burgers")
    @DisplayName("Перейти в контекст конструктора по клику на логотип Stellar Burgers")
    @Test
    public void entryConstructorFromPersonalAccountByLogo() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
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

        // Нажать на кнопку "Личный кабинет"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickPersonalAccountButton();

        // Нажать на логотип Stellar Burgers
        personalAccountPage.waitForOpened();
        personalAccountPage.clickLogoButton();

        // Проверить переход в контекст "Конструктор"
        burgerConstructorPage.waitForOpened();
        Assert.assertTrue(burgerConstructorPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }
}
