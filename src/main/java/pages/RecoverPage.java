package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Восстановить пароль"
 */
public class RecoverPage extends BasePage {

    private final WebDriver driver;

    /**
     * Контекст восстановления пароля
     */
    public final By context = By.xpath(".//h2[text()='Восстановление пароля']");

    /**
     * Кнопка "Войти"
     */
    public final By loginButton = By.xpath(".//a[text()='Войти']");

    public RecoverPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится контекст восстановления пароля
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(context));
    }

    /**
     * Нажать на кнопку "Войти"
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
