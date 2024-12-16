import api.responses.CreateCustomerResponseDTO;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.PersonalAccountPage;

public class LogoutCustomerTest extends BaseTest {

    @Description("Проверка выхода по кнопке «Выйти» в личном кабинете")
    @DisplayName("Выйти из аккаунта")
    @Test
    public void logoutCustomerTest() {
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

        // Нажать на кнопку "Выход"
        personalAccountPage.waitForOpened();
        personalAccountPage.clickLogoutButton();

        // Проверить выход из личного кабинета
        loginPage.waitForOpened();
        Assert.assertTrue(loginPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(response.getAccessToken());
    }
}
