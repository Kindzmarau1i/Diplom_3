package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Страница "Конструктор"
 */
public class BurgerConstructorPage extends BasePage {

    private final WebDriver driver;

    /**
     * Секция "Ингредиенты"
     */
    public final By ingredientsContext = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']");

    /**
     * Кнопка "Булки"
     */
    public final By bunsButton = By.xpath(".//span[text()='Булки']/parent::div");

    /**
     * Кнопка "Соусы"
     */
    public final By sousesButton = By.xpath(".//span[text()='Соусы']/parent::div");

    /**
     * Кнопка "Начинки"
     */
    public final By fillingsButton = By.xpath(".//span[text()='Начинки']/parent::div");

    /**
     * Кнопка "Войти в аккаунт"
     */
    public final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    /**
     * Кнопка "Оформить заказ"
     */
    public final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public BurgerConstructorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * Подождать, пока загрузится контекст конструктора
     */
    public void waitForOpened() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ingredientsContext));
    }

    /**
     * Проверить видимость контекста главной страницы авторизованным пользователем
     */
    public Boolean checkIsVisibleContext() {
        return driver.findElement(ingredientsContext).isDisplayed() && driver.findElement(createOrderButton).isDisplayed();
    }

    /**
     * Нажать на кнопку "Булки"
     */
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    /**
     * Нажать на кнопку "Соусы"
     */
    public void clickSousesButton() {
        driver.findElement(sousesButton).click();
    }

    /**
     * Нажать на кнопку "Начинки"
     */
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    /**
     * Нажать на кнопку "Войти в аккаунт"
     */
    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    /**
     * Проверить выбрана ли секция "Булки"
     */
    public String checkIsSelectedBunsSection() {
        return driver.findElement(bunsButton).getDomAttribute("class");
    }

    /**
     * Проверить выбрана ли секция "Соусы"
     */
    public String checkIsSelectedSousesSection() {
        return driver.findElement(sousesButton).getDomAttribute("class");
    }

    /**
     * Проверить выбрана ли секция "Начинки"
     */
    public String checkIsSelectedFillingsSection() {
        return driver.findElement(fillingsButton).getDomAttribute("class");
    }

    public void waitEntryBetweenSections(String section) {
        switch (section) {
            case "Булки":
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.attributeContains(bunsButton, "class", "tab_tab_type_current__2BEPc"));
                break;
            case "Соусы":
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.attributeContains(sousesButton, "class", "tab_tab_type_current__2BEPc"));
                break;
            case "Начинки":
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.attributeContains(fillingsButton, "class", "tab_tab_type_current__2BEPc"));
                break;
        }
    }
}
