package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Вход"
 */
public class LoginPage extends BasePage {

    private final WebDriver driver;

    /**
     * Контекст входа в аккаунт
     */
    public final By context = By.xpath(".//h2[text()='Вход']");

    /**
     * Поле "Email"
     */
    public final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");

    /**
     * Поле "Пароль"
     */
    public final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    /**
     * Кнопка "Войти"
     */
    public final By loginButton = By.xpath(".//button[text()='Войти']");

    /**
     * Кнопка "Зарегистрироваться"
     */
    public final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");

    /**
     * Кнопка "Восстановить пароль"
     */
    public final By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится контекст входа в аккаунт
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(context));
    }

    /**
     * Проверить видимость контекста входа в аккаунт
     */
    public Boolean checkIsVisibleContext() {
        return driver.findElement(context).isDisplayed();
    }

    /**
     * Заполнить все поля при входе в аккаунт
     */
    public void fillLoginFields(String email, String password) {
        setValueInEmailField(email);
        setValueInPasswordField(password);
    }

    /**
     * Ввести значение в поле "Email"
     */
    public void setValueInEmailField(String value) {
        driver.findElement(emailField).sendKeys(value);
    }

    /**
     * Ввести значение в поле "Пароль"
     */
    public void setValueInPasswordField(String value) {
        driver.findElement(passwordField).sendKeys(value);
    }

    /**
     * Нажать на кнопку "Войти"
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * Нажать на кнопку "Зарегистрироваться"
     */
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    /**
     * Нажать на кнопку "Восстановить пароль"
     */
    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }
}
