package demowebshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ComputerPage {

    private final SelenideElement
            DesktopsButton = $$("div.sub-category-grid div").first();

    @Step("Нажать на кнопку настольные компьютеры")
    public DesktopsPage clickDesktopsButton() {
        DesktopsButton.click();

        return new DesktopsPage();
    }
}

