package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private final SelenideElement searchResult = $(".root_TfEvJ");
    private final SelenideElement parcelTracking = $(".container_y7kmS");
    private final SelenideElement resultInAnotherCountry = $(".popular-products__grid");
    private final SelenideElement resultConcludeAgreement = $(".main-slider__container");

    public ResultComponent searchResult() {
        searchResult.should(exist);
        return this;
    }

    public ResultComponent parcelTracking() {
        parcelTracking.should(exist);
        return this;
    }

    public ResultComponent resultInAnotherCountry() {
        resultInAnotherCountry.should(exist);
        return this;
    }

    public ResultComponent resultConcludeAgreement() {
        resultConcludeAgreement.should(exist);
        return this;
    }
}
