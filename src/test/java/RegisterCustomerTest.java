import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pages.BurgerConstructorPage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegisterCustomerTest extends BaseTest {

    @Description("Проверка успешной регистарции")
    @DisplayName("Зарегистрироваться")
    @Test
    public void registerCustomerSuccessTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Нажать на кнопку "Войти в аккаунт"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickLoginAccountButton();

        // Нажать на кнопку "Зарегистрироваться"
        loginPage.waitForOpened();
        loginPage.clickRegisterButton();

        // Заполнить форму регистрации и нажать на кнопку "Зарегистрироваться"
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        registrationPage.waitForOpened();
        registrationPage.fillRegisterFields(name, email, password);
        registrationPage.clickRegisterButton();

        // Проверить, что отображается форма входа в аккаунт
        loginPage.waitForOpened();
        Assert.assertTrue(loginPage.checkIsVisibleContext());

        // Удалить созданного клиента
        deleteCustomer(loginCustomer(email, password).getAccessToken());
    }

    @Description("Проверка ошибки для некорректного пароля")
    @DisplayName("Получить ошибку при регистрации")
    @Test
    public void registerCustomerErrorTest() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Нажать на кнопку "Войти в аккаунт"
        burgerConstructorPage.waitForOpened();
        burgerConstructorPage.clickLoginAccountButton();

        // Нажать на кнопку "Зарегистрироваться"
        loginPage.waitForOpened();
        loginPage.clickRegisterButton();

        // Заполнить форму регистрации и нажать на кнопку "Зарегистрироваться"
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5);
        registrationPage.waitForOpened();
        registrationPage.fillRegisterFields(name, email, password);
        registrationPage.clickRegisterButton();

        // Проверить, что отображается ошибка для некорректного пароля
        Assert.assertTrue(registrationPage.checkPasswordError());
    }
}
