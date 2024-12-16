package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Базовый класс для работы с элементами страницы
 */
public class BasePage {

    private final WebDriver driver;

    /**
     * Button "Конструктор"
     */
    public final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    /**
     * Button "Лента Заказов"
     */
    public final By ordersListButton = By.xpath(".//p[text()='.//p[text()='Лента Заказов']']");

    /**
     * div "Логотип"
     */
    public final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    /**
     * Button "Личный Кабинет"
     */
    public final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Нажать на кнопку "Конструктор"
     */
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    /**
     * Нажать на кнопку "Лента Заказов"
     */
    public void clickOrdersListButton() {
        driver.findElement(ordersListButton).click();
    }

    /**
     * Нажать на кнопку "Логотип"
     */
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    /**
     * Нажать на кнопку "Личный Кабинет"
     */
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
}
