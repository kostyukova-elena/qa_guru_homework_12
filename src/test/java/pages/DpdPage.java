package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DpdPage {
    private final SelenideElement cookieWindow = $(".root_UnCiX");
    private final SelenideElement cookieButton = $(byText("Подтверждаю"));
    private final SelenideElement cityWindow = $(".select-city_aan4t");
    private final SelenideElement cityButton = $(byText("Все верно"));
    private final SelenideElement headerControlSearchInput = $(".content_uyL9E");
    private final SelenideElement searchInput = $("input.ui-input-root_a0jXy");
    private final SelenideElement clickFindInput = $(byText("Найти"));
    private final SelenideElement trackOrderInput = $(".text-field__input");
    private final SelenideElement clickTrackOrderInput = $(".button_W22q3");
    private final ElementsCollection expectedButtons = $$(".second-menu__item");
    private final SelenideElement popularProductsInput = $(".popular-products__tab-menu-item");


    public DpdPage openPage() {
        open("https://dpd.ru/");
        return this;
    }

    public DpdPage acceptCookies() {
        if (cookieWindow.is(visible)) {
            cookieButton.click();
        }

        return this;
    }

    public DpdPage acceptCity() {
        if (cityWindow.is(visible)) {
            cityButton.click();
        }

        return this;
    }

    public DpdPage setHeaderControlSearch() {
        headerControlSearchInput.shouldBe(visible).click();
        return this;
    }

    public DpdPage setSearch(String value) {
        searchInput.setValue(value);
        return this;
    }

    public DpdPage setClickFind() {
        clickFindInput.click();
        return this;
    }

    public DpdPage setTrackOrder(String value) {
        trackOrderInput.setValue(value);
        return this;
    }

    public DpdPage setClickTrackOrder() {
        clickTrackOrderInput.shouldBe(visible).click();
        return this;
    }

    public DpdPage expectedShouldButtons(List<String> expectedButtons) {
        this.expectedButtons.filter(visible).shouldHave(texts(expectedButtons));
        return this;
    }

    public DpdPage setPopularProducts() {
        popularProductsInput.shouldBe(visible).click();
        return this;
    }
}
