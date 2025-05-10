package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Регистрация"
 */
public class RegistrationPage extends BasePage {

    private final WebDriver driver;

    /**
     * Контекст регистарции
     */
    public final By context = By.xpath(".//h2[text()='Регистрация']");

    /**
     * Поле "Имя"
     */
    public final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");

    /**
     * Поле "Email"
     */
    public final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");

    /**
     * Поле "Пароль"
     */
    public final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    /**
     * Кнопка "Зарегистрироваться"
     */
    public final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    /**
     * Кнопка "Войти"
     */
    public final By loginButton = By.xpath(".//a[text()='Войти']");

    /**
     * Ошибка некорректного пароля
     */
    public final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится контекст регистрации
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(context));
    }

    /**
     * Заполнить все поля при регистрации
     */
    public void fillRegisterFields(String name, String email, String password) {
        setValueInNameField(name);
        setValueInEmailField(email);
        setValueInPasswordField(password);
    }

    /**
     * Ввести значение в поле "Имя"
     */
    public void setValueInNameField(String value) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(value);
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
     * Нажать на кнопку "Зарегистрироваться"
     */
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    /**
     * Нажать на кнопку "Войти"
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * Проверить ошибку для некорректного пароля
     */
    public Boolean checkPasswordError() {
        return driver.findElement(passwordError).isDisplayed();
    }
}
