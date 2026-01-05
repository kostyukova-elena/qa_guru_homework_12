package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@Tag("dpd")
public class DpdPageTest extends TestBase {
    DpdPage dpdPage = new DpdPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    @DisplayName("Тест для проверки строки поиска на сайте")
    void siteSearch() {
        step("Открываем главную страницу", () -> {
            dpdPage.openPage();
        });

        step("Закрываем банер с куки", () -> {
            dpdPage.acceptCookies();
        });

        step("Закрываем банер с местоположением", () -> {
            dpdPage.acceptCity();
        });

        step("Кликаем по кнопке Поиск", () -> {
            dpdPage.setHeaderControlSearch();
        });

        step("Вводим слово Акции", () -> {
            dpdPage.setSearch("Акции");
        });

        step("Кликаем по кнопке Найти", () -> {
            dpdPage.setClickFind();
        });

        step("Проверяем результат", () -> {
            resultComponent.searchResult();
        });
    }

    @Test
    @DisplayName("Тест поиска информации по посылке по трек-номеру")
    void SearchOrder() {
        step("Открываем главную страницу", () -> {
            dpdPage.openPage();
        });

        step("Закрываем банер с куки", () -> {
            dpdPage.acceptCookies();
        });

        step("Закрываем банер с местоположением", () -> {
            dpdPage.acceptCity();
        });

        step("Вводим номер заказа RU135266675", () -> {
            dpdPage.setTrackOrder("RU135266675");
        });

        step("Кликаем по кнопке Найти", () -> {
            dpdPage.setClickTrackOrder();
        });

        step("Проверяем результат", () -> {
            resultComponent.parcelTracking();
        });
    }


    static Stream<Arguments> siteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(List.of("О компании", "Контакты", "Помощь получателю", "Помощь отправителю", "Пункты приема и выдачи")));
    }

    @MethodSource
    @ParameterizedTest()
    @Tag("SMOCK")
    @DisplayName("Проверка основных элементов на главной странице")
    void siteShouldDisplayCorrectButtons(List<String> expectedButtons) {

        step("Открываем главную страницу", () -> {
            dpdPage.openPage();
        });

        step("Получаем текстовые элементы в основном меню", () -> {
            dpdPage.expectedShouldButtons(expectedButtons);
        });
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки В другую страну")
    void NavigateThroughTheMenuItemsOfPopularProducts() {
        step("Открываем главную страницу", () -> {
            dpdPage.openPage();
        });

        step("Закрываем банер с куки", () -> {
            dpdPage.acceptCookies();
        });

        step("Закрываем банер с местоположением", () -> {
            dpdPage.acceptCity();
        });

        step("Кликаем по меню В другую страну", () -> {
            dpdPage.setPopularProducts();
        });

        step("Проверяем результат", () -> {
            resultComponent.resultInAnotherCountry();
        });

    }

    @Test
    @DisplayName("Проверка наличия рекламного банера на странице")
    void AdvertisingBanner() {
        step("Открываем главную страницу", () -> {
            dpdPage.openPage();
        });

        step("Закрываем банер с куки", () -> {
            dpdPage.acceptCookies();
        });

        step("Закрываем банер с местоположением", () -> {
            dpdPage.acceptCity();
        });

        step("Проверяем результат", () -> {
            resultComponent.resultConcludeAgreement();
        });
    }
}