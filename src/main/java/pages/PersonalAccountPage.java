package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Личный кабинет"
 */
public class PersonalAccountPage extends BasePage {

    private final WebDriver driver;

    /**
     * Контекст "Личный кабинет"
     */
    public final By context = By.xpath(".//div[@class='Account_account__vgk_w']");

    /**
     * Button "Выход"
     */
    public final By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится контекст личного кабинета
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(context));
    }

    /**
     * Проверить видимость контекста личного кабинета
     */
    public Boolean checkIsVisibleContext() {
        return driver.findElement(context).isDisplayed();
    }

    /**
     * Нажать на кнопку "Выйти"
     */
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
