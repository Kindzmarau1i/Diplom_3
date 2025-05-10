import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.BurgerConstructorPage;

public class EntryBetweenSectionsOnConstructorTest extends BaseTest {

    @Description("Проверка перехода в секцию «Булки» на странице «Конструктор»")
    @DisplayName("Перейти в секцию «Булки» на странице «Конструктор»")
    @Test
    public void entryBunsTest() {
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);

        // Перейти на секцию "Начинки"
        burgerConstructorPage.clickSousesButton();

        // Перейти на секцию "Булки"
        burgerConstructorPage.clickBunsButton();

        // Проверить переход к секции "Булки"
        burgerConstructorPage.waitEntryBetweenSections("Булки");
        Assert.assertTrue(burgerConstructorPage.checkIsSelectedBunsSection().contains("tab_tab_type_current__2BEPc"));
    }

    @Description("Проверка перехода в секцию «Соусы» на странице «Конструктор»")
    @DisplayName("Перейти в секцию «Соусы» на странице «Конструктор»")
    @Test
    public void entrySousesTest() {
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);

        // Перейти на секцию "Соусы"
        burgerConstructorPage.clickSousesButton();

        // Проверить переход к секции "Соусы"
        burgerConstructorPage.waitEntryBetweenSections("Соусы");
        Assert.assertTrue(burgerConstructorPage.checkIsSelectedSousesSection().contains("tab_tab_type_current__2BEPc"));
    }

    @Description("Проверка перехода в секцию «Начинки» на странице «Конструктор»")
    @DisplayName("Перейти в секцию «Начинки» на странице «Конструктор»")
    @Test
    public void entryFillingsTest() {
        BurgerConstructorPage burgerConstructorPage = new BurgerConstructorPage(driver);

        // Перейти на секцию "Начинки"
        burgerConstructorPage.clickFillingsButton();

        // Проверить переход к секции "Начинки"
        burgerConstructorPage.waitEntryBetweenSections("Начинки");
        Assert.assertTrue(burgerConstructorPage.checkIsSelectedFillingsSection().contains("tab_tab_type_current__2BEPc"));
    }
}
